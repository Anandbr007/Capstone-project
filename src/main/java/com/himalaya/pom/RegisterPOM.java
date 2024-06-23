package com.himalaya.pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.himalaya.base.ReusableFunctions;

/**
 * This class represents the Page Object Model (POM) for the registration page.
 * It contains methods to interact with elements on the registration page.
 */
public class RegisterPOM {
	
	WebDriver driver;
	ReusableFunctions functions;
	
	/**
     * Constructor for RegisterPOM class.
     * @param driver The WebDriver instance to be used.
     */
	public RegisterPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Locators for elements on the registration page
	By icon = By.xpath("//a[@class='site-nav__link site-nav__link--icon small--hide']");
	By createaccount = By.xpath("//a[@id='customer_register_link']");
	By firstname = By.xpath("//input[@id='FirstName']");
	By lastname = By.xpath("//input[@id='LastName']");
	By email = By.xpath("//input[@id='Email']");
	By password = By.xpath("//input[@id='CreatePassword']");
	By create = By.xpath("//input[@id='register-submit']");
	
	@FindBy(xpath="(//*[@id='create_customer']/div/ul/li)[2]")
	public WebElement invalid;
	
	By logout = By.xpath("//a[@class='btn btn--secondary btn--small section-header__link']");

	/**
	 * Method to create a new account.
	 * @param fname The first name of the user.
	 * @param lname The last name of the user.
	 * @param email1 The email address of the user.
	 * @param pass The password for the new account.
	 * @throws InterruptedException
	 */
	public void createNew(String fname,String lname,String email1,String pass) throws InterruptedException {
		ReusableFunctions.clickOn(icon, Duration.ofSeconds(10));
		ReusableFunctions.delay(1);
		ReusableFunctions.clickOn(createaccount, Duration.ofSeconds(10));
		ReusableFunctions.delay(1);
		ReusableFunctions.sendText(firstname, fname);
		ReusableFunctions.delay(1);
		ReusableFunctions.sendText(lastname, lname);
		ReusableFunctions.delay(1);
		ReusableFunctions.sendText(email, email1);
		ReusableFunctions.delay(1);
		ReusableFunctions.sendText(password, pass);
		ReusableFunctions.delay(1);
		ReusableFunctions.clickOn(create , Duration.ofSeconds(10));
		ReusableFunctions.delay(4);	
	}
	
	/**
	 * Method to create a new account with invalid details.
	 * @param fname The first name of the user.
	 * @param lname The last name of the user.
	 * @param email1 The email address of the user.
	 * @param pass The password for the new account.
	 * @throws InterruptedException
	 */
	public void newInvalid(String fname,String lname,String email1,String pass) throws InterruptedException {
		ReusableFunctions.clickOn(icon, Duration.ofSeconds(10));
		ReusableFunctions.delay(1);
		ReusableFunctions.clickOn(logout, Duration.ofSeconds(10));
		ReusableFunctions.clickOn(icon, Duration.ofSeconds(10));
		ReusableFunctions.clickOn(createaccount, Duration.ofSeconds(10));
		ReusableFunctions.delay(1);
		ReusableFunctions.sendText(firstname, fname);
		ReusableFunctions.delay(1);
		ReusableFunctions.sendText(lastname, lname);
		ReusableFunctions.delay(1);
		ReusableFunctions.sendText(email, email1);
		ReusableFunctions.delay(1);
		ReusableFunctions.sendText(password, pass);
		ReusableFunctions.delay(1);
		ReusableFunctions.clickOn(create , Duration.ofSeconds(10));
		ReusableFunctions.delay(1);		
	}
	
	/**
	 * Method to perform an invalid registration attempt.
	 * @throws InterruptedException
	 */
	public void invalidreg() throws InterruptedException {
		ReusableFunctions.clickOn(icon, Duration.ofSeconds(10));
		ReusableFunctions.delay(1);
		ReusableFunctions.clickOn(createaccount, Duration.ofSeconds(10));
		Thread.sleep(10000);
		ReusableFunctions.clickOn(create , Duration.ofSeconds(10));
		ReusableFunctions.delay(1);
	}
	
	/**
	 * Method to logout from the current account.
	 * @throws InterruptedException
	 */
	public void logout() throws InterruptedException {
		ReusableFunctions.clickOn(icon, Duration.ofSeconds(10));
		ReusableFunctions.delay(1);		
	}
}