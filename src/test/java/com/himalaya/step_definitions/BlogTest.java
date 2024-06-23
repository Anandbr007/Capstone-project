package com.himalaya.step_definitions;

import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.himalaya.pom.BlogPagePOM;
import com.himalaya.pom.HomePagePOM;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BlogTest {
	
	private final WebDriver driver = Hooks.driver;
	public HomePagePOM home;
	public BlogPagePOM blog;
	
	@Given("User already open the website Himalaya")
	public void user_already_open_the_website_himalaya() {
		home=new HomePagePOM(driver);
	    assertEquals(home.getCurrentUrl(), "https://himalayawellness.in/");
	}

	@When("User clicks on Blog")
	public void user_clicks_on_blog() {
		home=new HomePagePOM(driver);
		home.clickBlog();
	}

	@Then("User validates the {string} page")
	public void user_validates_the_page(String string) {
		home=new HomePagePOM(driver);
		blog=new BlogPagePOM(driver);
		assertEquals(home.getCurrentUrl(), "https://himalayawellness.in/a/blog");
		assertTrue(blog.blogPageTitle().contains(string));
	}

	@Then("User clicks on the topic General Health")
	public void user_clicks_on_the_topic_general_health() {
		blog=new BlogPagePOM(driver);
		blog.selectGeneralHealth();
	}

	@Then("User validates the heading of page as {string} and takes the list of all blogs related to General Health")
	public void user_validates_the_heading_of_page_as_and_takes_the_list_of_all_blogs_related_to_general_health(String string) {
		blog=new BlogPagePOM(driver);
		assertEquals(blog.generalHealthTitle(), string);
		assertEquals(blog.blogCount(), 9);
		
	}

	@Then("User selects Benefits of Drinking Green Tea Daily blog")
	public void user_selects_benefits_of_drinking_green_tea_daily_blog() {
		blog=new BlogPagePOM(driver);
		blog.selectDrinkingGreenTeaBlog();
	}

	@Then("User validate the title of the blog as {string}")
	public void user_validate_the_title_of_the_blog_as(String string) {
		home=new HomePagePOM(driver);
		blog=new BlogPagePOM(driver);
	    assertEquals(home.getCurrentUrl(), "https://himalayawellness.in/a/blog/benefits-of-drinking-green-tea-daily");
	    assertEquals(blog.validateBlogName(),string);
	}

	@Then("User clicks on himalaya icon")
	public void user_clicks_on_himalaya_icon() {
		blog=new BlogPagePOM(driver);
		blog.clickHimalayaIcon();
	}

	@Then("User returns to the home page")
	public void user_returns_to_the_home_page() {
		home=new HomePagePOM(driver);
	    assertEquals(home.getCurrentUrl(), "https://himalayawellness.in/");
	}

}
