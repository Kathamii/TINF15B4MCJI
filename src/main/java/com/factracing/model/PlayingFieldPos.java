package com.factracing.model;


import com.factracing.Difficulty;
import org.springframework.stereotype.Service;

import javax.persistence.*;


@Entity
@Table(name = "PLAYINGFIELDPOS")
public class PlayingFieldPos
{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPlayingFieldPos;

	private Difficulty difficulty;
	@OneToOne(mappedBy = "")//TODO
	private int nextPos;


	public PlayingFieldPos()
	{
	}


	public Difficulty getDifficulty()
	{
		return difficulty;
	}


	public void setDifficulty(Difficulty difficulty)
	{
		this.difficulty = difficulty;
	}


	public int getNextPos()
	{
		return nextPos;
	}


	public void setNextPos(int nextPos)
	{
		this.nextPos = nextPos;
	}

	public int getIdPlayingFieldPos() {
		return idPlayingFieldPos;
	}

	public void setIdPlayingFieldPos(int idPlayingFieldPos) {
		this.idPlayingFieldPos = idPlayingFieldPos;
	}
}
