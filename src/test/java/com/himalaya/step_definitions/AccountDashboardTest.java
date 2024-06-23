package com.himalaya.step_definitions;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.himalaya.pom.AccountDashboardPOM;
import com.himalaya.pom.HomePagePOM;
import com.himalaya.pom.LoginPOM;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountDashboardTest {
	
	private final WebDriver driver = Hooks.driver;
	public HomePagePOM home;
	public LoginPOM login;
	public AccountDashboardPOM account;
	
	@Given("User input {string} as username {string} as password")
	public void user_input_as_username_as_password(String string, String string2) {
		home=new HomePagePOM(driver);
		login=new LoginPOM(driver);
		login.login(string,string2);
	}

	@When("User navigates to the Addresses section")
	public void user_navigates_to_the_addresses_section() {
		account=new AccountDashboardPOM(driver);
		account.clickViewAddress();
	}

	@Then("User validates {string} page")
	public void user_validates_page(String string) {
		home=new HomePagePOM(driver);
		assertTrue(home.getTitle().contains(string));
	}
	
	@When("User chooses to add a new address")
	public void user_chooses_to_add_a_new_address() {
		account=new AccountDashboardPOM(driver);
		account.selectAddAddress();
	}

	@Then("User fills in the address details as {string}, {string}, {string}, {string}, {string}, {string}, {string}, and {string}")
	public void user_fills_in_the_address_details_as_and(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
	   account=new AccountDashboardPOM(driver);
	   account.enterAddressDetails(string, string2, string3, string4, string5, string6, string7, string8);
	}

	@When("User selects the Province as Kerala and set the address as default")
	public void user_selects_the_province_as_kerala_and_set_the_address_as_default() {
		account=new AccountDashboardPOM(driver);
		account.selectProvince();
		account.clickCheckbox();
		
	}

	@When("User saves the new address")
	public void user_saves_the_new_address() {
		account=new AccountDashboardPOM(driver);
		account.clickSubmitbtn();
	}

	@Then("User verifies the added address is displayed correctly")
	public void user_verifies_the_added_address_is_displayed_correctly() {
		account=new AccountDashboardPOM(driver);
		System.out.println(account.validateAddress());
		assertTrue(account.validateAddress());
	}

	@When("User selects an existing address to edit")
	public void user_selects_an_existing_address_to_edit() {
		account=new AccountDashboardPOM(driver);
		account.clickEditbtn();
	}

	@Then("User updates the address1 field by {string} details")
	public void user_updates_the_address1_field_by_details(String string) {
		account=new AccountDashboardPOM(driver);
		account.editAddress1Field(string);
	}

	@When("User saves the changes")
	public void user_saves_the_changes() {
		account=new AccountDashboardPOM(driver);
		account.clickUpdatebtn();
	}

	@Then("User verifies the updated address1 field is same as {string}")
	public void user_verifies_the_updated_address1_field_is_same_as(String string) {
		account=new AccountDashboardPOM(driver);
		account.clickMyAccount();
		System.out.println(account.validateAddress1());
		assertTrue(account.validateAddress1().contains(string));
	}

	@Then("User selects an address and delete that address")
	public void user_selects_an_address_and_delete_that_address() {
		account=new AccountDashboardPOM(driver);
		account.clickDeletebtn();
	}

	@Then("User verifies the address is removed from the list")
	public void user_verifies_the_address_is_removed_from_the_list() {
		account=new AccountDashboardPOM(driver);
		assertFalse(account.validateAddress());
	}

}
