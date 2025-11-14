package com.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
			dryRun=false,
					features = ".\\src\\test\\resources\\com\\features\\GiftCards_Homepage.feature",glue = "com.stepDefinitionTestNG",
				       plugin = {"pretty", "html:Reports/cucumber-reports.html",
				    		   "json:reports/join-report.json",
				    		   "junit:reports/junit-report.xml"
			}
			
			)

	public class TestRunnerParallel extends AbstractTestNGCucumberTests
	{
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
	
	}

