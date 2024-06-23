package com.himalaya.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Test class for validating Store Locator functionality.
 */
public class StoreLocatorTest extends BaseTest {
	
	
	/**
	 * Test method to verify Store Locator page functionality.
	 */
	@Test(priority = 1)
	public void testStoreLocatorPage() {
		home.clickStoreLocator();
		home.switchHandle();
		assertEquals(home.getCurrentUrl(), "https://storelocator.himalayawellness.in/");
	}
	
	/**
	 * Test method to verify filter location functionality.
	 */
	@Test(dependsOnMethods="testStoreLocatorPage",priority = 2)
	public void testFilterLocation() {
		store.selectState();
		store.selectCity();
		for(String s:store.validateStoreInTvm()) {
			System.out.println(s);
			assertTrue(s.contains("Trivandrum"));
		}
	}

}





