package com.factracing.model;


import com.factracing.Dice;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.LinkedList;


@Entity
@Table(name = "GAME")
public class Game
{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idGame;

	@OneToMany(mappedBy = "")//TODO
	private LinkedList<Decks> decks;
	private Dice dice = new Dice();
	@OneToOne(mappedBy = "")//TODO
	private final PlayingField field;


	public Game()
	{
		// TODO
		field = null;
	}


	public LinkedList<Decks> getDecks()
	{
		return decks;
	}


	public void setDecks(LinkedList<Decks> decks)
	{
		this.decks = decks;
	}

	public int getIdGame() {
		return idGame;
	}

	public void setIdGame(int idGame) {
		this.idGame = idGame;
	}
}
