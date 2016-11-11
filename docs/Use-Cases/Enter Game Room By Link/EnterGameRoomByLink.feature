#Author: janikritz@gmail.com

Examples:
|min|max|decks|
|3|7|""|
|3|5|""|
|4|4|""|
|4|8|""|

Feature: Create Game Room
  as a User
  I want to create a Game Room with my Configurations

  Scenario: Valid Inputs
    Given Session with Name
    And On Main Page
    When click "Create Game Room" button
    And input <min> Minimum Players
    And input <max> Maximum Players
    And input <decks> Question Decks
    And click "Create" button
    Then Show created Game Room
    And Shown with <min> Players
    And  Shown with <max> Maximum Players
    And  Shown with <decks> Question Decks

  Scenario: Non-valid Inputs
    Given Session with Name
    And On Main Page
    When click "Create Game Room" button
    And input wrong data for configurations
    And click "Create" button
    Then Show create Game Room Page
    And Show configurations
    And Show errors

  Scenario: Cancel
    Given Session with Name
    And On Main Page
    When click "Create Game Room" button
    And input data for configurations
    And click "Cancel" button
    Then go to Main Page
