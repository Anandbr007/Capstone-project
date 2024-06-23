package com.himalaya.pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.himalaya.base.ReusableFunctions;

/**
 * This class represents the Page Object Model (POM) for the search results page.
 * It contains methods to check the presence of different types of search results.
 */
public class SearchResultsPOM {
	
	WebDriver driver;
	
	// Locators for elements on the search results page
	By searchResultText1 = By.xpath("(//div/nav[@class='breadcrumb']/span)[2]");
	
	/**
     * Constructor for SearchResultsPOM class.
     * @param driver The WebDriver instance to be used.
     */
	public SearchResultsPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Method to check the presence of search result type 1.
	 * @return True if search result type 1 is present, false otherwise.
	 */
	public boolean searchResult1() {
		return ReusableFunctions.isElementPresent(searchResultText1, Duration.ofSeconds(10));
	}
	
	
}