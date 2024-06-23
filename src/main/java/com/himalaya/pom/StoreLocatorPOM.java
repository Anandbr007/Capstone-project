package com.himalaya.pom;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.himalaya.base.ReusableFunctions;

/**
 * This class represents the Page Object Model (POM) for the store locator page.
 * It contains methods to interact with elements on the store locator page.
 */
public class StoreLocatorPOM {

    WebDriver driver;

    // Locators for elements on the store locator page
    By state = By.xpath("//div/select[@id='State']");
    By city = By.xpath("//div/select[@id='City']");
    By storeName = By.xpath("//div[@class='col-lg-4 col-md-6 viewlocation_gap']/div/h3");

    /**
     * Constructor for StoreLocatorPOM class.
     * @param driver The WebDriver instance to be used.
     */
    public StoreLocatorPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to select a state from the dropdown.
     */
    public void selectState() {
        try {
            ReusableFunctions.delay(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ReusableFunctions.clickJS(state, Duration.ofSeconds(10));
        Select s = new Select(driver.findElement(state));
        s.selectByValue("14"); // Assuming "14" represents the value of the desired state
    }

    /**
     * Method to select a city from the dropdown.
     */
    public void selectCity() {
        try {
            ReusableFunctions.delay(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Select s = new Select(driver.findElement(city));
        s.selectByValue("76"); // Assuming "76" represents the value of the desired city
    }

    /**
     * Method to validate the names of stores in Thiruvananthapuram (Trivandrum).
     * @return A list of store names in Thiruvananthapuram.
     */
    public List<String> validateStoreInTvm() {
        List<String> storeTvmName = new ArrayList<String>();
        List<WebElement> storeTvm = ReusableFunctions.getListOfElements(storeName);
        for (WebElement s : storeTvm) {
            storeTvmName.add(s.getText());
        }
        return storeTvmName;
    }

}