package Freelance;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReporterNG;


public class listeners extends Base implements ITestListener {
	ExtentTest report;
	ExtentReports rep = ExtentReporterNG.getReporter();
	ThreadLocal<ExtentTest> Thread = new ThreadLocal<ExtentTest>();
	



	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String tcname=result.getMethod().getMethodName();

		 report=rep.createTest(tcname);
		 Thread.set(report);
		 

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		Thread.get().log(Status.PASS, "Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String tcname=result.getMethod().getMethodName();
		WebDriver driver=null;
		System.out.println(tcname);
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		try {
			Thread.get().addScreenCaptureFromPath(TakeScreenshot(tcname,driver),tcname);
			// saves ss at report path,name given
			//gets path from ts method 

		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread.get().fail(result.getThrowable());
	}
		
	

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		rep.flush();
	}

}
