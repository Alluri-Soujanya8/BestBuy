package com.StepDefinitionTestNG;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Pages.UserPage;
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
	
	@Given("Top Deals functionality should be availble")
	public void top_deals_functionality_should_be_availble() {
		userpage=new UserPage(driver, test);
		boolean status=userpage.verifyTopDeals();
		Assert.assertTrue(status);
	}

	@When("i click on Top Deals link")
	public void i_click_on_top_deals_link() {
		boolean status =userpage.click_Top_Deals();
		Assert.assertTrue(status);
	}

	@And("should display Top Deals page")
	public void should_display_top_deals_page() {
		boolean status =userpage.Top_Deals_Page();
		Assert.assertTrue(status);
	}
	
	@And("should click on Computer & Tablet Deals")
	public void should_click_on_computer_tablet_deals() {
		boolean status =userpage.clickComputersAndTabletDeals();
		Assert.assertTrue(status);
	}

	@And("should click on Laptops")
	public void should_click_on_laptops() {
		boolean status =userpage.clickLaptops();
		Assert.assertTrue(status);
	}

	@Then("should display Laptop Deals")
	public void should_display_laptop_deals() 
	{
		boolean status =userpage.laptopDealsPage();
		Assert.assertTrue(status);
	}
	
	@Given("User Laptop Deals page should scroll to Featured deals")
	public void user_laptop_deals_page_should_scroll_to_featured_deals() throws InterruptedException {
		userpage=new UserPage(driver, test);
		userpage.scrollToFeaturedDeals();
	}

	@When("i click on save option for first laptop")
	public void i_click_on_save_option_for_first_laptop() throws InterruptedException {
		boolean status =userpage.saveFirstLaptop();
		Assert.assertTrue(status);
	}

	@And("click on save option for second laptop")
	public void click_on_save_option_for_second_laptop() {
		boolean status =userpage.saveSecondLaptop();
		Assert.assertTrue(status);
	}

	@And("scroll up to click on Saved Items")
	public void scroll_up_to_click_on_saved_items() throws InterruptedException {
		boolean status =userpage.clickSavedItems();
		Assert.assertTrue(status);
	}

	@Then("click on See all your saved items")
	public void click_on_see_all_your_saved_items() {
		boolean status =userpage.clickSeeAllYourSavedItems();
		Assert.assertTrue(status);
	}
}

