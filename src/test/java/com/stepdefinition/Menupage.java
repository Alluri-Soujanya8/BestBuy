package com.stepdefinition;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.pages.Brand;
import com.pages.CartPage;
import com.pages.TvPage;
import com.pages.UserPage;
import com.parameters.ExcelReader;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;
import com.setup.Reports;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Menupage extends BaseSteps {

	WebDriver driver = BaseSteps.driver;
	ExtentTest test = Hooks.test;

	UserPage userpage;
	TvPage tvpage;
//	Brand brand;
	CartPage cart;
	
	String excel;
	

	
	Properties prop = PropertyReader.readProperty();

	private String selectedBrand;

	//First Scenario
	
	@Given("Menu Bar should avaliable")
	public void menu_bar_should_avaliable() {
		userpage = new UserPage(driver, test);
		boolean status = userpage.menubar();
		Assert.assertTrue(status, "Menu Bar is not available");
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
//		boolean status = userpage.clickLg();
//		Assert.assertTrue(status, "TV & Home Theater module not found or clickable");
	    
	}
	
	// SECOND SCENARIO
	
	
	@When("I click on TVs by Brand")
	public void i_click_on_t_vs_by_brand() {
		
		boolean status1 = userpage.clickbrand();
		Assert.assertTrue(status1, "TV & Home Theater module not found or clickable");
	    
	}
	@When("I select from sheet {int}  {int}")
	public void i_select_from_sheet(Integer int1, Integer int2) throws Exception {
		tvpage = new TvPage(driver, test);
		
//		tvpage = new TvPage(driver, test);
//		Properties prop = PropertyReader.readProperty();
//		 
//	    // ✅ Now safely get the Excel path
//	    String excelPath = prop.getProperty("filepath");
//	    
//	    // ✅ Defensive check
//	    if (excelPath == null || excelPath.isEmpty()) {
//	        throw new RuntimeException("Excel path is missing in properties file");
//	    }
// 
//	    // ✅ Read from Excel
//	    excel = ExcelReader.getLocalityByRow(excelPath, 0, int2);
//	    
//	    tvpage.selectlg(excelPath);
//	    tvpage.selectsamsung(excelPath);
//	    tvpage.selectsony(excelPath);
//	    
		
		String brand = ExcelReader.getCellData(int1, int2, 0);
        tvpage.selectlg(brand);
        System.out.println("Applied Location filter: " + brand);
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
	public void it_displays_the_avaliable_t_vs() {
	  
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
		Assert.assertTrue(status, "Menu Bar is not available");

	}
	@When("User Add Tv to the Cart")
	public void user_add_tv_to_the_cart()
	{
		boolean status = cart.addcart();
		Assert.assertTrue(status, "Menu Bar is not available");
	}
	@When("Popup appears select go to the cart")
	public void popup_appears_select_go_to_the_cart() 
	{
		boolean status = cart.gocart();
		Assert.assertTrue(status, "Menu Bar is not available");
	}
	@Then("it displays cart page")
	public void it_displays_cart_page() 
	{
		boolean status = cart.gocart();
		Assert.assertTrue(status, "Menu Bar is not available");

	}
	
	
	// FIFTH SCENARIO
	
	
	
	@When("User is in the Cart Page")
	public void user_is_in_the_cart_page() {

	}
	@When("user can save the product")
	public void user_can_save_the_product() {

	}
	@When("user can remove the product if not needed")
	public void user_can_remove_the_product_if_not_needed() {

	}
	@When("user will do checkout")
	public void user_will_do_checkout() {

	}
	@When("user will go for the page to sign in")
	public void user_will_go_for_the_page_to_sign_in() {

	}
	@When("clicking on continue as guest")
	public void clicking_on_continue_as_guest() {

	}
	@Then("it displays the checkout page")
	public void it_displays_the_checkout_page() {

	}

	
	



}















