package com.himalaya.pom;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.himalaya.base.ReusableFunctions;

/**
 * This class represents the Page Object Model (POM) for the cart page.
 * It contains methods to interact with elements on the cart page.
 */
public class CartPOM {
    
    WebDriver driver;
    ReusableFunctions rf;
    
    // Locators for elements on the cart page
    By carticon = By.cssSelector("svg[class='icon icon-cart']");
    By txtmsg = By.xpath("(//div[@class='drawer__scrollable'])[5]");    
    By count = By.cssSelector("span[class='cart-link__bubble cart-link__bubble--visible']");
    By submitbtn = By.cssSelector("button[class='btn cart__checkout']");
    By cart = By.xpath("(//div[@class='h2 drawer__title'])[2]");
    By closebtn = By.xpath("(//button[@class='drawer__close-button js-drawer-close'])[2]");
    By productadd = By.cssSelector("input[id='gridbutton'][data-product='30349345914979']");
    By productadd2 = By.cssSelector("input[id='gridbutton'][data-product='40936632451171']");
    By productname = By.xpath("(//div[@class='grid-product__title grid-product__title--body'])[1]");
    By productname2 = By.xpath("(//div[@class='grid-product__title grid-product__title--body'])[2]");
    By expectedname = By.xpath("(//a[@class='cart__item-name'])[1]");
    By expectedname2 = By.xpath("(//a[@class='cart__item-name'])[2]");
    By removeproduct = By.xpath("(//span[@class='del--item remove_cart__item'])[1]");
    By checkoutbtn = By.cssSelector("button[class='btn cart__checkout bndlr-checkout-button-clicked se-processed']");

    @FindBy(xpath = "//div[@class='cart__item_header_wrap']")
    List<WebElement> product;
    
    
    /**
     * Constructor for CartPOM class.
     * @param driver The WebDriver instance to be used.
     */
    public CartPOM(WebDriver driver) {
        this.driver = driver;
        rf = new ReusableFunctions(driver);
        PageFactory.initElements(driver, this);
    }
    
    /**
     * Method to click on the cart icon and retrieve the text message.
     * @return The text message displayed after clicking on the cart icon.
     */
    public String CartClick() {
        ReusableFunctions.clickOn(carticon, Duration.ofSeconds(10));
        try {
            ReusableFunctions.delay(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String string = ReusableFunctions.getText(txtmsg);
        ReusableFunctions.clickOn(closebtn, Duration.ofSeconds(10));
        return string;
    }
    
    /**
     * Method to add products to the cart and retrieve the count of items.
     * @return The count of items in the cart.
     */
    public String ProductAdd() {
        try {
            ReusableFunctions.delay(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ReusableFunctions.clickOn(productadd, Duration.ofSeconds(10));
        try {
            ReusableFunctions.delay(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ReusableFunctions.clickOn(productadd2, Duration.ofSeconds(10));
        try {
            ReusableFunctions.delay(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ReusableFunctions.getText(count);
    }
    
    
    /**
     * Method to check the contents of the cart.
     * @return An ArrayList containing the product names, expected names, submit button text, and cart text.
     */
    public ArrayList<String> checkCart() {
        ArrayList<String> al = new ArrayList<String>();
        try {
            ReusableFunctions.delay(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        al.add(ReusableFunctions.getText(productname));
        al.add(ReusableFunctions.getText(productname2));
        try {
            ReusableFunctions.delay(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ReusableFunctions.clickOn(carticon, Duration.ofSeconds(10));
        try {
            ReusableFunctions.delay(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        al.add(ReusableFunctions.getText(expectedname));
        al.add(ReusableFunctions.getText(expectedname2));
        al.add(ReusableFunctions.getText(submitbtn));
        al.add(ReusableFunctions.getText(cart));
        return al;
    }
    
    /**
     * Method to check if the checkout button is displayed on the cart page.
     * @return True if the checkout button is displayed, false otherwise.
     */
    public boolean checkCheckoutbtn() {
        return ReusableFunctions.isDisplayed(submitbtn);
    }
    
    /**
     * Method to retrieve the list of items in the cart.
     * @return A list of WebElements representing the items in the cart.
     */
    public List<WebElement> checkitem() {
        return product;
    }
    
    /**
     * Method to remove a product from the cart.
     */
    public void ProductRemove(){
        ReusableFunctions.clickOn(removeproduct, Duration.ofSeconds(10));    
    }
    
    /**
     * Method to click on the checkout button and navigate to the checkout page.
     * @return A new instance of CheckoutPOM class representing the checkout page.
     */
    public CheckoutPOM clickCheckoutbtn() {
        try {
            ReusableFunctions.delay(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ReusableFunctions.clickOn(submitbtn, Duration.ofSeconds(10));   //click checkout button
        try {
            ReusableFunctions.delay(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CheckoutPOM(driver);
    }
}