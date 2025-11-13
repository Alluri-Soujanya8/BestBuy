package com.stepDefinitionTestNG;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pages.UserPage;
import com.parameters.ExcelReader;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Profile {
	Properties prop = PropertyReader.readProperty();
	WebDriver driver = BaseSteps.driver;
	ExtentTest test = Hooks.test;
	UserPage userpage;

	@Given("the user is on the BestBuy Home Page")
	public void the_user_is_on_the_best_buy_home_page() {
		userpage = new UserPage(driver, test);
		Assert.assertTrue(userpage.verifyHomepage(), "Home Page is not displayed");
	}
	
	@Then("the Gift Ideas page with various categories should be displayed")
	public void the_gift_ideas_page_with_various_categories_should_be_displayed() {
		boolean status = userpage.displayGiftIdeasPage();
		Assert.assertTrue(status);

	}
	@When("the user clicks on the moduleName link")
	public void the_user_clicks_on_the_link() {
		String moduleName = prop.getProperty("moduleName");
		boolean status = userpage.clickGiftIdeas();
		Assert.assertTrue(status);

	}

	@And("the user clicks on the categoryname category")
	public void the_user_clicks_on_the_category() {
		String petcategory = prop.getProperty("categoryname");
		boolean status = userpage.clickPetsPage();
		Assert.assertTrue(status);

	}
	@And("click on buttonName category")
	public void click_on_category() {
		String Petbutton = prop.getProperty("buttonName");
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

	//	@And("the user selects filter option at row {int} from Excel sheet {int}")
	//	public void the_user_selects_filter_on(int row,int col) throws Exception {
	//		ExcelReader excel=new ExcelReader();
	//		String var=excel.getCellData(1,0);
	//		boolean status =userpage.clickcheckbox();
	//		Assert.assertTrue(status);
	//	    
	//	}
	//------------------inp------------------------------//
	//	@And("click on filter {int}")
	//	public void click_on_filter(Integer rowIndex) throws Exception {
	//		ExcelReader excel=new ExcelReader();
	//		String var=excel.getCellData(rowIndex,0);
	//		boolean status =userpage.clickcheckbox();
	//		Assert.assertTrue(status);
	//
	//	}

	//	@And("click on filter {int} {int}")
	//	public void click_on_filter(Integer rowIndex,Integer sheetNo) throws Exception {
	//		String path=prop.getProperty("path");
	//		ExcelReader excel=new ExcelReader(path);
	//		List<String> var=excel.getRowData(sheetNo,rowIndex);
	//		boolean status =userpage.clickcheckbox();
	//		Assert.assertTrue(status);
	//
	//	}
	@And("click on filters {int} {int}")
	public void click_on_filters(Integer rowIndex,Integer sheetNo) throws Exception {
		String path=prop.getProperty("path");
		ExcelReader excel=new ExcelReader(path);
		//String selectedLocality = ExcelReader.getColumnData(path, sheetNo, rowIndex);
		List<String> var = excel.getColumnData(sheetNo, rowIndex);
		Assert.assertNotNull(var, "Locality not found at sheet " + sheetNo + ", row " + rowIndex);
//		boolean status =userpage.clickMultipleCheckbox();

		boolean status = false;

		// Decide action based on rowIndex
		if (rowIndex == 1) {
			// First brand (Petkit)
			status = userpage.clickcheckbox(); // Method for Petkit
		} else if (rowIndex == 2) {
			// Second brand (Petkit again or another)
			status = userpage.clickSecondCheckbox(); // Method for second brand
		} else if (rowIndex == 3) {
			// Price range
			status = userpage.clickThirdCheckbox(); // Method for price range
		} else {
			throw new IllegalArgumentException("Unsupported row index: " + rowIndex);
		}

		Assert.assertTrue(status);
	}


	
	@And("the user clicks the product list")
	public void click_on_products_list() {
		
		boolean status =userpage.clickOnProduct();
		Assert.assertTrue(status);


	}
	@Then("the product details page should display price, reviews, and availability")
	public void display_products_details_page() {
		boolean status =userpage.DisplayProductPage();
		Assert.assertTrue(status);
	}
	
	@And("I select the petfilter checkbox filter")
	public void i_select_the_petfilter_checkbox_filter() 
	{
		String path=prop.getProperty("petfilter");
	    userpage.clickcheckbox();
	}
	@And("I click on the first product under petfilter")
	public void i_click_on_the_first_product_under_petkit_filter() {
		userpage.clickOnProduct();
	    
	}
	@And("I click on addcart button")
	public void i_click_on_cart_button()  {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String path=prop.getProperty("addcart");
		userpage.clickAddToCart();
		//Thread.sleep(1000);
	    
	}
	

	@And("click on checkout button")
	public void click_on_checkout_button() {
		String path=prop.getProperty("checkout");
		userpage.clickCheckout();
	    
	    
	}

	@Then("verify if the user is on signin page")
	public void verify_if_the_user_is_on_cart_page() {
		userpage.VerifySigninPage();
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
