package com.factracing.beans;


import java.util.UUID;

import org.springframework.stereotype.Service;


@Service
public class UserSession
{

	private PlayingPiece SID;
	private GameRoom currentGameRoom;
	private String userName;
	private String userID;
	private boolean isAI;


	public UserSession()
	{
		userID = UUID.randomUUID().toString();
	}


	public UserSession(boolean isAI)
	{
		this.isAI = isAI;
	}


	public PlayingPiece getSID()
	{
		return SID;
	}


	public void setSID(PlayingPiece SID)
	{
		this.SID = SID;
	}


	public GameRoom getCurrentGameRoom()
	{
		return currentGameRoom;
	}


	public void setCurrentGameRoom(GameRoom room)
	{
		this.currentGameRoom = room;
	}


	
	/**
	 * @return the userID
	 */
	public String getUserID()
	{
		return userID;
	}


	public String getUserName()
	{
		return userName;
	}


	public void setUserName(String userName)
	{
		this.userName = userName;
	}


	/**
	 * Whether this user is an AI or not.
	 * 
	 * @return
	 */
	public boolean isAI()
	{
		return isAI;
	}

}
