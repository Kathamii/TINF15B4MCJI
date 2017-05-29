package com.factracing.beans;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class Deck
{

	private String category;
	private List<Card> cards;


	public Deck(String category)
	{
		this.category = category;
		this.cards = new ArrayList<>();
	}


	public String getCategory()
	{
		return category;
	}


	public List<Card> getCards()
	{
		return cards;
	}


	public void setCards(List<Card> cards)
	{
		this.cards = cards;
	}


	public boolean addCard(Card card)
	{
		return cards.add(card);
	}


	public enum DefaultDeck
	{
		SPORTS("Sports"),
		MATH("Math"),
		ANIMALS("Animals"),
		HISTORY("History"),
		CARS("Cars");

		Deck deck;


		DefaultDeck(String category)
		{
			deck = new Deck(category);
		}


		public static Deck[] getAllDefaultDecks()
		{
			DefaultDeck[] defaultDecks = values();
			Deck[] decks = new Deck[defaultDecks.length];
			for (int i = 0; i < defaultDecks.length; i++)
			{
				decks[i] = defaultDecks[i].getDeck();
			}
			return decks;
		}


		public Deck getDeck()
		{
			return deck;
		}
	}
}
