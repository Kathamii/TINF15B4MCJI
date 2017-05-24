package com.factracing.beans;


import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


@Service
public class Game
{

	private List<Deck> decks;
	private Dice dice = new Dice();
	private final PlayingField field;


	public Game()
	{
		// TODO
		field = null;
	}


	public List<Deck> getDecks()
	{
		return decks;
	}


	public void setDecks(List<Deck> decks)
	{
		this.decks = decks;
	}
}
