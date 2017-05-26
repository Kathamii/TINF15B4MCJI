package com.factracing.components;


import com.factracing.beans.GameRoom;
import com.factracing.beans.UserSession;
import com.factracing.ui.FactRacingUI;
import com.vaadin.server.UserError;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


public class PlayerManagementComponent extends VerticalLayout
{

	private GameRoom room;
	private int aiCount = 0; // amount of AI players in the room


	public PlayerManagementComponent(GameRoom room)
	{
		this.room = room;
		setSpacing(true);
		setMargin(true);
		setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		initializeLayout();
	}


	private void initializeLayout()
	{
		HorizontalLayout playerListWithButtons = createPlayerListLayout();
		HorizontalLayout gameRoomLinkLayout = createGameRoomLinkLayout();

		addComponents(playerListWithButtons, gameRoomLinkLayout);
	}


	/**
	 * Creates the upper layout with the player list and buttons on the right.
	 * 
	 * @return
	 */
	private HorizontalLayout createPlayerListLayout()
	{
		HorizontalLayout playerListWithButtons = new HorizontalLayout();
		playerListWithButtons.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

		ListSelect<String> playerList = createPlayerListComponent();
		VerticalLayout buttonLayout = createButtonsForPlayListLayout(playerList);

		playerListWithButtons.addComponents(playerList, buttonLayout);

		return playerListWithButtons;
	}


	/**
	 * Creates the text field that shows the URL you can give to other people to join the room.
	 * 
	 * @return
	 */
	private HorizontalLayout createGameRoomLinkLayout()
	{
		HorizontalLayout gameRoomLinkLayout = new HorizontalLayout();

		TextField linkField = new TextField("Room-URL:");
		linkField.setReadOnly(true);
		linkField.setWidth("575px");
		linkField.setValue("factracing.herokuapp.com/#" + room.getRoomID());

		gameRoomLinkLayout.addComponents(linkField);

		return gameRoomLinkLayout;
	}


	/**
	 * Creates the buttons on the right of the player list at the top.
	 * 
	 * @return
	 */
	private VerticalLayout createButtonsForPlayListLayout(ListSelect<String> playerList)
	{
		VerticalLayout buttonLayout = new VerticalLayout();
		buttonLayout.setDefaultComponentAlignment(Alignment.TOP_LEFT);

		Button addAIButton = createAddAIButton(playerList);
		Button kickButton = createKickButton();

		buttonLayout.addComponents(addAIButton, kickButton);

		return buttonLayout;
	}


	private Button createAddAIButton(ListSelect<String> playerList)
	{
		Button addAIButton = new Button("Add Computer");
		addAIButton.setWidth("150px");
		addAIButton.setId("createAIButton");
		addAIButton.addClickListener(e -> {
			if (room.getMaxPlayers() == room.getPlayerCount())
			{
				addAIButton.setComponentError(new UserError("Can't add more players!"));
				return;
			}
			UserSession newAI = new UserSession(true);
			newAI.setUserName("Comp" + aiCount++);
			room.addPlayer(newAI);
			playerList.setCaption(room.getPlayerCount() + "/" + room.getMaxPlayers() + " Players (" + room.getMinPlayers() + " Minimum)");
			playerList.setItems(room.getPlayerNames());
		});

		UserSession user = ((FactRacingUI) UI.getCurrent()).getUserSession();
		addAIButton.setVisible(room.getCreator().equals(user));

		return addAIButton;
	}


	private Button createKickButton()
	{
		Button kickButton = new Button("Kick");
		kickButton.setWidth("150px");
		return kickButton;
	}


	private ListSelect<String> createPlayerListComponent()
	{
		ListSelect<String> playerList = new ListSelect<>(
				room.getPlayerCount() + "/" + room.getMaxPlayers() + " Players (" + room.getMinPlayers() + " Minimum)");
		playerList.setItems(room.getPlayerNames());
		playerList.setWidth("355px");

		return playerList;
	}

}
