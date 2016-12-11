package com.factracing.model;


import org.springframework.stereotype.Service;

import javax.persistence.*;


@Entity
@Table(name = "PLAYINGPIECE")
public class PlayingPiece
{

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPlayingPiece;

	@OneToOne(mappedBy = "")//TODO
	private PlayingFieldPos playingFieldPos;
	private int points;


	public PlayingPiece()
	{
	}


	public PlayingFieldPos getPlayingFieldPos()
	{
		return playingFieldPos;
	}


	public void setPlayingFieldPos(PlayingFieldPos playingFieldPos)
	{
		this.playingFieldPos = playingFieldPos;
	}


	public int getPoints()
	{
		return points;
	}


	public void setPoints(int points)
	{
		this.points = points;
	}

	public int getIdPlayingPiece() {
		return idPlayingPiece;
	}

	public void setIdPlayingPiece(int idPlayingPiece) {
		this.idPlayingPiece = idPlayingPiece;
	}
}
