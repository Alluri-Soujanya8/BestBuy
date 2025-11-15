package com.setup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class DriverManager {
	    private static WebDriver driver;

	    public static WebDriver getDriver() {
	        if (driver == null) {
	            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	            driver = new ChromeDriver();
	            driver.manage().window().maximize();
	        }
	        return driver;
	    }

//	    public static void quitDriver() {
//	        if (driver != {
//	            driver.quit();
//	            driver = null;
//	        }
//	    }
	}


