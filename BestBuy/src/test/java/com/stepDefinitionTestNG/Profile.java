package com.stepDefinitionTestNG;


import java.time.Duration;
import java.util.List;
import java.util.Properties;
import com.parameters.PropertyReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
//-----------scenario 1---------------
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
    
  //-----------------scenario 2------------------  
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

  //-------------------------scenario 3---------------------------  
    @Given("user is on Design Selection page")
    public void user_is_on_design_selection_page() {


    	    String recipientName = reader.getCellData( 0, 0, 0); // Row 0, Col 0
    	    String senderName = reader.getCellData(0, 1, 0);

        Assert.assertTrue(userPage.navigateToDesignSelectionPage(recipientName, senderName));
        Assert.assertTrue(userPage.verifyDesignSelectionPage());
        System.out.println("Design Selection Page displayed successfully with Recipient: \" + recipientName + \" and Sender: \" + senderName");
    }

    @When("user selects a design")
    public void user_selects_a_design() {
        Assert.assertTrue(userPage.selectDesign());
        System.out.println(" Design selected successfully");
    }

    @And("user clicks on Continue and navigates to Amount page")
    public void user_clicks_on_continue_and_navigates_to_amount_page() {
        Assert.assertTrue(userPage.clickContinue());
        Assert.assertTrue(userPage.verifyAmountPage());
        System.out.println(" Navigated to Amount Page successfully");
    }

    @And("user selects an amount")
    public void user_selects_an_amount() {
        Assert.assertTrue(userPage.selectAmount());
        System.out.println("Amount selected successfully");
    }

    @And("user clicks on Add a Message")
    public void user_clicks_on_add_a_message() {
        Assert.assertTrue(userPage.clickAddMessage());
        System.out.println("Add a Message button clicked successfully");
    }

    @Then("user should be navigated to Add Message page")
    public void user_should_be_navigated_to_add_message_page() {
        Assert.assertTrue(userPage.verifyAddMessagePage());
        System.out.println("Add Message Page displayed successfully");
    }
    
    //------------------scenario outline 1------------------------

    
    
    @Given("user is on E-Gift Cards page")
    public void user_is_on_e_gift_cards_page() {

        Assert.assertTrue(userPage.verifyEGiftCardPage1(), "E-Gift Card page should be displayed");

    }

    @When("user enters recipient and sender names from sheet {int} and row {int}")
    public void user_enters_recipient_and_sender_names_from_excel(Integer sheet, Integer row) {
    	
    String recipient = reader.getCellData(sheet, row, 0); // Column 0
       String sender = reader.getCellData(sheet, row, 1);    // Column 1

       userPage.enterRecipientAndSender1(recipient, sender);

        }
    

    @Then("user clicks on Send a Digital Card and validate system response for all rows")
    public void user_clicks_on_send_a_digital_card_and_validate_system_response_for_all_rows() {
    	userPage.clickSendDigitalCard1();
    	boolean isDesignPageDisplayed = userPage.verifyDesignPage();
         Assert.assertTrue(isDesignPageDisplayed, "Design page displayed!"); 
    }
    //-------------------scenario outline 2-----------------
    
    @Given("user is on Add Message page")
    public void user_is_on_add_message_page() {
        // Navigate through More → Gift Cards → eGiftCard
        String recipientName = reader.getCellData(0, 0, 0); // Sheet2, Col0, Row0
        String senderName = reader.getCellData(0, 1, 0);    // Sheet2, Col1, Row0

        Assert.assertTrue(userPage.navigateToAddMessagePage(recipientName, senderName));
        Assert.assertTrue(userPage.verifyAddMessagePage());
        System.out.println("Navigated to Add Message Page successfully with Recipient: " + recipientName + " and Sender: " + senderName);
    }

    @When("user clicks on Continue")
    public void user_clicks_on_continue() {
        Assert.assertTrue(userPage.clickContinueFromAddMessage());
        System.out.println("Clicked Continue from Add Message Page");
    }

    @And("user should be navigated to Add to Cart page")
    public void user_should_be_navigated_to_add_to_cart_page() {
        Assert.assertTrue(userPage.verifyAddToCartPage());
        System.out.println("Navigated to Add to Cart Page successfully");
    }

    @And("user enters email and confirm email from sheet {int} and row {int}")
    public void user_enters_email_and_confirm_email_from_sheet_and_row(Integer sheet, Integer row) {
        String email = reader.getCellData(sheet,row,0); // Column 0 = Email
        String confirmEmail = reader.getCellData(sheet,row,1); // Column 1 = ConfirmEmail
        Assert.assertTrue(userPage.enterEmailDetails(email, confirmEmail));
        System.out.println("Entered Email: " + email + " and Confirm Email: " + confirmEmail);
    }

    @And("user clicks on Add to Cart")
    public void user_clicks_on_add_to_cart() {
        Assert.assertTrue(userPage.clickAddToCart());
        System.out.println("Clicked Add to Cart successfully");
    }

    @Then("user should be navigated to Checkout page")
    public void user_should_be_navigated_to_checkout_page() {
        Assert.assertTrue(userPage.verifyCheckoutPage());
        System.out.println("Checkout Page displayed successfully");
    }
    
    }



