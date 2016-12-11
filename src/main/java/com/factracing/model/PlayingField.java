package com.factracing.model;


import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.LinkedList;


@Entity
@Table(name = "PLAYINGFIELD")
public class PlayingField
{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPlayingField;

	@OneToMany(mappedBy = "")//TODO
	private LinkedList<PlayingFieldPos> positions;
	@OneToMany(mappedBy = "")//TODO
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

	public int getIdPlayingField() {
		return idPlayingField;
	}

	public void setIdPlayingField(int idPlayingField) {
		this.idPlayingField = idPlayingField;
	}
}
