Feature: CRM Login Page Validation


  Scenario: Verify login with valid credentials
    When User enters valid email "sneha.kiaq@gmail.com" in email field
    And User enters valid password "Sneha@123" in password field
    And User clicks on Login button
    Then User should be logged in successfully