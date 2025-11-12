package com.pages;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.parameters.PropertyReader;
import com.setup.Reports;

public class UserPage2 {
	static Properties prop = PropertyReader.readProperty();

    private static WebDriver driver;
    private static WebDriverWait wait;
    static ExtentTest test;

    @FindBy(xpath="//span[text()='More']")
    private static WebElement more ;
    
    @FindBy(xpath="//a[text()='Gift Cards']")
    private static WebElement giftCards;
    
    @FindBy(xpath="//h1[text()='Best Buy Gift Cards']")
    private static WebElement verifyGiftCardsPage;
    
    @FindBy(xpath="//span[text()='Best Buy E-Gift Cards*']")
    private static WebElement eGiftCardLink;
    
    @FindBy(xpath="//span[text()='Who is the e-gift card for?']")
    private static WebElement eGiftCardPageHeader;
     
    @FindBy(id="recipientName-input")
    private static WebElement recipientNameInput;
    
    @FindBy(id="senderName-input")
    private static WebElement senderNameInput;  
    
    @FindBy(xpath="//button[@data-cashbot-id='recipient-button-submit']")
    private static WebElement sendDigitalCardButton;  
    

//@FindBy(css = "h1.design-title")
//WebElement eGiftCardPageHeader1;

    
    @FindBy(xpath="//span[text()='Choose your e-gift card design.']")
    private static WebElement designPageHeader ;
    
    
    @FindBy(xpath="//span[text()='Continue']")
    private static WebElement continueButton;
    
    @FindBy(xpath="//span[text()='How much do you want to give?']")
    private static WebElement amountSelectionHeader;
    
//    @FindBy(xpath="//div[@class='error-message' or @id='validationMessage']")
//    private static WebElement responseMessage ;


@FindBy(xpath = "//div[contains(@class,'error-message') or contains(@class,'success-message')]")
private WebElement responseMessage;

    

