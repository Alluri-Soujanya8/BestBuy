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
	public static Properties prop;

	public static void launchBrowser() {
		prop = PropertyReader.readProperty();
		String browser = prop.getProperty("browserName");//chrome will come


		if (browser.equalsIgnoreCase("chrome")) {

			//System.setProperty("webdriver.chrome.driver", "C:\\training modules\\JavaSelenium\\BestBuy\\Drivers\\chromedriver.exe");//chrome will launch
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) { //firefox launch
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) { //edge launch 
			System.setProperty("webdriver.edge.driver", "C:\\training modules\\JavaSelenium\\BestBuy\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			System.out.println("Invalid browser specified in config.properties");
			return;
		}
		String url = prop.getProperty("sourceUrl");
		driver.get(url);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // Add this
		WebElement usButton = new WebDriverWait(driver, Duration.ofSeconds(15))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//h4[text()='United States']")));
		usButton.click();


	}


	public static void sleep(int msec) { // handling waits
		try {
			Thread.sleep(msec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public static void navigateToUrl(String key) {

		String url = prop.getProperty(key);
		if (url == null || url.isEmpty()) {
			throw new RuntimeException("URL for key '" + key + "' is missing in config.properties");
		}
		driver.get(url);


	}
}
