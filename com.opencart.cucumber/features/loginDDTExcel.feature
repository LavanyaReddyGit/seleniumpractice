Feature: Login Data Driven with excel
@regression
  Scenario Outline: Login Data driven Excel
    Given user navigates to the login page
    When user should be redirected to the My AccountPage by passing email and password with  excel row "<row_index">

    Examples: 
      | row_index |
      |         1 |
      |         2 |
      |         3 |
      |         4 |
      |         5 |
