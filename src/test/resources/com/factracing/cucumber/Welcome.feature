#Author: isabll muszynski

Feature: Input Name on Welcome View
  as a User
  I want to input my Name

  Scenario: Valid Inputs
    Given I navigate to "http://localhost:8080/"
    When I wait for 1 sec
    And I enter "Name" into input field having class "v-textfield"
    And I click on element having class "v-button"
