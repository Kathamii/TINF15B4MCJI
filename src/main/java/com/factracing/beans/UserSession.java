package com.factracing.beans;


import org.springframework.stereotype.Service;


@Service
public class UserSession
{

	private PlayingPiece SID;
	private GameRoom currentGameRoom;
	private String userName;
	private boolean isAI;


	public UserSession()
	{
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
