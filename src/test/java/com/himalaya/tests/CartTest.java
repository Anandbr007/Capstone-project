package com.himalaya.tests;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import java.util.ArrayList;
import org.testng.annotations.Test;
import com.himalaya.pom.CartPOM;

/**
 * Test class for validating Cart functionality.
 */
public class CartTest extends BaseTest {
	
	CartPOM cart;
	ArrayList<String> al;
	String link="Information - Himalaya Wellness (India) - Checkout";

	/**
	 * Test method to check the title of the page.
	 */
	@Test(priority = 1)
    public void checkTitle() {
		cart=new CartPOM(driver);
		assertEquals(home.getCurrentUrl(), "https://himalayawellness.in/");
	}
	
	/**
	 * Test method to check if the cart is empty.
	 */
	@Test(priority = 2,dependsOnMethods = "checkTitle")
    public void emptyCart() {
		cart=new CartPOM(driver);
		assertEquals(cart.CartClick(), "Your cart is currently empty.");
	}
	
	/**
	 * Test method to add a product to the cart.
	 */
	@Test(priority = 3,dependsOnMethods = "emptyCart")
    public void ProductAdd() {
        cart=new CartPOM(driver);
        assertEquals(cart.ProductAdd(), "2");
		assertEquals(home.getCurrentUrl(), "https://himalayawellness.in/");	
	}
	
	/**
	 * Test method to check the items in the cart.
	 */
	@Test(priority = 4,dependsOnMethods = "ProductAdd")
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
	@Test(priority = 5,dependsOnMethods = "checkcart")
    public void checkSubmit()  {
        cart=new CartPOM(driver);
		assertTrue(cart.checkCheckoutbtn());
	}
	
	/**
	 * Test method to remove a product from cart.
	 */
	@Test(priority = 6,dependsOnMethods = "checkSubmit")
    public void removeProduct() throws InterruptedException {
        cart=new CartPOM(driver);
        cart.ProductRemove();
		assertFalse(cart.checkitem().contains(al.get(0)));
	}
	
	
}
