package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtility {

	private WebDriver driver;
	private long Wait = 5;
	private static Properties PROPERTIES = null;
	private static String propsFileName = "data.properties";
	private static String propsfilePath = "data/";

	public TestUtility() {
	}

	public TestUtility(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElementAfterWait(By pointer) {
		return getElement(pointer, Wait);
	}

	public WebElement getElement(By pointer, long timeout) {
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.ignoring(NoSuchElementException.class);
			element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(pointer));
		} catch (TimeoutException e) {
			// no action
		}
		return element;
	}

	public static String getValue(String key) {

		if (PROPERTIES == null) {
			try {
				PROPERTIES = readProp();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return PROPERTIES.getProperty(key);
	}

	public static Properties readProp() throws FileNotFoundException,
			IOException {
		File file = new File(propsfilePath + propsFileName);
		Properties prop = new Properties();
		prop.load(new FileInputStream(file));
		return prop;
	}
}