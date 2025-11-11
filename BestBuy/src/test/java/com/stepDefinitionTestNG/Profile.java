package com.stepDefinitionTestNG;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pages.UserPage;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Profile extends BaseSteps{
	WebDriver driver = BaseSteps.driver;
	ExtentTest test = Hooks.test;

	UserPage userpage;

	@Given("the user is on the BestBuy Home Page")
	public void the_user_is_on_the_best_buy_home_page() {
	    userpage = new UserPage(driver, test);
	    Assert.assertTrue(userpage.verifyHomepage(), "Home Page is not displayed");
	}

	@When("the user clicks on the {string} link")
	public void the_user_clicks_on_the_link(String linkName) {
	    Assert.assertTrue(userpage.clickGiftIdeas(), linkName + " click failed");
	}

	@Then("the Gift Ideas page with various categories should be displayed")
	public void the_gift_ideas_page_with_various_categories_should_be_displayed() {
	    Assert.assertTrue(userpage. displayGiftIdeasPage(), "Gift Ideas page is not displayed");
	}
	

}
