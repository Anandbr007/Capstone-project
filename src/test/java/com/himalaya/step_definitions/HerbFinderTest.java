package com.himalaya.step_definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.himalaya.pom.HerbFinderPOM;
import com.himalaya.pom.HomePagePOM;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HerbFinderTest {
	
	private final WebDriver driver = Hooks.driver;
	public HomePagePOM home;
	public HerbFinderPOM herb;

	@When("User clicks on Herb Finder")
	public void user_clicks_on_herb_finder() {
	    home=new HomePagePOM(driver);
	    home.clickHerbFinder();
	}

	@Then("User validates the Herb Finder page as its title contains {string}")
	public void user_validates_the_herb_finder_page_as_its_title_contains(String string) {
	    home=new HomePagePOM(driver);
	    assertEquals(home.getCurrentUrl(), "https://herbfinder.himalayawellness.in/");
	    assertTrue(home.getTitle().contains(string));
	}

	@Then("User selects language as English")
	public void user_selects_language_as_english() {
	    herb=new HerbFinderPOM(driver);
	    herb.selectLanguageEng();
	}

	@Then("User clicks on each of the herbs provided and validate it")
	public void user_clicks_on_each_of_the_herbs_provided_and_validate_it() {
		herb=new HerbFinderPOM(driver);
		List<String> allherbs=herb.validateAllHerbs();
		int allherbsclick=herb.validateHerbsClick();
		System.out.println(allherbs);
		System.out.println(allherbs.size());
		System.out.println(allherbsclick);
		assertEquals(allherbsclick, allherbs.size());	
	}
	
	@Then("User clicks on herb Morning Glory Lily")
	public void user_clicks_on_herb_morning_glory_lily() {
		herb=new HerbFinderPOM(driver);
		herb.clickMorningGloryLily();
	}

	@Then("User validates the title of the herb as {string}")
	public void user_validates_the_title_of_the_herb_as(String string) {
		herb=new HerbFinderPOM(driver);
		assertEquals(herb.getHerbName(), string);
	}
	
}
