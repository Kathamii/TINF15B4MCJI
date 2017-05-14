package com.factracing.beans;


import org.springframework.stereotype.Service;


@Service
public class UserSession
{

	private PlayingPiece SID;
	private GameRoom currentGameRoom;
	private String userName;


	public UserSession()
	{
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
}
