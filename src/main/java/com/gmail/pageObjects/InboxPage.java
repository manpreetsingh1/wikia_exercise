package com.gmail.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import utils.TestUtility;

public class InboxPage extends LoadableComponent<InboxPage>{
		
		WebDriver driver = null;
		TestUtility utils = null;
		
		public InboxPage(WebDriver driver){
			this.driver = driver;
			utils = new TestUtility(driver);
			PageFactory.initElements(driver, this);
		}
		
		@Override
		protected void isLoaded() throws Error {
			Assert.assertTrue(driver.getCurrentUrl().contains("https://mail.google.com/mail/#inbox"));
		}

		@Override
		protected void load() {
			driver.get(TestUtility.getValue("URL.INBOXPAGE"));
			Assert.assertTrue(driver.getCurrentUrl().contains("https://mail.google.com/mail/#inbox"));
		}
		
	}

