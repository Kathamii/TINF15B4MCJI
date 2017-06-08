package com.factracing.components;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.factracing.beans.Deck;
import com.factracing.beans.GameRoom;
import com.factracing.ui.FactRacingUI;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


public class DeckChooserComponent extends HorizontalLayout
{

	private GameRoom room;
	private DeckChooser availableDecks;
	private DeckChooser usedDecks;


	public DeckChooserComponent(GameRoom room)
	{
		this.room = room;
		setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

		usedDecks = new UsedDeckChooser("In Use", room);
		availableDecks = new AvailableDeckChooser("Available", room);

		VerticalLayout buttonLayout = new VerticalLayout();
		Button addButton = createAddDeckButton();
		Button removeButton = createRemoveDeckButton();

		buttonLayout.addComponents(addButton, removeButton);

		addComponents(availableDecks, buttonLayout, usedDecks);

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
			if (room != null)
				if (!room.getCreator().equals(((FactRacingUI) UI.getCurrent()).getUserSession()))
					return;
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
			if (room != null)
				if (!room.getCreator().equals(((FactRacingUI) UI.getCurrent()).getUserSession()))
					return;
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
		List<Deck> decks = new ArrayList<>();
		while (it.hasNext())
		{
			String item = it.next();
			Deck deck = chooserToRemoveFrom.getDeckByName(item);
			decks.add(deck);
		}
		chooserToRemoveFrom.removeDecks(decks);
		chooserToAddTo.addDecks(decks);
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
