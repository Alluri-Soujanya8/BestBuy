package com.setup;

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

import com.parameters.PropertyReader;

public class BaseSteps {

	public static WebDriver driver;
	
	public static void launchBrowser() {
        Properties prop = PropertyReader.readProperty();
        String browser = prop.getProperty("browserName"); //chrome will open
        
 
        if (browser.equalsIgnoreCase(browser)) {
            
            System.setProperty("webdriver.chrome.driver", "C:\\Training\\SeleniumGrid\\chromedriver.exe");
            driver = new ChromeDriver();
        } 
        else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } 
        else if (browser.equalsIgnoreCase("edge"))
        {
         	//System.setProperty("webdriver.edge.driver", "C:\\Training\\SeleniumGrid\\msedgedriver.exe");
            driver = new EdgeDriver();
        } 
        else {
            System.out.println("Invalid browser specified in config.properties");
            return;
        }
        String url = prop.getProperty("sourceUrl");
        driver.get(url);

         String faqUrl = prop.getProperty("FaqUrl");
         driver.get(faqUrl);

        //maximizw the screen
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Add this
        WebElement usButton = new WebDriverWait(driver, Duration.ofSeconds(10))
		    .until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[text()='United States']")));
		usButton.click();
       
    }
 
    public static void sleep(int msec) { //hardcoded implementation, handling waits
        try 
        {
            Thread.sleep(msec);
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

