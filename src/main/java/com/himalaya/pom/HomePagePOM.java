package com.himalaya.pom;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.himalaya.base.ReusableFunctions;


/**
 * This class represents the Page Object Model (POM) for the home page of the Himalaya website.
 * It contains methods to interact with elements on the home page.
 */
public class HomePagePOM {
	
	WebDriver driver;
	WebDriverWait wait;
	
	// Locators for elements on the home page
	By store = By.xpath("//a[@class='site-nav__link site-nav__link--underline check_link'][1]");
	By searchBox = By.xpath("//input[@name='q'][@placeholder='Search']");
	By blog = By.linkText("Blog");
	By herbFinder = By.linkText("Herb Finder");
	By aboutUs = By.xpath("(//a[@class='site-nav__link site-nav__link--underline site-nav__link--has-dropdown check_link'])[1]");
	By milestones = By.xpath("(//a[@class='site-nav__dropdown-link '])[3]");
	By research = By.xpath("(//a[@class='site-nav__link site-nav__link--underline site-nav__link--has-dropdown check_link'])[2]");
	By science = By.xpath("(//ul[@class='site-nav__dropdown text-left']/li)[2]");
	By hema = By.xpath("//div[@class='as_chat_icon maximized right  ']");
	By products = By.xpath("(//a[@class='site-nav__link site-nav__link--underline site-nav__link--has-dropdown check_link'])[3]");
	By babyCareBath = By.xpath("((//div[@class='grid__item medium-up--one-fifth appear-animation appear-delay-2'])[2]/div)[4]/a");
	By hairCare = By.xpath("(//div[@class='grid__item medium-up--one-fifth appear-animation appear-delay-5']/div/a)[7]");
	By himalayaGlobal=By.xpath("//div/ul[@class='inline-list toolbar__menu']/li/a");
	By title = By.className("section-header__title");
	By globalholding = By.xpath("//ul[@class='inline-list toolbar__menu']/li/a/img");
	By referfriend = By.cssSelector("a[class='btn  btn--small section-header__link']");
	By ayurveda = By.xpath("(//ul[@class='site-nav__dropdown text-left']/li)[1]");
	By heart = By.xpath("(//ul[@class='site-nav__dropdown text-left']/li)[3]");
	By innovationhealth = By.xpath("(//ul[@class='site-nav__dropdown text-left']/li)[5]");
	By innovationpersonal = By.xpath("(//ul[@class='site-nav__dropdown text-left']/li)[6]");
	By cooperate=By.xpath("((//div[@class='grid'])[2]/div/div/a)[1]");
	By leader=By.xpath("((//div[@class='grid'])[2]/div/div/a)[6]");
	By media=By.xpath("((//div[@class='grid'])[2]/div/div/a)[11]");
	By career=By.xpath("((//div[@class='grid'])[2]/div/div/a)[14]");
	By partners=By.xpath("((//div[@class='grid'])[2]/div/div/a)[15]");
	By valiadteText=By.xpath("//header[@class='section-header']/h1");
	
	/**
     * Constructor for HomePagePOM class.
     * @param driver The WebDriver instance to be used.
     */
	public HomePagePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// Method to click Store Locator
	public void clickStoreLocator() {
		ReusableFunctions.clickOn(store, Duration.ofSeconds(10));
	}

	// Method to enter text in the search box
	public void enterSearchInput(String text) {
		ReusableFunctions.textboxClear(searchBox);
		ReusableFunctions.sendTextAndEnter(searchBox, text, Keys.ENTER);
	}
	
	// Method to click on the Blog link
	public void clickBlog() {
		ReusableFunctions.clickOn(blog, Duration.ofSeconds(10));
	}
	
	// Method to click on the Herb Finder link
	public void clickHerbFinder() {
		ReusableFunctions.clickOn(herbFinder, Duration.ofSeconds(10));
	}
	
	// Method to click on the About Us link
	public void clickAboutUs() {
		ReusableFunctions.clickAction(aboutUs, Duration.ofSeconds(10));
	}
	
	// Method to select the Milestones option
	public void selectMilestones() {
		ReusableFunctions.clickOn(milestones, Duration.ofSeconds(10));
	}
	
	// Method to click on the Research link
	public void clickResearch() {
		ReusableFunctions.clickAction(research, Duration.ofSeconds(10));
	}
	
	// Method to select the Our Science option
	public void selectOurScience() {
		ReusableFunctions.clickOn(science, Duration.ofSeconds(10));
	}
	
