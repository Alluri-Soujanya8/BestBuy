package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = ".\\src\\test\\resources\\com\\features\\Homepage.feature",glue = "com.stepDefinitionTestNG",
	       plugin = {"pretty", "html:reports/cucumber-reports.html",
	    		   "json:reports/json-report.json",
	    		   "junit:reports/junit_report.xml"
	    		   
		},tags="@Filters"
		)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests{

}
