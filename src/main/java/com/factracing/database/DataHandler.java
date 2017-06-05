package com.factracing.database;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.factracing.beans.GameRoom;
import com.factracing.beans.UserSession;
import com.factracing.ui.MainNavigationView;
import com.vaadin.ui.UI;


public class DataHandler
{

	private static List<UserSession> userList = new ArrayList<>();
	private static Map<UserSession, UI> mapUserUI = new HashMap<>();
	private static List<GameRoom> roomList = new ArrayList<>();


	public static void addUserToList(UserSession user)
	{
		userList.add(user);
		mapUserUI.put(user, UI.getCurrent());
	}


	public static void addGameRoomToList(GameRoom room)
	{
		roomList.add(room);
	}


	public static void addUserToGameRoom(UserSession user, String roomID)
	{
		GameRoom room = getRoomByID(roomID);
		if (room != null)
			room.addPlayer(user);
	}


	public static void removeUserFromGameRoom(UserSession user, GameRoom room)
	{
		if (room != null)
		{
			room.removePlayer(user);
			UI ui = mapUserUI.get(user);
			if (ui != null)
				ui.getNavigator().navigateTo(MainNavigationView.VIEW_NAME);
		}
	}


	public static void removeUsersFromGameRoom(GameRoom room, UserSession... users)
	{
		if (room != null)
		{
			room.removePlayers(users);
			for (UserSession user : users)
			{
				UI ui = mapUserUI.get(user);
				if (ui != null)
					ui.getNavigator().navigateTo(MainNavigationView.VIEW_NAME);
			}
		}
	}


	public static void deleteRoom(GameRoom room)
	{
		for (UserSession player : room.getPlayers())
		{
			player.setCurrentGameRoom(null);
		}
		roomList.remove(room);
	}


	public static boolean doesRoomExist(String roomID)
	{
		return getRoomByID(roomID) != null;
	}


	public static GameRoom getRoomByID(String roomID)
	{
		for (GameRoom gameRoom : roomList)
		{
			if (gameRoom.getRoomID().equals(roomID))
				return gameRoom;
		}
		return null;
	}

}
