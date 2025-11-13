package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {".\\src\\test\\resources\\com\\feature\\Homepage.feature"},		
		glue = "com.stepDefinitionTestNG",
	    
	       plugin = {"pretty", "html:Reports/cucumber-reports.html",
	    		         "json:reports/json-report.json",
	    		         "junit:reports/junit_report.xml"},
	       tags= "@Cart"
		)
		

public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
}