package com.factracing.components;


import java.util.ArrayList;
import java.util.List;

import com.factracing.beans.Deck;
import com.factracing.beans.GameRoom;


public class AvailableDeckChooser extends DeckChooser
{
	
	private static final String CAPTION = "Available";

	public AvailableDeckChooser(GameRoom room)
	{
		super(CAPTION, room);
	}


	@Override
	protected void update()
	{
		List<String> displayNames = new ArrayList<String>(getRoom().getAvailableDecks().size());
		for (Deck deck : getRoom().getAvailableDecks())
		{
			if (deck != null)
				displayNames.add(deck.getCategory());
		}
		setItems(displayNames);
	}


	@Override
	public List<Deck> getDecks()
	{
		return getRoom().getAvailableDecks();
	}


	@Override
	protected void removeDecks(List<Deck> decks)
	{
		getRoom().removeFromAvailableDecks(decks);
	}


	@Override
	protected void addDecks(List<Deck> decks)
	{
		getRoom().addToAvailableDecks(decks);
	}

}
