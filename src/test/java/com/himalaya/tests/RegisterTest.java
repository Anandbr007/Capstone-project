package com.himalaya.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.himalaya.pom.RegisterPOM;

/**
 * Test class for validating registration functionality.
 */
public class RegisterTest extends BaseTest {
	
	/**
	 * Test method for valid registration.
	 * 
	 * @param fname The first name of the user.
	 * @param lname The last name of the user.
	 * @param email1 The email address of the user.
	 * @param pass The password for the account.
	 * @throws InterruptedException If the thread is interrupted.
	 */
	@Test(dataProvider = "register", priority=1)
	public void register(String fname, String lname, String email1, String pass) throws InterruptedException {
		reg=new RegisterPOM(driver);
		reg.createNew(fname, lname, email1, pass);
		assertEquals(driver.getCurrentUrl(), "https://himalayawellness.in/");
	}
	
	/**
	 * Test method for logging out after registration.
	 * 
	 * @throws InterruptedException If the thread is interrupted.
	 */
	@Test(priority=2)
	public void logout() throws InterruptedException {
		reg=new RegisterPOM(driver);
		reg.logout();
	}
	
	/**
	 * Test method for invalid registration with existing email.
	 * 
	 * @param fname The first name of the user.
	 * @param lname The last name of the user.
	 * @param email1 The email address of the user.
	 * @param pass The password for the account.
	 * @throws InterruptedException If the thread is interrupted.
	 */
	@Test(dataProvider = "register", priority=3)
	public void invalidregister(String fname, String lname, String email1, String pass) throws InterruptedException {
		reg=new RegisterPOM(driver);
		reg.newInvalid(fname, lname, email1, pass);
		assertTrue(reg.invalid.getText().contains("This email address is already associated with an account."));
	}

	
}

