#Author: michi.buchwald@web.de



Feature: Join Random Game Room
  as a User
  I want to join a public random game room 

  Scenario: Valid Inputs
    Given I navigate to "http://localhost:8080/"
    And I wait for 3 sec
    Then I click on element having name "join"
    And I wait for 3 sec
    And I close browser
    
