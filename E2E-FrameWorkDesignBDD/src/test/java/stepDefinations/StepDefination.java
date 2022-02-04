package stepDefinations;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;


// @RunWith(Cucumber.class)
public class StepDefination extends Base {
	LoginPage lp;
	
    @Given("^Initialize browser with chrome$")
    public void initialize_browser_with_chrome() throws Throwable {
		driver=initializeDriver();
    }


    @And("^Navigate to \"([^\"]*)\" site$")
    public void navigate_to_something_site(String url) throws Throwable {
		driver.get(url);
    }

    @And("^Click on login and land on signin page$")
    public void click_on_login_and_land_on_signin_page() throws Throwable {
		LandingPage lap =new LandingPage(driver);
		 if(lap.getPopupSize().size() > 0)
		 {
			 lap.getPopup().click();
		 }

		 lp = lap.Login();
			 
	    }

    @When("^User login with (.+) and (.+) and logs in$")
    public void user_login_with_something_and_something_and_logs_in(String user, String pass) throws Throwable {

		lp.emailid().sendKeys(user);
		lp.password().sendKeys(pass);
		lp.submit().click();
		driver.navigate().to("https://courses.rahulshettyacademy.com/courses");

    	}

    @Then("^Verify user is succesfully logged in$")
    public void verify_user_is_succesfully_logged_in() throws Throwable {
		driver.navigate().to("https://courses.rahulshettyacademy.com/courses"); // fake replica

    }
    @And("^Close browser$")
    public void close_browser() throws Throwable {
    	driver.close();
    }




}
