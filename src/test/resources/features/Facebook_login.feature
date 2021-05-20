@WebUI
Feature: Facebook login

  @Login
  Scenario Outline: Login to Facebook and post
    Given User is opening "Facebook" page
    And User fill "royal_email" with "<Email>"
    And User fill "royal_pass" with "<Password>"
    And User click on the "royal_login_button" element
    Then User should be on the "https://www.facebook.com/" page

    When User click on the "" element
    Examples:
      | Email       | Password       |
      | user1_email | user1_password |
      | user2_email | user2_password |
