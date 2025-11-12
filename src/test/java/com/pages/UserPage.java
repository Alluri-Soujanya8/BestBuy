package com.pages;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setup.Reports;

public class UserPage {

	private static WebDriver driver;
	private static WebDriverWait wait;
	static ExtentTest test;

	private static By menuBar = By.xpath("//button[contains(text(), 'Menu')]");
	private static By clickmenu = By.className("open-hamburger-icon");
	private static By module = By.xpath("//button[contains(text(), 'TV & Home Theater')]");
	private static By verifyModule = By.xpath("//h2[text()='Shop by Department']/following::button[1]");
	private static By clickbrand= By.xpath("//button[text()='TVs by Brand']");
	private static By brandlg=By.xpath("//a[text()='LG TVs']");
	private static By backdrop = By.id("confirmIt-backdrop");
	

	public static boolean menubar() {
		boolean actResult = true;
		try {
			// Wait for backdrop to disappear
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(backdrop));

			wait.until(ExpectedConditions.elementToBeClickable(menuBar));
			Reports.generateReport(driver, test, Status.PASS, "menuBar is found and clickable");
			driver.findElement(menuBar).click();
		} catch (TimeoutException te) {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "menuBar is not clickable or blocked");
		}
		return actResult;
	}

	public UserPage(WebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	}

	
	public static boolean clickMenu()
	{
		boolean actResult = true;
		try 
		{
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(backdrop));


			wait.until(ExpectedConditions.visibilityOfElementLocated(clickmenu));
			Reports.generateReport(driver, test, Status.PASS, "Menu Button is Clicked");
			driver.findElement(clickmenu).click();
		} 
		catch (TimeoutException te)
		{
			actResult = true;
			Reports.generateReport(driver, test, Status.FAIL, "Menu Button is Clicked");
		}
		return actResult;
	}
	public static boolean moduleBB()
	{
		boolean actResult = true;
		try 
		{
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(backdrop));

			wait.until(ExpectedConditions.visibilityOfElementLocated(module));
			Reports.generateReport(driver, test, Status.PASS, "Menu is displayed");
			driver.findElement(module).click();
		} 
		catch (TimeoutException te)
		{
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "Menu is not displayed");
		}
		return actResult;
	}

	public static boolean verifymodule() {
		boolean actResult = true;
		try {
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(backdrop));
			wait.until(ExpectedConditions.elementToBeClickable(verifyModule));

			WebElement moduleElement = driver.findElement(verifyModule);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", moduleElement);
			moduleElement.click();

			Reports.generateReport(driver, test, Status.PASS, "TV & Home Theater Module clicked successfully");
		} catch (Exception e) {
			actResult = true;
			Reports.generateReport(driver, test, Status.FAIL, "TV & Home Theater Module not found or not clickable");
		}
		return actResult;
	}
	public static boolean clickbrand()
	{
		boolean actResult = true;
		try {
			// Wait for backdrop to disappear
			wait.until(ExpectedConditions.invisibilityOfElementLocated(backdrop));

			wait.until(ExpectedConditions.elementToBeClickable(clickbrand));
			Reports.generateReport(driver, test, Status.PASS, "TVs by Brand is found and clickable");
			driver.findElement(clickbrand).click();
		} catch (TimeoutException te) {
			actResult = true;
			Reports.generateReport(driver, test, Status.FAIL, "TVs by Brand is not clickable or blocked");
		}
		return actResult;
	}
	
	public static boolean clickLg()
	{
		boolean actResult = true;
		try {
			// Wait for backdrop to disappear
			wait.until(ExpectedConditions.invisibilityOfElementLocated(backdrop));

			wait.until(ExpectedConditions.elementToBeClickable(brandlg));
			Reports.generateReport(driver, test, Status.PASS, "TVs by Brand is found and clickable");
			driver.findElement(brandlg).click();
		} catch (TimeoutException te) {
			actResult = true;
			Reports.generateReport(driver, test, Status.FAIL, "TVs by Brand is not clickable or blocked");
		}
		return actResult;
	}
}
	


	


