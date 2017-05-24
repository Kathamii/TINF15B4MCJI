package com.factracing.components;


import java.util.ArrayList;
import java.util.List;

import com.factracing.beans.Deck;
import com.vaadin.ui.ListSelect;


public class DeckChooser extends ListSelect<String>
{

	private ArrayList<Deck> deckList;
	private static final String WIDTH = "200px";


	public DeckChooser(String caption)
	{
		super(caption);
		deckList = new ArrayList<Deck>();
		setWidth(WIDTH);
	}


	public DeckChooser(String caption, Deck... decks)
	{
		this(caption);
		addDecks(decks);
	}


	public void addDeck(Deck deck)
	{
		deckList.add(deck);
		update();
	}


	public void addDecks(Deck... decks)
	{
		for (Deck deck : decks)
		{
			deckList.add(deck);
		}
		update();
	}


	public void removeDeck(Deck deck)
	{
		deckList.remove(deck);
		update();
	}


	public void removeDecks(Deck... decks)
	{
		for (Deck deck : decks)
		{
			deckList.remove(deck);
		}
		update();
	}


	public Deck getDeckByName(String name)
	{
		for (Deck deck : deckList)
		{
			if(deck == null)
				continue;
			if (deck.getCategory().equalsIgnoreCase(name))
			{
				return deck;
			}
		}
		return null;
	}


	public List<Deck> getDecks()
	{
		return deckList;
	}


	public int getDeckCount()
	{
		return deckList.size();
	}


	/**
	 * Updates the ListSelect component with the current state of the list data.
	 */
	private void update()
	{
		List<String> displayNames = new ArrayList<String>(deckList.size());
		for (Deck deck : deckList)
		{
			if (deck != null)
				displayNames.add(deck.getCategory());
		}
		setItems(displayNames);
	}
}
