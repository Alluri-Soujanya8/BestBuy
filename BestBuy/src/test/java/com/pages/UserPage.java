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

	    static Properties prop = PropertyReader.readProperty();
	    private static WebDriver driver;
	    private static WebDriverWait wait;
	    static ExtentTest test;

	    // Locators
	    private static By more = By.xpath("//span[text()='More']");
	    private static By giftCards = By.xpath("//a[text()='Gift Cards']");
	    private static By verifyGiftCardsPage = By.xpath("//h1[text()='Best Buy Gift Cards']");
	    private static By eGiftCardLink = By.xpath("//span[text()='Best Buy E-Gift Cards*']");
	    private static By eGiftCardPageHeader = By.xpath("//span[text()='Who is the e-gift card for?']");
	    private static By recipientNameInput = By.id("recipientName-input");
	    private static By senderNameInput = By.id("senderName-input");
	    private static By sendDigitalCardButton = By.xpath("//button[@data-cashbot-id='recipient-button-submit']");
	    private static By designPageHeader = By.xpath("//span[text()='Choose your e-gift card design.']");
	    private static By birthdayDesign = By.xpath("//div[text()='Birthday']");
	    private static By continueButton = By.xpath("//button[@data-cashbot-id='choice-button-submit']");
	    private static By amountPageHeader = By.xpath("//span[text()='How much do you want to give?']");
	    private static By amountOption = By.xpath("//div[@id='amount-0-label']");
	    private static By addMessageButton = By.xpath("//button[@data-cashbot-id='amount-button-submit']");
	    private static By addMessagePageHeader = By.xpath("//span[text()='Add a personalized message.']");
	    private static By continueButtonOnAddMessage = By.xpath("//button[@data-cashbot-id='message-button-submit']");
	    private static By addToCartPageHeader = By.xpath("//span[text()='How would you like it delivered?']");
	    private static By emailInput = By.id("recipientEmail-input");
	    private static By confirmEmailInput = By.id("recipientEmailConfirmation-input");
	    private static By addToCartButton = By.xpath("//button[@data-cashbot-id='delivery-button-submit']");
	    private static By checkoutPageHeader = By.xpath("//span[text()='Review your cart.']");

	    public UserPage(WebDriver driver, ExtentTest test) {
	        UserPage.driver = driver;
	        UserPage.test = test;
	        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    }

	    // ---------------- Scenario 1 ----------------
	    public boolean verifyMore() {
	        try {
	            wait.until(ExpectedConditions.visibilityOfElementLocated(more));
	            Reports.generateReport(driver, test, Status.PASS, "Gift Cards Functionality is displayed");
	            return true;
	        } catch (TimeoutException te) {
	            Reports.generateReport(driver, test, Status.FAIL, "Gift Cards Functionality is not displayed");
	            return false;
	        }
	    }

	    public boolean clickMore() {
	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(more)).click();
	            Reports.generateReport(driver, test, Status.PASS, "Clicked on More");
	            return true;
	        } catch (TimeoutException te) {
	            Reports.generateReport(driver, test, Status.FAIL, "More button not displayed");
	            return false;
	        }
	    }

	    public boolean selectGiftCards() {
	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(giftCards)).click();
	            Reports.generateReport(driver, test, Status.PASS, "Clicked on Gift Cards");
	            return true;
	        } catch (TimeoutException te) {
	            Reports.generateReport(driver, test, Status.FAIL, "Gift Cards link not displayed");
	            return false;
	        }
	    }

	    public boolean verifyGiftCardsPage() {
	        try {
	            wait.until(ExpectedConditions.visibilityOfElementLocated(verifyGiftCardsPage));
	            Reports.generateReport(driver, test, Status.PASS, "Gift Cards page is displayed");
	            return true;
	        } catch (TimeoutException te) {
	            Reports.generateReport(driver, test, Status.FAIL, "Gift Cards page is not displayed");
	            return false;
	        }
	    }

	    // ---------------- Scenario 2 ----------------
	    public boolean clickEGiftCards() {
	        String url = prop.getProperty("targetUrl");
	        driver.get(url);
	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(eGiftCardLink)).click();
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
	            wait.until(ExpectedConditions.visibilityOfElementLocated(recipientNameInput)).sendKeys(recipient);
	            wait.until(ExpectedConditions.visibilityOfElementLocated(senderNameInput)).sendKeys(sender);
	            Reports.generateReport(driver, test, Status.INFO, "Entered recipient: " + recipient + " and sender: " + sender);
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

	    // ---------------- Scenario 3 ----------------
	    public boolean navigateToDesignSelectionPage(String recipient, String sender) {
	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(more)).click();
	            wait.until(ExpectedConditions.elementToBeClickable(giftCards)).click();
	            wait.until(ExpectedConditions.elementToBeClickable(eGiftCardLink)).click();
	            wait.until(ExpectedConditions.visibilityOfElementLocated(recipientNameInput)).sendKeys(recipient);
	            wait.until(ExpectedConditions.visibilityOfElementLocated(senderNameInput)).sendKeys(sender);
	            wait.until(ExpectedConditions.elementToBeClickable(sendDigitalCardButton)).click();
	            Reports.generateReport(driver, test, Status.INFO, "Navigated to Design Selection Page and entered details");
	            return true;
	        } catch (TimeoutException e) {
	            Reports.generateReport(driver, test, Status.FAIL, "Failed to navigate to Design Selection Page");
	            return false;
	        }
	    }

	    public boolean verifyDesignSelectionPage() {
	        try {
	            wait.until(ExpectedConditions.visibilityOfElementLocated(designPageHeader));
	            Reports.generateReport(driver, test, Status.PASS, "Design Selection Page is displayed");
	            return true;
	        } catch (TimeoutException e) {
	            Reports.generateReport(driver, test, Status.FAIL, "Design Selection Page not displayed");
	            return false;
	        }
	    }

	    public boolean selectDesign() {
	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(birthdayDesign)).click();
	            Reports.generateReport(driver, test, Status.INFO, "Selected first design");
	            return true;
	        } catch (TimeoutException e) {
	            Reports.generateReport(driver, test, Status.FAIL, "Failed to select design");
	            return false;
	        }
	    }

	    public boolean clickContinue() {
	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
	            Reports.generateReport(driver, test, Status.INFO, "Clicked Continue");
	            return true;
	        } catch (TimeoutException e) {
	            Reports.generateReport(driver, test, Status.FAIL, "Failed to click Continue");
	            return false;
	        }
	    }

	    public boolean verifyAmountPage() {
	        try {
	            wait.until(ExpectedConditions.visibilityOfElementLocated(amountPageHeader));
	            Reports.generateReport(driver, test, Status.PASS, "Amount Page is displayed");
	            return true;
	        } catch (TimeoutException e) {
	            Reports.generateReport(driver, test, Status.FAIL, "Amount Page not displayed");
	            return false;
	        }
	    }

	    public boolean selectAmount() {
	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(amountOption)).click();
	            Reports.generateReport(driver, test, Status.INFO, "Selected amount: $25");
	            return true;
	        } catch (TimeoutException e) {
	            Reports.generateReport(driver, test, Status.FAIL, "Failed to select amount");
	            return false;
	        }
	    }

	    public boolean clickAddMessage() {
	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(addMessageButton)).click();
	            Reports.generateReport(driver, test, Status.INFO, "Clicked Add a Message");
	            return true;
	        } catch (TimeoutException e) {
	            Reports.generateReport(driver, test, Status.FAIL, "Failed to click Add a Message");
	            return false;
	        }
	    }

	    public boolean verifyAddMessagePage() {
	        try {
	            wait.until(ExpectedConditions.visibilityOfElementLocated(addMessagePageHeader));
	            Reports.generateReport(driver, test, Status.PASS, "Add Message Page is displayed");
	            return true;
	        } catch (TimeoutException e) {
	            Reports.generateReport(driver, test, Status.FAIL, "Add Message Page not displayed");
	            return false;
	        }
	    }

	    // ---------------- Scenario Outline 1 ----------------
	    public boolean verifyEGiftCardPage1() {
	        try {
	            driver.findElement(more).click();
	            driver.findElement(giftCards).click();
	            driver.findElement(eGiftCardLink).click();
	            wait.until(ExpectedConditions.visibilityOfElementLocated(eGiftCardPageHeader));
	            Reports.generateReport(driver, test, Status.PASS, "E-Gift Card page is displayed");
	            return true;
	        } catch (TimeoutException e) {
	            Reports.generateReport(driver, test, Status.FAIL, "E-Gift Card page is not displayed");
	            return false;
	        }
	    }

	    public void enterRecipientAndSender1(String recipient, String sender) {
	        try {
	            wait.until(ExpectedConditions.visibilityOfElementLocated(recipientNameInput)).sendKeys(recipient);
	            wait.until(ExpectedConditions.visibilityOfElementLocated(senderNameInput)).sendKeys(sender);
	            Reports.generateReport(driver, test, Status.INFO, "Entered recipient: " + recipient + " and sender: " + sender);
	        } catch (Exception e) {
	            Reports.generateReport(driver, test, Status.FAIL, "Failed to enter names");
	        }
	    }

	    public void clickSendDigitalCard1() {
	        try {
	            driver.findElement(sendDigitalCardButton).click();
	            Reports.generateReport(driver, test, Status.INFO, "Clicked Send Digital Card");
	        } catch (Exception e) {
	            Reports.generateReport(driver, test, Status.FAIL, "Failed to click Send Digital Card");
	        }
	    }

	    // ---------------- Scenario Outline 2 ----------------
	    public boolean navigateToAddMessagePage(String recipient, String sender) {
	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(more)).click();
	            wait.until(ExpectedConditions.elementToBeClickable(giftCards)).click();
	            wait.until(ExpectedConditions.elementToBeClickable(eGiftCardLink)).click();
	            wait.until(ExpectedConditions.visibilityOfElementLocated(recipientNameInput)).sendKeys(recipient);
	            wait.until(ExpectedConditions.visibilityOfElementLocated(senderNameInput)).sendKeys(sender);
	            wait.until(ExpectedConditions.elementToBeClickable(sendDigitalCardButton)).click();

	            // Design Page
	            wait.until(ExpectedConditions.visibilityOfElementLocated(designPageHeader));
	            wait.until(ExpectedConditions.elementToBeClickable(birthdayDesign)).click();
	            wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();

	            // Amount Page
	            wait.until(ExpectedConditions.visibilityOfElementLocated(amountPageHeader));
	            wait.until(ExpectedConditions.elementToBeClickable(amountOption)).click();
	            wait.until(ExpectedConditions.elementToBeClickable(addMessageButton)).click();

	            Reports.generateReport(driver, test, Status.INFO, "Navigated to Add Message Page");
	            return true;
	        } catch (TimeoutException e) {
	            Reports.generateReport(driver, test, Status.FAIL, "Failed to navigate to Add Message Page");
	            return false;
	        }
	    }

	    public boolean verifyAddMessagePage1() {
	        try {
	            wait.until(ExpectedConditions.visibilityOfElementLocated(addMessagePageHeader));
	            Reports.generateReport(driver, test, Status.PASS, "Add Message Page is displayed");
	            return true;
	        } catch (TimeoutException e) {
	            Reports.generateReport(driver, test, Status.FAIL, "Add Message Page not displayed");
	            return false;
	        }
	    }

	    public boolean clickContinueFromAddMessage() {
	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(continueButtonOnAddMessage)).click();
	            Reports.generateReport(driver, test, Status.INFO, "Clicked Continue on Add Message Page");
	            return true;
	        } catch (TimeoutException e) {
	            Reports.generateReport(driver, test, Status.FAIL, "Failed to click Continue on Add Message Page");
	            return false;
	        }
	    }

	    public boolean verifyAddToCartPage() {
	        try {
	            wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartPageHeader));
	            Reports.generateReport(driver, test, Status.PASS, "Add to Cart Page is displayed");
	            return true;
	        } catch (TimeoutException e) {
	            Reports.generateReport(driver, test, Status.FAIL, "Add to Cart Page not displayed");
	            return false;
	        }
	    }

	    public boolean enterEmailDetails(String email, String confirmEmail) {
	        try {
	            wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(email);
	            wait.until(ExpectedConditions.visibilityOfElementLocated(confirmEmailInput)).sendKeys(confirmEmail);
	            Reports.generateReport(driver, test, Status.INFO, "Entered Email and Confirm Email");
	            return true;
	        } catch (TimeoutException e) {
	            Reports.generateReport(driver, test, Status.FAIL, "Failed to enter Email details");
	            return false;
	        }
	    }

	    public boolean clickAddToCart() {
	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
	            Reports.generateReport(driver, test, Status.INFO, "Clicked Add to Cart");
	            return true;
	        } catch (TimeoutException e) {
	            Reports.generateReport(driver, test, Status.FAIL, "Failed to click Add to Cart");
	            return false;
	        }
	    }

	    public boolean verifyCheckoutPage() {
	        try {
	            wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutPageHeader));
	            Reports.generateReport(driver, test, Status.PASS, "Checkout Page is displayed");
	            return true;
	        } catch (TimeoutException e) {
	            Reports.generateReport(driver, test, Status.FAIL, "Checkout Page not displayed");
	            return false;
	        }
	    }
	}
   



   