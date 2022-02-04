package Freelance;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateTextDisplayed extends Base{
	WebDriver driver;
	LandingPage lap;
	public static Logger log =LogManager.getLogger(ValidateTextDisplayed.class.getName());
	
	@Test
	public void ValidateTitleText() throws IOException {
		log.info("TEST	 : ValidateTitle");

		 lap =new LandingPage(driver);
		String s = lap.getTitle().getText();
		Assert.assertEquals(s, "FEATUREDe COURSES");
		log.info("Title is Validated");		
	}
	@Test
	public void ValidateHeader() {
		log.info("TEST	 : ValidateHeader");
		 lap =new LandingPage(driver);
		String act = lap.getHeader().getText();
		String exptd = "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING";
		Assert.assertEquals(act, exptd);
		log.info("Header is validated");		
	}
	@Test
	public void ValidateHeader2() {
		log.info("TEST	 : ValidateHeader2");
		 lap =new LandingPage(driver);
		String act = lap.getHeader2().getText();
		String exptd = "Learn Hot tools like Selenium, Appium, JMeter, SoapUI,Database Testing and more..";
		Assert.assertEquals(act, exptd);
		log.info("Header2 is validated");

		
	}

	
	
	
	
	@BeforeTest
	public void Initialize() throws IOException {
		driver=initializeDriver();
		log.info("Driver initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to webpage");
	}
	@AfterTest
	public void teardown() {
		driver.close();
	}


	
	
	
	

}
