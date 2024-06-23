package com.himalaya.step_definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import com.himalaya.pom.HomePagePOM;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class HomepageTest {
	
	private final WebDriver driver = Hooks.driver;
	public HomePagePOM home;
	
	@Given("User navigates to homepage of himalaya")
	public void user_navigates_to_homepage_of_himalaya() {
		home=new HomePagePOM(driver);
		assertEquals(home.getCurrentUrl(), "https://himalayawellness.in/");
	}
	@When("User clicks on Aboutus page")
	public void user_clicks_on_aboutus_page() {
		home=new HomePagePOM(driver);
		home.clickAboutusbtn();
	}
	@Then("User validates the About Us page")
	public void user_validates_the_about_us_page() {
		home=new HomePagePOM(driver);
		assertEquals(driver.getCurrentUrl(), "https://himalayawellness.in/pages/our-story");
		assertEquals(driver.getTitle(), "Our Story - Himalaya Wellness (India)");
	}
	@Then("User clicks on Our research page")
	public void user_clicks_on_our_research_page() {
		home=new HomePagePOM(driver);
		home.clickOurResearchbtn();
	}
	@Then("User validates the heading of page as {string}")
	public void user_validates_the_heading_of_page_as(String string) {
		home=new HomePagePOM(driver);
		assertTrue(home.getTitle1().contains(string));
	}
	@Then("User clicks on Product page")
	public void user_clicks_on_product_page() {
		home=new HomePagePOM(driver);
		home.clickProductsbtn();
	}
	@Then("User clicks on himalaya global holdings page")
	public void user_clicks_on_himalaya_global_holdings_page() {
		home=new HomePagePOM(driver);
		home.clickGlobalholdingbtn();
	}
	@Then("User validates the global holdings page")
	public void user_validates_the_global_holdings_page() {
		home=new HomePagePOM(driver);
		assertEquals(driver.getCurrentUrl(), "https://himalayaglobalholdings.com/");
		home.goBack();
	}
	@Then("User clicks on Refer a friend page")
	public void user_clicks_on_refer_a_friend_page() {
		home=new HomePagePOM(driver);
		home.clickreferFriendbtn();
	}
	@When("User clicks {string} at footer section")
	public void user_clicks_at_footer_section(String string) throws InterruptedException {
		home=new HomePagePOM(driver);
		home.clickFooterlinks(string);
	}
	
	@Then("user validates the heading as {string}")
	public void user_validates_the_heading_as(String string) {
		home=new HomePagePOM(driver);
		assertEquals(driver.getCurrentUrl(), string);
	}
}
