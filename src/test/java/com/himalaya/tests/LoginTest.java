package com.himalaya.tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import com.himalaya.pom.LoginPOM;

/**
 * Test class for validating login functionality.
 */
public class LoginTest extends BaseTest {
	
	/**
	 * Test method for valid login credentials.
	 * 
	 * @param username The username to login.
	 * @param password The password associated with the username.
	 * @throws InterruptedException If the thread is interrupted.
	 */
	@Test(dataProvider = "validData")
    public void validLogintest(String username, String password)  {
		login.login(username,password);
		assertEquals(driver.getCurrentUrl(),"https://himalayawellness.in/account");
	}
	
	/**
	 * Test method for invalid login credentials.
	 * 
	 * @param username The username to login.
	 * @param password The password associated with the username.
	 */
	@Test(dataProvider = "invalidData")
	public void invalidLogintest(String username, String password) {
		login=new LoginPOM(driver);
		login.login(username,password);
		System.out.println(driver.getTitle());
		assertEquals(login.titleTextValidate(),"Login");
	}
}
