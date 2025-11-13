package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setup.Reports;

public class UserPage {
	
	private static WebDriver driver;
    private static WebDriverWait wait;
    static ExtentTest test;

    
   
    private static By dealOfTheDaypage = By.xpath("//span[text()='Deal']");  // this is link for the deal of the page
    private static By dealPageIdentifier = By.xpath("//a[text() = 'Deal of the Day']");  // this deal of the page title locator
    
	public UserPage(WebDriver driver, ExtentTest test)
	{
		this.driver=driver;
		this.test = test;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	public static boolean clickDealOfTheDayModule() {
        boolean actResult = true;
        try {
            wait.until(ExpectedConditions.elementToBeClickable(dealPageIdentifier));
            driver.findElement(dealPageIdentifier).click();
            Reports.generateReport(driver, test, Status.PASS, "Clicked Deal of the Day module");
        } catch (TimeoutException te) {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Deal of the Day module not clickable");
        }
        return actResult;
    }

    public static boolean verifyDealOfTheDayPage() {
        boolean actResult = true;
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(dealOfTheDaypage));
//            String actualTitle = driver.getTitle();
//            if (!actualTitle.contains(expectedTitle)) {
//                actResult = false;
//            }
            Reports.generateReport(driver, test, Status.PASS, "Deal of the Day page loaded: ");
        } catch (TimeoutException te) {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Deal of the Day page not displayed");
        }
        return actResult;
    }
    

	
	
	
}
