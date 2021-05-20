@WebUI
Feature: Facebook login

  @Login
  Scenario Outline: Login to Facebook and post
    Given User is opening "Facebook" page
    And User fill "royal_email" with "<Email>"
    And User fill "royal_pass" with "<Password>"
    And User click on the "royal_login_button" button
    Then User should be on the "/" page
    Examples:
      | Email             | Password          |
      | hungpqd@gmail.com | ThisIsThePassword |
