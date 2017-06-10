package com.factracing.components;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.factracing.beans.GameRoom;
import com.factracing.beans.UserSession;
import com.vaadin.ui.ListSelect;


public class PlayerList extends ListSelect<String> implements GameRoomListener
{

	private static final String WIDTH = "355px";
	private GameRoom room;


	public PlayerList(String caption, GameRoom room)
	{
		super(caption);
		setWidth(WIDTH);

		this.room = room;
		room.addGameRoomListener(this);
		update();
		if(caption != null)
			setCaption(caption);
	}


	public UserSession[] getSelectedPlayers()
	{
		UserSession[] selectedPlayers = new UserSession[room.getPlayerCount()];
		Set<String> selectedPlayerSet = getSelectedItems();
		Iterator<String> it = selectedPlayerSet.iterator();
		for (int i = 0; it.hasNext(); i++)
		{
			String item = it.next();
			String userID = item.substring(item.indexOf("(") + 1, item.indexOf(")"));
			selectedPlayers[i] = room.getPlayerByID(userID);
		}
		return selectedPlayers;
	}


	/**
	 * Updates the ListSelect component with the current state of the list data.
	 */
	private void update()
	{
		List<String> displayNames = new ArrayList<String>(room.getPlayerCount());
		for (UserSession player : room.getPlayers())
		{
			if (player != null)
			{
				String name = player.getUserName() + " (" + player.getUserID().substring(0, 7) + ")";
				if (room.getCreator().equals(player))
					name += " <Creator>";
				displayNames.add(name);
			}
		}
		setItems(displayNames);
		setCaption(room.getPlayerCount() + "/" + room.getMaxPlayers() + " Players (" + room.getMinPlayers() + " Minimum)");
	}


	@Override
	public void playerRemoved()
	{
		update();
	}


	@Override
	public void playerAdded()
	{
		update();
	}


	@Override
	public void gameStarted()
	{
	}


	@Override
	public void decksChanged()
	{
	}


	@Override
	public void receiveChatMessage(String message)
	{
	}
}
