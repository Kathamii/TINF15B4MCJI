package com.factracing.components;


import java.util.Iterator;
import java.util.Set;

import com.factracing.beans.Deck;
import com.factracing.beans.GameRoom;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;


public class GameRoomDeckChooserLayout extends HorizontalLayout
{

	private GameRoom room;
	private DeckChooser availableDecks;
	private DeckChooser usedDecks;


	public GameRoomDeckChooserLayout()
	{
		setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

		usedDecks = new DeckChooser("In Use");
		availableDecks = new DeckChooser("Available");
		availableDecks.addDecks(Deck.DefaultDeck.getAllDefaultDecks());

		VerticalLayout buttonLayout = new VerticalLayout();
		Button addButton = createAddDeckButton();
		Button removeButton = createRemoveDeckButton();

		buttonLayout.addComponents(addButton, removeButton);

		addComponents(availableDecks, buttonLayout, usedDecks);
	}


	public GameRoomDeckChooserLayout(GameRoom room)
	{
		this();
		this.room = room;
		for (Deck deck : room.getDecks())
		{
			if (deck == null)
				continue;
			usedDecks.addDeck(deck);
			// remove decks from available list that have already been added to the In Use list
			Deck deck2 = availableDecks.getDeckByName(deck.getCategory());
			availableDecks.removeDeck(deck2);
		}
	}


	/**
	 * The button that allows you to add decks to the game room.
	 * 
	 * @param usedDecks
	 * @param availableDecks
	 * @return
	 */
	private Button createAddDeckButton()
	{
		Button addButton = new Button(VaadinIcons.ARROW_RIGHT);
		addButton.setId("addDeckButton");
		addButton.setWidth("100px");
		addButton.addClickListener(e -> {
			swapSelectedDecks(availableDecks, usedDecks);
		});
		availableDecks.addSelectionListener(event -> {
			if (event.getAllSelectedItems().size() > 0)
			{
				addButton.setEnabled(true);
				usedDecks.deselectAll();
				return;
			}
			addButton.setEnabled(false);
		});
		addButton.setEnabled(false);
		return addButton;
	}


	/**
	 * The button that allows you to remove decks from the game room.
	 * 
	 * @param usedDecks
	 * @param availableDecks
	 * @return
	 */
	private Button createRemoveDeckButton()
	{
		Button removeButton = new Button(VaadinIcons.ARROW_LEFT);
		removeButton.setId("removeDeckButton");
		removeButton.setWidth("100px");
		removeButton.addClickListener(e -> {
			swapSelectedDecks(usedDecks, availableDecks);
		});
		usedDecks.addSelectionListener(event -> {
			if (event.getAllSelectedItems().size() > 0)
			{
				removeButton.setEnabled(true);
				availableDecks.deselectAll();
				return;
			}
			removeButton.setEnabled(false);
		});
		removeButton.setEnabled(false);
		return removeButton;
	}


	private void swapSelectedDecks(DeckChooser chooserToRemoveFrom, DeckChooser chooserToAddTo)
	{
		Set<String> selectedDecks = chooserToRemoveFrom.getSelectedItems();
		Iterator<String> it = selectedDecks.iterator();
		Deck[] decks = new Deck[chooserToRemoveFrom.getDeckCount()];
		for (int i = 0; it.hasNext(); i++)
		{
			String item = it.next();
			Deck deck = chooserToRemoveFrom.getDeckByName(item);
			decks[i] = deck;
		}
		chooserToRemoveFrom.removeDecks(decks);
		chooserToAddTo.addDecks(decks);
		if (room != null)
			room.setDecks(chooserToAddTo.getDecks());
	}


	public DeckChooser getAvailableDecksDeckChooser()
	{
		return availableDecks;
	}


	public DeckChooser getUsedDecksDeckChooser()
	{
		return usedDecks;
	}


	public GameRoom getRoom()
	{
		return room;
	}


	public void setRoom(GameRoom room)
	{
		this.room = room;
	}

}
