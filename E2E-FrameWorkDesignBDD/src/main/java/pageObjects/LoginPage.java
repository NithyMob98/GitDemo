package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	
	private By email =By.cssSelector("input[type='email']");
	private By pass=By.cssSelector("input[type='password']");
	private By submit = By.cssSelector("input[value='Log In']");
	private By fpass = By.cssSelector("[href*='password/new']");
	
	
	public WebElement emailid() {
		return driver.findElement(email);
		
	}
	
	public WebElement password() {
		return driver.findElement(pass);
		
	}

	public WebElement submit() {
		return driver.findElement(submit);
		
	}
	
	public ForgotPassword forgotpassword() {
		driver.findElement(fpass).click();
		return  new ForgotPassword(driver);
	}

	public  LoginPage(WebDriver driver) {
		this.driver=driver;
	}
}
