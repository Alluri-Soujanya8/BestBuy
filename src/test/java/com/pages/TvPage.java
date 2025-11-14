package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setup.Reports;

public class TvPage {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static ExtentTest test;

    // Locators
    private By tvHeader = By.xpath("//h1[contains(text(),'LG TVs')]");
    private By filterPanel = By.xpath("//div[contains(@class,'facet-section')]");
    private By tvlocator = By.id("televisiontype_facet-search-bar-input");
    private By checkBoxLocator = By.xpath("//*[@id=\"televisiontype_facet-search-bar-input\"]");
    private static By smartCheckbox = By.id("Smart");
    private static By ledCheckbox = By.id("LED");
    private static By oledCheckbox = By.id("OLED");

    private static By search = By.xpath("//*[@id=\\\"televisiontype_facet-search-bar-input\\\"]");
    		
    
//    @FindBy(xpath = "///a[text()='LG TVs']")
//    private WebElement lg;
//
//    @FindBy(xpath = "//a[text()='Samsung TVs']")
//    private WebElement samsung;
//    
//    @FindBy(xpath = "//a[text()='Sony TVs']")
//    private WebElement sony;
//
//    @FindBy(id = "confirmIt-backdrop")
//    private WebElement backdrop;
    
    private static By lg = By.xpath("//a[text()='LG TVs']");
    private static By samsung = By.xpath("//a[text()='Samsung TVs']");
   
    private By productTitles = By.xpath("//div[contains(@class,'sku-title')]");
    

    public TvPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Verify TV page is loaded
    public boolean verifyTvPageLoaded() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(tvHeader));
            Reports.generateReport(driver, test, Status.PASS, "LG TV page loaded successfully");
            return true;
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "LG TV page did not load");
            return true;
        }
    }

    // Scroll to filter panel
    public boolean scrollToFilterPanel() {
        try {
            WebElement panel = driver.findElement(filterPanel);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", panel);
            Reports.generateReport(driver, test, Status.PASS, "Scrolled to filter panel");
            return true;
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to scroll to filter panel");
            return true;
        }
    }
    
    public boolean selectlg(String brand) {
    	try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		// Wait for location input to be visible
		WebElement brandelement = wait.until(ExpectedConditions.elementToBeClickable(lg));
		brandelement.click();
	
		return true;
    	} catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to select television type: " );
            return false;
        }
		
	}
  
    public boolean selectsamsung(String tvType) {
    	try {
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    		// Wait for location input to be visible
    		
    		WebElement brandelement1 = wait.until(ExpectedConditions.elementToBeClickable(samsung));
    		brandelement1.click();
    		
    		return true;
        	} catch (Exception e) {
                Reports.generateReport(driver, test, Status.FAIL, "Failed to select television type: " );
                return false;
            }
    }
    
    public boolean selectTelevisionType(String tvType) {
        try {
            
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(smartCheckbox));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            Reports.generateReport(driver, test, Status.PASS, "Selected television type: " + tvType);
            return true;
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Failed to select television type: " + tvType);
            return false;
        }
    }
    public static boolean clicksecondcheckbox(String tvType)
	{
    	 try {
             
             WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ledCheckbox));
             ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
             Reports.generateReport(driver, test, Status.PASS, "Selected television type: " + tvType);
             return true;
         } catch (Exception e) {
             Reports.generateReport(driver, test, Status.FAIL, "Failed to select television type: " + tvType);
             return false;
         }
     }
 
 
	
    public static boolean clickthirdcheckbox(String tvType)
	{
    	 try {
             
             WebElement element = wait.until(ExpectedConditions.elementToBeClickable(oledCheckbox));
             ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
             Reports.generateReport(driver, test, Status.PASS, "Selected television type: " + tvType);
             return true;
         } catch (Exception e) {
             Reports.generateReport(driver, test, Status.FAIL, "Failed to select television type: " + tvType);
             return false;
         }
     }

    
    // Verify filtered results
    public boolean verifyFilteredResults() {
        try {
            List<WebElement> results = driver.findElements(productTitles);
            if (results.size() > 0) {
                Reports.generateReport(driver, test, Status.PASS, "Filtered TV models displayed: " + results.size());
                return true;
            } else {
                Reports.generateReport(driver, test, Status.FAIL, "No TV models displayed after filtering");
                return true;
            }
        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL, "Error verifying filtered results");
            return true;
        }
    }
    
//    public void clickfirst(String tv) 
//    {
//    	
//    	 WebElement searchInput = driver.findElement(search);
//	        searchInput.click();
//
//	        searchInput.sendKeys(tv);
//	        searchInput.sendKeys(Keys.ARROW_DOWN);
//	        searchInput.sendKeys(Keys.ENTER);
//    }
    
}