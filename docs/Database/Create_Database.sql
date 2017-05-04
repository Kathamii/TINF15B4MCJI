-- Tabellen mit gleichen Namen loeschen

DROP TABLE IF EXISTS Spielfigur;
DROP TABLE IF EXISTS Game;
DROP TABLE IF EXISTS BrowserSession;
DROP TABLE IF EXISTS UserSession;
DROP TABLE IF EXISTS GameRoom;
DROP TABLE IF EXISTS Deck;
DROP TABLE IF EXISTS GameRoom_Deck;


CREATE TABLE Spielfigur
(
  SpielfigurID INTEGER PRIMARY KEY,
  SpielerID    INTEGER REFERENCES UserSession ON DELETE SET NULL,
  Position     INTEGER,
  nextPlayer   INTEGER,
  anwesend     BOOL
);

CREATE TABLE Game
(
  GameID       INTEGER PRIMARY KEY,
  Runde        INTEGER,
  ActivePlayer INTEGER REFERENCES UserSession ON DELETE SET NULL
);

CREATE TABLE BrowserSession
(
  SessionID INTEGER PRIMARY KEY
);

CREATE TABLE UserSession
(
  SpielerID    INTEGER PRIMARY KEY,
  GameRoomID   INTEGER REFERENCES GameRoom ON DELETE SET NULL,
  Name         VARCHAR(20),
  lastGameRoom INTEGER,
  activeFlag   BOOL
);

CREATE TABLE GameRoom
(
  GameRoomID INTEGER PRIMARY KEY,
  minPlayers INTEGER,
  maxPlayers INTEGER CHECK (minPlayers <= GameRoom.maxPlayers),
  gameId     INTEGER REFERENCES Game ON DELETE SET NULL,
  canJoin    BOOL,
  ended      BOOL
);

CREATE TABLE GameRoom_Deck
(
  GameRoom_DeckID INTEGER PRIMARY KEY,
  GameRoomID      INTEGER REFERENCES GameRoom ON DELETE CASCADE,
  DeckID          INTEGER REFERENCES Deck ON DELETE CASCADE
);

CREATE TABLE Deck
(
  DeckID        INTEGER PRIMARY KEY,
  Name          VARCHAR(20),
  Category      VARCHAR(30),
  File          VARCHAR(50),
  NumberOfCards INTEGER CHECK (NumberOfCards >= 0)
);