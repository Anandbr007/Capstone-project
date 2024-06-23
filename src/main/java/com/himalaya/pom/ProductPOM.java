package com.himalaya.pom;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.himalaya.base.ReusableFunctions;
/**
 * This class represents the Page Object Model (POM) for the product page.
 * It contains methods to interact with elements on the product page.
 */
public class ProductPOM {
	
	WebDriver driver;
	
	// Locators for elements on the product page
	By category = By.xpath("(//div[@class='snize-filters-dropdown-title'])[4]");
	By babyCare = By.xpath("(//div[@id='snize_filters_dropdown_collections']/div/ul/li)[3]");
	By price = By.xpath("//div[@id='snize_filters_dropdown_price']");
	By priceMin = By.xpath("(//input[@class='snize-price-range-input snize-range-min-price'])[1]");
	By priceMax = By.xpath("(//input[@class='snize-price-range-input snize-range-max-price'])[1]");
	By producttype=By.cssSelector("div[id='snize_filters_dropdown_product_type']");
	By liquid=By.xpath("(//div[@class='snize-filter-checkbox'])[2]");
	By oil=By.xpath("(//div[@class='snize-filter-checkbox'])[3]");
	By grid=By.xpath("//div[@class='snize-main-panel-view-mode']/a[2]");
	By sort=By.xpath("//a[@class='snize-main-panel-dropdown-button']");
	By hightolow=By.xpath("//ul[@class='snize-main-panel-dropdown-content']/li[7]/a");
	By soap = By.xpath("(//span[@class='snize-title'])[1]");
	By soapPrice = By.xpath("(//div[@class='product-block product-block--price']/span)[4]");
//	By checkprice = By.xpath("//span[@class='snize-price  money ']");
	By checkprice = By.xpath("//div[@class='snize-price-list']");

	
	/**
	 * Constructor for ProductPOM class.
	 * @param driver The WebDriver instance to be used.
	 */
	public ProductPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Method to select the category from the dropdown.
	 */
	public void selectCategory() {
		ReusableFunctions.clickOn(category, Duration.ofSeconds(10));
		ReusableFunctions.clickOn(babyCare, Duration.ofSeconds(10));
		try {
			ReusableFunctions.delay(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to retrieve the list of soaps displayed.
	 * @return A list of soap names.
	 */
	public List<String> soapList() {
		List<String> soaps = new ArrayList<String>();
		for (int i = 1; i <= 4; i++) {
			soaps.add(ReusableFunctions.getText(By.xpath("((//div[@id='snize-search-results-grid-mode']/ul/li/a/div/span)[" + i + "]/span)[1]")).toLowerCase());
		}
		return soaps;
	}
	
	/**
	 * Method to select the price range from the dropdown.
	 */
	public void selectPriceRange() {
		ReusableFunctions.clickOn(price, Duration.ofSeconds(10));
		ReusableFunctions.textboxClear(priceMin);
		ReusableFunctions.sendTextAndEnter(priceMin, "100", Keys.ENTER);
		ReusableFunctions.textboxClear(priceMax);
		ReusableFunctions.sendTextAndEnter(priceMax, "150", Keys.ENTER);	
		try {
			ReusableFunctions.delay(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to select the product type from the dropdown.
	 * @return 
	 */
	public ArrayList<String> productType()  {
		int i=0;
		try {
			ReusableFunctions.delay(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ReusableFunctions.clickOn(producttype, Duration.ofSeconds(10));
		try {
			ReusableFunctions.delay(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ReusableFunctions.clickOn(liquid, Duration.ofSeconds(10));
		try {
			ReusableFunctions.delay(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ReusableFunctions.clickOn(oil, Duration.ofSeconds(10));
		ReusableFunctions.clickOn(grid, Duration.ofSeconds(10));
		List<WebElement> before=ReusableFunctions.getListOfElements(checkprice);
		ArrayList<String> obtainedList = new ArrayList<>();
		
		for(WebElement we:before){
			if(i>=8) {
			   obtainedList.add(we.getText());
			   i++;
			}else {
				break;
			}
			}
		Collections.sort(obtainedList,Collections.reverseOrder());
		return obtainedList;
		}
	
	
	public ArrayList<String> sort() {
		int i=0;
		ReusableFunctions.clickAction(sort, Duration.ofSeconds(10));
		try {
			ReusableFunctions.delay(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ReusableFunctions.clickOn(hightolow, Duration.ofSeconds(10));
		List<WebElement> after=ReusableFunctions.getListOfElements(checkprice);
		ArrayList<String> obtainedList = new ArrayList<>();

		for(WebElement we:after){
			if(i>=8) {
			   obtainedList.add(we.getText());
			   i++;
			}else {
				break;
			}
			}
//		for (int i = 0; i < 8; i++) {
//			if(i%2==0) {
//				obtainedList1.add(obtainedList.get(i));
//			}
//		}
		return obtainedList;
	}
	/**
	 * Method to select a soap.
	 * @throws InterruptedException
	 */
	public void selectSoap() {
		try {
			ReusableFunctions.delay(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ReusableFunctions.clickOn(soap, Duration.ofSeconds(10));
		try {
			ReusableFunctions.delay(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to validate if the soap price is within the specified range.
	 * @return true if the price is within range, false otherwise.
	 */
	public boolean validateSoapPrice() {
		String[] amount = ReusableFunctions.getText(soapPrice).split(" ");
		float price = Float.parseFloat(amount[1]);
		if (price <= 150) {
			return true;
		}
		return false;
	}
}