package com.stepDefinitionTestNG;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.pages.UserPage;
import com.pages.UserPage2;
import com.setup.BaseSteps;
 
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

import java.time.Duration;

import org.junit.platform.suite.api.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;




public class Hooks extends BaseSteps {
	
	public static ExtentSparkReporter spark;                     // classes of extent reports what should be color of report& gui
    public static ExtentReports extReports;                      // what to track on report (tester name , date etc..,)
    public static ExtentTest test;                               // It will track the test cases

    
    @BeforeAll                                                   // it will run the code before feature file starts
    public static void beforeAll()
    {
        
        spark = new ExtentSparkReporter(".\\target\\ExtentReport.html");   //for extent report
        extReports = new ExtentReports();
        extReports.attachReporter(spark);
    }
 
    @AfterAll                                                     // after feature file ends this will run
    public static void afterAll()
    {
        
        extReports.flush();                                       // to generate extent report like commit method
    }
 

@Before
public void beforeScenario(Scenario scenario) {
    test = extReports.createTest(scenario.getName());
    launchBrowser();
}


@BeforeSuite
public void initializeDriver() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
      
 
    @After                                                         // after every scenario
    public void afterScenario(Scenario scenario)
    {
        
        BaseSteps.sleep(4000);
        driver.quit();

//    	  if (driver != null) {
//    	        driver.quit();
//    	    }

    }
 
 
}