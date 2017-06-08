#Author: janikritz@gmail.com

  
Feature: Create Game Room
  as a User
  I want to create a Game Room with my Configurations

  Scenario: Valid Inputs
    Given I navigate to "http://localhost:8080/"
    Then I wait for 1 sec
    And I enter "Name" into input field having class "v-textfield"
    And I click on element having class "v-button"
    And I wait for 2 sec
    And I click on element having class "v-button"
    And I wait for 1 sec
    And I clear input field having id "gwt-uid-3"
    And I enter "2" into input field having id "gwt-uid-3"
    And I wait for 1 sec
    And I clear input field having id "gwt-uid-5"
    And I enter "3" into input field having id "gwt-uid-5"
    And I wait for 1 sec
    And I click on element having value "1"
    And I wait for 1 sec
    And I click on element having text "Create Game Room"
    And I wait for 1 sec
    And I close browser
