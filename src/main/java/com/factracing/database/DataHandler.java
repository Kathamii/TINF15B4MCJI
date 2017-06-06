package com.factracing.database;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.factracing.beans.GameRoom;
import com.factracing.beans.UserSession;
import com.factracing.ui.FactRacingUI;
import com.factracing.ui.GameRoomView;
import com.factracing.ui.MainNavigationView;


public class DataHandler
{

	private static List<UserSession> userList = new ArrayList<>();
	private static List<DataHandlerListener> listeners = new ArrayList<>();
	private static List<GameRoom> roomList = new ArrayList<>();


	public static void addUserToList(UserSession user)
	{
		userList.add(user);
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
			sendViewChangeToUserSession(user, MainNavigationView.VIEW_NAME);
		}
	}


	public static void removeUsersFromGameRoom(GameRoom room, UserSession... users)
	{
		if (room != null)
		{
			room.removePlayers(users);
			for (UserSession user : users)
				sendViewChangeToUserSession(user, MainNavigationView.VIEW_NAME);
		}
	}


	public static void joinRandomGameRoom(UserSession user)
	{
		GameRoom room = DataHandler.getRandomGameRoom();
		if (room == null)
			return;
		user.setCurrentGameRoom(room);
		DataHandler.addUserToGameRoom(user, user.getCurrentGameRoom().getRoomID());
		sendViewChangeToUserSession(user, GameRoomView.VIEW_NAME);
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


	private static GameRoom getRandomGameRoom()
	{
		if (roomList.size() > 0)
		{
			int rand = new Random().nextInt(roomList.size());
			return roomList.get(rand);
		}
		return null;
	}


	public static void register(DataHandlerListener listener)
	{
		listeners.add(listener);
	}


	public static void unregister(DataHandlerListener listener)
	{
		listeners.remove(listener);
	}


	private static void sendViewChangeToUserSession(UserSession session, String viewName)
	{
		for (DataHandlerListener listener : listeners)
		{
			FactRacingUI ui = (FactRacingUI) listener;
			if (ui.getUserSession().equals(session))
				ui.switchView(viewName);
		}
	}

}
