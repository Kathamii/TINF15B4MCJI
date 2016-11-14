Feature: Enter game room by link
  as a User
  I want to enter a game room with a link

  Scenario: Invalid token in link
    Given I receive a link with a session-token
    And The session token is not valid
    When I press on the link
    Then I should see an error page with a message

  Scenario: Game room is full
    Given I receive a link with a session-token
    And The session-token is valid
    When I press on the link
    Then I should see an error page with a message

  Scenario: Name is not in cache
    Given I receive a link with a session-token
    And The session-token is valid
    And The game room is not full
    And The player name is not saved in cache
    When I press on the link
    Then I should see an "enter name"-field

  Scenario: Enter new player name
    Given I see an "enter name"-field
    When I enter my name
    Then I should see the game room
    And I should be added to the game room

  Scenario: Name is in cache
    Given I receive a link with a session-token
    And The session-token is valid
    And the game room is not full
    And The player name is saved in cache
    When I press on the link
    Then I should see the game room
    And I should be added to the game room