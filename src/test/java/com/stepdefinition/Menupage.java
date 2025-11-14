package com.stepdefinition;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
//import com.pages.Brand;
import com.pages.CartPage;
import com.pages.CheckoutPage;
import com.pages.TvPage;
import com.pages.UserPage;
import com.parameters.ExcelReader;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Menupage extends BaseSteps {

	WebDriver driver = BaseSteps.driver;
	ExtentTest test = Hooks.test;

	UserPage userpage;
	TvPage tvpage;
	CartPage cart;
	CheckoutPage check;
	
	String excel;
	

	
	Properties prop = PropertyReader.readProperty();

	private String selectedBrand;

	//First Scenario
	
	@Given("Menu Bar should avaliable")
	public void menu_bar_should_avaliable() {
		userpage = new UserPage(driver, test);
		boolean status = userpage.menubar();
		Assert.assertTrue(status, "Menu Bar is avaliable");
	}

	@And("click on Menu Bar")
	public void click_on_menu_bar() {
		userpage = new UserPage(driver, test);
		boolean status = userpage.clickMenu(); // updated to use clickMenu()
		Assert.assertTrue(status, "Failed to click on Menu Button");
	}

	@And("Select the Shop by Department")
	public void select_the_shop_by_department() {
		boolean status = userpage.moduleBB(); // now calling moduleBB() here
		Assert.assertTrue(status, "Shop by Department (TV & Home Theater) not found");
	}

	@When("I click on Tv&Home Theatre")
	public void i_click_on_tv_home_theatre() {
		boolean status = userpage.verifymodule();
		boolean status1 = userpage.clickbrand();
		Assert.assertTrue(status, "TV & Home Theater module not found or clickable");
		Assert.assertTrue(status1, "TV & Home Theater module not found or clickable");

	   
	}
	@Then("should display the Product page")
	public void should_display_the_product_page() {
		boolean status = userpage.clickLg();
		Assert.assertTrue(status, "TV & Home Theater module not found or clickable");
	    
	}
	
	// SECOND SCENARIO
	
	
	@When("I click on TVs by Brand")
	public void i_click_on_t_vs_by_brand() {
		
		boolean status1 = userpage.clickbrand();
		Assert.assertTrue(status1, "TV & Home Theater module not found or clickable");
	    
	}
	@When("I select from sheet {int}  {int}")
	public void i_select_from_sheet(Integer int1, Integer int2) throws Exception {
		userpage.clickbrand();
		tvpage = new TvPage(driver, test);
		
		tvpage = new TvPage(driver, test);
		Properties prop = PropertyReader.readProperty();
		 
	    // ✅ Now safely get the Excel path
	    String excelPath = prop.getProperty("filepath");
	    
	    // ✅ Defensive check
	    if (excelPath == null || excelPath.isEmpty()) {
	        throw new RuntimeException("Excel path is missing in properties file");
	    }
 
	    // ✅ Read from Excel
	    excel = ExcelReader.getLocalityByRow(excelPath, 0, int2);
	    
//	    tvpage.selectlg(excelPath);
//	    tvpage.selectsamsung(excelPath);
	    if(int2 == 0) {
	    	tvpage.selectlg(excelPath);
	    }else if(int2 ==1)
	    {
	    	tvpage.selectsamsung(excelPath);
	    }
	    else {
	    	throw new IllegalArgumentException();
	    }

//	    
//		
//		String brand = ExcelReader.getCellData(int1, int2, 0);
//        tvpage.selectlg(brand);
//        System.out.println("Applied Location filter: " + brand);
	}
	@Then("the TV listingpage for the brand  should be displayed")
	public void the_tv_listingpage_for_the_brand_should_be_displayed() {
		
		boolean status = tvpage.verifyTvPageLoaded();
		Assert.assertTrue(status, "page is displayed");
	    
	}
	@Then("I click on Brand")
	public void i_click_on_brand() {
		
	    
	}
	
	
	
	//Third Scenario
	
	
	@Then("User select first television type  {int} {int}")
	public void user_select_first_television_type(Integer int1, Integer int2) throws Exception {
		tvpage = new TvPage(driver, test);
		Properties prop = PropertyReader.readProperty();
		 
	    // ✅ Now safely get the Excel path
	    String excelPath = prop.getProperty("filepath");
	    
	    // ✅ Defensive check
	    if (excelPath == null || excelPath.isEmpty()) {
	        throw new RuntimeException("Excel path is missing in properties file");
	    }
 
	    // ✅ Read from Excel
	    excel = ExcelReader.getLocalityByRow(excelPath, 0, int2);
	    
	    tvpage.selectTelevisionType(excelPath);
	    
 
	    
	}
	@And("user select second television type {int} {int}")
	public void user_select_second_television_type(Integer sheetIndex, Integer rowIndex) throws Exception {
		tvpage = new TvPage(driver, test);
		Properties prop = PropertyReader.readProperty();
		 
	    // ✅ Now safely get the Excel path
	    String excelPath = prop.getProperty("filepath");
	    
	    // ✅ Defensive check
	    if (excelPath == null || excelPath.isEmpty()) {
	        throw new RuntimeException("Excel path is missing in properties file");
	    }
 
	    // ✅ Read from Excel
	    excel = ExcelReader.getLocalityByRow(excelPath, 0, rowIndex);
	    
	    tvpage.clicksecondcheckbox(excelPath);
	}  


	@Then("user select third television type  {int} {int}")
	public void user_select_third_television_type(Integer int1, Integer int2) throws Exception {
		tvpage = new TvPage(driver, test);
		Properties prop = PropertyReader.readProperty();
		 
	    // ✅ Now safely get the Excel path
	    String excelPath = prop.getProperty("filepath");
	    
	    // ✅ Defensive check
	    if (excelPath == null || excelPath.isEmpty()) {
	        throw new RuntimeException("Excel path is missing in properties file");
	    }
 
	    // ✅ Read from Excel
	    excel = ExcelReader.getLocalityByRow(excelPath, 0, int2);
	    
	    tvpage.clickthirdcheckbox(excelPath);
	}
	
	@Then("it displays the avaliable TVs")
	public void it_displays_the_avaliable_t_vs() 
	{
	  
	}

	
	
//	FOURTH SCENARIO

	@When("User Select a product it will go into the product page")
	public void user_select_a_product_it_will_go_into_the_product_page() 
	{
		cart = new CartPage(driver, test);
		boolean status = cart.product();
		Assert.assertTrue(status, "Menu Bar is not available");
	}
	@When("User can click the link for reviews")
	public void user_can_click_the_link_for_reviews()
	{
		boolean status = cart.review();
		driver.navigate().back();
		Assert.assertTrue(status, "Menu Bar is not available");

	}
	@When("User Add Tv to the Cart")
	public void user_add_tv_to_the_cart()
	{
		cart = new CartPage(driver, test);
		boolean status = cart.addtocart();
		Assert.assertTrue(status, "Menu Bar is not available");
	}
	@When("Popup appears select go to the cart")
	public void popup_appears_select_go_to_the_cart() 
	{
		boolean status = cart.gotocart();
		Assert.assertTrue(status, "Menu Bar is not available");
	}
	@Then("it displays cart page")
	public void it_displays_cart_page() 
	{
		boolean status = cart.verifycart();
		Assert.assertTrue(status, "Menu Bar is not available");

	}
	
	
	// FIFTH SCENARIO
	
	
	
	@When("User is in the Cart Page")
	public void user_is_in_the_cart_page() 
	{
		cart = new CartPage(driver, test);
		UserPage.clickLg();
		
		boolean status = cart.addtocart();
		Assert.assertTrue(status, "Menu Bar is not available");
		boolean status1 = cart.gotocart();
		Assert.assertTrue(status1, "Menu Bar is not available");


	}
	
	@When("user can remove the product if not needed")
	public void user_can_remove_the_product_if_not_needed() 
	{
		
		boolean status = cart.removefromcart();
		Assert.assertTrue(status, "Menu Bar is not available");

	}
	@When("user will do checkout")
	public void user_will_do_checkout() 
	{
		boolean status = cart.checkOut();
		Assert.assertTrue(status, "Menu Bar is not available");

	}
	@When("user will go for the page to sign in")
	public void user_will_go_for_the_page_to_sign_in() 
	{
		boolean status = cart.verifycart();
		Assert.assertTrue(status, "Menu Bar is not available");
       
	}
	@When("clicking on continue as guest")
	public void clicking_on_continue_as_guest() 
	{
		boolean status = cart.signin();
		Assert.assertTrue(status, "Menu Bar is not available");

       
	}
	@Then("it displays the checkout page")
	public void it_displays_the_checkout_page()
	{
		boolean status = cart.verifycheckout();
		Assert.assertTrue(status, "Menu Bar is not available");

	}
	
	
	
//	
//	@And("User clicks on the PayPal checkout")
//	public void clickPayPalCheckout() {
//	    WebElement paypalButton = driver.findElement(By.xpath("//button[contains(text(),'PayPal')]"));
//	    paypalButton.click();
//	}
//	
//	@When("It goes into the PayPal email page")
//	public void switchToPayPalWindow() {
//	    String mainWindow = driver.getWindowHandle();
//	    for (String handle : driver.getWindowHandles()) {
//	        if (!handle.equals(mainWindow)) {
//	            driver.switchTo().window(handle);
//	            break;
//	        }
//	    }
//	}
//	
//	@And("User should enter email or phone number {string} {string}")
//	public void enterPayPalCredentials(String sheet, String row) {
//	    WebElement emailField = driver.findElement(By.id("email")); // PayPal email input
//	    emailField.sendKeys("testuser@example.com"); // Replace with data from sheet/row
//	}
//	
//	@And("User can cancel and return to Best Buy")
//	public void cancelAndReturn() {
//	    WebElement cancelButton = driver.findElement(By.xpath("//button[contains(text(),'Cancel')]"));
//	    cancelButton.click();
//	}
//	
//	@Then("User comes back to the checkout page")
//	public void switchBackToMainWindow() {
//	    for (String handle : driver.getWindowHandles()) {
//	        driver.switchTo().window(handle);
//	        if (driver.getTitle().contains("Checkout")) {
//	            break;
//	        }
//	    }
//	}
	@When("User clicks on the paypal checkout")
	public void user_clicks_on_the_paypal_checkout()
	{
		check = new CheckoutPage(driver, test);
		boolean status = check.clickPaypalCheckout();
		Assert.assertTrue(status, "Menu Bar is not available");

	}
	@When("it goes into the paypal email page")
	public void it_goes_into_the_paypal_email_page() 
	{
		boolean status = check.verifyPaypalPage();
		Assert.assertTrue(status, "Menu Bar is not available");
	}
	@When("User should enter email or phone number {int} {int}")
	public void user_should_enter_email_or_phone_number(Integer int1, Integer int2) 
	{
		check = new CheckoutPage(driver, test);
		
		Properties prop = PropertyReader.readProperty();
		 
	    // ✅ Now safely get the Excel path
	    String excelPath = prop.getProperty("filepath");
	    
	    // ✅ Defensive check
	    if (excelPath == null || excelPath.isEmpty()) {
	        throw new RuntimeException("Excel path is missing in properties file");
	    }
 
	    // ✅ Read from Excel
	    excel = ExcelReader.getLocalityByRow(excelPath, 0, int2);
	    
	    check.enterValue(excelPath);
	}
	@When("user can cancel and return to best buy")
	public void user_can_cancel_and_return_to_best_buy() 
	{
		boolean status = check.clickcancel();
		Assert.assertTrue(status, "Menu Bar is not available");
	}
	@Then("user come backs to the checkout page")
	public void user_come_backs_to_the_checkout_page() 
	{
		boolean status = check.verifyCheckout();
		Assert.assertTrue(status, "Menu Bar is not available");
	}
	
	@Given("Menu Bar should be available")
	public void menu_bar_should_be_available() 
	{
		userpage = new UserPage(driver, test);
		boolean status = userpage.clickMenu(); // updated to use clickMenu()
		Assert.assertTrue(status, "Failed to click on Menu Button");
	}
	@When("I click on Tv & Home Theatre")
	public void i_click() 
	{
		userpage.clickMenu();
		userpage.moduleBB();
		userpage.clickbrand();
		userpage.clickLg();
	}

	
//	@Then("User tries to select invalid television type {int} {int}")
//	public void user_tries_to_select_invalid_television_type(Integer int1, Integer int2) 
//	{
//		tvpage = new TvPage(driver, test);
//		Properties prop = PropertyReader.readProperty();
//		 
//	    // ✅ Now safely get the Excel path
////	    String excelPath = prop.getProperty("checkoutPage");
//		String excelPath=ExcelReader.getCellData(ExcelReader.pathfiles, int2, i);
//	    
//	    // ✅ Defensive check
//	    if (excelPath == null || excelPath.isEmpty()) {
//	        throw new RuntimeException("Excel path is missing in properties file");
//	    }
// 
//	    // ✅ Read from Excel
//	    excel = ExcelReader.getLocalityByRow(excelPath, 0, int2);
//	    if(int2 == 0) {
//	    	tvpage.clickfirst(excelPath);
//	    }else if(int2 ==1)
//	    {
//	    	tvpage.clicksecond(excelPath);
//	    }
//	    else if(int2 == 3)
//	    {
//	    	tvpage.clickthird(excelPath);
//	    }
//	    else {
//	    	throw new IllegalArgumentException();
//	    }
	@Then("User tries to select invalid television type {int} {int}")
	public void user_tries_to_select_invalid_television_type(Integer sheetIndex, Integer rowIndex) 
	{

		   String search = ExcelReader.getCellDatas(ExcelReader.pathfiles, sheetIndex, rowIndex, ExcelReader.SEARCH_COLUMN_INDEX);
	        System.out.println("Hospital from Excel: " + search);

	        WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"televisiontype_facet-search-bar-input\"]"));
	        searchInput.click();
	        searchInput.sendKeys(search);
	        searchInput.sendKeys(Keys.ARROW_DOWN);
	        searchInput.sendKeys(Keys.ENTER);
	    
	}
	@Then("it should display No products found message")
	public void it_should_display_no_products_found_message() 
	{
	    
	}


	
	



}















