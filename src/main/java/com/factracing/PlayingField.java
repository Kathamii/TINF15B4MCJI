package com.factracing;


import org.springframework.stereotype.Service;

import java.util.LinkedList;


@Service
public class PlayingField
{

	private LinkedList<PlayingFieldPos> positions;
	private LinkedList<PlayingPiece> playingPieces;


	public PlayingField()
	{
	}


	public LinkedList<PlayingFieldPos> getPositions()
	{
		return positions;
	}


	public void setPositions(LinkedList<PlayingFieldPos> positions)
	{
		this.positions = positions;
	}


	public LinkedList<PlayingPiece> getPlayingPieces()
	{
		return playingPieces;
	}


	public void setPlayingPieces(LinkedList<PlayingPiece> playingPieces)
	{
		this.playingPieces = playingPieces;
	}
}
