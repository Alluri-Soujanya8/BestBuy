package com.Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
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
import com.Parameters.ExcelReader;
import com.Parameters.PropertyReader;
import com.Setup.Reports;

public class UserPage {
	
	
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
//    @FindBy (xpath = "(//button[text()='Add to cart'])[1]")
//    private static WebElement featuredDeals;
    @FindBy (xpath = "(//div[@class='save-for-later'])[5]")
    private static WebElement firstLaptop;
    @FindBy (xpath = "(//div[@class='save-for-later'])[6]")
    private static WebElement secondLaptop;
    @FindBy (xpath = "//button[span[text()='Saved Items']]")
    private static WebElement savedItems;
    @FindBy (xpath = "//a[text()='See all your saved items ›']")
    private WebElement viewSavedItems;
    @FindBy (xpath = "//div[@class='experience-toggle primary-item active']")
    private static WebElement SavedItemsPage;
    @FindBy (xpath = "(//input[@type='checkbox'])[1]")
    private static WebElement firstCheckbox;
    @FindBy (xpath = "(//input[@type='checkbox'])[2]")
    private static WebElement secondCheckbox;
    @FindBy (xpath = "//a[@class='compare-button btn btn-secondary']")
    private static WebElement compareButton;
    @FindBy (xpath = "//span[@class='c-toggle-slider c-toggle-round']")
    private static WebElement toggleSwitch;
    
    
	
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
	
	public boolean goToFirstLaptop() throws InterruptedException
	{
		boolean actResult = true;
        try 
        {
        	Properties props = PropertyReader.readProperty();
        	String laptopXpath = props.getProperty("firstLaptop.link.xpath");
          	WebElement link1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(laptopXpath)));
          	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", link1);
            wait.until(ExpectedConditions.visibilityOf(link1));
            Reports.generateReport(driver, test, Status.PASS, "Go to Featured Deals section");
        } 
        catch (Exception e) 
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Featured Deals section not visible");
        }
        return actResult;
	}
	
	public boolean saveFirstLaptop() throws InterruptedException
	{
		boolean actResult = true;
        try 
        {
        	wait.until(ExpectedConditions.visibilityOf(firstLaptop));
        	//((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstLaptop);
        	Reports.generateReport(driver, test, Status.PASS, "First Laptop is saved");
        	firstLaptop.click();
//            wait.until(ExpectedConditions.elementToBeClickable(firstLaptop));
           
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
            //((JavascriptExecutor) driver).executeScript("arguments[0].click();", secondLaptop);
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
        	wait.until(ExpectedConditions.visibilityOf(savedItems));
        	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", savedItems);
        	((JavascriptExecutor) driver).executeScript("arguments[0].click();", savedItems);
        	Reports.generateReport(driver, test, Status.PASS, "Saved Items are visible");
//        	Properties props = PropertyReader.readProperty();
//            String scrollUp = props.getProperty("SavedItems.link.xpath");
//            WebElement link2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(scrollUp)));
//            ((JavascriptExecutor) driver).executeScript("window.scrollTo({top: 0, left: 0, behavior: 'smooth'});", link2);
//            
//            
//            savedItems.click();
        } 
        catch (TimeoutException | ElementClickInterceptedException e) 
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
	
	//Third Scenario
	
	public boolean verifySavedItemsPage()
	{
		boolean actResult = true;
        try 
        {
            wait.until(ExpectedConditions.visibilityOf(SavedItemsPage));
            Reports.generateReport(driver, test, Status.PASS, "Saved Items Page is opened");
        } 
        catch (TimeoutException te) 
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Saved Items Page is not opened");
        }
        return actResult;
	}
	
	public boolean checkboxFirstLaptop(int sheetNo, int rowNum) throws IOException
	{
		boolean actResult = true;
        try 
        {
            String[] firstCheckboxXpath = ExcelReader.getRowData(sheetNo, rowNum); // Assuming row 1 = First checkbox
            wait.until(ExpectedConditions.visibilityOf(firstCheckbox));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", firstCheckbox);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstCheckbox);
            Reports.generateReport(driver, test, Status.PASS, "Clicked first checkbox for first laptop");

        } 
        catch (TimeoutException | ElementClickInterceptedException e) {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Failed to click first checkbox: " + e.getMessage());
        }
        return actResult;
    }


	public boolean checkboxSecondLaptop(int sheetNo, int rowNum) throws IOException {
        boolean actResult = true;
        try {
        	String[] firstCheckboxXpath = ExcelReader.getRowData(sheetNo, rowNum); // Assuming row 3 = second checkbox
            wait.until(ExpectedConditions.visibilityOf(secondCheckbox));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", secondCheckbox);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", secondCheckbox);
            Reports.generateReport(driver, test, Status.PASS, "Clicked second checkbox for second laptop");
        } 
        catch (TimeoutException | ElementClickInterceptedException e) 
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Failed to click second checkbox: " + e.getMessage());
        }
        return actResult;
    }

	public boolean clickCompare()
	{
		boolean actResult = true;
        try 
        {
            wait.until(ExpectedConditions.visibilityOf(viewSavedItems));
            Reports.generateReport(driver, test, Status.PASS, "Compare Products Page is opened");
            viewSavedItems.click();
        } 
        catch (TimeoutException te) 
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Compare Products Page is not opened");
        }
        return actResult;
	}
	public boolean verifyCompareProducts()
	{
		boolean actResult = true;
        try 
        {
            wait.until(ExpectedConditions.visibilityOf(compareButton));
            Reports.generateReport(driver, test, Status.PASS, "Compare button is clicked");
            compareButton.click();
        } 
        catch (TimeoutException te) 
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Compare button is not clicked");
        }
        return actResult;
	}
	public boolean verifyAndClickToggleSwitch()
	{
		boolean actResult = true;
        try 
        {
            wait.until(ExpectedConditions.visibilityOf(toggleSwitch));
            Reports.generateReport(driver, test, Status.PASS, "Saved Items Page is opened");
            toggleSwitch.click();
        } 
        catch (TimeoutException te) 
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Saved Items Page is not opened");
        }
        return actResult;
	}
	public boolean scrollUpAndRemoveLaptop()
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
