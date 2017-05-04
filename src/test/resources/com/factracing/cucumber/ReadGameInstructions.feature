Feature: Read Game Instructions
  as a User
  I want to read the manual and then go back to home/playing/creating/etc.

  Scenario: Navigate from Home
    Given I navigate to "http://localhost:8080/"
    And I wait for 1 sec
    And I click on element having name "read"
    And I wait for 1 sec
    Then I should see page title having partial text as "Instructions"
    And link having partial text "Back" should be present

  Scenario: Navigate from Home and Back
    Given I navigate to "http://localhost:8080/"
    And I wait for 1 sec
    And I click on element having name "read"
    And I wait for 1 sec
    And I click on element having id "back-link"
    And I wait for 1 sec
    Then I should see page title as "Fact Racing"

  Scenario: Navigate from Elsewhere to Instructions and back