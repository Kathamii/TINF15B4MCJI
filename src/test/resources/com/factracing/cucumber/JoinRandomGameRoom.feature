#Author: michi.buchwald@web.de



Feature: Join Random Game Room
  as a User
  I want to join a public random game room 

  Scenario: Valid Inputs
    Given I navigate to "http://localhost:8080/"
    And I wait for 1 sec
    And I enter "Name" into input field having class "v-textfield"
    And I click on element having class "v-button"
    And I wait for 2 sec
    And I click on element having class "v-button"
    
