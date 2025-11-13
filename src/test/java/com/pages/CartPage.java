package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.setup.Reports;

public class CartPage {
	
	private static WebDriver driver;
	private static WebDriverWait wait;
	static ExtentTest test;
	
	private static By product = By.xpath("/html/body/div[5]/main/div[3]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div/ul/li[1]/div/div/div/a/span");
	private static By reviewlink = By.xpath("/html/body/div[5]/div[4]/div[1]/div/div[4]/a/div/span[2]");
	private static By addtocart = By.xpath("//*[@id=\"a2c\"]/div/div/div/button");
	private static By gotoCart = By.xpath("//*[@id=\"recs-interruptor-drawer-overlay-backdrop\"]/div/div[3]/div/div/div/div[2]/a");
	
	private static By backdrop = By.id("confirmIt-backdrop");

	
	public CartPage(WebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
		wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	}
	
	public static boolean product() {
		boolean actResult = true;
		try {
			// Wait for backdrop to disappear
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(backdrop));

			wait.until(ExpectedConditions.elementToBeClickable(product));
			Reports.generateReport(driver, test, Status.PASS, "menuBar is found and clickable");
			driver.findElement(product).click();
		} catch (TimeoutException te) {
			actResult = true;
			Reports.generateReport(driver, test, Status.FAIL, "menuBar is not clickable or blocked");
		}
		return actResult;
	}
	public static boolean review() {
		boolean actResult = true;
		try {
			// Wait for backdrop to disappear
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(backdrop));

			wait.until(ExpectedConditions.elementToBeClickable(reviewlink));
			Reports.generateReport(driver, test, Status.PASS, "menuBar is found and clickable");
			driver.findElement(reviewlink).click();
		} catch (Exception te) {
			actResult = true;
			Reports.generateReport(driver, test, Status.FAIL, "menuBar is not clickable or blocked");
		}
		return actResult;
	}
	public static boolean addcart() {
		boolean actResult = true;
		try {
			// Wait for backdrop to disappear
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(backdrop));

			wait.until(ExpectedConditions.elementToBeClickable(addtocart));
			Reports.generateReport(driver, test, Status.PASS, "menuBar is found and clickable");
			driver.findElement(addtocart).click();
		} catch (Exception te) {
			actResult = true;
			Reports.generateReport(driver, test, Status.FAIL, "menuBar is not clickable or blocked");
		}
		return actResult;
	}
	
	
	public static boolean gocart() {
		boolean actResult = true;
		try {
			// Wait for backdrop to disappear
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(backdrop));

			wait.until(ExpectedConditions.elementToBeClickable(product));
			Reports.generateReport(driver, test, Status.PASS, "menuBar is found and clickable");
			driver.findElement(product).click();
		} catch (Exception te) {
			actResult = true;
			Reports.generateReport(driver, test, Status.FAIL, "menuBar is not clickable or blocked");
		}
		return actResult;
	}




}
