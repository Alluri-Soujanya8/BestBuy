package com.pages;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.parameters.ExcelReader;
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
    ////*[@id="autocomplete-search-bar-container"]
    /////div[@id='autocomplete-search-bar-container']

//    @FindBy(xpath = "//*[@id=\"autocomplete-search-bar-container\"]")
//    private WebElement searchBar;
    @FindBy(xpath = "//div[contains(@class,'sugg-lv-search-bar')]")
    ////button[@id='searchButton']
    private WebElement searchButton;
//    @FindBy(xpath = "//div[contains(@class,'product-item')]")
//    private List<WebElement> productResults;
    @FindBy(xpath = "(//div[@data-testid='TermSuggestion-0'])[1]")
    private WebElement firstsuggestion;
    //(//div[@data-testid='TermSuggestion-0'])[1]
    @FindBy(xpath = "//h1[contains(@class,'product-title')]")
    private WebElement productTitle;
    

    
    //4th scenario
    @FindBy(xpath = "(//a[@class='wf-offer-link wf-image-wrapper'])[2]")
    //(//a[@class='wf-offer-link wf-image-wrapper'])[2]
    private WebElement firstBonusDealProduct;

    @FindBy(xpath = "//button[@data-test-id='add-to-cart'][1]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[text()='Added to cart']")
    private WebElement addedToCartMessage;

    
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
    
    public boolean enterProductFromExcel(int sheetIndex, int rowIndex) {
        String productName = ExcelReader.getProduct(sheetIndex, rowIndex);
        if (productName == null || productName.isEmpty()) return false;

        try {
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            //driver.findElement(By.id("gh-search-input")).sendKeys(productName);
            ////div[contains(@class,'sugg-lv-search-bar')]
            //WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        	WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("gh-search-input")));
            searchInput.clear();

            
        	searchInput.clear();
            searchInput.sendKeys(productName);
            //searchInput.sendKeys(Keys.ENTER);////button[@data-testid="SearchButton-TestID"]
            //WebElement searchbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='autocomplete-search-button']")));
            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("autocomplete-search-button")));
            
            searchButton.click();
            return true;
        } catch (Exception e) {
            System.out.println("Error entering product: " + e.getMessage());
            return false;
        }
    }

    public boolean clickSearchButton() {
        try {
            WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'sugg-lv-search-bar')]")));
            button.click();
            Reports.generateReport(driver, test, Status.PASS, "Clicked search button successfully");
            return true;
        } catch (TimeoutException te) {
            Reports.generateReport(driver, test, Status.FAIL, "Search button not clickable");
            return false;
        }
    }
    
    
    
//    public boolean enterProductName(String productName) {
//        try {
//            WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
//            //searchInput.click();
//            searchInput.clear();
//            searchInput.sendKeys(productName);
//            //searchInput.sendKeys(Keys.ENTER);
////            WebElement firstproduct = wait.until(ExpectedConditions.visibilityOf(firstsuggestion));
////            firstproduct.click();
//            Reports.generateReport(driver, test, Status.PASS, "Entered product: ");
//            return true;
//        } catch (TimeoutException te) {
//            Reports.generateReport(driver, test, Status.FAIL, "Search bar not visible");
//            return false;
//        }
//    }

//    public boolean clickSearchButton() {
//        try {
//            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
//            button.click();
//            Reports.generateReport(driver, test, Status.PASS, "Clicked search button successfully");
//            return true;
//        } catch (TimeoutException te) {
//            Reports.generateReport(driver, test, Status.FAIL, "Search button not clickable");
//            return false;
//        }
//    }

    public boolean verifyProductDetailPage(int sheetIndex, int rowIndex) {
//        try {
//            wait.until(ExpectedConditions.visibilityOf(productTitle));
//            Reports.generateReport(driver, test, Status.PASS, "Product detail page displayed successfully");
//            return true;
//        } catch (TimeoutException te) {
//            Reports.generateReport(driver, test, Status.FAIL, "Product detail page not displayed");
//            return false;
//        }
    	String productName = ExcelReader.getProduct(sheetIndex, rowIndex);
        if (productName == null || productName.isEmpty()) {
            System.out.println("Product name is missing or unreadable from Excel.");
            return false;
        }
        return driver.getPageSource().toLowerCase().contains(productName.toLowerCase());


//        try {
//            String pageContent = driver.getPageSource().toLowerCase();
//            return pageContent.contains(productName.toLowerCase());
//        } catch (Exception e) {
//            System.out.println("Error verifying product detail: " + e.getMessage());
//            return false;
//        }

        

    }
    
    //----------------------------4th scenario-----------------------------

public boolean clickFirstBonusDealProduct() {
        try {
            WebElement product = wait.until(ExpectedConditions.elementToBeClickable(firstBonusDealProduct));
            product.click();
            return true;
        } catch (TimeoutException e) {
            System.out.println("First Bonus Deal product not clickable");
            return false;
        }
    }

    public boolean clickAddToCart() {
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
            button.click();
            return true;
        } catch (TimeoutException e) {
            System.out.println("Add to Cart button not clickable");
            return false;
        }
    }

    public boolean verifyAddedToCart() {
        try {
            wait.until(ExpectedConditions.visibilityOf(addedToCartMessage));
            return true;
        } catch (TimeoutException e) {
            System.out.println("Added to cart message not displayed");
            return false;
        }
    }


    
    
}


