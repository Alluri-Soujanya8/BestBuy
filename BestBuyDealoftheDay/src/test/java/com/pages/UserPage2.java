package com.pages;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

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
import com.parameters.PropertyReader;
import com.setup.Reports;

public class UserPage2 {
	
	private static WebDriver driver;
    private static WebDriverWait wait;
    static ExtentTest test;
	

    @FindBy(xpath = "//span[text()='Deal']")
    private static WebElement dealOfTheDaypage;
    @FindBy(xpath = "//a[text() = 'Deal of the Day']")
    private static WebElement dealPageIdentifier;


    
    @FindBy(xpath = "//a[text() = 'See Deal of the Day FAQs']") 
    private WebElement faqLink;
    @FindBy(xpath = "//h1[text()='Deal of the Day Frequently Asked Questions']") 
    private WebElement faqPageHeader;
    @FindBy(xpath = "(//a[contains(text(),'Help Center')])[1]")
    private WebElement helpCenterLink;
    @FindBy(xpath = "//h1[contains(text(),'Best')]")
    private WebElement helpCenterHeader;


    //third scenario
//    @FindBy(xpath = "//input[@id='searchBar']") // Update XPath as per your app
//    private WebElement searchBar;
//    @FindBy(xpath = "//button[@id='searchButton']") // Update XPath
//    private WebElement searchButton;
//    @FindBy(xpath = "//div[contains(@class,'product-item')]") // Update XPath for product list
//    private List<WebElement> productResults;
//    @FindBy(xpath = "//h1[contains(@class,'product-title')]") // Update XPath for product detail page
//    private WebElement productTitle;

//   @FindBy(xpath = "//a[@id='dealOfTheDay']")
//    private WebElement dealPageIdentifier;

    @FindBy(xpath = "//div[@id='autocomplete-search-bar-container']")
    private WebElement searchBar;

    @FindBy(xpath = "//button[@id='searchButton']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[contains(@class,'product-item')]")
    private List<WebElement> productResults;

    @FindBy(xpath = "//h1[contains(@class,'product-title')]")
    private WebElement productTitle;


    // Actions

    
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
            Properties props = PropertyReader.readProperty();
            String expectedTitle = props.getProperty("dealOfTheDay.expectedTitle");
            String actualTitle = driver.getTitle();
            if (!actualTitle.contains(expectedTitle)) {
                actResult = false;
            }
            Reports.generateReport(driver, test, Status.PASS, "Deal of the Day page loaded: ");
        } catch (TimeoutException te) {
            actResult = false;
            Reports.generateReport(driver, test, Status.FAIL, "Deal of the Day page not displayed");
        }
        return actResult;
    }
    
    
    
    //=================================================
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
          	//helpCenterLink

            Properties props = PropertyReader.readProperty();
            String helpCenterLocator = props.getProperty("helpCenter.link.xpath");

          	WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(helpCenterLocator)));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", link);
//            wait.until(ExpectedConditions.elementToBeClickable(link));
//            link.click();

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
    
    //============================================================
    //Third Scenario
    /**
     * Enter product in search bar and click search
     */
    public boolean enterProductInSearchBar(String productName) {
        boolean actResult = true;
        try {
            wait.until(ExpectedConditions.visibilityOf(searchBar));
            searchBar.clear();
            searchBar.sendKeys(productName);
            wait.until(ExpectedConditions.elementToBeClickable(searchButton));
            searchButton.click();
            Reports.generateReport(driver, "SearchProduct", Status.PASS, "Entered product: " + productName);
        } catch (TimeoutException te) {
            actResult = false;
            Reports.generateReport(driver, "SearchProduct", Status.FAIL, "Search bar or button not clickable for product: " + productName);
        } catch (Exception e) {
            actResult = false;
            Reports.generateReport(driver, "SearchProduct", Status.FAIL, "Error while entering product: " + productName + " - " + e.getMessage());
        }
        return actResult;
    }

    /**
     * Validate search results displayed
     */
    public boolean isSearchResultsDisplayed() {
        boolean actResult = true;
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(productResults));
            Reports.generateReport(driver, "SearchResults", Status.PASS, "Search results displayed");
        } catch (TimeoutException te) {
            actResult = false;
            Reports.generateReport(driver, "SearchResults", Status.FAIL, "Search results not displayed");
        }
        return actResult;
    }

    /**
     * Click on the first product in search results
     */
    public boolean clickFirstProduct() {
        boolean actResult = true;
        try {
            if (!productResults.isEmpty()) {
                wait.until(ExpectedConditions.elementToBeClickable(productResults.get(0)));
                productResults.get(0).click();
                Reports.generateReport(driver, "ClickProduct", Status.PASS, "Clicked on the first product");
            } else {
                actResult = false;
                Reports.generateReport(driver, "ClickProduct", Status.FAIL, "No products found in search results");
            }
        } catch (TimeoutException te) {
            actResult = false;
            Reports.generateReport(driver, "ClickProduct", Status.FAIL, "First product not clickable");
        }
        return actResult;
    }

    /**
     * Verify navigation to product detail page
     */
    public boolean verifyProductDetailPage() {
        boolean actResult = true;
        try {
            wait.until(ExpectedConditions.visibilityOf(productTitle));
            Reports.generateReport(driver, "ProductDetail", Status.PASS, "Navigated to product detail page");
        } catch (TimeoutException te) {
            actResult = false;
            Reports.generateReport(driver, "ProductDetail", Status.FAIL, "Product detail page not loaded");
        }
        return actResult;
    }
}




	
	
}

