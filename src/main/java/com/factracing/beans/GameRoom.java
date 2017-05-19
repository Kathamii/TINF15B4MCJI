package com.factracing.beans;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

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
	private UserSession creator;


	public GameRoom(UserSession creator)
	{
		roomID = UUID.randomUUID().toString();
		players = new ArrayList<>();
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
			return true;
		}
		return false;
	}


	public boolean removePlayer(UserSession player)
	{
		if (players.remove(player))
		{
			playerCount--;
			return true;
		}
		return false;
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
		Integer playerCount = new NumberValidator(minPlayers, maxPlayers).validate(this.playerCount);
		if(this.playerCount != playerCount)
			return false;
		if(decks.size() <= 0)
			return false;
		return true;
	}

}
