package com.factracing.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.factracing.beans.Deck;
import com.factracing.beans.GameRoom;
import com.factracing.components.DeckChooser;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = CreateGameRoomView.VIEW_NAME)
public class CreateGameRoomView extends VerticalLayout implements View {

	public static final String VIEW_NAME = "createGameRoom";

	public CreateGameRoomView() {
		setSpacing(true);
		setMargin(true);
		setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
	}

	/**
	 * Initializes layout on each enter.
	 */
	private void initializeLayout() {
		removeAllComponents();
		Label factRacingLabel = new Label("<h1>Fact Racing<h1>", ContentMode.HTML);
		Label createRoomLabel = new Label("<h2>Create Game Room<h2>", ContentMode.HTML);
		TextField minPlayersField = new TextField("Minimum Players:");
		minPlayersField.setValue("2");
		TextField maxPlayersField = new TextField("Maximum Players:");
		maxPlayersField.setValue("2");

		DeckChooser usedDecks = new DeckChooser("In Use");
		HorizontalLayout deckChooserLayout = createDeckChooserLayout(usedDecks);

		Button createRoomButton = new Button("Create Game Room");
		createRoomButton.addClickListener(e -> {
			GameRoom room = new GameRoom(((FactRacingUI) UI.getCurrent()).getUserSession());
			room.setMinPlayers(Integer.valueOf(minPlayersField.getValue()));
			room.setMaxPlayers(Integer.valueOf(maxPlayersField.getValue()));
			room.setDecks(usedDecks.getDecks());
			((FactRacingUI) UI.getCurrent()).getUserSession().setCurrentGameRoom(room);

			UI.getCurrent().getNavigator().navigateTo(GameRoomView.VIEW_NAME);
		});

		Button backButton = new Button("Back");
		backButton.addClickListener(e -> {
			UI.getCurrent().getNavigator().navigateTo(MainNavigationView.VIEW_NAME);
		});

		addComponents(factRacingLabel, createRoomLabel, minPlayersField, maxPlayersField, deckChooserLayout,
				createRoomButton, backButton);
	}

	/**
	 * Creates the deck chooser lists.
	 *
	 * @return
	 */
	private HorizontalLayout createDeckChooserLayout(DeckChooser usedDecks) {
		HorizontalLayout layout = new HorizontalLayout();
		layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

		DeckChooser availableDecks = new DeckChooser("Available");
		availableDecks.addDecks(new Deck("History"), new Deck("Cars"), new Deck("Animals"), new Deck("Math"));

		VerticalLayout buttonLayout = new VerticalLayout();
		Button addButton = new Button("-->");
		addButton.setWidth("100px");
		addButton.addClickListener(e -> {
			Set<String> selectedDecks = availableDecks.getSelectedItems();
			Iterator<String> it = selectedDecks.iterator();
			Deck[] decks = new Deck[availableDecks.getDeckCount()];
			for (int i = 0; it.hasNext(); i++) {
				String item = it.next();
				Deck deck = availableDecks.getDeckByName(item);
				decks[i] = deck;
			}
			availableDecks.removeDecks(decks);
			usedDecks.addDecks(decks);

		});

		Button removeButton = new Button("<--");
		removeButton.setWidth("100px");
		removeButton.addClickListener(e -> {
			Set<String> selectedDecks = usedDecks.getSelectedItems();
			Iterator<String> it = selectedDecks.iterator();
			Deck[] decks = new Deck[usedDecks.getDeckCount()];
			for (int i = 0; it.hasNext(); i++) {
				String item = it.next();
				Deck deck = usedDecks.getDeckByName(item);
				decks[i] = deck;
			}
			availableDecks.addDecks(decks);
			usedDecks.removeDecks(decks);
		});

		buttonLayout.addComponents(addButton, removeButton);

		layout.addComponents(availableDecks, buttonLayout, usedDecks);
		return layout;
	}

	@Override
	public void enter(ViewChangeEvent event) {
		UI.getCurrent().getPage().setTitle("Create Game Room - Fact Racing");
		initializeLayout();
	}

}
