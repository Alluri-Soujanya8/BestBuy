package com.stepDefinitionJUnit;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pages.UserPage;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Profile extends BaseSteps {

    WebDriver driver = BaseSteps.driver;
    ExtentTest test=Hooks.test;
    
    UserPage userPage;

    @Given("more functionality should be available")
    public void more_functionality_should_be_available() {
    	userPage=new UserPage(driver, test);
		boolean status=userPage.verifyMore();
		Assert.assertTrue(status);
    }

    @When("user clicks More")
    public void user_clicks_more() {
    	boolean status =userPage.clickMore();
		Assert.assertTrue(status);
    }

    @When("user clicks Gift Cards")
    public void user_clicks_gift_cards() {
    	boolean status =userPage.selectGiftCards();
		Assert.assertTrue(status);
    }

    @Then("the Gift Cards page should be displayed")
    public void the_gift_cards_page_should_be_displayed() {
    	boolean status =userPage.verifyGiftCardsPage();
		Assert.assertTrue(status);
    }
}
