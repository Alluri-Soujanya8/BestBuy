package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = ".\\src\\test\\resources\\com\\features\\GiftCards_Homepage.feature",
		glue = "com.stepDefinitionTestNG",
	    plugin = {"pretty", "html:reports/cucumber-reports.html",
	    		   "json:reports/join-report.json",
	    		   "junit:reports/junit-report.xml"}
	    
		)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests{

}
