package com.factracing;


import org.springframework.stereotype.Service;


@Service
public class UserSession
{

	private PlayingPiece SID;
	private GameRoom GRID;
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


	public GameRoom getGRID()
	{
		return GRID;
	}


	public void setGRID(GameRoom GRID)
	{
		this.GRID = GRID;
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
