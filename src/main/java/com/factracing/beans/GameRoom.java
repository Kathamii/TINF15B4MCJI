package com.factracing.beans;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.factracing.components.GameRoomListener;
import com.factracing.database.DataHandler;
import com.factracing.validation.NumberValidator;


@Service
public class GameRoom
{

	private String roomID;
	private int minPlayers;
	private int maxPlayers;
	private int playerCount;
	private List<UserSession> players;
	private List<Deck> usedDecks;
	private List<Deck> availableDecks;
	private List<GameRoomListener> listeners;
	private UserSession creator;


	public GameRoom(UserSession creator)
	{
		roomID = UUID.randomUUID().toString();
		roomID = roomID.replaceAll("-", "");
		roomID = roomID.substring(0, 15);
		players = new ArrayList<>();
		listeners = new ArrayList<>();
		usedDecks = new ArrayList<>();
		availableDecks = Deck.DefaultDeck.getAllDefaultDecksAsList();
		this.creator = creator;
		addPlayer(creator);
	}


	public String getRoomID()
	{
		return roomID;
	}


	public void setRoomID(String id)
	{
		this.roomID = id;
	}


	public int getMinPlayers()
	{
		return minPlayers;
	}


	public void setMinPlayers(int minP)
	{
		this.minPlayers = minP;
	}


	public int getMaxPlayers()
	{
		return maxPlayers;
	}


	public void setMaxPlayers(int maxP)
	{
		this.maxPlayers = maxP;
	}


	public int getPlayerCount()
	{
		return playerCount;
	}


	public List<UserSession> getPlayers()
	{
		return players;
	}


	public List<String> getPlayerNames()
	{
		List<String> playerNames = new ArrayList<>(players.size());
		for (UserSession player : players)
		{
			playerNames.add(player.getUserName());
		}
		return playerNames;
	}


	public boolean addPlayer(UserSession player)
	{
		if (getPlayerByID(player.getUserID()) == null && players.add(player))
		{
			playerCount++;
			firePlayerAddedEvent();
			player.setCurrentGameRoom(this);
			return true;
		}
		return false;
	}


	public boolean addPlayers(UserSession... players)
	{
		boolean allPlayersAdded = true;
		int prevPlayerCount = playerCount;
		for (UserSession player : players)
		{
			if (getPlayerByID(player.getUserID()) == null && this.players.add(player))
			{
				playerCount++;
				player.setCurrentGameRoom(this);
				continue;
			}
			allPlayersAdded = false;
		}
		if (playerCount > prevPlayerCount)
			firePlayerAddedEvent();
		return allPlayersAdded;
	}


	public boolean removePlayer(UserSession player)
	{
		if (players.remove(player))
		{
			playerCount--;
			player.setCurrentGameRoom(null);
			firePlayerRemovedEvent();
			if (creator.equals(player))
				DataHandler.deleteRoom(this);
			return true;
		}
		return false;
	}


	public boolean removePlayers(UserSession... players)
	{
		boolean allPlayersRemoved = true;
		int prevPlayerCount = playerCount;
		for (UserSession player : players)
		{
			if (player == null)
				continue;
			if (this.players.remove(player))
			{
				playerCount--;
				player.setCurrentGameRoom(null);
				if (creator.equals(player))
					DataHandler.deleteRoom(this);
				continue;
			}
			allPlayersRemoved = false;
		}
		if (playerCount < prevPlayerCount)
			firePlayerRemovedEvent();
		return allPlayersRemoved;
	}


	public boolean removePlayer(String userID)
	{
		for (UserSession user : players)
		{
			if (user.getUserID().equals(userID))
				return removePlayer(user);
		}
		return false;
	}


	public UserSession getPlayerByID(String id)
	{
		for (UserSession player : players)
		{
			if (player == null)
				continue;
			if (player.getUserID().startsWith(id))
				return player;
		}
		return null;
	}


	public UserSession getCreator()
	{
		return creator;
	}


	public List<Deck> getUsedDecks()
	{
		return usedDecks;
	}


	public List<Deck> getAvailableDecks()
	{
		return availableDecks;
	}


	public void addToUsedDecks(List<Deck> decks)
	{
		this.usedDecks.addAll(decks);
		fireDecksChangedEvent();
	}


	public void addToAvailableDecks(List<Deck> availDecks)
	{
		this.availableDecks.addAll(availDecks);
		fireDecksChangedEvent();
	}


	public void removeFromUsedDecks(List<Deck> decks)
	{
		this.usedDecks.removeAll(decks);
		fireDecksChangedEvent();
	}


	public void removeFromAvailableDecks(List<Deck> availDecks)
	{
		this.availableDecks.removeAll(availDecks);
		fireDecksChangedEvent();
	}


	/**
	 * Checks whether the game room fits all the necessary requirements to start a game, i.e. correct player count and at least 1
	 * deck.
	 * 
	 * @return
	 */
	public boolean canStart()
	{
		Integer playerCountTest = new NumberValidator(minPlayers, maxPlayers).validate(this.playerCount);
		if (this.playerCount != playerCountTest)
			return false;
		if (usedDecks.size() <= 0)
			return false;
		return true;
	}


	private void firePlayerAddedEvent()
	{
		for (GameRoomListener listener : listeners)
		{
			listener.playerAdded();
		}
	}


	private void firePlayerRemovedEvent()
	{
		for (GameRoomListener listener : listeners)
		{
			listener.playerRemoved();
		}
	}


	private void fireDecksChangedEvent()
	{
		for (GameRoomListener listener : listeners)
		{
			listener.decksChanged();
		}
	}


	public void addGameRoomListener(GameRoomListener listener)
	{
		listeners.add(listener);
	}


	public void removeGameRoomListener(GameRoomListener listener)
	{
		listeners.remove(listener);
	}

}
