Feature: Add to Cart

  Background:
    Given User is logged in to Saucedemo with username "standard_user" and password "secret_sauce"

  Scenario: Add a product to the cart
    When User adds the product "Sauce Labs Backpack" to the cart
    Then The product "Sauce Labs Backpack" should be in the cart
