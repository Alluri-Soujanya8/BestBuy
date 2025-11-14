package com.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".\\src\\test\\resources\\com\\Features\\TopDeals.feature",
		glue = "com.StepDefinitionjUnit",
		plugin = {"pretty", "html:reports/cucumber-reports.html",
		"json:reports/join-report.json",
		"junit:reports/junit-report.xml"}
		)

public class TestRunnerjUnit {
    
}
