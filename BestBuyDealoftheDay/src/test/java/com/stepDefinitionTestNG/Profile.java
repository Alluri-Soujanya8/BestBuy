package com.stepDefinitionTestNG;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pages.UserPage2;
import com.setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Profile extends BaseSteps {
	
	WebDriver driver = BaseSteps.driver;
    ExtentTest test = Hooks.test;
    UserPage2 userpage;
	
    //first scenario
    @Given("User is on BestBuy homepage")
    public void user_is_on_best_buy_homepage() {
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
    @And("the FAQ page should be displayed")
    public void the_faq_page_should_be_displayed() {
    	boolean faqPageDisplayed = userpage.verifyFAQPage();
        Assert.assertTrue(faqPageDisplayed);
    }
    @And("the user clicks on the Help Center link")
    public void the_user_clicks_on_the_help_center_link() {
    	 boolean helpCenterClickResult = userpage.clickHelpCenterLink();
         Assert.assertTrue(helpCenterClickResult);
    }
    @Then("the Help Center page should be displayed")
    public void the_help_center_page_should_be_displayed() {
    	boolean helpCenterDisplayed = userpage.verifyHelpCenterPage();
        Assert.assertTrue(helpCenterDisplayed);
    }
    
    
    
    //Third Scenario
    @Given("user is on the Deal of the Day page")
    public void user_is_on_the_deal_of_the_day_page() {
        
    }

    @And("user enters the <search product> in the search bar")
    public void user_enters_the_search_product_in_the_search_bar() {
        
    }

    @And("the <search product> results displayed")
    public void the_search_product_results_displayed() {
        
    }

    @And("user should be able to click on the first product")
    public void user_should_be_able_to_click_on_the_first_product() {
       
    }

    @Then("navigates to the full product detail page")
    public void navigates_to_the_full_product_detail_page() {
        
    }

}
