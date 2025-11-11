package com.pages;

import java.time.Duration;

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
import com.setup.Reports;

public class UserPage2 {

    private static WebDriver driver;
    private static WebDriverWait wait;
    static ExtentTest test;

    @FindBy(xpath="//span[text()='More']")
    private static WebElement more ;
    
    @FindBy(xpath="//a[text()='Gift Cards']")
    private static WebElement giftCards;
    
    @FindBy(xpath="//h1[text()='Best Buy Gift Cards']")
    private static WebElement verifyGiftCardsPage;

    public UserPage2(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test=test;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
}