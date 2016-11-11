#Author: janikritz@gmail.com

Feature: Create Game Room
  as a User
  I want to create a Game Room with my Configurations

  Scenario: Valid Inputs
    Given Session with Name
    And On Main Page
    When click "Create Game Room" button
    And input data for configurations
    And click "Create" button
    Then Show created Game Room

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
