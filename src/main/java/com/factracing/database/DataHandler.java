package com.factracing.database;


import java.util.ArrayList;
import java.util.List;

import com.factracing.beans.GameRoom;
import com.factracing.beans.UserSession;


public class DataHandler
{

	private static List<UserSession> userList = new ArrayList<>();
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
