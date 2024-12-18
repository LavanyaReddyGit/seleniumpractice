Feature: Validate Login

  # @sanity @regression
  # Scenario: Successful Login with Valid Credentials
  # Given the user navigates to login page
  # When user enters email as "testmail425@gmail.com" and password as "Test@123"
  # And the user clicks on the Login button
  # Then the user should be redirected to the MyAccount Page
  
  @regression
  Scenario Outline: Valid Login Functionality
    Given user navigates to the login page
    When user enters email as "<email>" and password as "<password>"
    And the user clicks on the Login button
    Then the user should be redirected to the MyAccount Page

    Examples: 
      | email                 | password |
      | testmail425@gmail.com | Test@123 |
      | testmail@gmail.com    | Test123  |
