package com.stepDefinitionJUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pages.UserPage;
import com.parameters.ExcelReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Profile {
	WebDriver driver = BaseSteps.driver;
	ExtentTest test = Hooks.test;

	//PetsPage petspage;
	UserPage userpage;
	
	@Given("the user is on the BestBuy Home Page")
	public void the_user_is_on_the_best_buy_home_page() {
	    userpage = new UserPage(driver, test);
	    Assert.assertTrue(userpage.verifyHomepage(), "Home Page is not displayed");
	}
//	@When("the user clicks on the {string} link")
//	public void the_user_clicks_on_the_link1(String string) {
//		
//		boolean status = userpage.clickGiftIdeas();
//		Assert.assertTrue(status);
//	    
//	}
	@Then("the Gift Ideas page with various categories should be displayed")
	public void the_gift_ideas_page_with_various_categories_should_be_displayed() {
		boolean status = userpage.displayGiftIdeasPage();
		Assert.assertTrue(status);

	}
//	@Given("the user is on the BestBuy Home Page")
//	public void the_user_is_on_the_best_buy_home_page1() {
//	    userpage = new UserPage(driver, test);
//	    Assert.assertTrue(userpage.verifyHomepage(), "Home Page is not displayed");
//	}
	@When("the user clicks on the {string} link")
	public void the_user_clicks_on_the_link(String string) {
		
		boolean status = userpage.clickGiftIdeas();
		Assert.assertTrue(status);
	    
	}
	
	@And("the user clicks on the {string} category")
	public void the_user_clicks_on_the_category(String string) {
		boolean status = userpage.clickPetsPage();
		Assert.assertTrue(status);
	    
	}
	@And("click on {string} category")
	public void click_on_category(String string) {
		boolean status = userpage.clickpetfeeders();
		Assert.assertTrue(status);
	    
	}
	@Then("the Pets category page should display pet-related gift items")
	public void the_pets_category_page_should_display_pet_related_gift_items() {
		
		boolean status = userpage.DisplayPetPage();
		Assert.assertTrue(status);
	    
	}
	
//	@And("the user applies filter {String}")
//	public void the_user_applies_filter_with_value(String string, String string2) throws Exception {
//		
//		ExcelReader excel=new ExcelReader();
//		String var=excel.getCellData(1, 0);
//		boolean status =userpage.clickcheckbox();
//		Assert.assertTrue(status);
//		
//	    
//	}

	@And("the user selects filter option at row {int} from Excel sheet {int}")
	public void the_user_selects_filter_on(String string) throws Exception {
		ExcelReader excel=new ExcelReader();
		String var=excel.getCellData(1,0);
		boolean status =userpage.clickcheckbox();
		Assert.assertTrue(status);
	    
	}

	@And("the user clicks on {int} from the product list")
	public void the_user_clicks_on_from_the_product_list(String string) throws Exception {
		ExcelReader excel=new ExcelReader();
		String var=excel.getCellData(1,1);
		boolean status =userpage.clickOnProduct();
		Assert.assertTrue(status);
	    
	}

	@Then("the product details page should display price, reviews, and availability")
	public void the_product_details_page_should_display_price_reviews_and_availability() {
		boolean status =userpage.DisplayProductPage();
		Assert.assertTrue(status);
		
	    
	}
//	@And("the user applies filter {string} with value {string}")
//	public void the_user_applies_filter_with_value(String string, String string2) {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//	@Then("the page should display products matching the selected filter")
//	public void the_page_should_display_products_matching_the_selected_filter() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}

}
