package com.stepDefinitionTestNG;


import java.time.Duration;
import java.util.List;
import java.util.Properties;
import com.parameters.PropertyReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pages.UserPage;
import com.pages.UserPage2;
import com.parameters.ExcelReader;

import com.setup.BaseSteps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Profile extends BaseSteps {

    WebDriver driver = BaseSteps.driver;
    ExtentTest test=Hooks.test;
    
    UserPage2 userPage;


    @Before
       public void setUp() {
           userPage = new UserPage2(driver, test); // driver and test must be initialized globally
       }
 
ExcelReader reader = new ExcelReader("src/test/resources/ExcelData/GiftCards_data.xlsx");

String recipientName = "";
String senderName = "";
boolean navigatedToDesignPage = false;

    @Given("more functionality should be available")
    public void more_functionality_should_be_available() {
    	userPage=new UserPage2(driver, test);
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

    	 userPage = new UserPage2(driver, test);

userPage.clickMore();
userPage.selectGiftCards();

    	    Assert.assertTrue(userPage.verifyGiftCardsPage(), "Gift Cards page should be displayed");
    	

    }

    @When("the user clicks on E-Gift Cards,E-Gift Card page should be displayed")
    public void the_user_clicks_on_e_gift_cards_e_gift_card_page_should_be_displayed() {


    UserPage2 userPage = new UserPage2(driver, test); // ✅ Fresh instance

    	
Assert.assertTrue(userPage.clickEGiftCards(), "Clicked on E-Gift Cards");

    Assert.assertTrue(userPage.verifyEGiftCardPage(), "E-Gift Card page should be displayed");

    }

//    @And("the user enters {string} as the recipient name and the user enters {string} as the sender name")
//    public void the_user_enters_as_the_recipient_name_and_the_user_enters_as_the_sender_name(String string, String string2) {

    @And("the user enters  recipient name and the user enters  sender name")
    public void the_user_enters_recipient_name_and_the_user_enters_sender_name() {
recipientName = reader.getCellData(0, 0, 0); // Sheet2: John
    senderName = reader.getCellData(0, 1, 0);    // Sheet3: Alice
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
    

//    @Given("user is on E-Gift Cards personalization page")
//    public void user_is_on_e_gift_cards_personalization_page() {
//   	   Assert.assertTrue(userPage.verifyEGiftCardPage1(), "E-Gift Card page not be displayed");
//   }
//
//    @When("user enters recipient name from Excel row {int}")
//    public void user_enters_recipient_name_from_excel_row(Integer rowIndex) {
//    	String recipientName = reader.getCellData(1, rowIndex, 0);
//    	userPage.enterRecipientName(recipientName);
//    }
//
//   @And("user enters sender name from Excel row {int}")
//    public void user_enters_sender_name_from_excel_row(Integer rowIndex) {
//    	String senderName = reader.getCellData(1, rowIndex, 1); // Sheet2, col 1
//   	userPage.enterSenderName(senderName);
//   }
//    
//
//
//    @Then("the system should respond with expected result from Excel row {int}")
//    public void the_system_should_respond_with_expected_result_from_excel_row_row(Integer rowIndex) {
//
//
//String expectedResult = reader.getCellData(1, rowIndex, 2); // Sheet2, col 2
//    String actualResult = userPage.getResponseMessage();
//    Assert.assertEquals(actualResult, expectedResult,
//        "Validation failed for row " + rowIndex + ": Expected '" + expectedResult + "' but got '" + actualResult + "'");
//
//    } 
//    

    @Given("user is on E-Gift Cards personalization page")
    public void user_is_on_e_gift_cards_personalization_page() {
        Assert.assertTrue(userPage.verifyEGiftCardPage1(), "E-Gift Card page not displayed");
    }

    @When("user loads Excel data")
    public void user_loads_excel_data() {
      ExcelReader  reader = new ExcelReader("src/test/resources/ExcelData/GiftCards_data.xlsx");
    }

    @And("user enters recipient and sender names for all rows")
    public void user_enters_recipient_and_sender_names_for_all_rows() {
        // We will just prepare data here, actual validation in @Then
        System.out.println("Excel data loaded successfully.");
    }

    @Then("validate system response for all rows")
    public void validate_system_response_for_all_rows() {
        int rowCount = reader.getRowcount(1); // Sheet2 index = 1
        for (int i = 1; i <= rowCount; i++) {
            String recipientName = reader.getCellData(1, i, 0);
            String senderName = reader.getCellData(1, i, 1);
            String expectedResult = reader.getCellData(1, i, 2);

            userPage.enterRecipientName(recipientName);
            userPage.enterSenderName(senderName);
            String actualResult = userPage.getResponseMessage();

            Assert.assertEquals(actualResult, expectedResult,
                "Validation failed for row " + i + ": Expected '" + expectedResult + "' but got '" + actualResult + "'");
        }
    }
}
