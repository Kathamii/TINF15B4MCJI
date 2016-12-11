package com.factracing.model;


import org.springframework.stereotype.Service;

import javax.persistence.*;


@Entity
@Table(name = "GAMEROOM")
public class GameRoom
{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idGameRoom;

	private int minP;
	private int maxP;
	private boolean join;
	private int players;

	public int getMinP()
	{
		return minP;
	}


	public void setMinP(int minP)
	{
		this.minP = minP;
	}


	public int getMaxP()
	{
		return maxP;
	}


	public void setMaxP(int maxP)
	{
		this.maxP = maxP;
	}


	public boolean isJoin()
	{
		return join;
	}


	public void setJoin(boolean join)
	{
		this.join = join;
	}


	public int getPlayers()
	{
		return players;
	}


	public void setPlayers(int players)
	{
		this.players = players;
	}

	public int getIdGameRoom() {
		return idGameRoom;
	}

	public void setIdGameRoom(int idGameRoom) {
		this.idGameRoom = idGameRoom;
	}
}
