@Blog
Feature: Blog Feature
  As a user I want to validate the title of a blog

  Scenario: Validating the title of blog
    Given User already open the website Himalaya
    When User clicks on Blog
    Then User validates the "Blog" page
    And User clicks on the topic General Health
    Then User validates the heading of page as "General Health" and takes the list of all blogs related to General Health
    And User selects Benefits of Drinking Green Tea Daily blog
    Then User validate the title of the blog as "6 Benefits of Drinking Green Tea Daily"
    And User clicks on himalaya icon
    Then User returns to the home page
