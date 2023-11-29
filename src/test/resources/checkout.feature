Feature: Checkout

  Background:
    Given User is logged in to Saucedemo with username "standard_user" and password "secret_sauce"

  Scenario: Proceed to checkout and provide shipping details
    When User clicks on the Checkout button
    Then User is redirected to the Checkout page
    When User enters shipping details:
      | First Name    | Last Name   | Zip/Postal Code |
      | John           | Doe         | 12345           |
    And User clicks on the Continue button
    Then User is on the Checkout Step Two page
