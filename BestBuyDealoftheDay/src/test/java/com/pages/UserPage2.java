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
	
	private static WebDriver driver;
    private static WebDriverWait wait;
    static ExtentTest test;
	

    @FindBy(xpath = "//span[text()='Deal']")
    private static WebElement dealOfTheDaypage;
    
    @FindBy(xpath = "//a[text() = 'Deal of the Day']")
    private static WebElement dealPageIdentifier;


    //@FindBy(xpath = "//a[contains(text(),'FAQ')]")
    @FindBy(xpath = "//a[text() = 'See Deal of the Day FAQs']")
    private WebElement faqLink;

    @FindBy(xpath = "//h1[contains(text(),'FAQs')]") //
    private WebElement faqPageHeader;

    @FindBy(xpath = "(//a[contains(text(),'Help Center')])[1]")
    private WebElement helpCenterLink;

    //@FindBy(xpath = "//h1[contains(text(),'Help Center')]")
    @FindBy(xpath = "//h1[contains(text(),'Best')]")
    private WebElement helpCenterHeader;

    
	public UserPage2(WebDriver driver, ExtentTest test)
	{
		this.driver=driver;
		this.test = test;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
	}
	public static boolean clickDealOfTheDayModule() {
        boolean actResult = true;
        try {
            wait.until(ExpectedConditions.elementToBeClickable(dealPageIdentifier));
            dealPageIdentifier.click();
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
            wait.until(ExpectedConditions.visibilityOf(dealOfTheDaypage));
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

 // 2nd scenario
    public boolean clickFAQLink() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(faqLink));
            faqLink.click();
            Reports.generateReport(driver, test, Status.PASS, "Clicked FAQ link");
            return true;
        } catch (TimeoutException te) {
            Reports.generateReport(driver, test, Status.FAIL, "FAQ link not clickable");
            return false;
        }
    }

    public boolean verifyFAQPage() {
        try {
            wait.until(ExpectedConditions.visibilityOf(faqPageHeader));
            Reports.generateReport(driver, test, Status.PASS, "FAQ page loaded successfully");
            return true;
        } catch (TimeoutException te) {
            Reports.generateReport(driver, test, Status.FAIL, "FAQ page not displayed");
            return false;
        }
    }

    //Click Help Center link (with scroll)
    public boolean clickHelpCenterLink() {
        try {
            // Scroll to bottom before clicking

//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        	
        	//helpCenterLink
          	WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Help Center')]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", link);
            wait.until(ExpectedConditions.elementToBeClickable(link));
            link.click();

            wait.until(ExpectedConditions.elementToBeClickable(helpCenterLink));
            helpCenterLink.click();
            Reports.generateReport(driver, test, Status.PASS, "Clicked Help Center link");
            return true;
        } catch (TimeoutException te) {
            Reports.generateReport(driver, test, Status.FAIL, "Help Center link not clickable");
            return false;
        }
    }

    public boolean verifyHelpCenterPage() {
        try {
            wait.until(ExpectedConditions.visibilityOf(helpCenterHeader));
            Reports.generateReport(driver, test, Status.PASS, "Help Center page loaded successfully");
            return true;
        } catch (TimeoutException te) {
            Reports.generateReport(driver, test, Status.FAIL, "Help Center page not displayed");
            return false;
        }
    }

	
	
}

