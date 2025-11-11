package com.stepDefinitionTestNG;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pages.UserPage;
import com.parameters.ExcelReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Profile extends BaseSteps {

    WebDriver driver = BaseSteps.driver;
    ExtentTest test=Hooks.test;
    
    UserPage userPage;
    

ExcelReader reader = new ExcelReader("src/test/resources/ExcelData/GiftCards_data.xlsx");

String recipientName = "";
String senderName = "";
boolean navigatedToDesignPage = false;




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

    @And("user clicks Gift Cards")
    public void user_clicks_gift_cards() {
    	boolean status =userPage.selectGiftCards();
		Assert.assertTrue(status);
    }

    @Then("the Gift Cards page should be displayed")
    public void the_gift_cards_page_should_be_displayed() {
    	boolean status =userPage.verifyGiftCardsPage();
		Assert.assertTrue(status);
    }
    
    
    @Given("the user is on the Gift Cards page")
    public void the_user_is_on_the_gift_cards_page() {

    	 userPage = new UserPage(driver, test);

userPage.clickMore();
userPage.selectGiftCards();

    	    Assert.assertTrue(userPage.verifyGiftCardsPage(), "Gift Cards page should be displayed");
    	

    }

    @When("the user clicks on E-Gift Cards,E-Gift Card page should be displayed")
    public void the_user_clicks_on_e_gift_cards_e_gift_card_page_should_be_displayed() {

Assert.assertTrue(userPage.clickEGiftCards(), "Clicked on E-Gift Cards");
    Assert.assertTrue(userPage.verifyEGiftCardPage(), "E-Gift Card page should be displayed");

    }

    @And("the user enters {string} as the recipient name and the user enters {string} as the sender name")
    public void the_user_enters_as_the_recipient_name_and_the_user_enters_as_the_sender_name(String string, String string2) {

recipientName = reader.getCellData(1, 0, 0); // Sheet2: John
    senderName = reader.getCellData(2, 0, 0);    // Sheet3: Alice
    userPage.enterRecipientAndSender(recipientName, senderName);

    }

    @And("the user  clicks on Send a Digital Card")
    public void the_user_clicks_on_send_a_digital_card() {

    	 userPage.clickSendDigitalCard();
    	    navigatedToDesignPage = userPage.verifyDesignPage();

    }

    @Then("the user should be navigated to the Choose E-Gift Card Design page")
    public void the_user_should_be_navigated_to_the_choose_e_gift_card_design_page() {
    	Assert.assertTrue(navigatedToDesignPage, "User should be navigated to the design selection page");
    }
}
