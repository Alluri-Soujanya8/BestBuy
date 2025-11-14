package com.stepDefinitionTestNG;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pages.UserPage2;
import com.parameters.ExcelReader;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Profile extends BaseSteps {
	
	WebDriver driver = BaseSteps.driver;
    ExtentTest test = Hooks.test;
    UserPage2 userpage;
    Properties prop = PropertyReader.readProperty();
	
//==================================first scenario===================================================
    @Given("User is on BestBuy homepage")
    public void user_is_on_best_buy_homepage() {
       	userpage = new UserPage2(driver, test);
    }
    @When("the user clicks on the Deal of the Day")
    public void the_user_clicks_on_the_deal_of_the_day() {
        boolean clickResult = userpage.clickDealOfTheDayModule();
        Assert.assertTrue(clickResult);
    }

    @Then("the Deal of the Day page should be displayed")
    public void the_deal_of_the_day_page_should_be_displayed() {
    	boolean pageDisplayed = userpage.verifyDealOfTheDayPage();
        Assert.assertTrue(pageDisplayed);
    }
    
    
//==============================second scenario====================================================
    @Given("User is on Deal of the Day page")
    public void user_is_on_deal_of_the_day_page() {
         userpage = new UserPage2(driver, test); 
         Assert.assertTrue(userpage.clickDealOfTheDayModule());

    }
    @When("the user clicks on the FAQ link")
    public void the_user_clicks_on_the_faq_link() {

        boolean faqClickResult = userpage.clickFAQLink();
        Assert.assertTrue(faqClickResult);

    }
    @And("the FAQ page should be displayed")
    public void the_faq_page_should_be_displayed() {
    	boolean faqPageDisplayed = userpage.verifyFAQPage();
        Assert.assertTrue(faqPageDisplayed);
    }
    @And("the user clicks on the Help Center link")
    public void the_user_clicks_on_the_help_center_link() {
    	 boolean helpCenterClickResult = userpage.clickHelpCenterLink();
         Assert.assertTrue(helpCenterClickResult);
    }
    @Then("the Help Center page should be displayed")
    public void the_help_center_page_should_be_displayed() {
    	boolean helpCenterDisplayed = userpage.verifyHelpCenterPage();
        Assert.assertTrue(helpCenterDisplayed);
    }
    
    

    //Third Scenario
    
//    
//    @And("user enters the product from sheet {int} and row {int}")
//    public void user_enters_the_product_from_sheet_and_row(Integer sheet, Integer row) {
//    //	try {
//     	Properties props = PropertyReader.readProperty();
//    	    String excelPathSO = props.getProperty("Scenario3OutlineExcelPath");
//    	 
//		
//		String productName = ExcelReader.getLocalityByRow(excelPathSO, int1, int2);
//		Assert.assertNotNull(productName, "product not found at sheet " + int1 + ", row " + int2);
// 
//
//		  // Enter product name using UserPage method
//		        boolean statusEnterProduct = userpage.enterProductName(productName);
//		        Assert.assertTrue(statusEnterProduct, "Failed to enter product: " + productName);
//
//		     // Verify product detail page
//		             boolean statusVerifyProduct = userpage.verifyProductDetailPage();
//		             Assert.assertTrue(statusVerifyProduct, "Product detail page not displayed");
//		      
//    		//}
//
//    		catch (Exception e) {
//        Reports.generateReport(driver, test, Status.FAIL, "Exception occurred: " + e.getMessage());
//        Assert.fail("Step failed due to exception: " + e.getMessage());
//    }
//    	
//
//    Properties props = PropertyReader.readProperty();
//    String excelPath = props.getProperty("Scenario3OutlineExcelPath");
//    //ExcelReader excel=new ExcelReader(excelPath);
//
//    // Get product name from Excel
//           String productName = ExcelReader.getLocalityByRow(excelPath, sheet, row);
//           Assert.assertNotNull(productName, "Product not found at sheet " + sheet + ", row " + row);
//
//           // Enter product name in search bar
//           boolean statusEnterProduct = userpage.enterProductName(productName);
//           Assert.assertTrue(statusEnterProduct, "Failed to enter product: " + productName);
//
//           // Click search button
//           boolean statusClickSearch = userpage.clickSearchButton();
//           Assert.assertTrue(statusClickSearch, "Search button not clickable");
//
//	
//    
//
//    String productName = ExcelReader.getLocalityByRow(excelPath, sheet, row);
//    Assert.assertNotNull(productName, "Product not found at sheet " + sheet + ", row " + row);
//
//    boolean statusEnterProduct = userpage.enterProductName(productName);
//    Assert.assertTrue(statusEnterProduct, "Failed to enter product: " + productName);
//
//    boolean statusVerifyProduct = userpage.verifyProductDetailPage();
//    Assert.assertTrue(statusVerifyProduct, "Product detail page not displayed");
//
//
//    	
//    }
//
//    
//
    
    @Given("user is on the Deal of the Day page")
    public void user_is_on_the_deal_of_the_day_page() {
     	userpage = new UserPage2(driver, test); 
        Assert.assertTrue(userpage.clickDealOfTheDayModule());
    }
    
    @When("user click on the search button")
    public void user_click_on_the_search_button() {
     	Assert.assertTrue(userpage.clickSearchButton());
    }
    
    @And("user enters the product from sheet {int} and row {int}")
    public void user_enters_the_product_from_sheet_and_row(Integer sheetIndex, Integer rowIndex) 
    {
    	 Properties prop = PropertyReader.readProperty();
         String excelPath = prop.getProperty("S3Path"); // Get dynamic path from properties
         String productName = ExcelReader.getCellData(excelPath, sheetIndex, rowIndex, 0); // Column 0 for product name

         userpage = new UserPage2(driver,test);
         userpage.enterProductAndSearch(productName);

    
    }
    @Then("it should display product details")
    public void it_should_display_product_details() 
    {
//    	 String pageSource = driver.getPageSource();
//         Assert.assertTrue("Product details page not displayed", pageSource.contains("Results"));
//    		
    }
//    Properties props = PropertyReader.readProperty();
//    String excelPath = prop.getProperty("Scenario3OutlineExcelPath");
//    System.out.println("Excel Path: " + excelPath);
//    System.out.println("Sheet: " + sheetIndex + ", Row: " + rowIndex);
//    if (excelPath == null || excelPath.isEmpty()) {
//        throw new RuntimeException("Excel path is missing in properties file");
//    }
//    String productName = ExcelReader.getLocalityByRow(excelPath,sheetIndex, rowIndex);
//    //Assert.assertNotNull(productName);
//
//     userpage.enterProductName(productName);
//    //Assert.assertTrue(statusEnterProduct, "Failed to enter product: " + productName);
//
////    boolean statusClickSearch = userpage.clickSearchButton();
////    Assert.assertTrue(statusClickSearch, "Search button not clickable");
//
//    

    	
    
   


//    @Then("it should display product details")
//    public void it_should_display_product_details() {
////
//////        Assert.assertTrue(userpage.verifyProductDetailPage());
//////        driver.quit();
////     	boolean detailVisible = userpage.verifyProductDetailPage(sheetIndex, rowIndex);
////        Assert.assertTrue(detailVisible, "Product detail not displayed for the expected product.");
////        driver.quit();
////
////
//    }

    //----------------------------4th scenario-------------------------------------------------
    @Given("user is on the Deal of the Day Page Module")
    public void user_is_on_the_deal_of_the_day_page_module() {
    		userpage = new UserPage2(driver, test); 
    		userpage.clickDealOfTheDayModule();
    }

    @And("user clicks on the first product of Bonus Deals")
    public void user_clicks_on_the_first_product_of_bonus_deals() {
        userpage.clickFirstBonusDealProduct();
    }

    @And("Navigate to the product page")
    public void navigate_to_the_product_page() {
        
    }
    @And("click on cart icon navigate to add to cart page")
    public void click_on_cart_icon_navigate_to_add_to_cart_page() {
    		userpage.clickAddToCart();
    }

    @Then("verify no product to be is visible")
    public void verify_no_product_to_be_is_visible() {
    		Assert.assertTrue(userpage.verifyAddedToCart());
    }

    //-------------------------------------fifth-----------------------------------------
    
    @Given("the user is land on the Deals page")
    public void the_user_is_land_on_the_deals_page() {
       
    }
    @When("user scrolls down to the deal page")
    public void user_scrolls_down_to_the_deal_page() {
        
    }
    @When("user clicks on the order&purchases from sheet <sheet> and row <row>")
    public void user_clicks_on_the_order_purchases_from_sheet_sheet_and_row_row() {
        
    }
    @Then("navigate to the support page")
    public void navigate_to_the_support_page() {
        
    }



}
