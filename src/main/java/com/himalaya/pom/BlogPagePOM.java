package com.himalaya.pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.himalaya.base.ReusableFunctions;


/**
 * This class represents the Page Object Model (POM) for the Blog Page.
 * It contains methods to interact with elements on the Blog Page.
 */
public class BlogPagePOM {

    WebDriver driver;
    By blogPageTitle = By.xpath("//h1[@class='dib-homepage-title']");
    By generalHealth = By.xpath("(//ul[@class='dib-cat-menu']/li)[4]");
    By generalHealthTitle = By.xpath("//h1[@class='dib-category-title']");
    By blogs = By.xpath("//div[@class='dib-post-wrap']/a");
    By drinkingGreenTeaBlog = By.xpath("(//div[@class='dib-post-wrap']/a)[7]");
    By blogName = By.xpath("//h1[@class='dib-post-title dib-highlight']");
    By himalayaIcon = By.xpath("//div[@class='h1 site-header__logo']/a");

    /**
     * Constructor for BlogPagePOM class.
     * @param driver The WebDriver instance to be used.
     */
    public BlogPagePOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to get the title of the blog page.
     * @return The title of the blog page.
     */
    public String blogPageTitle() {
        return ReusableFunctions.getText(blogPageTitle);
    }

    /**
     * Method to select the 'General Health' category.
     */
    public void selectGeneralHealth() {
        ReusableFunctions.clickOn(generalHealth, Duration.ofSeconds(10));
    }

    /**
     * Method to get the title of the 'General Health' category.
     * @return The title of the 'General Health' category.
     */
    public String generalHealthTitle() {
        return ReusableFunctions.getText(generalHealthTitle);
    }

    /**
     * Method to get the count of blogs displayed.
     * @return The count of blogs displayed.
     */
    public int blogCount() {
        List<WebElement> blog = ReusableFunctions.getListOfElements(blogs);
        return blog.size();
    }

    /**
     * Method to select the 'Drinking Green Tea' blog.
     */
    public void selectDrinkingGreenTeaBlog() {
        ReusableFunctions.clickOn(drinkingGreenTeaBlog, Duration.ofSeconds(10));
    }

    /**
     * Method to validate the name of the blog.
     * @return The name of the blog.
     */
    public String validateBlogName() {
        return ReusableFunctions.getText(blogName);
    }

    /**
     * Method to click on the Himalaya icon.
     */
    public void clickHimalayaIcon() {
        ReusableFunctions.clickOn(himalayaIcon, Duration.ofSeconds(10));
    }
}