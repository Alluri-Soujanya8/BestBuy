package com.setup;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.parameters.PropertyReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSteps {

	public static WebDriver driver;

	public static void launchBrowser() 
	{
		Properties prop = PropertyReader.readProperty();
		String browser = prop.getProperty("browserName");   

		if (browser.equalsIgnoreCase("chrome"))             
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications"); // Disable notifications
	        options.addArguments("--disable-geolocation");   // Disable location prompts
	        options.addArguments("--start-maximized");
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			

		} 
		else if (browser.equalsIgnoreCase("firefox"))       
		{
			driver = new FirefoxDriver();
		} 
		else if (browser.equalsIgnoreCase("edge"))           
		{
			driver = new EdgeDriver();
		} 
		else 
		{
			System.out.println("Invalid browser specified in config.properties");
			return;
		}
		String url = prop.getProperty("sourceUrl");
		driver.get(url);
		
//		String url2 = prop.getProperty("homePage");
		
//		driver.get(url2);
//
//		String url3 = prop.getProperty("tvPage");
//		driver.get(url3);

		driver.manage().window().maximize();


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); // Add this
		WebElement usButton = new WebDriverWait(driver, Duration.ofSeconds(15))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[text()='United States']")));
		usButton.click();
		
		try {
        	// Switch to alert and dismiss (Block notifications)
        	Alert alert = driver.switchTo().alert();
        	alert.dismiss(); // or alert.accept() if you want to allow
        	
        } catch (NoAlertPresentException e) {
//        	System.out.println("No notification popup appeared");
        }
	}

	public static void sleep(int msec)                     // Handling waits
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



