package com.factracing.beans;


import java.util.UUID;

import org.springframework.stereotype.Service;

import com.factracing.ui.FactRacingUI;
import com.factracing.ui.MainNavigationView;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.UI;


@Service
public class UserSession
{

	private GameRoom currentGameRoom;
	private String userName;
	private String userID;
	private boolean isAI;


	public UserSession()
	{
		userID = UUID.randomUUID().toString();
		userID = userID.replaceAll("-", "");
		userID = userID.substring(0, 15);
	}


	public UserSession(boolean isAI)
	{
		this();
		this.isAI = isAI;
	}


	public GameRoom getCurrentGameRoom()
	{
		return currentGameRoom;
	}


	public void setCurrentGameRoom(GameRoom room)
	{
		currentGameRoom = room;
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
