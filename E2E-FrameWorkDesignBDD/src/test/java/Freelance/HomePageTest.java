package Freelance;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePageTest extends Base{
	WebDriver driver;

	public static Logger log =LogManager.getLogger(HomePageTest.class.getName());
	
	@Test(dataProvider="getData")
	public void basePageNavigate(String email,String pass,String tc) throws IOException {
		log.info("TEST	 : basePageNavigate");

		driver.get(prop.getProperty("url"));
		log.info("Page loaded");
		LandingPage lap =new LandingPage(driver);
		LoginPage lp = lap.Login();
		lp.emailid().sendKeys(email);
		log.info("Email is entered");
		lp.password().sendKeys(pass);
		log.info("pass is entered");
		lp.submit().click();
		
		ForgotPassword fp =lp.forgotpassword();
		fp.emailid().sendKeys("aqua@gmail.com");
		fp.submit().click();

		log.info(tc);

		
		
	}
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		//tc 1 data
		data[0][0]="user1@rs.com";
		data[0][1]="Password";
		data[0][2]="Testcase 1 Executed";

		//tc 2 data
		data[1][0]="user2@rs.com";
		data[1][1]="Password";
		data[1][2]="Testcase 2 Executed";
		
		return data;

	
	
	
	}
	@BeforeTest
	public void Initialize() throws IOException {
		driver=initializeDriver();
		log.info("Driver initialized");

	}
	@AfterTest
	public void teardown() {
		driver.close();
	}


}
