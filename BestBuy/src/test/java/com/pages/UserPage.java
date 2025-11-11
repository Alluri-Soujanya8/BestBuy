package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
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
	public static boolean clickpetfeeders()
	{
		boolean actResult = true;
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(clickpetfeeders));
			Reports.generateReport(driver, test, Status.PASS, "Gift Ideas button is found");
			driver.findElement(clickpetfeeders).click();
		}
		catch (TimeoutException te)
		{
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "loginButton is not found");
		}
		return actResult;

	}
	public static boolean DisplayPetPage() {
		boolean actResult = true;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(displayPetpage));
			WebElement giftIdeasHeader = driver.findElement(displayPetpage);

			if (giftIdeasHeader.isDisplayed()) {
				Reports.generateReport(driver, test, Status.PASS, "Gift Ideas Functionality is displayed");

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
}
