package com.Setup;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Parameters.PropertyReader;

public class BaseSteps {
	
	public static WebDriver driver;
	 
    public static void launchBrowser() 
    {
        Properties prop = PropertyReader.readProperty();	//prop---object
        String browser = prop.getProperty("browserName");	//Chrome will come, browserName----Key value(acts as variable)  
        
        if (browser.equalsIgnoreCase(browser)) 		//Chrome will launch
        {
            System.setProperty("webdriver.chrome.driver", "C:\\Training\\Java\\Selenium Grid\\chromedriver.exe");
            driver = new ChromeDriver();
        } 
        else if (browser.equalsIgnoreCase("firefox")) 	//firefox will launch
        {
            driver = new FirefoxDriver();
        } 
        else if (browser.equalsIgnoreCase("edge")) 		//edge will launch
        {
            driver = new EdgeDriver();
        } 
        else 
        {
            System.out.println("Invalid browser specified in config.properties");
            return;
        }
        String url=prop.getProperty("sourceUrl");
        driver.get(url);        
        driver.manage().window().maximize(); 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Add this
        WebElement unitedStates = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[text()='United States']")));
		unitedStates.click();
    }
   
    public static void sleep(int msec) 		//Handling waits
    {
        try 
        {
            Thread.sleep(msec);
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
    }
    
}

