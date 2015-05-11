package com.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import utils.DriverClass;
import utils.TestUtility;

public class TestBase {

	public WebDriver driver;

	@BeforeClass
	public void BeforeClass() {
		if (TestUtility.getValue("test_browser") == null) {
			this.driver = DriverClass.getDefaultDriver();
		} else {
			this.driver = DriverClass.getDriver(TestUtility
					.getValue("test_browser"));
		}
	}

	@AfterClass
	public void AfterClass() {
		doLogout();
	}

	private void doLogout() {
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}
