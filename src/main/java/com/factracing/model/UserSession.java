package com.factracing.model;


import org.springframework.stereotype.Service;

import javax.persistence.*;


@Entity
@Table(name = "USERSESSION")
public class UserSession
{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUserSession;

	@OneToOne(mappedBy = "")//TODO
	private PlayingPiece SID;
	@OneToOne(mappedBy = "")//TODO
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

	public int getIdUserSession() {
		return idUserSession;
	}

	public void setIdUserSession(int idUserSession) {
		this.idUserSession = idUserSession;
	}
}
