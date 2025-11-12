package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
			features = ".\\src\\test\\resources\\com\\Features\\TV&HomeTheatre.feature",
			glue = {"com.stepdefinition"},
			       
		    plugin = {"pretty", "html:junitreportsjunit/cucumber-reports.html",
		    		   "json:junitreportsjunit/json-report.json",
		    		   "junit:junitreportsjunit/junit_report.xml"},tags = "@Menu"
		    		   )
public class TestRunnerJunit {
	

}
