package com.factracing.ui;


import java.util.Iterator;
import java.util.Set;

import com.factracing.beans.Deck;
import com.factracing.beans.GameRoom;
import com.factracing.beans.UserSession;
import com.factracing.components.DeckChooser;
import com.factracing.components.GameRoomDeckChooserLayout;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.UserError;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


@SpringView(name = GameRoomView.VIEW_NAME)
public class GameRoomView extends VerticalLayout implements View
{

	public static final String VIEW_NAME = "gameRoom";

	private ListSelect<String> playerList;
	private int aiCount = 0; // amount of AI players in the room


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

		UserSession user = ((FactRacingUI) UI.getCurrent()).getUserSession();
		GameRoom room = user.getCurrentGameRoom();
		playerList = new ListSelect<>(
				room.getPlayerCount() + "/" + room.getMaxPlayers() + " Players (" + room.getMinPlayers() + " Minimum)");
		playerList.setItems(room.getPlayerNames());
		playerList.setWidth("350px");
		Button createAIButton = new Button("Add Computer");
		createAIButton.setId("createAIButton");
		createAIButton.addClickListener(e -> {
			if (room.getMaxPlayers() == room.getPlayerCount())
			{
				createAIButton.setComponentError(new UserError("Can't add more players!"));
				return;
			}
			UserSession newAI = new UserSession(true);
			newAI.setUserName("Comp" + aiCount++);
			room.addPlayer(newAI);
			playerList.setCaption(room.getPlayerCount() + "/" + room.getMaxPlayers() + " Players (" + room.getMinPlayers() + " Minimum)");
			playerList.setItems(room.getPlayerNames());
		});
		createAIButton.setVisible(room.getCreator().equals(user));
		GameRoomDeckChooserLayout deckChooserLayout = new GameRoomDeckChooserLayout(room);

		Button startGameButton = new Button("Start Game");
		startGameButton.setId("startGameButton");
		startGameButton.addClickListener(e -> {
			if (room.getPlayerCount() < room.getMinPlayers())
				return;
			if (room.getPlayerCount() > room.getMaxPlayers())
				return;
			UI.getCurrent().getNavigator().navigateTo(GameView.VIEW_NAME);
		});

		Button backButton = new Button("Leave");
		backButton.setId("leaveButton");
		backButton.addClickListener(e -> {
			UI.getCurrent().getNavigator().navigateTo(MainNavigationView.VIEW_NAME);
		});

		addComponents(factRacingLabel, createRoomLabel, playerList, createAIButton, deckChooserLayout, startGameButton, backButton);
	}


	@Override
	public void enter(ViewChangeEvent event)
	{
		// FactRacingUI.getUserSession().setCurrentGameRoom(room); Retrieve gameroom from database here and update stuff!
		UI.getCurrent().getPage().setTitle("Game Room - Fact Racing");
		initializeLayout();
	}

}
