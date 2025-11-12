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

    private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest test;


    @FindBy(xpath = "//button[contains(text(), 'Menu')]")
    private WebElement userName;

    @FindBy(className = "open-hamburger-icon")
    private WebElement password;

    @FindBy(xpath = "//button[contains(text(), 'TV &amp; Home Theater')]")
    private WebElement loginButton;

    @FindBy(xpath = "//h2[text()='Shop by Department']/following::button[1]")
    private WebElement verifyLogin;

    @FindBy(id = "confirmIt-backdrop")
    private WebElement verifyHomePage;

    public UserPage2(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        PageFactory.initElements(driver, this);
    }

    public boolean menubar(WebElement menuBarElement) {
        boolean actResult = true;
        try {
            wait.until(ExpectedConditions.visibilityOf(menuBarElement));
            Reports.generateReport(driver, test, Status.PASS, "Menu bar button is found");
            menuBarElement.click();
        } catch (TimeoutException te) {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Menu bar is not clickable or blocked");
        }
        return actResult;
    }

    public boolean clickMenu(WebElement clickMenuElement) {
        boolean actResult = true;
        try 
        {
        	wait.until(ExpectedConditions.visibilityOf(clickMenuElement));
            Reports.generateReport(driver, test, Status.PASS, "Menu bar button is found");
            clickMenuElement.click();
        } 
        catch (TimeoutException te) 
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Menu bar is not clickable or blocked");
        }
        return actResult;
    }

    public boolean moduleBB(WebElement moduleBBElement) 
    {
        boolean actResult = true;
        try 
        {
        	wait.until(ExpectedConditions.visibilityOf(moduleBBElement));
            Reports.generateReport(driver, test, Status.PASS, "Menu bar button is found");
            moduleBBElement.click();
        } 
        catch (TimeoutException te) 
        {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Menu bar is not clickable or blocked");
        }
        return actResult;
        
    }

    public boolean verifymodule(WebElement verifymoduleElement) {
        boolean actResult = true;
        try {
            wait.until(ExpectedConditions.elementToBeClickable(verifymoduleElement));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", verifymoduleElement);
            verifymoduleElement.click();

            Reports.generateReport(driver, test, Status.PASS, "TV & Home Theater module clicked successfully");
        } catch (Exception e) {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "TV & Home Theater module not found or not clickable");
        }
        return actResult;
    }
}
