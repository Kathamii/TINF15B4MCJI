#Author: janikritz@gmail.com



Feature: Create Game Room
  as a User
  I want to create a Game Room with my Configurations

  Scenario: Valid Inputs
    Given I navigate to "http://localhost:8080/"
    Then I should see page title as "Fact Racing"
    Then I close browser

