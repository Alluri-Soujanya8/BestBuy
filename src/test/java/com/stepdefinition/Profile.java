package com.stepdefinition;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pages.Brand;
import com.pages.TvPage;
import com.pages.UserPage;
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

	UserPage userpage;
	TvPage tvpage;
	Brand brand;


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
		Assert.assertTrue(status);
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
	public void should_display_what_are_avaliable_on_that() {
		boolean status = userpage.clickLg();
		Assert.assertTrue(status, "TV & Home Theater module not found or clickable");

	}
//	@Given("User is on the TV page")
//	public void user_is_on_the_tv_page() {
//	    Properties prop = PropertyReader.readProperty();
//	    String tvPageUrl = prop.getProperty("tvPage");
//	    driver.get(tvPageUrl);
//	    tvpage = new TvPage(driver, test);
//	    boolean status = tvpage.verifyTvPageLoaded();
//	    Assert.assertTrue(tvpage.verifyTvPageLoaded(), "TV page did not load correctly");
//	}
//
//	@When("User scrolls to the filter panel")
//	public void user_scrolls_to_the_filter_panel() {
//		boolean status = tvpage.scrollToFilterPanel();
//	    Assert.assertTrue(tvpage.scrollToFilterPanel(), "Failed to scroll to filter panel");
//	}
//
//	@And("User applies filters from Excel")
//	public void user_applies_filters_from_excel() {
//	    boolean status = tvpage.applyFilter(category, value);
//	    Assert.assertTrue(status);
//	}
//
//	@Then("Relevant TV models matching the criteria should be displayed")
//	public void relevant_tv_models_matching_the_criteria_should_be_displayed() {
//		boolean status = tvpage.verifyFilteredResults();
//	    Assert.assertTrue(tvpage.verifyFilteredResults(), "Filtered TV models are not displayed correctly");
//	}
//	
//	@When("I click on TVs by Brand")
//	public void i_click_on_t_vs_by_brand() throws InterruptedException {
//		brand = new Brand(driver, test);
//		
//	    
//	}
//
//	@Then("the TV listingpage for the brand  should be displayed")
//	public void the_tv_listingpage_for_the_brand_should_be_displayed() throws InterruptedException {
//	    
//	}
//
//	@Then("I click on Brand")
//	public void i_click_on_brand() throws InterruptedException {
//		
//		brand.clickonLG();
//		brand.clickonSony();
//	    brand.clickonSamsung();
//	}
}









