package com.himalaya.pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.himalaya.base.ReusableFunctions;

/**
 * This class represents the Page Object Model (POM) for the checkout page.
 * It contains methods to interact with elements on the checkout page.
 */
public class CheckoutPOM {
    
    WebDriver driver;
    ReusableFunctions rf;
    
    // Locators for elements on the checkout page
    By firstname = By.id("checkout_shipping_address_first_name");
    By lastname = By.id("checkout_shipping_address_last_name");
    By address = By.id("checkout_shipping_address_address1");
    By city = By.id("checkout_shipping_address_city");
    By statedropdown = By.id("checkout_shipping_address_province"); 
    By stateclick = By.cssSelector("option[value='KL']");      
    By pincode = By.id("checkout_shipping_address_zip");
    By phone = By.id("checkout_shipping_address_phone");
    By submitbtn = By.cssSelector("button[class='step__footer__continue-btn btn']");
    By loginsend = By.id("checkout_email");
    By errormsg = By.id("error-for-email");
    
    /**
     * Constructor for CheckoutPOM class.
     * @param driver The WebDriver instance to be used.
     */
    public CheckoutPOM(WebDriver driver) {
        this.driver = driver;
        rf = new ReusableFunctions(driver);
        PageFactory.initElements(driver, this);
    }
    
    /**
     * Method to click on the submit button.
     */
    public void submitbtn() {
        ReusableFunctions.clickOn(submitbtn, Duration.ofSeconds(10));
    }
    
    /**
     * Method to get the error message displayed on the checkout page.
     * @return The text of the error message.
     */
    public String Errormsg() {
        return ReusableFunctions.getText(errormsg);
    }
    
    /**
     * Method to enter data into the checkout form fields and submit.
     * @param fname First name.
     * @param lname Last name.
     * @param address1 Shipping address.
     * @param city1 City.
     * @param pincode1 Pincode.
     * @param phone1 Phone number.
     */
    public void senddata(String fname, String lname, String address1, String city1, String pincode1, String phone1)  {
        ReusableFunctions.sendText(loginsend, "anandbijumohan2001@gmail.com");
        ReusableFunctions.sendText(firstname, fname);
        ReusableFunctions.sendText(lastname, lname);
        ReusableFunctions.sendText(address, address1);
        ReusableFunctions.sendText(city, city1);
        ReusableFunctions.sendText(pincode, pincode1);
        ReusableFunctions.sendText(phone, phone1);
        ReusableFunctions.clickOn(statedropdown, Duration.ofSeconds(10));
        try {
            ReusableFunctions.delay(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ReusableFunctions.clickOn(stateclick, Duration.ofSeconds(10));
        submitbtn();
    }
    
    /**
     * Method to check if the submit button is displayed on the page.
     * @return True if the submit button is displayed, false otherwise.
     */
    public boolean submitdisplayed() {
        return ReusableFunctions.isDisplayed(submitbtn);
    }
}