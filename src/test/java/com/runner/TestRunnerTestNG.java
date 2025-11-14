package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = ".\\src\\test\\resources\\com\\Features\\TV&HomeTheatre.feature",glue = "com.stepdefinition",
	       plugin = {"pretty:Reports/pretty-reports.html", "html:Reports/cucumber-reports.html",
	    		   "html:Reports/HTMLReports.html",
	    		   "json:Reports/json-report.json",
	    		   "junit:Reports/junit_report.xml", 
		},tags= "@Menu"
	    		   )

public class TestRunnerTestNG extends AbstractTestNGCucumberTests{

}
