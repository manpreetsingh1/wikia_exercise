package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverClass {

	public static WebDriver driver;

	public static WebDriver getDriver(String browser) {

		if (browser.equalsIgnoreCase("firefox")) {
			return new FirefoxDriver();	
		} 
		
		else if (browser.equalsIgnoreCase("chrome")) {
			String driver_path = null;
			driver_path = TestUtility.getValue("webdriver.chrome.driver");
			System.setProperty("webdriver.chrome.driver", driver_path);
			return new ChromeDriver();
		}
		return driver;
	}
	
	public static WebDriver getDefaultDriver() {
		return new FirefoxDriver();
	}
}
