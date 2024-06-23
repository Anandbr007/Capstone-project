package com.himalaya.tests;
import java.util.List;
import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * Test class for product functionality.
 */
public class ProductTest extends BaseTest {
	
	/**
	 * Test method for category filter.
	 */
	@Test(priority = 1)
	public void testCategoryFilter() {
		home.enterSearchInput("soap");
		product.selectCategory();
		List<String> soaplist=product.soapList();
		for(String s:soaplist) {
			Assert.assertTrue(s.contains("baby soap") || s.contains("baby bar"));
		}
	}
	
	/**
	 * Test method for price filter.
	 */
	@Test(priority = 2)
	public void testPriceFilter() {
		product.selectPriceRange();
		Assert.assertEquals(home.getTitle(), "₹100-₹150 / soap - Himalaya Wellness (India)");
		
	}
	
	/**
	 * Test method to verify the product type.
	 */
	@Test(priority = 3)
	public void testProducttype(){
		List<String> before=product.productType();
		List<String> after=product.sort();
		
		Assert.assertEquals(before, after);
	}
	
	/**
	 * Test method to select a soap product and validate its price.
	 */
	@Test(priority = 4)
	public void testProduct(){
		product.selectSoap();
		Assert.assertTrue(product.validateSoapPrice());
	}
}