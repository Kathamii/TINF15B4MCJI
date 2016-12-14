#Author: janikritz@gmail.com



Feature: Create Game Room
  as a User
  I want to create a Game Room with my Configurations

  Scenario: Valid Inputs
    Given I navigate to "http://localhost:8080/"
    And I wait for 1 sec
    Then I click on element having name "create"
    And I wait for 1 sec
    And I clear input field having name "minP"
    And I enter "2" into input field having name "minP"
    And I wait for 1 sec
    And I clear input field having name "maxP"
    And I enter "3" into input field having name "maxP"
    And I wait for 1 sec
