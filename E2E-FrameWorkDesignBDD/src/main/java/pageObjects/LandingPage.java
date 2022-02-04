package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	WebDriver driver;
	
	private By login = By.xpath("//a/span[text()='Login']");
	private By title = By.cssSelector("section[id='content'] div h2");
	private By nav = By.xpath("//nav[@class='navbar-collapse collapse']/ul/li/a");
	private By popup = By.xpath("//button[text()='NO THANKS']");
	
	private By header = By.cssSelector("div[class='carousel-caption'] h3");
	private By header2 = By.cssSelector("div[class='carousel-caption'] p");



	public LoginPage Login() {
		 driver.findElement(login).click();
		return new LoginPage(driver);

	}
	
	
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	public WebElement getNavBar() {
		return driver.findElement(nav);
	}
	

	public List<WebElement> getPopupSize() {
		return driver.findElements(popup);
	}
	
	public WebElement getPopup() {
		return driver.findElement(popup);
	}

	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
	public WebElement getHeader() {
		return driver.findElement(header);
	}
	public WebElement getHeader2() {
		return driver.findElement(header2);
	}

}
