package com.himalaya.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test class for Our Research functionality.
 */
public class OurResearchTest extends BaseTest {
		
	/**
	 * Test method to verify Ayurveda page.
	 */
	@Test(priority = 1)
	public void testAyurveda() {
		home.clickResearch();
		home.selectAyurveda();
		Assert.assertEquals(home.getCurrentUrl(), "https://himalayawellness.in/pages/ayurveda-and-wellness");
		Assert.assertTrue(home.getTitle().contains("Ayurveda and Wellness"));
	}
	
	/**
	 * Test method to verify Our Science page.
	 */
	@Test(priority = 2)
	public void testOurScience() {
		home.clickResearch();
		home.selectOurScience();
		assertEquals(home.getCurrentUrl(), "https://himalayawellness.in/pages/our-science");
		assertTrue(home.getTitle().contains("Our Science"));
	}
	
	/**
	 * Test method to verify Research at the Heart page.
	 */
	@Test(priority = 3)
	public void testResearchheart() {
		home.clickResearch();
		home.selectHeart();
		assertEquals(home.getCurrentUrl(), "https://himalayawellness.in/pages/research-at-the-heart");
		assertTrue(home.getTitle().contains("Research at the Heart"));
	}
	
	/**
	 * Test method to verify Innovation in Health Care page.
	 */
	@Test(priority = 4)
	public void testInnovationhealth() {
		home.clickResearch();
		home.selectInnovationhealth();
		assertEquals(home.getCurrentUrl(), "https://himalayawellness.in/pages/innovation-in-health-care");
		assertTrue(home.getTitle().contains("Innovation in Health Care"));
	}
	
	/**
	 * Test method to verify Innovation in Personal Care page.
	 */
	@Test(priority = 5)
	public void testInnovationpersonal() {
		home.clickResearch();
		home.selectInnovationpersonal();
		Assert.assertEquals(home.getCurrentUrl(), "https://himalayawellness.in/pages/innovation-in-personal-care");
		Assert.assertTrue(home.getTitle().contains("Innovation in Personal Care"));
	}
}