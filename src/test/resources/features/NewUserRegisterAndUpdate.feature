@Tablet
Feature:  New user registration and profile update feature


  Background: user is on a home page
    Given user is on the Tablet home page

  Scenario: Register new user account

    When user selects "Register" from the homepage header navigation menu
    And user fills out email input with valid email and clicks submit
    And  user fills first name and last name and clicks submit
    And user provides valid password and submits the registration form
    Then the user should have a registered account
    And user updates their bio with new information
    And user uploads a profile image and saves updates
    Then the user signs out and should be redirected to the homepage


