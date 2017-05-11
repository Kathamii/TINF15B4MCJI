package com.factracing.beans;


import org.springframework.stereotype.Service;


@Service
public class PlayingPiece
{

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
}
