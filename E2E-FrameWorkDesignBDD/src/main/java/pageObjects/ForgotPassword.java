package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	WebDriver driver;
	
	private By email =By.cssSelector("input[id='user_email']");
	 private By submit=By.cssSelector("input[type='submit']");
	
	
	public WebElement emailid() {
		return driver.findElement(email);
		
	}
	

	public WebElement submit() {
		return  driver.findElement(submit);
		
	}
	

	public  ForgotPassword(WebDriver driver) {
		this.driver=driver;
	}
}
