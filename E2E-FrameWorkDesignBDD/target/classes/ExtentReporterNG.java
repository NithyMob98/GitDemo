package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentReports rep;
	
	public static ExtentReports getReporter() {
		String path  = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Automation Test Results");
		reporter.config().setReportName("Selenium Automation");
		
		rep = new ExtentReports();
		rep.attachReporter(reporter);
		rep.setSystemInfo("nithi", "tester");
		
		return rep;

	}

}
