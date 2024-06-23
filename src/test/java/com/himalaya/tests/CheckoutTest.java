package com.himalaya.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.himalaya.pom.CartPOM;

/**
 * Test class for validating Checkout functionality.
 */
public class CheckoutTest extends BaseTest{

	CartPOM cart;
	ArrayList<String> al;
	String link="Information - Himalaya Wellness (India) - Checkout";
	
	/**
	 * Test method to add a product to the cart.
	 */
	@Test(priority=1)
	public void ProductAdd()  {
        cart=new CartPOM(driver);
        assertEquals(cart.ProductAdd(), "2");
		assertEquals(home.getCurrentUrl(), "https://himalayawellness.in/");	
	}
	
	/**
	 * Test method to check the items in the cart.
	 */
	@Test(priority = 2,dependsOnMethods = "ProductAdd")
	public void checkcart() {
		cart=new CartPOM(driver);
		al=new ArrayList<String>();
		al.addAll(cart.checkCart());
		assertEquals(al.get(0), al.get(3));
	    assertEquals(al.get(1), al.get(2));
	    assertEquals(al.get(4), "CHECK OUT");
	    assertEquals(al.get(5), "Cart");
	}
	
	/**
	 * Test method to check if the checkout button is displayed.
	 */
	@Test(priority = 3,dependsOnMethods = "checkcart")
    public void checkSubmit() {
        cart=new CartPOM(driver);
		assertTrue(cart.checkCheckoutbtn());
	}
	
	/**
	 * Test method to click the checkout button and verify the title of the checkout page.
	 */
	@Test(priority = 4,dependsOnMethods = "checkSubmit")
    public void clickSubmitbtn() throws InterruptedException{
        cart=new CartPOM(driver);
        cart.clickCheckoutbtn();
        assertEquals(home.getTitle(), link);  
	}
	
	/**
	 * Test method to validate error message when submitting without entering email.
	 */
	@Test(priority = 5,dependsOnMethods = "clickSubmitbtn")
	public void nullClickSubmitbtn(){
		checkout.submitbtn();
		String string=checkout.Errormsg();
		assertEquals(string, "Enter a valid email");
	}
	
	/**
	 * Test method to enter valid data for checkout.
	 */
	@Test(priority = 6,dataProvider = "address",dependsOnMethods = "nullClickSubmitbtn")
	public void validDatatest(String... data) throws InterruptedException {
		assertEquals(home.getTitle(), "Error - Information - Himalaya Wellness (India) - Checkout");
		checkout.senddata(data[0], data[1], data[2], data[3], data[4], data[5]);
	}
	
	/**
	 * Test method to verify if the submit button is displayed after entering valid data.
	 */
	@Test(priority = 7,dependsOnMethods = "validDatatest")
	public void submitbtn() {
		assertTrue(checkout.submitdisplayed());
	}
}
