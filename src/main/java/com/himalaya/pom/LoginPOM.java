package com.himalaya.pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

import com.himalaya.base.ReusableFunctions;

/**
 * This class represents the Page Object Model (POM) for the login page.
 * It contains methods to interact with elements on the login page.
 */
public class LoginPOM {

	WebDriver driver;
	ReusableFunctions rf;
	
	// Locators for elements on the login page
	By loginicon = By.xpath("//a[@class=\"site-nav__link site-nav__link--icon small--hide\"]");
	By uname = By.xpath("//input[@class='input-full'][@id='CustomerEmail']");
	By pass = By.xpath("//input[@class='input-full'][@id='CustomerPassword']");
	By submitbtn = By.xpath("//button[@class='btn btn--full']");
	By titleText = By.xpath("//h1[@class='section-header__title']");
	
	/**
	 * Constructor for LoginPOM class.
	 * @param driver The WebDriver instance to be used.
	 */
	public LoginPOM(WebDriver driver) {
		this.driver = driver;
		rf = new ReusableFunctions(driver);
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Method to perform login action.
	 * @param username The username to be entered.
	 * @param password The password to be entered.
	 */
	public void login(String username, String password) {
        ReusableFunctions.clickOn(loginicon, Duration.ofSeconds(10));
        try {
			ReusableFunctions.delay(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        ReusableFunctions.sendText(uname, username);
        try {
			ReusableFunctions.delay(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        ReusableFunctions.sendText(pass, password);
        try {
			ReusableFunctions.delay(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        ReusableFunctions.clickOn(submitbtn, Duration.ofSeconds(10));
        try {
			ReusableFunctions.delay(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
	
	/**
	 * Method to validate the title text on the login page.
	 * @return The title text displayed on the login page.
	 */
	public String titleTextValidate() {
		return ReusableFunctions.getText(titleText);
	}

}