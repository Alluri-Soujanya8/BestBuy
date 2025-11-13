//package com.StepDefinitionjUnit;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//
//import com.Pages.UserPage;
//import com.Setup.BaseSteps;
//import com.aventstack.extentreports.ExtentTest;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class Profile extends BaseSteps{
//	
//	WebDriver driver=BaseSteps.driver;
//	ExtentTest test=Hooks.test;
//	
//	UserPage userpage;
//	
//	@Given("Top Deals functionality should be availble")
//	public void top_deals_functionality_should_be_availble() {
//		userpage=new UserPage(driver, test);
//		boolean status=userpage.verifyTopDeals();
//		Assert.assertTrue(status);
//	}
//
//	@When("i click on Top Deals link")
//	public void i_click_on_top_deals_link() {
//		boolean status =userpage.click_Top_Deals();
//		Assert.assertTrue(status);
//	}
//
//	@Then("should display Top Deals page")
//	public void should_display_top_deals_page() {
//		boolean status =userpage.Top_Deals_Page();
//		Assert.assertTrue(status);
//	}
//
//}
