package com.pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.parameters.PropertyReader;
import com.setup.Reports;

public class UserPage {

    private static WebDriver driver;
    private static WebDriverWait wait;
    static ExtentTest test;


    private static By more=By.xpath("//span[text()='More']") ;
  
    private static By giftCards=By.xpath("//a[text()='Gift Cards']");
    private static By verifyGiftCardsPage =By.xpath("//h1[text()='Best Buy Gift Cards']") ; 
  //span[text()='Best Buy E-Gift Cards*']
    

private static By eGiftCardLink = By.xpath("//span[text()='Best Buy E-Gift Cards*']"); // Adjust if needed
private static By eGiftCardPageHeader = By.xpath("//span[text()='Who is the e-gift card for?']");
private static By recipientNameInput = By.id("recipientName-input"); // Adjust ID as per actual DOM
private static By senderNameInput = By.id("senderName-input");       // Adjust ID as per actual DOM
private static By sendDigitalCardButton = By.xpath("//button[@data-cashbot-id='recipient-button-submit']");   // Adjust ID as per actual DOM
private static By designPageHeader = By.xpath("//span[text()='Choose your e-gift card design.']");


    
static Properties prop = PropertyReader.readProperty();

    public UserPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test=test;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    public static boolean verifyMore()
	{
    	
		boolean actResult = true;
        try
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(more));
            Reports.generateReport(driver, test, Status.PASS, "Gift Cards Functionality is displayed");
        }
        catch (TimeoutException te)
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Gift Cards Functionality is not displayed");
        }
        return actResult;
	}

    public boolean clickMore() {
    	boolean actResult = true;
        try
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(more));
            Reports.generateReport(driver, test, Status.PASS, "Gift Cards Functionality is displayed");
            driver.findElement(more).click();
        }
        catch (TimeoutException te)
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Gift Cards Functionality is not displayed");
        }
        return actResult;
    }

    public boolean selectGiftCards() {
    	boolean actResult = true;
        try
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(giftCards));
            Reports.generateReport(driver, test, Status.PASS, "Gift Cards Functionality is displayed");
            driver.findElement(giftCards).click();
        }
        catch (TimeoutException te)
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Gift Cards Functionality is not displayed");
        }
        return actResult;
    }

    public boolean verifyGiftCardsPage() {
    	boolean actResult = true;
        try
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(verifyGiftCardsPage));
            Reports.generateReport(driver, test, Status.PASS, "Gift Cards Functionality is displayed");
        }
        catch (TimeoutException te)
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Gift Cards Functionality is not displayed");
        }
        return actResult;
    }
    
    

public boolean clickEGiftCards() {
	String url=prop.getProperty("targetUrl");
    driver.get(url);
    try {
        wait.until(ExpectedConditions.elementToBeClickable(eGiftCardLink));
        driver.findElement(eGiftCardLink).click();
        Reports.generateReport(driver, test, Status.PASS, "Clicked on E-Gift Cards");
        return true;
    } catch (TimeoutException e) {
        Reports.generateReport(driver, test, Status.FAIL, "Failed to click E-Gift Cards");
        return false;
    }
}

public boolean verifyEGiftCardPage() {
    try {
        wait.until(ExpectedConditions.visibilityOfElementLocated(eGiftCardPageHeader));
        Reports.generateReport(driver, test, Status.PASS, "E-Gift Card page is displayed");
        return true;
    } catch (TimeoutException e) {
        Reports.generateReport(driver, test, Status.FAIL, "E-Gift Card page is not displayed");
        return false;
    }
}

public void enterRecipientAndSender(String recipient, String sender) {
    try {
        WebElement recipientField = driver.findElement(recipientNameInput);
        WebElement senderField = driver.findElement(senderNameInput);
        recipientField.clear();
        recipientField.sendKeys(recipient);
        senderField.clear();
        senderField.sendKeys(sender);
        Reports.generateReport(driver, test, Status.INFO, "Entered recipient and sender names");

    } catch (Exception e) {
         Reports.generateReport(driver, test, Status.FAIL, "Failed to enter names");
     }
 }

public void clickSendDigitalCard() {
    try {
        driver.findElement(sendDigitalCardButton).click();
        Reports.generateReport(driver, test, Status.INFO, "Clicked Send Digital Card");
    } catch (Exception e) {
        Reports.generateReport(driver, test, Status.FAIL, "Failed to click Send Digital Card");
    }
}

public boolean verifyDesignPage() {
	String url=prop.getProperty("endUrl");
    driver.get(url);
    try {
        wait.until(ExpectedConditions.visibilityOfElementLocated(designPageHeader));
        Reports.generateReport(driver, test, Status.PASS, "Navigated to Design Selection Page");
        return true;
    } catch (TimeoutException e) {
        Reports.generateReport(driver, test, Status.FAIL, "Design Selection Page not displayed");
        return false;
    }
}

    
}
   