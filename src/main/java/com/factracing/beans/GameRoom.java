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
	private List<Deck> decks;
	private List<GameRoomListener> listeners;
	private UserSession creator;


	public GameRoom(UserSession creator)
	{
		roomID = UUID.randomUUID().toString();
		roomID = roomID.replaceAll("-", "");
		roomID = roomID.substring(0, 15);
		players = new ArrayList<>();
		listeners = new ArrayList<>();
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
		if (players.add(player))
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
		boolean atLeastOnePlayerAdded = false;
		for (UserSession player : players)
		{
			if (this.players.add(player))
			{
				playerCount++;
				player.setCurrentGameRoom(this);
				atLeastOnePlayerAdded = true;
				continue;
			}
			allPlayersAdded = false;
		}
		if (atLeastOnePlayerAdded)
			firePlayerAddedEvent();
		return allPlayersAdded;
	}


	public boolean removePlayer(UserSession player)
	{
		if (players.remove(player))
		{
			playerCount--;
			player.setCurrentGameRoom(null);
			if (creator.equals(player))
				DataHandler.deleteRoom(this);
			return true;
		}
		return false;
	}


	public boolean removePlayers(UserSession... players)
	{
		boolean allPlayersRemoved = true;
		boolean atLeastOnePlayerRemoved = false;
		for (UserSession player : players)
		{
			if (this.players.remove(player))
			{
				playerCount--;
				player.setCurrentGameRoom(null);
				if (creator.equals(player))
					DataHandler.deleteRoom(this);
				atLeastOnePlayerRemoved = true;
				continue;
			}
			allPlayersRemoved = false;
		}
		if (atLeastOnePlayerRemoved)
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


	public List<Deck> getDecks()
	{
		return decks;
	}


	public void setDecks(List<Deck> decks)
	{
		this.decks = decks;
	}


	public boolean addDeck(Deck deck)
	{
		return decks.add(deck);
	}


	public boolean removeDeck(Deck deck)
	{
		return decks.remove(deck);
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
		if (decks.size() <= 0)
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


	public void addGameRoomListener(GameRoomListener listener)
	{
		listeners.add(listener);
	}


	public void removeGameRoomListener(GameRoomListener listener)
	{
		listeners.remove(listener);
	}

}
