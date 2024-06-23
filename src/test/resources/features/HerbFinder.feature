@HerbFinder
Feature: Herb Finder feature
  As a user I want to validate the details of herb

  Scenario: Validating all herb details
    Given User already open the website Himalaya
    When User clicks on Herb Finder
    Then User validates the Herb Finder page as its title contains "Herb"
    And User selects language as English
    Then User clicks on each of the herbs provided and validate it

  Scenario: Validating a herb detail
    Given User already open the website Himalaya
    When User clicks on Herb Finder
    Then User validates the Herb Finder page as its title contains "Herb"
    And User selects language as English
    And User clicks on herb Morning Glory Lily
    Then User validates the title of the herb as "Morning Glory Lily"
