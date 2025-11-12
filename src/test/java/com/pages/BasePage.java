package com.pages;
 
import java.time.Duration;
 
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;
 
import com.setup.BaseSteps;
 
public class BasePage {
 
	

	protected WebDriver driver = BaseSteps.driver;

    protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 
    public void scrollToElement(WebElement element) throws InterruptedException {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        Thread.sleep(1000);

    }
 
    public void waitForTitleContains(String titleFragment) {

        wait.until(ExpectedConditions.titleContains(titleFragment));

    }
 
	

	public void switchToNewTab() {

        for (String handle : driver.getWindowHandles()) {

            driver.switchTo().window(handle);

        }

    }
 
    public void clickElement(WebElement element) throws InterruptedException {

    	Thread.sleep(2000);

    	element.click();

    }

 
    public void sendKeys(WebElement element, String value) {

        element.clear();

        element.sendKeys(value);

    }
 
    public void selectDropdownByVisibleText(WebElement dropdown, String text) {

        new Select(dropdown).selectByVisibleText(text);

    }
 
    public void waitForElementVisible(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));

    }
 
}

 