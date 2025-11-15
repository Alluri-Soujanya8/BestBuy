package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
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

	private static By verifyHomePage = By.xpath("//div[@data-testid='header']");
	private static By clickGiftIdeas = By.xpath("//a[@data-testid='gift-ideas-button']");
	private static By displayGiftIdeas = By.xpath("//h2[text()= 'Who are you shopping for?']");

	//	private static By verifyGiftIdeas = By.xpath("//h2[text()= 'Who are you shopping for?']");
	private static By clickPets = By.xpath("//div[@data-testid='flex-grid-4694c3ad-c47d-483b-a919-11c09571ae8e-1-item-9']");
	private static By clickpetfeeders = By.linkText("Pet feeders and water fountains");
	private static By displayPetpage = By.xpath("//h1[text()='Pet Feeders & Water Fountains']");


	private static By filterforsingle = By.cssSelector("#Petkit");
	private static By filterforthird = By.cssSelector("#App_Compatible");
	private static By click= By.xpath("//h2[@class='product-title']");
	private static By clickproduct= By.xpath("//*[@id=\"main-results\"]/ul/li[1]/div/div[2]/div[1]/div[2]/div/div/a/h2");
	private static By displayproduct= By.id("anchor-product-details");
	
	private static By filter= By.xpath("//input[@id='$50_-_$74.99']");
	private static By clearAll = By.linkText("Clear all");
	
	private static By addtocart= By.xpath("//button[@data-test-id='add-to-cart']");// #a2c button
	private static By check=By.xpath("//button[@data-track='Checkout - Top']");
	private static By verifysignin=By.className("cia-settings-container");
	
	private static By Email=By.name("emailAddress");
	private static By phone=By.xpath("//input[@id='user.phone']");
	private static By clickGuest=By.xpath("//button[text()='Continue as Guest']");
	private static By paymentbutton=By.xpath("//span[text()='Continue to Payment Information']");
	
	private static By popup=By.id("main-results");
	private static By cart=By.xpath("//a[@data-testid='go-to-cart']");
	
	public UserPage(WebDriver driver, ExtentTest test)
	{
		this.driver = driver;
		this.test = test;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	public static boolean verifyHomepage()
	{
		boolean actResult = true;
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(verifyHomePage));
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
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(clickGiftIdeas ));
			Reports.generateReport(driver, test, Status.PASS, "Gift Ideas button is found");
			driver.findElement(clickGiftIdeas ).click();
		}
		catch (TimeoutException te)
		{
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "loginButton is not found");
		}
		return actResult;


	}

	public static boolean displayGiftIdeasPage() {
		boolean actResult = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(displayGiftIdeas));
			WebElement giftIdeasHeader = driver.findElement(displayGiftIdeas);

			if (giftIdeasHeader.isDisplayed()) {
				Reports.generateReport(driver, test, Status.PASS, "Gift Ideas Functionality is displayed");
				System.out.println("Gift Ideas page is displayed");

			} else {
				actResult = false;
				Reports.generateReport(driver, test, Status.FAIL, "Gift Ideas Functionality is not displayed");
			}

		} catch (TimeoutException te) {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "Gift Ideas Functionality is not displayed within timeout");
		}
		return actResult;
	}

	public static boolean clickPetsPage()
	{
		boolean actResult = true;
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(clickPets));
			Reports.generateReport(driver, test, Status.PASS, "pets page is launched");
			driver.findElement(clickPets).click();
		}
		catch (TimeoutException te)
		{
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "pets page is not Launched");
		}
		return actResult;
	}
	//second scenario
	public static boolean clickpetfeeders()
	{
		boolean actResult = true;
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(clickpetfeeders));
			Reports.generateReport(driver, test, Status.PASS, "pet feeders is found");
			driver.findElement(clickpetfeeders).click();
		}
		catch (TimeoutException te)
		{
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "pet feeders is not found");
		}
		return actResult;

	}

	public static boolean DisplayPetPage() {
		boolean actResult = true;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(displayPetpage));
			WebElement giftIdeasHeader = driver.findElement(displayPetpage);

			if (giftIdeasHeader.isDisplayed()) {
				Reports.generateReport(driver, test, Status.PASS, "Pet page is displayed");

			} else {
				actResult = false;
				Reports.generateReport(driver, test, Status.FAIL, "Pet page is not displayed");
			}

		} catch (TimeoutException te) {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "Pet page is not displayed within timeout");
		}
		return actResult;
	}
	//third scenario
	public static boolean clickcheckbox()
	{
		boolean actResult = true;
		try
		{
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement checkbox = driver.findElement(filterforsingle);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
			wait.until(ExpectedConditions.visibilityOfElementLocated(filterforsingle));
			Reports.generateReport(driver, test, Status.PASS, "check box is found");
			checkbox.click();
		}
		catch (TimeoutException te)
		{
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "Check box is not found");
		}
		return actResult;


	}
	//third scenario
	public static boolean clickSecondCheckbox() {
		boolean actResult = true;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			// Wait for second checkbox
			wait.until(ExpectedConditions.visibilityOfElementLocated(filter));
			Reports.generateReport(driver, test, Status.PASS, "Second checkbox is found");
			driver.findElement(filter).click();

		} catch (TimeoutException te) {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "One or more checkboxes not found");
		}
		return actResult;
	}
	//third scenario
	public static boolean clickThirdCheckbox() {
		boolean actResult = true;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			// Wait for second checkbox
			wait.until(ExpectedConditions.visibilityOfElementLocated(filterforthird));
			Reports.generateReport(driver, test, Status.PASS, "Third checkbox is found");
			WebElement thirdfilter=driver.findElement(filterforthird);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", thirdfilter);
			thirdfilter.click();
			

		} catch (TimeoutException te) {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "Third checkbox not found");
		}
		return actResult;
	}
	//fourth 
	public static boolean clickAddToCart()
	{
		boolean actResult = true;
		try
		{
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			//WebElement addcart=wait.until(ExpectedConditions.visibilityOfElementLocated(addtocart));
			
			
			WebElement addToCartButton = driver.findElement(addtocart);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);
			
			//WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(addtocart));
			addToCartButton.click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(addtocart));

			Reports.generateReport(driver, test, Status.PASS, "Add to cart is found");
			
			System.out.println(driver.getCurrentUrl());
			System.out.println("Clicking Add to Cart");
			WebElement pop=driver.findElement(popup);
			if(pop.isDisplayed()) {
				((WebElement) cart).click();
			}
			return true;

		}
		catch (StaleElementReferenceException te)
		{

			System.out.println("Stale element detected. Retrying...");
			return retryClickAddToCart();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	private static boolean retryClickAddToCart() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(addtocart));
			addToCartButton.click();
			return true;
		} catch (Exception e) {

			return false;
		}
		}

		public static boolean clickCheckout()
		{
			boolean actResult = true;
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOfElementLocated(check));
				Reports.generateReport(driver, test, Status.PASS, "clear all is found");
				driver.findElement(check).click();
			}
			catch (TimeoutException te)
			{
				actResult = false;
				Reports.generateReport(driver, test, Status.FAIL, "clear all is not found");
			}
			return actResult;


		}

		//third scenario
		public static boolean clickOnProduct()
		{
			boolean actResult = true;
			try
			{
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOfElementLocated(clickproduct));
				Reports.generateReport(driver, test, Status.PASS, "click on product");
				driver.findElement(clickproduct).click();
			}
			catch (TimeoutException te)
			{
				actResult = false;
				Reports.generateReport(driver, test, Status.FAIL, "Click on product");
			}
			return actResult;


		}

		//	public static boolean clickOnProductAfter()
		//	{
		//		boolean actResult = true;
		//		try
		//		{
		//			wait.until(ExpectedConditions.visibilityOfElementLocated(clickproductafter));
		//			Reports.generateReport(driver, test, Status.PASS, "click on product");
		//			driver.findElement(clickproductafter).click();
		//		}
		//		catch (TimeoutException te)
		//		{
		//			actResult = false;
		//			Reports.generateReport(driver, test, Status.FAIL, "Click on product");
		//		}
		//		return actResult;
		//
		//
		//	}
		//third scenario
		public static boolean DisplayProductPage() {
			boolean actResult = true;
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOfElementLocated(displayproduct));
				WebElement giftIdeasHeader = driver.findElement(displayproduct);

				if (giftIdeasHeader.isDisplayed()) {
					String text=driver.findElement(displayproduct).getText();
					Reports.generateReport(driver, test, Status.PASS, "product page is displayed");
					System.out.println("Product page is displayed and the text is : "+text);

				} else {
					actResult = false;
					Reports.generateReport(driver, test, Status.FAIL, "Pet page is not displayed");
				}

			} catch (TimeoutException te) {
				actResult = false;
				Reports.generateReport(driver, test, Status.FAIL, "Pet page is not displayed within timeout");
			}
			return actResult;
		}

		public static boolean VerifySigninPage() {
			boolean actResult = true;
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(verifysignin));
				WebElement checkoutsignin = driver.findElement(verifysignin);
				//			boolean value=checkoutsignin.isDisplayed();
				//			System.out.println(value);
				if (checkoutsignin.isDisplayed()) {
					String text=driver.findElement(verifysignin).getText();
					Reports.generateReport(driver, test, Status.PASS, "sign in page is displayed");
					System.out.println("Sign in page is displayed and the text is : "+text);

				} 
				//			else {
				//				actResult = false;
				//				Reports.generateReport(driver, test, Status.FAIL, "sign in page is not displayed");
				//			}

			} catch (TimeoutException te) {
				actResult = false;
				Reports.generateReport(driver, test, Status.FAIL, "sign in page is not displayed within timeout");
			}
			return actResult;
		}
		public static boolean clickContinueAsGuestButton() {
			boolean actResult = true;
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(clickGuest));
				Reports.generateReport(driver, test, Status.PASS, "continue as guest button is found");
				driver.findElement(clickGuest).click();

			} catch (TimeoutException te) {
				actResult = false;
				Reports.generateReport(driver, test, Status.FAIL, "continue as guest button is not found");
			}
			return actResult;
		} 
		public static boolean EnterInputFields(String email,String phonenumber) {
			boolean actResult = true;
			try {
				WebElement emaildetails=wait.until(ExpectedConditions.visibilityOfElementLocated(Email));
				//Reports.generateReport(driver, test, Status.PASS, "continue as guest button is found");
				emaildetails.sendKeys(email);
				WebElement phonedetails=wait.until(ExpectedConditions.visibilityOfElementLocated(phone));
				phonedetails.sendKeys(phonenumber);
				Reports.generateReport(driver, test, Status.PASS, "Entered Email and Phone successfully");

			} catch (TimeoutException te) {
				actResult = false;
				Reports.generateReport(driver, test, Status.FAIL, "continue as guest button is not found");
			}
			return actResult;
//			try {
//			wait.until(ExpectedConditions.visibilityOf((WebElement) Email));
//			((WebElement) Email).clear();
//			((WebElement) Email).sendKeys(email);
//        	wait.until(ExpectedConditions.visibilityOf((WebElement) phone));  
//        	((WebElement) phone).clear();      
//        	((WebElement) phone).sendKeys(phonenumber);  
//			}catch(TimeoutException te) {
//				actResult = false;
//				Reports.generateReport(driver, test, Status.FAIL, "continue as guest button is not found");
//			
//			}
//			return actResult;
		} 
		public static boolean clickPaymentButton() {
			boolean actResult = true;
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOfElementLocated(paymentbutton));
				Reports.generateReport(driver, test, Status.PASS, "continue as payment button is found");
				driver.findElement(paymentbutton).click();

			} catch (TimeoutException te) {
				actResult = false;
				Reports.generateReport(driver, test, Status.FAIL, "continue as payment button is not found");
			}
			return actResult;
		} 
		
		public static boolean goToCart()
		{
			boolean actResult = true;
			try
			{
				WebElement gotocart=wait.until(ExpectedConditions.visibilityOfElementLocated(popup));
				//WebElement cartbutton=(WebElement) wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cart));
				Reports.generateReport(driver, test, Status.PASS, "Go To Cart page is displayed");
				if (gotocart.isDisplayed()) {
					driver.findElement(cart).click();
					Reports.generateReport(driver, test, Status.PASS, "Go To Cart page is displayed");
					System.out.println("Go to cart is clicked");

				}else {
					driver.findElement(addtocart).click();
				}
			}
			catch (TimeoutException te)
			{
				actResult = false;
				Reports.generateReport(driver, test, Status.FAIL, "HomePage is not Launched");
			}
			return actResult;

			//		driver.findElement(verifyHomePage);
		}
	}
