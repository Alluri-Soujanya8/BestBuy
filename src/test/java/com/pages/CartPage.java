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
	private static By back = By.xpath("/html/body/div[5]/div[4]/div[2]/div/div[2]/div[2]/div/div[2]/div/button[1]");
	private static By add1 = By.xpath("//*[@id=\"main-results\"]//span[text()=\"Add to cart\"][1]");
	private static By add2 = By.xpath("//*[@id=\"main-results\"]/ul/li[1]/div/div[3]/div/div/div/div[1]/div[1]/div/div/div/button/div/span");
	private static By add3 = By.xpath("//*[@id=\"main-results\"]/ul/li[2]/div/div[3]/div/div/div/div[1]/div[1]/div/div/div/button/div/span");
	private static By go = By.xpath("(//a[text()='Go to cart'])[2]");
	private static By remove = By.xpath("(//button[text()='Remove'])[2]");
	private static By save = By.xpath("//button[text()='Save for later']");
	private static By checkout = By.xpath("//button[text()='Checkout']");
	private static By continueasguest = By.xpath("//button[text()='Continue as Guest']");
	private static By verifyCartpage = By.xpath("//*[@id=\"cartApp\"]/div[2]/div/div[1]/div/div[2]");
	private static By verifyCheckout = By.xpath("/html/body/div[1]/div/section/main/div[2]/div/div");
	
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
	public static boolean backbutton()
	{
		boolean actResult = true;
		try {
			// Wait for backdrop to disappear
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(backdrop));

			wait.until(ExpectedConditions.elementToBeClickable(back));
			Reports.generateReport(driver, test, Status.PASS, "menuBar is found and clickable");
			driver.findElement(back).click();
		} catch (Exception te) {
			actResult = true;
			Reports.generateReport(driver, test, Status.FAIL, "menuBar is not clickable or blocked");
		}
		return actResult;

	}
	
	

	public static boolean addtocart()
	{
		boolean actResult = true;
		try {
			// Wait for backdrop to disappear
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(backdrop));

			wait.until(ExpectedConditions.elementToBeClickable(add1));
			Reports.generateReport(driver, test, Status.PASS, "menuBar is found and clickable");
			driver.findElement(add1).click();
			wait.until(ExpectedConditions.elementToBeClickable(add2));
			Reports.generateReport(driver, test, Status.PASS, "menuBar is found and clickable");
			driver.findElement(add2).click();
			wait.until(ExpectedConditions.elementToBeClickable(add3));
			Reports.generateReport(driver, test, Status.PASS, "menuBar is found and clickable");
			driver.findElement(add3).click();
		} catch (Exception te) {
			actResult = true;
			Reports.generateReport(driver, test, Status.FAIL, "menuBar is not clickable or blocked");
		}
		return actResult;
	}
	public static boolean gotocart()
	{
		boolean actResult = true;
		try {
			// Wait for backdrop to disappear
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(backdrop));

			
			wait.until(ExpectedConditions.elementToBeClickable(go));
			Reports.generateReport(driver, test, Status.PASS, "menuBar is found and clickable");
			driver.findElement(go).click();
		} catch (Exception te) {
			actResult = true;
			Reports.generateReport(driver, test, Status.FAIL, "menuBar is not clickable or blocked");
		}
		return actResult;
	}
	
	public static boolean removefromcart()
	{
		boolean actResult = true;
		try {
			// Wait for backdrop to disappear
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(backdrop));

			wait.until(ExpectedConditions.elementToBeClickable(remove));
			Reports.generateReport(driver, test, Status.PASS, "menuBar is found and clickable");
			driver.findElement(remove).click();
		} catch (Exception te) {
			actResult = true;
			Reports.generateReport(driver, test, Status.FAIL, "menuBar is not clickable or blocked");
		}
		return actResult;
	}
	public static boolean checkOut()
	{
		boolean actResult = true;
		try {
			// Wait for backdrop to disappear
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(backdrop));

			wait.until(ExpectedConditions.elementToBeClickable(checkout));
			Reports.generateReport(driver, test, Status.PASS, "menuBar is found and clickable");
			driver.findElement(checkout).click();
		} catch (Exception te) {
			actResult = true;
			Reports.generateReport(driver, test, Status.FAIL, "menuBar is not clickable or blocked");
		}
		return actResult;
	}
	public static boolean signin()
	{
		boolean actResult = true;
		try {
			// Wait for backdrop to disappear
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(backdrop));

			wait.until(ExpectedConditions.elementToBeClickable(continueasguest));
			Reports.generateReport(driver, test, Status.PASS, "menuBar is found and clickable");
			driver.findElement(continueasguest).click();
		} catch (Exception te) {
			actResult = true;
			Reports.generateReport(driver, test, Status.FAIL, "menuBar is not clickable or blocked");
		}
		return actResult;
	}
	public static boolean verifycart()
	{
		boolean actResult = true;
		try {
			// Wait for backdrop to disappear
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(backdrop));

			wait.until(ExpectedConditions.visibilityOfElementLocated(verifyCartpage));
			Reports.generateReport(driver, test, Status.PASS, "menuBar is found and clickable");
			driver.findElement(verifyCartpage).click();
		} catch (Exception te) {
			actResult = true;
			Reports.generateReport(driver, test, Status.FAIL, "menuBar is not clickable or blocked");
		}
		return actResult;
		
	}
	public static boolean verifycheckout()
	{
		boolean actResult = true;
		try {
			// Wait for backdrop to disappear
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(backdrop));

			wait.until(ExpectedConditions.visibilityOfElementLocated(verifyCheckout));
			Reports.generateReport(driver, test, Status.PASS, "menuBar is found and clickable");
			driver.findElement(verifyCheckout).click();
		} catch (Exception te) {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "menuBar is not clickable or blocked");
		}
		return actResult;
		
	}
	
	
}




