# Fact Racing - GamesCobold
# Use Case Specification: Enter game room by link
### Version 1.0

# Revision History

|Date       | Version |	Description   |	Author          |
|-----------|---------|---------------|-----------------|
|06/12/2016 |	1.0     |	Initial draft |	Christian Vogel |


# Table of Contents

1. Use-Case Name  
    1.1 Brief Description  
2. Flow of Events  
    2.1 Basic Flow  
    2.2 Alternative Flows  
3. Special Requirements  
    3.1 Actual Browser  
    3.2 Internet Connection  
4. Preconditions  
    4.1 Created a game room  
5. Postconditions  
    5.1 Started the game  
6. Extension Points  

# Use-Case Specification: Start game
## 1.    Use-Case Name
### 1.1   Brief Description
A user who created a game room could administrate the room. If the player is fine with the settings, he can start the game. For this use-case exists a fitting [.feature file](https://github.com/Kahmul/TINF15B4MCJI/src/test/resources/com/factracing/cucumber/StartGame.feature) written in Cucumber with tests for all Flows.

## 2.    Flow of Events
### 2.1   Basic Flow
![Use-case-diagramm](https://github.com/Kahmul/TINF15B4MCJI/blob/97644c27676cbafb3cf188fa0d4cdbc5345b8926/docs/Use-Cases/Start%20Game/Diagram-StartGame.png)
### 2.2   Alternative Flows
None
## 3.    Special Requirements
### 3.1   Actual Browser
The user needs to have an actual browser where “Fact Racing” is running.
### 3.2   Internet connection
The user needs to have an working internet connection.

## 4.   Preconditions
### 4.1   Created a game room
The user have to do at first the use case "Create Game Room".

## 5.    Postconditions
### 5.1   Started the game
The user has started the the game and a the game field is at the screen.

## 6.    Extension Points
None
