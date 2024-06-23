package com.himalaya.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Test class for validating Himalaya Global functionality.
 */
public class HimalayaGlobalTest extends BaseTest {
	
	
	/**
	 * Test method to verify Himalaya Global Holdings page.
	 */
	@Test(priority = 1)
	public void testHimalayaGlobal() {
		home.clickHimalayaGlobalHoldings();
		assertEquals(home.getCurrentUrl(), "https://himalayaglobalholdings.com/");
	}
	
	/**
	 * Test method to verify links on the page.
	 */
	@Test(priority = 2,dependsOnMethods="testHimalayaGlobal")
	public void testLinks() {
		List<String> titles=global.clickLinks();
		List<String> names=global.linksText();
		for(int i=0;i<titles.size();i++) {
			assertTrue(titles.get(i).contains(names.get(i)));
		}
	}

}
