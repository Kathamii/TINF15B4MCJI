package com.factracing.components;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.factracing.beans.GameRoom;
import com.factracing.beans.UserSession;
import com.vaadin.ui.ListSelect;


public class PlayerList extends ListSelect<String>
{

	private ArrayList<UserSession> playerList;
	private static final String WIDTH = "355px";
	private GameRoom room;


	public PlayerList(String caption, GameRoom room)
	{
		super(caption);
		setWidth(WIDTH);
		
		this.room = room;
		playerList = new ArrayList<>();
		addPlayers(room.getPlayers());
	}


	public void addPlayer(UserSession player)
	{
		playerList.add(player);
		update();
	}


	public void addPlayers(UserSession... players)
	{
		for (UserSession player : players)
		{
			playerList.add(player);
		}
		update();
	}
	
	public void addPlayers(List<UserSession> players)
	{
		for (UserSession player : players)
		{
			playerList.add(player);
		}
		update();
	}


	public void removePlayer(UserSession player)
	{
		playerList.remove(player);
		room.removePlayer(player);
		update();
	}


	public void removePlayers(UserSession... players)
	{
		for (UserSession player : players)
		{
			playerList.remove(player);
			room.removePlayer(player);
		}
		update();
	}


	public UserSession getPlayerByID(String id)
	{
		for (UserSession player : playerList)
		{
			if (player == null)
				continue;
			if (player.getUserID().startsWith(id))
				return player;
		}
		return null;
	}


	public List<UserSession> getPlayers()
	{
		return playerList;
	}


	public int getPlayerCount()
	{
		return playerList.size();
	}


	public UserSession[] getSelectedPlayers()
	{
		UserSession[] selectedPlayers = new UserSession[getPlayerCount()];
		Set<String> selectedPlayerSet = getSelectedItems();
		Iterator<String> it = selectedPlayerSet.iterator();
		for (int i = 0; it.hasNext(); i++)
		{
			String item = it.next();
			String userID = item.substring(item.indexOf("(") + 1, item.indexOf(")"));
			selectedPlayers[i] = getPlayerByID(userID);
		}
		return selectedPlayers;
	}


	/**
	 * Updates the ListSelect component with the current state of the list data.
	 */
	private void update()
	{
		List<String> displayNames = new ArrayList<String>(playerList.size());
		for (UserSession player : playerList)
		{
			if (player != null)
				displayNames.add(player.getUserName() + " (" + player.getUserID().substring(0, 7) + ")");
		}
		setItems(displayNames);
		setCaption(room.getPlayerCount() + "/" + room.getMinPlayers() + " Players (" + room.getMaxPlayers() + " Minimum)");
	}
}
