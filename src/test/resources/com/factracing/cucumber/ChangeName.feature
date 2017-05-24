#Author: isabll muszynski

Feature: Change Name in Navigation View
  as a User
  I want to change my Name

  Scenario: Valid Inputs
    Given I navigate to "http://localhost:8080/"
    And I wait for 1 sec
    And I enter "Name" into input field having class "v-textfield"
    And I click on element having class "v-button"
    When I wait for 1 sec
    And I click on element having class "v-button"
    And I wait for 1 sec
    Then An element with class "popupContent" exists
    And I wait for 1 sec
