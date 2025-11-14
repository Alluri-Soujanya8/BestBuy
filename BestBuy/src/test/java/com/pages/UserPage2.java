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

    
    @FindBy(xpath="//span[text()='Choose your e-gift card design.']")
    private static WebElement designPageHeader ;
    

    @FindBy(xpath = "//div[text()='Birthday']") 
      private static WebElement birthdayDesign;


    @FindBy(xpath = "//button[@data-cashbot-id='choice-button-submit']")
    private static WebElement continueButton;

    @FindBy(xpath = "//span[text()='How much do you want to give?']")
    private static WebElement amountPageHeader;

    @FindBy(xpath ="//div[@id='amount-0-label']") // Example locator for $25amount
    private static WebElement amountOption;


    @FindBy(xpath = "//button[@data-cashbot-id=\"amount-button-submit\"]")
     private static WebElement addMessageButton;
      

    @FindBy(xpath = "//span[text()='Add a personalized message.']")
      private static WebElement addMessagePageHeader;
  
  
    @FindBy(xpath="//button[@data-cashbot-id=\"message-button-submit\"]")
   public static WebElement continueButtonOnAddMessage;

   @FindBy(xpath="//span[text()='How would you like it delivered?']")
   public static WebElement addToCartPageHeader ;
 
   @FindBy(id="recipientEmail-input")
   public static WebElement emailInput;

   @FindBy(id="recipientEmailConfirmation-input")
   public static WebElement confirmEmailInput;

   @FindBy(xpath="//button[@data-cashbot-id=\"delivery-button-submit\"]")
   public static WebElement addToCartButton;
   
   @FindBy(xpath="//span[text()='Review your cart.']")
   public static WebElement checkoutPageHeader;
   

    public UserPage2(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test=test;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
        
    }
    //-----------scenario 1----------------
    public static boolean verifyMore()
	{
		boolean actResult = true;
        try
        {
            wait.until(ExpectedConditions.visibilityOf(more));
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
            wait.until(ExpectedConditions.visibilityOf(more));
            Reports.generateReport(driver, test, Status.PASS, "Gift Cards Functionality is displayed");
           more.click();
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
            wait.until(ExpectedConditions.visibilityOf(giftCards));
            Reports.generateReport(driver, test, Status.PASS, "Gift Cards Functionality is displayed");
            giftCards.click();
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
            wait.until(ExpectedConditions.visibilityOf(verifyGiftCardsPage));
            Reports.generateReport(driver, test, Status.PASS, "Gift Cards Functionality is displayed");
        }
        catch (TimeoutException te)
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Gift Cards Functionality is not displayed");
        }
        return actResult;
    }
    
  //-------------Scenario 2 --------------------------  
    
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
    
    //-----------------scenario 3-----------------------------

           
 // Navigate to Design Selection Page
    public boolean navigateToDesignSelectionPage(String recipient, String sender) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(more)).click();
            wait.until(ExpectedConditions.elementToBeClickable(giftCards)).click();
            wait.until(ExpectedConditions.elementToBeClickable(eGiftCardLink)).click();
           wait.until(ExpectedConditions.visibilityOf(recipientNameInput)).sendKeys(recipient);
          wait.until(ExpectedConditions.visibilityOf(senderNameInput)).sendKeys(sender);
          wait.until(ExpectedConditions.elementToBeClickable(sendDigitalCardButton)).click();

            Reports.generateReport(driver, test, Status.INFO, "Navigated to Design Selection Page and entered details");
            return true;
        } catch (TimeoutException e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to navigate to Design Selection Page");
            return false;
        }
    }

    // Verify Design Selection Page
    public boolean verifyDesignSelectionPage() {
        try {
            wait.until(ExpectedConditions.visibilityOf(designPageHeader));
            Reports.generateReport(driver, test, Status.PASS, "Design Selection Page is displayed");
            return true;
        } catch (TimeoutException e) {
            Reports.generateReport(driver, test, Status.FAIL, "Design Selection Page not displayed");
            return false;
        }
    }


            // Select a design
            public boolean selectDesign() {
                try {
                    wait.until(ExpectedConditions.elementToBeClickable(birthdayDesign));
                    birthdayDesign.click();
                    Reports.generateReport(driver, test, Status.INFO, "Selected first design");
                    return true;
                } catch (TimeoutException e) {
                    Reports.generateReport(driver, test, Status.FAIL, "Failed to select design");
                    return false;
                }
            }

            // Click Continue and navigate to Amount Page
            public boolean clickContinue() {
                try {
                    wait.until(ExpectedConditions.elementToBeClickable(continueButton));
                    continueButton.click();
                    Reports.generateReport(driver, test, Status.INFO, "Clicked Continue");
                    return true;
                } catch (TimeoutException e) {
                    Reports.generateReport(driver, test, Status.FAIL, "Failed to click Continue");
                    return false;
                }
            }

            // Verify Amount Page
            public boolean verifyAmountPage() {
                try {
                    wait.until(ExpectedConditions.visibilityOf(amountPageHeader));
                    Reports.generateReport(driver, test, Status.PASS, "Amount Page is displayed");
                    return true;
                } catch (TimeoutException e) {
                    Reports.generateReport(driver, test, Status.FAIL, "Amount Page not displayed");
                    return false;
                }
            }

            // Select an amount
            public boolean selectAmount() {
                try {
                    wait.until(ExpectedConditions.elementToBeClickable(amountOption));
                    amountOption.click();
                    Reports.generateReport(driver, test, Status.INFO, "Selected amount: $25");
                    return true;
                } catch (TimeoutException e) {
                    Reports.generateReport(driver, test, Status.FAIL, "Failed to select amount");
                    return false;
                }
            }

            // Click Add a Message
            public boolean clickAddMessage() {
                try {
                    wait.until(ExpectedConditions.elementToBeClickable(addMessageButton));
                    addMessageButton.click();
                    Reports.generateReport(driver, test, Status.INFO, "Clicked Add a Message");
                    return true;
                } catch (TimeoutException e) {
                    Reports.generateReport(driver, test, Status.FAIL, "Failed to click Add a Message");
                    return false;
                }
            }

            // Verify Add Message Page
            public boolean verifyAddMessagePage() {
                try {
                    wait.until(ExpectedConditions.visibilityOf(addMessagePageHeader));
                    Reports.generateReport(driver, test, Status.PASS, "Add Message Page is displayed");
                    return true;
                } catch (TimeoutException e) {
                    Reports.generateReport(driver, test, Status.FAIL, "Add Message Page not displayed");
                    return false;
                }
            }
            
            //scenario outline 1 ------------------------
            public boolean verifyEGiftCardPage1() {

                try {
                	more.click();
                	giftCards.click();
                	eGiftCardLink.click();
                    wait.until(ExpectedConditions.visibilityOf(eGiftCardPageHeader));
                    Reports.generateReport(driver, test, Status.PASS, "E-Gift Card page is displayed");
                    return true;
                } catch (TimeoutException e) {
                    Reports.generateReport(driver, test, Status.FAIL, "E-Gift Card page is not displayed");
                    return false;
                }
            }

            public void enterRecipientAndSender1(String recipient, String sender) {
        	
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

            public void clickSendDigitalCard1() {
                try {
                   sendDigitalCardButton.click();
                    Reports.generateReport(driver, test, Status.INFO, "Clicked Send Digital Card");
                } catch (Exception e) {
                    Reports.generateReport(driver, test, Status.FAIL, "Failed to click Send Digital Card");
                }

            }
            
            
        //-------------------scenario outline 2--------------------
         // Navigate from More → Gift Cards → eGiftCard → enter Recipient & Sender → reach Add Message Page
            public boolean navigateToAddMessagePage(String recipient, String sender) {
                try {
                    wait.until(ExpectedConditions.elementToBeClickable(more)).click();
                    wait.until(ExpectedConditions.elementToBeClickable(giftCards)).click();
                    wait.until(ExpectedConditions.elementToBeClickable(eGiftCardLink)).click();
                    wait.until(ExpectedConditions.visibilityOf(recipientNameInput)).sendKeys(recipient);
                    wait.until(ExpectedConditions.visibilityOf(senderNameInput)).sendKeys(sender);
                    wait.until(ExpectedConditions.elementToBeClickable(sendDigitalCardButton)).click();

                    // Verify Design Selection Page
                    wait.until(ExpectedConditions.visibilityOf(designPageHeader));
                    wait.until(ExpectedConditions.elementToBeClickable(birthdayDesign)).click();
                    wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();

                    // Verify Amount Page
                    wait.until(ExpectedConditions.visibilityOf(amountPageHeader));
                    wait.until(ExpectedConditions.elementToBeClickable(amountOption)).click();
                    wait.until(ExpectedConditions.elementToBeClickable(addMessageButton)).click();

                    Reports.generateReport(driver, test, Status.INFO, "Navigated to Add Message Page");
                    return true;
                } catch (TimeoutException e) {
                    Reports.generateReport(driver, test, Status.FAIL, "Failed to navigate to Add Message Page");
                    return false;
                }
            }

            // Verify Add Message Page
            public boolean verifyAddMessagePage1() {
                try {
                    wait.until(ExpectedConditions.visibilityOf(addMessagePageHeader));
                    Reports.generateReport(driver, test, Status.PASS, "Add Message Page is displayed");
                    return true;
                } catch (TimeoutException e) {
                    Reports.generateReport(driver, test, Status.FAIL, "Add Message Page not displayed");
                    return false;
                }
            }

            // Click Continue from Add Message Page
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

            // Verify Add to Cart Page
            public boolean verifyAddToCartPage() {
                try {
                    wait.until(ExpectedConditions.visibilityOf(addToCartPageHeader));
                    Reports.generateReport(driver, test, Status.PASS, "Add to Cart Page is displayed");
                    return true;
                } catch (TimeoutException e) {
                    Reports.generateReport(driver, test, Status.FAIL, "Add to Cart Page not displayed");
                    return false;
                }
            }

            // Enter Email and Confirm Email
            public boolean enterEmailDetails(String email, String confirmEmail) {
                try {
                    wait.until(ExpectedConditions.visibilityOf(emailInput)).sendKeys(email);
                    wait.until(ExpectedConditions.visibilityOf(confirmEmailInput)).sendKeys(confirmEmail);
                    Reports.generateReport(driver, test, Status.INFO, "Entered Email and Confirm Email");
                    return true;
                } catch (TimeoutException e) {
                    Reports.generateReport(driver, test, Status.FAIL, "Failed to enter Email details");
                    return false;
                }
            }

            // Click Add to Cart
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

            // Verify Checkout Page
            public boolean verifyCheckoutPage() {
                try {
                    wait.until(ExpectedConditions.visibilityOf(checkoutPageHeader));
                    Reports.generateReport(driver, test, Status.PASS, "Checkout Page is displayed");
                    return true;
                } catch (TimeoutException e) {
                    Reports.generateReport(driver, test, Status.FAIL, "Checkout Page not displayed");
                    return false;
                }
            }

    }

    
