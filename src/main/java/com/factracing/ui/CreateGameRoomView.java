package com.factracing.ui;


import com.factracing.beans.GameRoom;
import com.factracing.components.DeckChooserComponent;
import com.factracing.database.DataHandler;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


@SpringView(name = CreateGameRoomView.VIEW_NAME)
public class CreateGameRoomView extends VerticalLayout implements View
{

	public static final String VIEW_NAME = "createGameRoom";


	public CreateGameRoomView()
	{
		setSpacing(true);
		setMargin(true);
		setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
	}


	/**
	 * Initializes layout on each enter.
	 */
	private void initializeLayout()
	{
		removeAllComponents();
		Label factRacingLabel = new Label("<h1>Fact Racing<h1>", ContentMode.HTML);
		Label createRoomLabel = new Label("<h2>Create Game Room<h2>", ContentMode.HTML);
		TextField minPlayersField = new TextField("Minimum Players:");
		minPlayersField.setId("minPlayersField");
		minPlayersField.setValue("2");
		TextField maxPlayersField = new TextField("Maximum Players:");
		maxPlayersField.setId("maxPlayersField");
		maxPlayersField.setValue("2");

		GameRoom room = new GameRoom(((FactRacingUI) UI.getCurrent()).getUserSession());
		DeckChooserComponent deckChooserLayout = new DeckChooserComponent(room);

		Button createRoomButton = new Button("Create Game Room");
		createRoomButton.setId("createGameRoomButton");
		createRoomButton.addClickListener(e -> {
			room.setMinPlayers(Integer.valueOf(minPlayersField.getValue()));
			room.setMaxPlayers(Integer.valueOf(maxPlayersField.getValue()));
			((FactRacingUI) UI.getCurrent()).getUserSession().setCurrentGameRoom(room);
			DataHandler.addGameRoomToList(room);

			UI.getCurrent().getNavigator().navigateTo(GameRoomView.VIEW_NAME);
		});

		Button backButton = new Button("Back");
		backButton.setId("backButton");
		backButton.addClickListener(e -> {
			((FactRacingUI) UI.getCurrent()).getUserSession().setCurrentGameRoom(null);
			UI.getCurrent().getNavigator().navigateTo(MainNavigationView.VIEW_NAME);
		});

		addComponents(factRacingLabel, createRoomLabel, minPlayersField, maxPlayersField, deckChooserLayout, createRoomButton, backButton);
	}


	@Override
	public void enter(ViewChangeEvent event)
	{
		UI.getCurrent().getPage().setTitle("Create Game Room - Fact Racing");
		initializeLayout();
	}

}
