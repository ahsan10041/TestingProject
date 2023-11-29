Feature: Saucedemo Login

  Background:
    Given User is on the Saucedemo login page

  Scenario: Login with correct credentials
    When User enters correct username and password
    Then User should be logged in successfully

  Scenario Outline: Login with incorrect credentials
    When User enters incorrect username "<username>" and/or password "<password>"
    Then User should see an error message

    Examples:
      | username           | password      |
      | invalid_user       | secret_sauce  |
      | locked_out_user    | secret_sauce  |
      | problem_user       | secret_sauce  |
      | performance_glitch_user | secret_sauce |
      | error_user         | secret_sauce  |
      | visual_user        | secret_sauce  |
