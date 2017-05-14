package com.factracing.beans;


import org.springframework.stereotype.Service;

import java.util.LinkedList;


@Service
public class Game
{

	private LinkedList<Deck> decks;
	private Dice dice = new Dice();
	private final PlayingField field;


	public Game()
	{
		// TODO
		field = null;
	}


	public LinkedList<Deck> getDecks()
	{
		return decks;
	}


	public void setDecks(LinkedList<Deck> decks)
	{
		this.decks = decks;
	}
}
