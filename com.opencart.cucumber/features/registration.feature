Feature: Verify registration
  @regression
  Scenario: Successfull Registration
    Given the user navigates to register page
    When user enter the values into the below fields
      | firstname | junkgook   |
      | lastname  | jeoul      |
      | telephone | 9876543212 |
      | password  | Seoul@425  |
    And click on the privacy policy
    And clicks on continue button
    Then the usercshould see a your account registration message
