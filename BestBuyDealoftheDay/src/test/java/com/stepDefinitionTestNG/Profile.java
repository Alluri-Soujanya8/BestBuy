package com.stepDefinitionTestNG;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pages.UserPage;
import com.pages.UserPage2;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Profile extends BaseSteps {
	
	WebDriver driver = BaseSteps.driver;
    ExtentTest test = Hooks.test;
    UserPage2 userpage;
	
    @Given("User is on BestBuy homepage")
    public void user_is_on_best_buy_homepage() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
       	userpage = new UserPage2(driver, test);
    }
    @When("the user clicks on the Deal of the Day")
    public void the_user_clicks_on_the_deal_of_the_day() {
    	
        boolean clickResult = userpage.clickDealOfTheDayModule();
        Assert.assertTrue(clickResult);
    }

    @Then("the Deal of the Day page should be displayed")
    public void the_deal_of_the_day_page_should_be_displayed() {
    	boolean pageDisplayed = userpage.verifyDealOfTheDayPage();
        Assert.assertTrue(pageDisplayed);
    }
    
    // second scenario
    @Given("User is on Deal of the Day page")
    public void user_is_on_deal_of_the_day_page() {
         userpage = new UserPage2(driver, test); 
         Assert.assertTrue(userpage.clickDealOfTheDayModule());


    }

    @When("the user clicks on the FAQ link")
    public void the_user_clicks_on_the_faq_link() {

        boolean faqClickResult = userpage.clickFAQLink();
        Assert.assertTrue(faqClickResult);

    }

    @When("the FAQ page should be displayed")
    public void the_faq_page_should_be_displayed() {
    	boolean faqPageDisplayed = userpage.verifyFAQPage();
        Assert.assertTrue(faqPageDisplayed);
    }

    @When("the user clicks on the Help Center link")
    public void the_user_clicks_on_the_help_center_link() {
    	 boolean helpCenterClickResult = userpage.clickHelpCenterLink();
         Assert.assertTrue(helpCenterClickResult);
    }

    @Then("the Help Center page should be displayed")
    public void the_help_center_page_should_be_displayed() {
    	boolean helpCenterDisplayed = userpage.verifyHelpCenterPage();
        Assert.assertTrue(helpCenterDisplayed);
    }




	
}
