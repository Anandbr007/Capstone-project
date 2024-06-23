package com.himalaya.pom;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.himalaya.base.ReusableFunctions;

/**
 * This class represents the Page Object Model (POM) for the Herb Finder page.
 * It contains methods to interact with elements on the Herb Finder page.
 */
public class HerbFinderPOM {

	WebDriver driver;
	
    // Locators for elements on the Herb Finder page
	By english = By.linkText("ENGLISH");
	By herbs = By.xpath("//ul[@class='features']/li/a");
	By morningGloryLily=By.linkText("Morning Glory Lily");
	By herbTitleName = By.xpath("//div[@class='entry-body clearfix']/header/h1");

	/**
     * Constructor for HerbFinderPOM class.
     * @param driver The WebDriver instance to be used.
     */
	public HerbFinderPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
     * Method to select English language on the Herb Finder page.
     */
	public void selectLanguageEng() {
		ReusableFunctions.clickOn(english, Duration.ofSeconds(10));
	}

	/**
     * Method to validate all herbs displayed on the Herb Finder page.
     * @return A list of herb names.
     */
	public List<String> validateAllHerbs() {
		List<WebElement> allherbs = ReusableFunctions.getListOfElements(herbs);
		List<String> herbNames = new ArrayList<String>();
		for (WebElement ele : allherbs) {
			herbNames.add(ele.getText());
		}
		return herbNames;
	}

	/**
	 * Method to validate and count the clicks on herb links displayed on the Herb Finder page.
	 * This method iterates through the herb categories and clicks on each herb link,
	 * then returns the total number of clicks made.
	 * @return The total number of clicks made on herb links.
	 */
	public int validateHerbsClick() {
		int x = 89,click=0;
		for (int i = 1; i <= 3; i++) {
			if (i == 1) {
				for (int j =1 ; j < x; j++) {
					ReusableFunctions.clickOn(By.xpath("((//div[@class='column featured'])[" + i + "]/ul[@class='features']/li/a)[" + j + "]"),
							Duration.ofSeconds(10));
					click++;
					driver.navigate().back();
				}
			} else {
				ReusableFunctions.clickJS(By.xpath("((//div[@class='column featured'])[" + i + "]/ul[@class='features']/li/a)[1]"),
						Duration.ofSeconds(10));
				click++;
				for (int j = 2; j <= x; j++) {
					ReusableFunctions.clickOn(By.xpath("((//div[@class='column featured'])[" + i + "]/ul[@class='features']/li/a)[" + j + "]"),
							Duration.ofSeconds(10));
					click++;
					driver.navigate().back();
				}
			}
		}
		return click;
	}
	
	/**
     * Method to click on Morning Glory Lily herb.
     */
	public void clickMorningGloryLily() {
		ReusableFunctions.clickOn(morningGloryLily, Duration.ofSeconds(10));
	}
	
	 /**
     * Method to get the name of the herb displayed on the page.
     * @return The name of the herb.
     */
	public String getHerbName() {
		return ReusableFunctions.getText(herbTitleName);
	}

}
