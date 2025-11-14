package com.StepDefinitionTestNG;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Pages.UserPage;
import com.Parameters.ExcelReader;
import com.Parameters.PropertyReader;
import com.Setup.BaseSteps;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Profile extends BaseSteps{
	
	WebDriver driver=BaseSteps.driver;
	ExtentTest test=Hooks.test;
	
	UserPage userpage;
	
	//first Scenario
	@Given("Top Deals functionality should be availble")
	public void top_deals_functionality_should_be_availble() {
		userpage=new UserPage(driver, test);
		boolean status=userpage.verifyTopDeals();
		Assert.assertTrue(status);
	}

	@When("i click on Top Deals link")
	public void i_click_on_top_deals_link() {
		userpage.click_Top_Deals();
	}

	@And("should display Top Deals page")
	public void should_display_top_deals_page() {
		userpage.Top_Deals_Page();
	}
	
	@And("should click on Computer & Tablet Deals")
	public void should_click_on_computer_tablet_deals() {
		userpage.clickComputersAndTabletDeals();
	}

	@And("should click on Laptops")
	public void should_click_on_laptops() {
		userpage.clickLaptops();
	}

	@Then("should display Laptop Deals")
	public void should_display_laptop_deals() 
	{
		boolean status =userpage.laptopDealsPage();
		Assert.assertTrue(status);
	}
	
	
	
	//Second Scenario
	
	@Given("User Laptop Deals page should scroll to Featured deals")
	public void user_laptop_deals_page_should_scroll_to_featured_deals() throws InterruptedException {
		userpage=new UserPage(driver, test);
		userpage.goToFirstLaptop();
	}

	@When("i click on save option for first laptop")
	public void i_click_on_save_option_for_first_laptop() throws InterruptedException {
		userpage.saveFirstLaptop();
	}

	@And("click on save option for second laptop")
	public void click_on_save_option_for_second_laptop() {
		userpage.saveSecondLaptop();
	}

	@And("scroll up to click on Saved Items")
	public void scroll_up_to_click_on_saved_items() throws InterruptedException {
		userpage.clickSavedItems();
	}

	@Then("click on See all your saved items")
	public void click_on_see_all_your_saved_items() {
		boolean status =userpage.clickSeeAllYourSavedItems();
		Assert.assertTrue(status);
	}
	
	
	
	//Third Scenario
	
	@Given("Saved Items Page should be open")
	public void saved_items_page_should_be_open() {
		boolean status =userpage.verifySavedItemsPage();
		Assert.assertTrue(status);
	}

	@When("i select First checkbox of first Laptop {int} {int}")
	public void i_select_first_checkbox_of_first_laptop(Integer sheetNo, Integer rowNum) throws IOException {
		userpage.checkboxFirstLaptop(sheetNo, rowNum);
	}
	@And("select second checkbox of second Laptop {int} {int}")
	public void select_second_checkbox_of_second_laptop(Integer sheetNo, Integer rowNum) throws IOException {
		userpage.checkboxSecondLaptop(sheetNo, rowNum);
	}
	
	@And("click on Compare button")
	public void click_on_compare_button() {
		userpage.clickCompare();
	}

	@And("verify Compare Products")
	public void verify_compare_products() {
		boolean status =userpage.verifyCompareProducts();
		Assert.assertTrue(status);
	}

	@And("verify and click Toggle Switch")
	public void verify_and_click_toggle_switch() {
		boolean status =userpage.verifyAndClickToggleSwitch();
		Assert.assertTrue(status);
	}

	@Then("Scroll up and click Remove on First Laptop")
	public void scroll_up_and_click_remove_on_first_laptop() {
		userpage.scrollUpAndRemoveLaptop();
	}
	
	
	//Fourth Scenario
	
	@And("click Add to Cart for first Laptop {int} {int}")
	public void click_add_to_cart_for_first_laptop(Integer sheetNo, Integer rowNum) throws IOException {
		userpage.AddToCartFirstLaptop(sheetNo, rowNum);
	}

	@And("click Add to Cart for second Laptop {int} {int}")
	public void click_add_to_cart_for_second_laptop_1(Integer sheetNo, Integer rowNum) throws IOException {
		userpage.AddToCartSecondLaptop(sheetNo, rowNum);
	}

	@And("click on Cart")
	public void click_on_cart() {
		userpage.clickCart();
	}

	@Then("verify Cart")
	public void verify_cart() {
		boolean status =userpage.verifyCart();
		Assert.assertTrue(status);
	}
	
	
	//Fifth Scenario
	
	@When("should click Shop now")
	public void should_click_shop_now() {
		userpage.clickShopNow();
	}

	@Then("verify All the Holiday Deals")
	public void verify_all_the_holiday_deals() {
		boolean status =userpage.verifyAllTheHolidayDeals();
		Assert.assertTrue(status);
	}
}

