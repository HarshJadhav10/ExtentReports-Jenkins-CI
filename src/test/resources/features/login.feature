Feature: Login Test

  Scenario: Verify login page title
    Given user opens the browser
    When user navigates to "https://example.com"
    Then page title should contain "Example Domain"