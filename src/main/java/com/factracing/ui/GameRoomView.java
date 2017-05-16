package com.factracing.ui;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.factracing.beans.GameRoom;
import com.factracing.beans.UserSession;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


@SpringView(name = GameRoomView.VIEW_NAME)
public class GameRoomView extends VerticalLayout implements View
{

	public static final String VIEW_NAME = "gameRoom";

	private ListSelect<String> playerList;


	public GameRoomView()
	{
		setSpacing(true);
		setMargin(true);
		setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
	}


	/**
	 * Initializes layout.
	 */
	private void initializeLayout()
	{
		removeAllComponents();
		Label factRacingLabel = new Label("<h1>Fact Racing<h1>", ContentMode.HTML);
		Label createRoomLabel = new Label("<h2Game Room<h2>", ContentMode.HTML);

		GameRoom room = ((FactRacingUI) UI.getCurrent()).getUserSession().getCurrentGameRoom();
		playerList = new ListSelect<>(room.getPlayerCount() + "/" + room.getMaxPlayers() + " Players (" + room.getMinPlayers() + " Minimum)");
		playerList.setItems(room.getPlayerNames());
		playerList.setWidth("350px");
		HorizontalLayout deckChooserLayout = createDeckChooserLayout();

		Button startGameButton = new Button("Start Game");
		startGameButton.addClickListener(e -> {
			if(room.getPlayerCount() < room.getMinPlayers())
				return;
			if(room.getPlayerCount() > room.getMaxPlayers())
				return;
		});

		Button backButton = new Button("Leave");
		backButton.addClickListener(e -> {
			UI.getCurrent().getNavigator().navigateTo(MainNavigationView.VIEW_NAME);
		});

		addComponents(factRacingLabel, createRoomLabel, playerList, deckChooserLayout, startGameButton, backButton);
	}


	/**
	 * Creates the deck chooser lists.
	 *
	 * @return
	 */
	private HorizontalLayout createDeckChooserLayout()
	{
		HorizontalLayout layout = new HorizontalLayout();
		layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

		ListSelect<String> availableDecks = new ListSelect<>("Available");
		availableDecks.setWidth("150px");
		List<String> availableDeckList = new ArrayList<>(); // holds the items
		availableDeckList.add("History");
		availableDeckList.add("Cars");
		availableDeckList.add("Animals");
		availableDeckList.add("Math");
		availableDecks.setItems(availableDeckList);

		ListSelect<String> usedDecks = new ListSelect<>("In Use");
		usedDecks.setWidth("150px");
		List<String> usedDeckList = new ArrayList<>(); // holds the items

		VerticalLayout buttonLayout = new VerticalLayout();
		Button addButton = new Button("-->");
		addButton.setWidth("100px");
		addButton.addClickListener(e -> {
			Set<String> selectedDecks = availableDecks.getSelectedItems();
			Iterator<String> it = selectedDecks.iterator();
			while (it.hasNext())
			{
				String item = it.next();
				availableDeckList.remove(item);
				usedDeckList.add(item);
			}
			availableDecks.setItems(availableDeckList);
			usedDecks.setItems(usedDeckList);
		});

		Button removeButton = new Button("<--");
		removeButton.setWidth("100px");
		removeButton.addClickListener(e -> {
			Set<String> selectedDecks = usedDecks.getSelectedItems();
			Iterator<String> it = selectedDecks.iterator();
			while (it.hasNext())
			{
				String item = it.next();
				usedDeckList.remove(item);
				availableDeckList.add(item);
			}
			availableDecks.setItems(availableDeckList);
			usedDecks.setItems(usedDeckList);
		});

		buttonLayout.addComponents(addButton, removeButton);

		layout.addComponents(availableDecks, buttonLayout, usedDecks);
		return layout;
	}


	@Override
	public void enter(ViewChangeEvent event)
	{
		//FactRacingUI.getUserSession().setCurrentGameRoom(room); Retrieve gameroom from database here and update stuff!
		UI.getCurrent().getPage().setTitle("Game Room - Fact Racing");
		initializeLayout();
	}

}
