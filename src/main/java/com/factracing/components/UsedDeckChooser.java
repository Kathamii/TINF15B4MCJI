package com.factracing.components;


import java.util.ArrayList;
import java.util.List;

import com.factracing.beans.Deck;
import com.factracing.beans.GameRoom;


public class UsedDeckChooser extends DeckChooser
{
	
	private static final String CAPTION = "In Use";

	public UsedDeckChooser(GameRoom room)
	{
		super(CAPTION, room);
	}


	@Override
	protected void update()
	{
		List<String> displayNames = new ArrayList<String>(getRoom().getUsedDecks().size());
		for (Deck deck : getRoom().getUsedDecks())
		{
			if (deck != null)
				displayNames.add(deck.getCategory());
		}
		setItems(displayNames);
	}


	@Override
	public List<Deck> getDecks()
	{
		return getRoom().getUsedDecks();
	}


	@Override
	protected void removeDecks(List<Deck> decks)
	{
		getRoom().removeFromUsedDecks(decks);
	}


	@Override
	protected void addDecks(List<Deck> decks)
	{
		getRoom().addToUsedDecks(decks);
	}

}
