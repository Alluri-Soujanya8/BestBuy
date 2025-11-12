package com.pages;

import java.time.Duration;

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

public class UserPagePageFactory {
	
	private static WebDriver driver;
    private static WebDriverWait wait;
    static ExtentTest test;
    
//    private static By verifyHomePage = By.xpath("//div[@data-testid='header']");
//	private static By clickGiftIdeas = By.xpath("//a[@data-testid='gift-ideas-button']");
//	private static By verifyGiftIdeas = By.xpath("//h2[text()= 'Who are you shopping for?']");
	
    @FindBy(xpath="//div[@data-testid='header']")
    public static WebElement verifyHomePage;
    @FindBy(xpath="//a[@data-testid='gift-ideas-button']")
    public static WebElement clickGiftIdeas;
    @FindBy(xpath="//h2[text()= 'Who are you shopping for?']")
    public static WebElement verifyGiftIdeas;
    
    
	public UserPagePageFactory(WebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
	}
	
	public static boolean verifyHomepage()
	{
		boolean actResult = true;
        try
        {
            wait.until(ExpectedConditions.visibilityOf(verifyHomePage));
            Reports.generateReport(driver, test, Status.PASS, "HomePage is launched");
        }
        catch (TimeoutException te)
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "HomePage is not Launched");
        }
        return actResult;
        
//		driver.findElement(verifyHomePage);
	}
	public static boolean clickGiftIdeas()
	{
		boolean actResult = true;
        try
        {
            wait.until(ExpectedConditions.visibilityOf(clickGiftIdeas));
            Reports.generateReport(driver, test, Status.PASS, "Gift Ideas button is found");
            clickGiftIdeas.click();
        }
        catch (TimeoutException te)
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "loginButton is not found");
        }
        return actResult;
 
		
	}
	public static boolean verfiyGiftIdeasPage()
	{
		boolean actResult = true;
        try
        {
            wait.until(ExpectedConditions.visibilityOf(verifyGiftIdeas));
            Reports.generateReport(driver, test, Status.PASS, "Gift Ideas Functionality is displayed");
        }
        catch (TimeoutException te)
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Gift Ideas Functionality is not displayed");
        }
        return actResult;
 
//		driver.findElement(verifyLogin);
	}
	

}
