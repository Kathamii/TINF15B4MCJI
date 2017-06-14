package com.factracing.components;


import java.util.List;

import com.factracing.beans.Deck;
import com.factracing.beans.GameRoom;
import com.vaadin.ui.ListSelect;


public abstract class DeckChooser extends ListSelect<String> implements GameRoomListener
{

	private static final String WIDTH = "200px";
	private GameRoom room;


	public DeckChooser(String caption, GameRoom room)
	{
		super(caption);
		this.room = room;
		setWidth(WIDTH);
		room.addGameRoomListener(this);
		update();
	}


	/**
	 * Updates the DeckChooser component with the current state of the list data.
	 */
	protected abstract void update();


	protected abstract List<Deck> getDecks();


	protected abstract void removeDecks(List<Deck> decks);


	protected abstract void addDecks(List<Deck> decks);


	protected Deck getDeckByName(String name)
	{
		for (Deck deck : getDecks())
		{
			if (deck == null)
				continue;
			if (deck.getCategory().equalsIgnoreCase(name))
			{
				return deck;
			}
		}
		return null;
	}


	protected GameRoom getRoom()
	{
		return room;
	}


	@Override
	public void playerRemoved()
	{

	}


	@Override
	public void playerAdded()
	{

	}

	@Override
	public void decksChanged()
	{
		update();
	}


	@Override
	public void gameStarted()
	{

	}
	
	@Override
	public void receiveChatMessage(String message)
	{

	}
	
}
