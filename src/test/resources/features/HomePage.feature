@Homepage
Feature: Homepage Feature
  As a user I want to validate the Homepage of himalaya wellness

  Scenario: Validating the homepage
    Given User navigates to homepage of himalaya
    When User clicks on Aboutus page
    Then User validates the About Us page
    And User clicks on Our research page
    Then User validates the heading of page as "Ayurveda and Wellness"
    And User clicks on Product page
    Then User validates the heading of page as "All"
    And User clicks on himalaya global holdings page
    Then User validates the global holdings page
    And User clicks on himalaya icon
    And User clicks on Refer a friend page
    Then User validates the heading of page as "Refer a Friend"
    And User clicks on himalaya icon

  Scenario Outline: validating footer section
    Given User navigates to homepage of himalaya
    When User clicks "<number>" at footer section
    Then user validates the heading as "<url>"

    Examples: 
      | number | url                                                   |
      |      1 | https://himalayawellness.in/pages/ask-the-experts     |
      |      2 | https://himalayawellness.in/a/blog                    |
      |      4 | https://himalayawellness.in/pages/contact-us          |
      |      5 | https://himalayawellness.in/pages/faqs                |
      |      6 | https://healthhelp.himalayawellness.in/               |
      |      7 | https://herbfinder.himalayawellness.in/               |
      |      8 | https://himalayawellness.in/pages/himalayasmiles      |
      |      9 | https://researchpapers.himalayawellness.in/           |
      |     10 | https://storelocator.himalayawellness.in/             |
      |     11 | https://himalayawellness.in/policies/refund-policy    |
      |     12 | https://himalayawellness.in/policies/terms-of-service |
