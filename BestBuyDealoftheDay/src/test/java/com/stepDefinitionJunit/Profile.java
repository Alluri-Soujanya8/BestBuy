package com.stepDefinitionJunit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pages.UserPage;
import com.setup.BaseSteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Profile extends BaseSteps {
	
	WebDriver driver = BaseSteps.driver;
    ExtentTest test = Hooks.test;
    UserPage userpage;
	
    @When("the user clicks on the Deal of the Day")
    public void the_user_clicks_on_the_deal_of_the_day() {
    	userpage = new UserPage(driver, test);
        boolean clickResult = UserPage.clickDealOfTheDayModule();
        Assert.assertTrue(clickResult);
    }
//    @When("the user clicks on the {string}")
//    public void the_user_clicks_on_the(String string) {
//    	
//    	userpage = new UserPage(driver, test);
//      boolean clickResult = UserPage.clickDealOfTheDayModule();
//      Assert.assertTrue(clickResult);
//    }

    @Then("the Deal of the Day page should be displayed")
    public void the_deal_of_the_day_page_should_be_displayed() {
    	boolean pageDisplayed = UserPage.verifyDealOfTheDayPage();
        Assert.assertTrue(pageDisplayed);
    }



	
}
