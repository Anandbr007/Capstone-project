package com.himalaya.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


/**
 * Test class for About Us functionality.
 */
public class AboutUsTest extends BaseTest {
	
	
	/**
	 * Test method to verify Corporate Profile page.
	 */
	@Test(priority=1)
	public void testCooperateProfile() {
		home.clickAboutUs();
		home.selectCooperateProfile();
		assertEquals(home.getCurrentUrl(), "https://himalayawellness.in/pages/our-story");
	}
	
	/**
	 * Test method to verify Leadership page.
	 */
	@Test(priority=2)
	public void testLeadership() {
		home.clickAboutUs();
		home.selectLeadership();
		assertTrue(home.validatePageHeading().contains("Leadership"));
	}
	
	/**
	 * Test method to verify Media page.
	 */
	@Test(priority=3)
	public void testMedia() {
		home.clickAboutUs();
		home.selectMedia();
		assertEquals(home.getCurrentUrl(), "https://himalayawellness.in/pages/podcast-season1");
	}
	
	/**
	 * Test method to verify Careers page.
	 */
	@Test(priority=4)
	public void testCareers() {
		home.clickAboutUs();
		home.selectCareers();
		assertEquals(home.validatePageHeading(),"Careers");
	}
	
	/**
	 * Test method to verify Partners page.
	 */
	@Test(priority=5)
	public void testPartners() {
		home.clickAboutUs();
		home.selectPartners();
		assertEquals(home.getCurrentUrl(), "https://himalayawellness.in/pages/himalaya-drug-company-private-limited");
	}
	
}