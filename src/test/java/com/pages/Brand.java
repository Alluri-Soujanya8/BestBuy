package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class Brand extends BasePage {
	
	private WebDriver driver;
    private WebDriverWait wait;
    private ExtentTest test;
    
//    private static By lgBrand = By.xpath("//a[text()='LG TVs']");
//    private static By sonyBrand = By.xpath("//a[text()='Sony TVs']");
//    private static By samsungBrand = By.xpath("//a[text()='Samsung TVs']");
    
    @FindBy(xpath="(//a[text()='LG TVs']")
    static WebElement lgBrand;
    
    @FindBy(xpath = "(//a[text()='Sony TVs'])")
    static WebElement sonyBrand;
    
    @FindBy(xpath ="(//a[text()='Samsung TVs'])")
    static WebElement samsungBrand;
    
    public Brand(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    
    public void clickonLG() throws InterruptedException
    {
    	clickElement(lgBrand);
    }
    
    public void clickonSony() throws InterruptedException
    {
    	clickElement(sonyBrand);
    }
    public void clickonSamsung() throws InterruptedException
    {
    	clickElement(samsungBrand);
    }
    
    
    
    


}