    public UserPage2(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test=test;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
        
    }
    public static boolean verifyMore()
	{
		boolean actResult = true;
        try
        {
            wait.until(ExpectedConditions.visibilityOf(more));
            Reports.generateReport(driver, test, Status.PASS, "Top Deals Functionality is displayed");
        }
        catch (TimeoutException te)
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Top Deals Functionality is not displayed");
        }
        return actResult;
	}

    public boolean clickMore() {
    	boolean actResult = true;
        try
        {
            wait.until(ExpectedConditions.visibilityOf(more));
            Reports.generateReport(driver, test, Status.PASS, "Top Deals Functionality is displayed");
           more.click();
        }
        catch (TimeoutException te)
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Top Deals Functionality is not displayed");
        }
        return actResult;
    }

    public boolean selectGiftCards() {
    	boolean actResult = true;
        try
        {
            wait.until(ExpectedConditions.visibilityOf(giftCards));
            Reports.generateReport(driver, test, Status.PASS, "Top Deals Functionality is displayed");
            giftCards.click();
        }
        catch (TimeoutException te)
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Top Deals Functionality is not displayed");
        }
        return actResult;
    }

    public boolean verifyGiftCardsPage() {
    	boolean actResult = true;
        try
        {
            wait.until(ExpectedConditions.visibilityOf(verifyGiftCardsPage));
            Reports.generateReport(driver, test, Status.PASS, "Top Deals Functionality is displayed");
        }
        catch (TimeoutException te)
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Top Deals Functionality is not displayed");
        }
        return actResult;
    }
    
    
    
    public boolean clickEGiftCards() {
    	String url=prop.getProperty("targetUrl");
        driver.get(url);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(eGiftCardLink));
            eGiftCardLink.click();
            Reports.generateReport(driver, test, Status.PASS, "Clicked on E-Gift Cards");
            return true;
        } catch (TimeoutException e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to click E-Gift Cards");
            return false;
        }
    }

    public boolean verifyEGiftCardPage() {
        try {
            wait.until(ExpectedConditions.visibilityOf(eGiftCardPageHeader));
            Reports.generateReport(driver, test, Status.PASS, "E-Gift Card page is displayed");
            return true;
        } catch (TimeoutException e) {
            Reports.generateReport(driver, test, Status.FAIL, "E-Gift Card page is not displayed");
            return false;
        }
    }

    public void enterRecipientAndSender(String recipient, String sender) {
//        try {
//            WebElement recipientField = driver.findElement(recipientNameInput);
//            WebElement senderField = driver.findElement(senderNameInput);
//            recipientField.clear();
//            recipientField.sendKeys(recipient);
//            senderField.clear();
//            senderField.sendKeys(sender);
//            Reports.generateReport(driver, test, Status.INFO, "Entered recipient and sender names");
//
//        } catch (Exception e) {
//             Reports.generateReport(driver, test, Status.FAIL, "Failed to enter names");
//         }
    	
    	
        try {        
        	wait.until(ExpectedConditions.visibilityOf(recipientNameInput)); 
        	recipientNameInput.clear(); 
        	recipientNameInput.sendKeys(recipient); 
        	wait.until(ExpectedConditions.visibilityOf(senderNameInput));  
        	senderNameInput.clear();      
        	senderNameInput.sendKeys(sender);  
        	Reports.generateReport(driver, test, Status.INFO,"Entered recipient: " + recipient + " and sender: " + sender);  
        	} catch (Exception e) {       
        		Reports.generateReport(driver, test, Status.FAIL, "Failed to enter names");   
        		}    
     }

    public void clickSendDigitalCard() {
        try {
           sendDigitalCardButton.click();
            Reports.generateReport(driver, test, Status.INFO, "Clicked Send Digital Card");
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to click Send Digital Card");
        }
    }

    public boolean verifyDesignPage() {
    	String url=prop.getProperty("endUrl");
        driver.get(url);
        try {
            wait.until(ExpectedConditions.visibilityOf(designPageHeader));
            Reports.generateReport(driver, test, Status.PASS, "Navigated to Design Selection Page");
            return true;
        } catch (TimeoutException e) {
            Reports.generateReport(driver, test, Status.FAIL, "Design Selection Page not displayed");
            return false;
        }
    }

    
    public boolean verifyEGiftCardPage1() {
    	String url=prop.getProperty("endUrl");
    	//System.out.println("Navigating to: " + url);
        driver.get(url);
        try {
            wait.until(ExpectedConditions.visibilityOf(eGiftCardPageHeader));
            Reports.generateReport(driver, test, Status.PASS, "E-Gift Card page is displayed");
            return true;
        } catch (TimeoutException e) {
            Reports.generateReport(driver, test, Status.FAIL, "E-Gift Card page is not displayed");
            return false;
        }
    }
    

    
  
 // Enter recipient name
    public void enterRecipientName(String recipient) {
        try {
            wait.until(ExpectedConditions.visibilityOf(recipientNameInput));
            recipientNameInput.clear();
            recipientNameInput.sendKeys(recipient);
            Reports.generateReport(driver, test, Status.INFO, "Entered recipient name: " + recipient);
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to enter recipient name");
        }
    }

   // Enter sender name
    public void enterSenderName(String sender) {
        try {
            wait.until(ExpectedConditions.visibilityOf(senderNameInput));
            senderNameInput.clear();
           senderNameInput.sendKeys(sender);
          Reports.generateReport(driver, test, Status.INFO, "Entered sender name: " + sender);
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to enter sender name");
        }
   }
    
    public String getResponseMessage() {
       try {
            wait.until(ExpectedConditions.visibilityOf(responseMessage));
            String message = responseMessage.getText().trim();
            Reports.generateReport(driver, test, Status.INFO, "Fetched response message: " + message);
            return message;
       } catch (TimeoutException e) {
            Reports.generateReport(driver, test, Status.FAIL, "Response message not displayed");
            return "Message not found";
        }
    }
    
    
}