Feature: Read Game Instructions
  as a User
  I want to read the manual and then go back to home/playing/creating/etc.

  Scenario: Navigate from Home
    Given I navigate to "http://localhost:8080/"
    And I wait for 1 sec
    And I enter "Name" into input field having class "v-textfield"
    And I click on element having class "v-button"
    And I wait for 1 sec
    And I click on element having class "v-button"
    And I wait for 1 sec
    Then An element with class "popupContent" exists

  Scenario: Navigate from Home and Back
    Given I navigate to "http://localhost:8080/"
    And I wait for 1 sec
    When I enter "Name" into input field having class "v-textfield"
    And I click on element having class "v-button"
    And I wait for 1 sec
    And I click on element having class "v-button"
    And I wait for 3 sec
    Then I click on element having class "v-window-closebox"
    And I wait for 1 sec
