package com.factracing.beans;


import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


@Service
public class PlayingField
{

	private List<PlayingFieldPos> positions;
	private List<PlayingPiece> playingPieces;


	public PlayingField()
	{
	}


	public List<PlayingFieldPos> getPositions()
	{
		return positions;
	}


	public void setPositions(List<PlayingFieldPos> positions)
	{
		this.positions = positions;
	}


	public List<PlayingPiece> getPlayingPieces()
	{
		return playingPieces;
	}


	public void setPlayingPieces(List<PlayingPiece> playingPieces)
	{
		this.playingPieces = playingPieces;
	}
}
