//package com.pages;
//
//import java.time.Duration;
//import org.openqa.selenium.*;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.setup.Reports;
//
//public class Brand {
//
//    private WebDriver driver;
//    private WebDriverWait wait;
//    private ExtentTest test;
//
//    // Page Factory locators
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
//
//    // Constructor
//    public Brand(WebDriver driver, ExtentTest test) {
//        this.driver = driver;
//        this.test = test;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        PageFactory.initElements(driver, this);
//    }
//
//    // Click on TVs by Brand link
//    public boolean clickOnTVsByBrand() {
//        try {
//            wait.until(ExpectedConditions.elementToBeClickable(lg)).click();
//            Reports.generateReport(driver, test, Status.PASS, "Clicked on TVs by Brand");
//            return true;
//        } catch (Exception e) {
//            Reports.generateReport(driver, test, Status.FAIL, "Failed to click on TVs by Brand: " + e.getMessage());
//            return false;
//        }
//    }
//
//    // Click on Brand Filter section
//    public boolean clickOnBrandFilter() {
//        try {
//            wait.until(ExpectedConditions.elementToBeClickable(samsung)).click();
//            Reports.generateReport(driver, test, Status.PASS, "Clicked on Brand Filter section");
//            return true;
//        } catch (Exception e) {
//            Reports.generateReport(driver, test, Status.FAIL, "Failed to click on Brand Filter: " + e.getMessage());
//            return false;
//        }
//    }
//
//
//    // Validate listing page for selected brand
//    public boolean isListingPageDisplayed(String brandName) {
//        try {
//            wait.until(ExpectedConditions.titleContains("TVs"));
//            String pageTitle = driver.getTitle();
//            return pageTitle.toLowerCase().contains("tvs") && pageTitle.toLowerCase().contains(brandName.toLowerCase());
//        } catch (Exception e) {
//            Reports.generateReport(driver, test, Status.FAIL, "Listing page validation failed: " + e.getMessage());
//            return false;
//        }
//    }
//}