package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.io.FileUtils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Base {
	public static Logger log =LogManager.getLogger(Base.class.getName());

	public WebDriver driver;
	public Properties prop;

	
	public WebDriver initializeDriver() throws IOException {
		
	
		
		 prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\browser.properties");
		prop.load(fis);
		log.info("Properties Loaded");
		String browserName = prop.getProperty("browser"); // sys for jenkin
	
		int sec=Integer.parseInt(prop.getProperty("timeout"));
		
		if(browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\BrowserDrivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if (browserName.contains("headless")) {
				options.addArguments("headless"); // adds headless and run in headless
			}
			 driver   = new ChromeDriver(options); // option is blank if no headless
	

			
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\BrowserDrivers\\geckodriver.exe");
			
			 driver   = new FirefoxDriver();

			
		}
		else if(browserName.equals("IE")) {
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\BrowserDrivers\\msedgedriver.exe");
			
			 driver   = new EdgeDriver();

			
		}
		else {
			System.out.println("INVALID BROWSER");
			log.error("INVALID BROWSER");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
		return driver;
	}

	public  String TakeScreenshot(String tcname, WebDriver driver2) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver2;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"\\reports\\Screenshots\\"+tcname+".png";
		
		FileUtils.copyFile(src,new File(path));
		return path;
		

	}

}
