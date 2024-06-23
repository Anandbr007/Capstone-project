package com.himalaya.pom;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.himalaya.base.ReusableFunctions;

/**
 * Page Object Model (POM) class for handling global elements on Himalaya Wellness website.
 */
public class HimalayaGlobalPOM {

    WebDriver driver;

    By linksText = By.xpath("(//div[@class='container-fluid']/ul/li)[2]");
    List<String> titles = new ArrayList<String>();
    List<String> titleName = new ArrayList<String>();

    /**
     * Constructor to initialize the HimalayaGlobalPOM class with WebDriver.
     * @param driver The WebDriver instance to be used.
     */
    public HimalayaGlobalPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to click on links and capture titles.
     * @return A list of titles captured after clicking on links.
     */
    public List<String> clickLinks() {
        for (int i = 1; i <= 5; i++) {
            ReusableFunctions.clickOn(By.xpath("(//div[@class='pt-desctop-menu']/nav/ul/li/a)[" + i + "]"), Duration.ofSeconds(10));
            titles.add(driver.getTitle());
        }
        return titles;
    }

    /**
     * Method to capture text of links.
     * @return A list of texts captured from links.
     */
    public List<String> linksText() {
        for (int i = 1; i <= 5; i++) {
            ReusableFunctions.clickOn(By.xpath("(//div[@class='pt-desctop-menu']/nav/ul/li/a)[" + i + "]"), Duration.ofSeconds(10));
            titleName.add(ReusableFunctions.getText(linksText));
        }
        return titleName;
    }
}