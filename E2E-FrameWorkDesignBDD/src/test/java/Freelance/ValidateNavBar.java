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

public class ValidateNavBar extends Base{
	WebDriver driver;

	public static Logger log =LogManager.getLogger(ValidateNavBar.class.getName());

	
	@Test
	public void CheckTextnb() throws IOException {
		log.info("TEST	 : ValidateNavBar");

		LandingPage lap =new LandingPage(driver);
		System.out.println(lap.getNavBar().isDisplayed());
		Assert.assertTrue(lap.getNavBar().isDisplayed());
		log.info("NavBar is validated");
		
	}

	
	
	
	@BeforeTest
	public void Initialize() throws IOException {
		driver=initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Webpage Loaded");
	}
	@AfterTest
	public void teardown() {
		driver.close();
	}
	

}
