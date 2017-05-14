package com.factracing.beans;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class GameRoom
{

	private long roomID;
	private int minPlayers;
	private int maxPlayers;
	private int playerCount;
	private List<UserSession> players;
	private UserSession creator;


	public GameRoom(UserSession creator)
	{
		players = new ArrayList<>();
		this.creator = creator;
		players.add(creator);
	}


	public long getRoomID()
	{
		return roomID;
	}


	public void setRoomID(long id)
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


	public void setPlayerCount(int playerCount)
	{
		this.playerCount = playerCount;
	}


	public List<UserSession> getPlayers()
	{
		return players;
	}


	public boolean addPlayer(UserSession player)
	{
		return players.add(player);
	}


	public boolean removePlayer(UserSession player)
	{
		return players.remove(player);
	}


	public UserSession getCreator()
	{
		return creator;
	}

}
