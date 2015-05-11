package com.gmail.inbox;

import org.testng.annotations.Test;
import utils.TestUtility;
import com.base.TestBase;
import com.gmail.pageObjects.InboxPage;
import com.gmail.pageObjects.LoginPage;

public class TestInboxLogin extends TestBase {
	
	public String username;
	public String password;

	@Test()
	public void LoginTest(){
		
		LoginPage loginPage = new LoginPage(driver).get();
		
		this.username = TestUtility.getValue("USERNAME");
		this.password = TestUtility.getValue("PASSWORD");
		
		loginPage.setEmailAddress(username);
		loginPage.setEmailPassword(password);
		loginPage.clickSignIn();
		
		InboxPage inboxPage = new InboxPage(driver).get();
	}
}
