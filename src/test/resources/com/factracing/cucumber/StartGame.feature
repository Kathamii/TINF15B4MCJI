Feature: Start Game
  as a User
  I want to start a game with my configurations

  Scenario: Valid Inputs
    Given I navigate to "http://localhost:8080/gameroom?minP=2&maxP=3"
    And I wait for 1 sec
    Then I click on element having name "minP"
    And I wait for 1 sec
    And I select "3" option by value from dropdown having name "minP"
    And I wait for 1 sec
    Then I click on element having name "maxP"
    And I wait for 1 sec
    And I select "5" option by value from dropdown having name "maxP"
    And I wait for 1 sec
    Then I select "sport" option by value from dropdown having name "decks"
    And I wait for 1 sec
    And I select "nature" option by value from dropdown having name "decks"
    And I wait for 1 sec
    And I select "sciene" option by value from dropdown having name "decks"
    And I wait for 1 sec
    Then I select "public" option by value from radio button group having name "visibility"
    And I wait for 1 sec
    Then I click on element having name "submit"
    And I wait for 1 sec
    And I close browser