	// Method to click on the Virtual Advisor icon
	public void clickVirtualAdvisor() {
		ReusableFunctions.clickOn(hema, Duration.ofSeconds(30));
	}
	
	// Method to click on the Products link
	public void clickProduct() {
		ReusableFunctions.clickAction(products, Duration.ofSeconds(10));
	}
	
	// Method to select the Baby Care & Bath option
	public void selectBabyCareBath() {
		ReusableFunctions.clickOn(babyCareBath, Duration.ofSeconds(10));
	}
	
	// Method to select the Hair Care option
	public void selectHairCare() {
		ReusableFunctions.clickOn(hairCare, Duration.ofSeconds(10));
	}
	
	// Method to click on Himalaya Global Holdings link
	public void clickHimalayaGlobalHoldings() {
		ReusableFunctions.clickOn(himalayaGlobal, Duration.ofSeconds(10));
	}
	
	// Method to switch to a new window or tab
	public void switchHandle() {
		String parent = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			if (!handle.equals(parent)) {
				driver.switchTo().window(handle);
			}
		}
	}
	
	// Method to get the title of the current page
	public String getTitle() {
		return driver.getTitle();
	}
	
	// Method to get the URL of the current page
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}	
	
	// Method to click About Us button
	public void clickAboutusbtn() {
		ReusableFunctions.clickOn(aboutUs, Duration.ofSeconds(10));
	}
	
	// Method to click Our Research button
	public void clickOurResearchbtn() {
		ReusableFunctions.clickOn(research, Duration.ofSeconds(10));
	}
	
	// Method to get the title text
	public String getTitle1() {
		String str = ReusableFunctions.getText(title);
		return str;
	}
		
	// Method to go back to the previous page
	public void goBack() {
		driver.navigate().back();
	}
		
	// Method to click Products button
	public void clickProductsbtn() {
		ReusableFunctions.clickOn(products, Duration.ofSeconds(10));
	}
		
	// Method to click Global Holdings button
	public void clickGlobalholdingbtn() {
		ReusableFunctions.clickOn(globalholding, Duration.ofSeconds(10));
	}
	
	// Method to click Refer a Friend button
	public void clickreferFriendbtn() {
		ReusableFunctions.clickOn(referfriend, Duration.ofSeconds(10));
	}
		
	// Method to click on footer links
	public void clickFooterlinks(String str) throws InterruptedException {	
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='grid__item footer__item--footer-1']/div[@id='Footer-footer-1']/div/div/ul/li/a")));
		ReusableFunctions.clickOn(By.xpath("//div[@class='grid__item footer__item--footer-1']/div[@id='Footer-footer-1']/div/div/ul/li["+Integer.parseInt(str)+"]/a"), Duration.ofSeconds(10));			
	}
	
	// Method to click on the Ayurveda link.
	public void selectAyurveda() {
	    ReusableFunctions.clickOn(ayurveda, Duration.ofSeconds(10));
	}

	 // Method to click on the Heart link.
	public void selectHeart() {
	    ReusableFunctions.clickOn(heart, Duration.ofSeconds(10));
	}

	// Method to click on the Innovation in Health link.
	public void selectInnovationhealth() {
	    ReusableFunctions.clickOn(innovationhealth, Duration.ofSeconds(10));
	}

	 // Method to click on the Innovation in Personal Care link.
	public void selectInnovationpersonal() {
	    ReusableFunctions.clickOn(innovationpersonal, Duration.ofSeconds(10));
	}

	 // Method to click on the Corporate Profile link.
	public void selectCooperateProfile() {
	    ReusableFunctions.clickOn(cooperate, Duration.ofSeconds(10));
	}

	 // Method to click on the Leadership link.
	public void selectLeadership() {
	    ReusableFunctions.clickOn(leader, Duration.ofSeconds(10));
	}

	 // Method to click on the Media link.
  	public void selectMedia() {
	    ReusableFunctions.clickOn(media, Duration.ofSeconds(10));
	}

	// Method to click on the Careers link.
	public void selectCareers() {
	    ReusableFunctions.clickOn(career, Duration.ofSeconds(10));
	}

	// Method to click on the Partners link.
	public void selectPartners() {
	    ReusableFunctions.clickOn(partners, Duration.ofSeconds(10));
	}

	// Method to validate the page heading.
	public String validatePageHeading() {
	    return ReusableFunctions.getText(valiadteText);
	}
	
}