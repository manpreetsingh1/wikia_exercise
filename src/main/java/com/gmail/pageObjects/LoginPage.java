package com.gmail.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import utils.TestUtility;

public class LoginPage extends LoadableComponent<LoginPage> {
	
	WebDriver driver;
	TestUtility util = null;
	
	public LoginPage(WebDriver driver){
        this.driver = driver;
        util = new TestUtility(driver);
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage setEmailAddress(String emailAddress) {
		util.getElementAfterWait(By.id("Email")).sendKeys(emailAddress);
		return new LoginPage(driver);
	}
	
	public LoginPage setEmailPassword(String password) {
		util.getElementAfterWait(By.id("Passwd")).sendKeys(password);
		return new LoginPage(driver);
	}
	
	public InboxPage clickSignIn(){
		util.getElementAfterWait(By.id("signIn")).click();;
		return new InboxPage(driver);
	}
	
	
	@Override
	protected void isLoaded() throws Error {
	try {
		driver.findElement(By.id("Email"));
	} catch(Exception e) {
		throw new Error(e.getMessage());
	}
}

	@Override
	protected void load() {
		driver.get(TestUtility.getValue("URL.LOGINPAGE"));
		util.getElementAfterWait(By.id("Email"));
	}
}


