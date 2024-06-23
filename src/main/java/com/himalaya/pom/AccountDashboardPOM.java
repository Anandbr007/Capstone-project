package com.himalaya.pom;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.himalaya.base.ReusableFunctions;

/**
 * This class represents the Page Object Model (POM) for the account dashboard page.
 * It contains methods to interact with elements on the account dashboard page.
 */
public class AccountDashboardPOM {
	
	WebDriver driver;
	
    // Locators for elements on the account dashboard page
	By accountDetails=By.xpath("//div[@class='grid__item medium-up--one-third']/p");
	By viewAddress=By.xpath("//div[@class='grid__item medium-up--one-third']/p/a");
	By addAddress=By.xpath("//button[@class='btn btn--secondary btn--small section-header__link address-new-toggle']");
	By firstName=By.cssSelector("input#AddressFirstNameNew");
	By lastName=By.cssSelector("input#AddressLastNameNew");
	By company=By.cssSelector("input#AddressCompanyNew");
	By address1=By.cssSelector("input#AddressAddress1New");
	By address2=By.cssSelector("input#AddressAddress2New");
	By city=By.cssSelector("input#AddressCityNew");
	By pincode=By.cssSelector("input#AddressZipNew");
	By phone=By.cssSelector("input#AddressPhoneNew");
	By checkbox=By.cssSelector("input#address_default_address_new");
	By submitbtn=By.cssSelector("button#addresses-add-submit");
	By validate=By.xpath("//p[@class='h4']");
	By editbtn=By.xpath("//button[@class='btn btn--small address-edit-toggle']");
	By editAddress1=By.xpath("(//input[@name='address[address1]'])[2]");
	By updatebtn=By.xpath("//button[@id='addresses-update-submit']");
	By myAccount=By.linkText("My account");
	By validateAddress1=By.xpath("(//div[@class='grid__item medium-up--one-third']/p)[2]");
	By deletebtn=By.xpath("//button[@class='btn btn--secondary btn--small address-delete']");
	@FindBy(css="select#AddressProvinceNew")
	WebElement province;
	
	/**
     * Constructor for AccountDashboardPOM class.
     * @param driver The WebDriver instance to be used.
     */
	public AccountDashboardPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
    // Method to validate if account details section is present
	public boolean validateAccountDetails() {
		return ReusableFunctions.isElementPresent(accountDetails, Duration.ofSeconds(10));
	}
	
    // Method to click on View Address link
	public void clickViewAddress() {
		ReusableFunctions.clickOn(viewAddress, Duration.ofSeconds(10));
	}
	
    // Method to select add address button
	public void selectAddAddress() {
		ReusableFunctions.clickOn(addAddress, Duration.ofSeconds(10));
	}
	
    // Method to enter address details
	public void enterAddressDetails(String fname,String lname,String companyName,String add1,String add2,String cityName,String pin,String phoneno) {
		ReusableFunctions.sendText(firstName, fname);
		ReusableFunctions.sendText(lastName, lname);
		ReusableFunctions.sendText(company, companyName);
		ReusableFunctions.sendText(address1, add1);
		ReusableFunctions.sendText(address2, add2);
		ReusableFunctions.sendText(city, cityName);
		ReusableFunctions.sendText(pincode, pin);
		ReusableFunctions.sendText(phone, phoneno);

	}

    // Method to select province from dropdown
	public void selectProvince() {
		Select s=new Select(province);
		s.selectByValue("Kerala");
	}
	
    // Method to click on set as default checkbox
	public void clickCheckbox() {
		ReusableFunctions.clickOn(checkbox, Duration.ofSeconds(10));
	}
	
    // Method to click on submit button
	public void clickSubmitbtn() {
		ReusableFunctions.clickOn(submitbtn, Duration.ofSeconds(10));
	}
	
    // Method to validate address creation
	public boolean validateAddress() {
		return ReusableFunctions.isElementPresent(validate, Duration.ofSeconds(10));
	}
	
    // Method to click on edit button
	public void clickEditbtn() {
		ReusableFunctions.clickOn(editbtn, Duration.ofSeconds(20));
	}
	
    // Method to edit address1 field
	public void editAddress1Field(String address1) {
		ReusableFunctions.textboxClear(editAddress1);
		ReusableFunctions.sendText(editAddress1, address1);
	}
	
    // Method to click on update button
	public void clickUpdatebtn() {
		ReusableFunctions.clickOn(updatebtn, Duration.ofSeconds(10));
	}
	
    // Method to click on my account link
	public void clickMyAccount() {
		ReusableFunctions.clickOn(myAccount, Duration.ofSeconds(10));
	}
	
    // Method to validate address after editing
	public String validateAddress1() {
		return ReusableFunctions.getText(validateAddress1);
	}
	
    // Method to click on delete button
	public void clickDeletebtn() {
		ReusableFunctions.clickOn(deletebtn, Duration.ofSeconds(10));
		Alert a=driver.switchTo().alert();
		a.accept();
	}
	
}
