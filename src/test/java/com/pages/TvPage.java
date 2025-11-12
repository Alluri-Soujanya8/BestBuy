package com.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setup.Reports;

public class TvPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest test;

    // Locators
    private By tvHeader = By.xpath("//h1[contains(text(),'LG TVs')]");
    private By filterPanel = By.xpath("//div[contains(@class,'facet-section')]");
    private By tvlocator = By.id("televisiontype_facet-search-bar-input");
    private By checkBoxLocator = By.xpath("//*[@id=\"televisiontype_facet-search-bar-input\"]");
    
//    private By condlocator = By.className("condition-facet-list");
//    private By resolutionlocator = By.xpath("(//section[contains(@class, 'facet')])[9]");
//    private By workswithlocator = By.xpath("(//section[contains(@class, 'facet')])[14]");
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
            return false;
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

//    public boolean applyFilter(String category, String value) {
//        try {
//            By elementLocator;
//
//            if (category.equalsIgnoreCase("Television Type")) {
//                // Search and click checkbox by ID
//                WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(tvlocator));
//                searchInput.clear();
//                searchInput.sendKeys(value);
//
//                elementLocator = By.id(value); // Example: Smart
//            } 
////            else if (category.equalsIgnoreCase("Condition")) {
////                // Condition uses clickable cards
////                elementLocator = By.xpath("//button//div[text() = 'New']");
////            } 
//            else if (category.equalsIgnoreCase("Resolution") ) {
//                // Resolution and Voice Assistant use checkboxes
//                elementLocator = By.id("Full_HD_(1080p)");
//            } 
//            
//
//            // Wait and click using JS for reliability
//
//
//
//            Reports.generateReport(driver, test, Status.PASS, "Applied filter: " + category + " = " + value);
//            return true;
//
//        } catch (Exception e) {
//            Reports.generateReport(driver, test, Status.FAIL,
//                    "Failed to apply filter: " + category + " = " + value + ". Error: " + e.getMessage());
//            return true;
//        }
//    }

//    public boolean applyFilter(String category, String value) {
//        try {
//            WebElement filterElement = null;
//
//            switch (category.toLowerCase()) {
//                case "television type":
//                    WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(tvlocator));
//                    searchInput.clear();
//                    searchInput.sendKeys(value);
//                    filterElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("Smart")));
//                    break;
//
//                case "condition":
//                    filterElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button//div[text()='New']")));
//                    break;
//
//                case "resolution":
//                    filterElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='checkbox' and @aria-label='Full HD (1080p)']")));
//                    break;
//
//                case "customer ratings":
//                    filterElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='checkbox' and @aria-label='Top-Rated']" )));
//                    break;
//
//                default:
//                    Reports.generateReport(driver, test, Status.FAIL, "Unknown filter category: " + category);
//                    return false;
//            }
//
//            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", filterElement);
//            Reports.generateReport(driver, test, Status.PASS, "Applied filter: " + category + " = " + value);
//            return true;
//
//        } catch (Exception e) {
//            Reports.generateReport(driver, test, Status.FAIL, "Failed to apply filter: " + category + " = " + value + ". Error: " + e.getMessage());
//            return false;
//        }
//    }

    
    public boolean applyFilter(String category, String value) {
        try {
            By elementLocator ;

            // Handle different filter categories
            if (category.equalsIgnoreCase("Television Type")) {
                // Example: Smart TV, LED TV
                WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(tvlocator));
                searchInput.clear();
                searchInput.sendKeys(value);
                elementLocator = By.xpath("//input[@type='checkbox' and @id='" + value + "']");
            } else if (category.equalsIgnoreCase("Resolution")) {
                // Example: Full HD, 4K Ultra HD
                elementLocator = By.xpath("//input[@type='checkbox' and @id='" + value + "']");
            } else if (category.equalsIgnoreCase("Condition")) {
                // Example: New, Refurbished
                elementLocator = By.xpath("//button//div[text()='" + value + "']");
            } else if (category.equalsIgnoreCase("Brand")) {
                // Example: Sony, LG, Samsung
                elementLocator = By.xpath("//input[@type='checkbox' and @id='" + value + "']");
            } else {
                throw new RuntimeException("Unknown filter category: " + category);
            }

            // Wait for element and click using JavaScript for reliability
            WebElement filterElement = wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", filterElement);

            Reports.generateReport(driver, test, Status.PASS, "Applied filter: " + category + " = " + value);
            return true;

        } catch (Exception e) {
            Reports.generateReport(driver, test, Status.FAIL,
                    "Failed to apply filter: " + category + " = " + value + ". Error: " + e.getMessage());
            return false;
        }
    }
    // Verify filtered results
    public boolean verifyFilteredResults() {
        try {
            List<WebElement> results = driver.findElements(productTitles);
            if (results.size() > 0) {
                Reports.generateReport(driver, test, Status.PASS,
                        "Filtered TV models displayed: " + results.size());
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
}