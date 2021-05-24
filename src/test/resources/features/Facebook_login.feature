@WebUI
Feature: Facebook login

  @Login
  Scenario Outline: Login to Facebook and post
    Given User is opening "Facebook" page
    And User fill "royal_email" with "<Email>" on login page
    And User fill "royal_pass" with "<Password>" on login page
    And User click on the "royal_login_button" element on login page
    Then User should be on the "https://www.facebook.com" page

    When User click on the "Home" symbol element on landing page
    And User click on the "What's on your mind, " text element on landing page
    And User fill the post with "Hello" on landing page
    And User click on the post button on landing page
    Then User should see the new "Hello" status on landing page
    Examples:
      | Email       | Password       |
      | user1_email | user1_password |
