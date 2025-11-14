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

public class CheckoutPage {

	private static WebDriver driver;
	private static WebDriverWait wait;
	static ExtentTest test;

	private static By checkout = By.xpath("//button[contains(@class,'checkout-buttons__paypal btn v-medium')]");
	private static By verifypage = By.xpath("//*[@id=\"content\"]/div[1]");
	private static By emailorphno = By.id("email");
	private static By cancel = By.id("cancelLink");
	private static By verifycheckout = By.xpath("//*[@id=\"checkoutApp\"]/div[2]/div[1]/div[1]/main/div[3]/div[1]");



	public CheckoutPage(WebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	}

	public static boolean clickPaypalCheckout()
	{
		boolean actResult = true;
		try {
			// Wait for backdrop to disappear
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(backdrop));

			wait.until(ExpectedConditions.elementToBeClickable(checkout));
			Reports.generateReport(driver, test, Status.PASS, "menuBar is found and clickable");
			driver.findElement(checkout).click();
		} catch (TimeoutException te) {
			actResult = true;
			Reports.generateReport(driver, test, Status.FAIL, "menuBar is not clickable or blocked");
		}
		return actResult;
	}
	public static boolean verifyPaypalPage()
	{
		boolean actResult = true;
		try {
			// Wait for backdrop to disappear
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(backdrop));

			wait.until(ExpectedConditions.elementToBeClickable(verifypage));
			Reports.generateReport(driver, test, Status.PASS, "menuBar is found and clickable");
			driver.findElement(verifypage).click();
		} catch (TimeoutException te) {
			actResult = true;
			Reports.generateReport(driver, test, Status.FAIL, "menuBar is not clickable or blocked");
		}
		return actResult;
	}
	public static boolean enterValue(String value)
	{
		try {

			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(emailorphno));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			Reports.generateReport(driver, test, Status.PASS, "Selected television type: " + value);
			return true;
		} catch (Exception e) {
			Reports.generateReport(driver, test, Status.FAIL, "Failed to select television type: " + value);
			return false;
		}
	}
	public static boolean clickcancel()
	{
		boolean actResult = true;
		try {
			// Wait for backdrop to disappear
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(backdrop));

			wait.until(ExpectedConditions.elementToBeClickable(cancel));
			Reports.generateReport(driver, test, Status.PASS, "menuBar is found and clickable");
			driver.findElement(cancel).click();
		} catch (TimeoutException te) {
			actResult = true;
			Reports.generateReport(driver, test, Status.FAIL, "menuBar is not clickable or blocked");
		}
		return actResult;
	}
	public static boolean verifyCheckout()
	{
		boolean actResult = true;
		try {
			// Wait for backdrop to disappear
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(backdrop));

			wait.until(ExpectedConditions.elementToBeClickable(verifycheckout));
			Reports.generateReport(driver, test, Status.PASS, "menuBar is found and clickable");
			driver.findElement(verifycheckout).click();
		} catch (TimeoutException te) {
			actResult = true;
			Reports.generateReport(driver, test, Status.FAIL, "menuBar is not clickable or blocked");
		}
		return actResult;
	}

}
