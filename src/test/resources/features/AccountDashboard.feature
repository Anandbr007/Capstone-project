@AccountDashboard
Feature: Account Dashboard feature
  As a user I want to validate the account dashboard features

  Scenario Outline: Add address on the account dashboard
    Given User already open the website Himalaya
    And User input "joeyk123@gmail.com" as username "Joey123" as password
    When User navigates to the Addresses section
    Then User validates "Addresses" page
    And User chooses to add a new address
    And User fills in the address details as "<firstname>", "<lastname>", "<company>", "<address1>", "<address2>", "<city>", "<postalCode>", and "<phone>"
    And User selects the Province as Kerala and set the address as default
    And User saves the new address
    Then User verifies the added address is displayed correctly

    Examples: 
      | firstname | lastname | company | address1          | address2 | city       | postalCode | phone      |
      | Joey      | Kim      | UST     | Skyline Apartment | Pettah   | Trivandrum |     695024 | 9765843321 |

  Scenario: Edit address on the account dashboard
    Given User already open the website Himalaya
    And User input "joeyk123@gmail.com" as username "Joey123" as password
    When User navigates to the Addresses section
    Then User validates "Addresses" page
    And User selects an existing address to edit
    And User updates the address1 field by "SFS Apartment" details
    And User saves the changes
    Then User verifies the updated address1 field is same as "SFS Apartment"

  Scenario: Delete address on the account dashboard
    Given User already open the website Himalaya
    And User input "joeyk123@gmail.com" as username "Joey123" as password
    When User navigates to the Addresses section
    Then User validates "Addresses" page
    And User selects an address and delete that address
    Then User verifies the address is removed from the list
