package com.Pages;

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
import com.Setup.Reports;

public class UserPage extends BasePage{
	
	
	private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest test;
	
    @FindBy (xpath = "//a[text()='Top Deals']")
    private static WebElement verifyTopDeals;
    @FindBy (xpath = "//h1[text()='Top Deals']")
	private static WebElement Top_Deals_Page;
    @FindBy (xpath = "//p[text()='Computers & Tablets']")
    private static WebElement computerAndTabletDeals;
    @FindBy (xpath = "//p[text()='Laptops']")
    private static WebElement LaptopsLink;
    @FindBy (xpath = "//h1[text()='Laptop Deals']")
    private static WebElement LaptopDeals;
    @FindBy (xpath = "(//button[text()='Add to cart'])[1]")
    private static WebElement featuredDeals;
    @FindBy (xpath = "//h2[text()='Featured deals']/following::button[contains(@aria-label,'Save')])[1]")
    private static WebElement firstLaptop;
    @FindBy (xpath = "(//h2[text()='Featured deals']/following::button[contains(@aria-label,'Save')])[2]")
    private static WebElement secondLaptop;
    @FindBy (xpath = "//button[span[text()='Saved Items']]")
    private static WebElement savedItems;
    @FindBy (xpath = "//a[text()='See all your saved items ›']")
    private WebElement viewSavedItems;
    
	
	public UserPage(WebDriver driver, ExtentTest test) 
	{
		this.driver=driver;
		this.test=test;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	public boolean verifyTopDeals()
	{
		boolean actResult = true;
        try 
        {
            wait.until(ExpectedConditions.visibilityOf(verifyTopDeals));
            Reports.generateReport(driver, test, Status.PASS, "Top Deals Functionality is displayed");
        } 
        catch (TimeoutException te) 
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Top Deals Functionality is not displayed");
        }
        return actResult;
	}
	public boolean click_Top_Deals()
	{
		boolean actResult = true;
        try 
        {
            wait.until(ExpectedConditions.visibilityOf(verifyTopDeals));
            Reports.generateReport(driver, test, Status.PASS, "Top Deals path is found");
            verifyTopDeals.click();
        } 
        catch (TimeoutException te) 
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Top Deals path is not found");
        }
        return actResult;
	}
	public boolean Top_Deals_Page()
	{
		boolean actResult = true;
        try 
        {
            wait.until(ExpectedConditions.visibilityOf(Top_Deals_Page));
            Reports.generateReport(driver, test, Status.PASS, "Top Deals Page is opened");
        } 
        catch (TimeoutException te) 
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Top Deals Page is not opened");
        }
        return actResult;
	}
	public boolean clickComputersAndTabletDeals()
	{
		boolean actResult = true;
        try 
        {
            wait.until(ExpectedConditions.visibilityOf(computerAndTabletDeals));
            Reports.generateReport(driver, test, Status.PASS, "Computer And Tablet Deals Page is opened");
            computerAndTabletDeals.click();
        } 
        catch (TimeoutException te) 
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Computer And Tablet Deals Page is not opened");
        }
        return actResult;
	}
	public boolean clickLaptops()
	{
		boolean actResult = true;
        try 
        {
            wait.until(ExpectedConditions.visibilityOf(LaptopsLink));
            Reports.generateReport(driver, test, Status.PASS, "Laptop Deals Page is opened");
            LaptopsLink.click();
        } 
        catch (TimeoutException te) 
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Laptop Deals Page is not opened");
        }
        return actResult;
	}
	public boolean laptopDealsPage()
	{
		boolean actResult = true;
        try 
        {
            wait.until(ExpectedConditions.visibilityOf(LaptopDeals));
            Reports.generateReport(driver, test, Status.PASS, "Laptop Deals Page is opened");
        } 
        catch (TimeoutException te) 
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Laptop Deals Page is not opened");
        }
        return actResult;
	}
	
	public void scrollToFeaturedDeals() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(featuredDeals));
		scrollToElement(featuredDeals);
	}
	
//	public boolean goToFeaturedDeals() throws InterruptedException
//	{
//		boolean actResult = true;
//        try 
//        {
//            wait.until(ExpectedConditions.visibilityOf(featuredDeals));
//            Reports.generateReport(driver, test, Status.PASS, "Go to Featured Deals section");
//            scrollToElement(featuredDeals);
//        } 
//        catch (TimeoutException te) 
//        {
//            actResult = false;
//            Reports.generateReport(driver, test, Status.FAIL, "Featured Deals section not visible");
//        }
//        return actResult;
//	}
	
	public boolean saveFirstLaptop() throws InterruptedException
	{
		boolean actResult = true;
        try 
        {
        	scrollToElement(firstLaptop);
            wait.until(ExpectedConditions.visibilityOf(firstLaptop));
            firstLaptop.click();
            Reports.generateReport(driver, test, Status.PASS, "First Laptop is saved");
        } 
        catch (TimeoutException te) 
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "First Laptop is not saved");
        }
        return actResult;
	}
	public boolean saveSecondLaptop()
	{
		boolean actResult = true;
        try 
        {
            wait.until(ExpectedConditions.visibilityOf(secondLaptop));
            Reports.generateReport(driver, test, Status.PASS, "Second Laptop is saved");
            secondLaptop.click();
        } 
        catch (TimeoutException te) 
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Second Laptop is not saved");
        }
        return actResult;
	}
	public boolean clickSavedItems() throws InterruptedException
	{
		boolean actResult = true;
        try 
        {
        	scrollToElement(savedItems);
            wait.until(ExpectedConditions.visibilityOf(savedItems));
            Reports.generateReport(driver, test, Status.PASS, "Saved Items are visible");
            savedItems.click();
        } 
        catch (TimeoutException te) 
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Saved Items are not visible");
        }
        return actResult;
	}
	public boolean clickSeeAllYourSavedItems()
	{
		boolean actResult = true;
        try 
        {
            wait.until(ExpectedConditions.visibilityOf(viewSavedItems));
            Reports.generateReport(driver, test, Status.PASS, "Saved Items Page is opened");
            viewSavedItems.click();
        } 
        catch (TimeoutException te) 
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Saved Items Page is not opened");
        }
        return actResult;
	}
}
