package com.factracing.ui;


import com.factracing.beans.GameRoom;
import com.factracing.beans.UserSession;
import com.factracing.components.ChatComponent;
import com.factracing.components.DeckChooserComponent;
import com.factracing.components.PlayerManagementComponent;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


@SpringView(name = GameRoomView.VIEW_NAME)
public class GameRoomView extends VerticalLayout implements View
{

	public static final String VIEW_NAME = "gameRoom";


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

		HorizontalLayout playerListAndChatLayout = createPlayerManagementAndChatLayout(room);
		DeckChooserComponent deckChooserLayout = new DeckChooserComponent(room);

		addComponents(factRacingLabel, createRoomLabel, playerListAndChatLayout, deckChooserLayout);
	}


	private HorizontalLayout createPlayerManagementAndChatLayout(GameRoom room)
	{
		HorizontalLayout playerListAndChatLayout = new HorizontalLayout();
		playerListAndChatLayout.setWidth("1100px");

		PlayerManagementComponent playerManagementComponent = new PlayerManagementComponent(room);
		ChatComponent chat = new ChatComponent(room, "257px");
		
		playerListAndChatLayout.addComponents(playerManagementComponent, chat);
		
		playerListAndChatLayout.setExpandRatio(playerManagementComponent, 1.25f);
		playerListAndChatLayout.setExpandRatio(chat, 1);

		return playerListAndChatLayout;
	}


	@Override
	public void enter(ViewChangeEvent event)
	{
		UI.getCurrent().getPage().setTitle("Game Room - Fact Racing");
		initializeLayout();
	}

}
