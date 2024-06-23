package com.himalaya.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Test class for validating search functionality.
 */
public class SearchTest extends BaseTest {
		
			
	/**
	 * Test method to verify search with invalid input.
	 */
	@Test(priority = 1)
	public void testInvalidSearch() {
		home.enterSearchInput("shirt");
//		System.out.println(home.getTitle());
		assertEquals(home.getTitle(), "Search: 0 results found for \"shirt\" – Himalaya Wellness (India)");
	}
	
	/**
	 * Test method to verify search result with invalid input.
	 */
	@Test(dependsOnMethods="testInvalidSearch",priority = 2)
	public void testInvalidSearch1() {
		assertTrue(searchResult.searchResult1());
	}
	
	/**
	 * Test method to verify search with null input.
	 */
	@Test(priority = 3)
	public void testNullSearch() {
		home.enterSearchInput("");
//		System.out.println(home.getTitle());
		assertEquals(home.getTitle(), "Search – Himalaya Wellness (India)");
	}
	
	/**
	 * Test method to verify search result with null input.
	 */
	@Test(dependsOnMethods="testNullSearch",priority = 4)
	public void testNullSearch1() {
		assertTrue(searchResult.searchResult1());
	}
	
	/**
	 * Test method to verify search with valid input.
	 */
	@Test(priority = 5)
	public void testValidSearch() {
		home.enterSearchInput("sunscreen");
//		System.out.println(home.getTitle());
		assertTrue(home.getTitle().contains("sunscreen"));
	}
	
	/**
	 * Test method to verify search result with valid input.
	 */
	@Test(dependsOnMethods="testValidSearch",priority = 6)
	public void testValidSearch1() {
		assertTrue(searchResult.searchResult1());
	}
}