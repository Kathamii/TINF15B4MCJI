package com.factracing.components;


import com.factracing.beans.GameRoom;
import com.factracing.beans.UserSession;
import com.factracing.ui.FactRacingUI;
import com.vaadin.server.UserError;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ListSelect;
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
		ListSelect<String> playerList = createPlayerListComponent();
		Button addAIButton = createAddAIButton(playerList);
		UserSession user = ((FactRacingUI) UI.getCurrent()).getUserSession();
		addAIButton.setVisible(room.getCreator().equals(user));

		addComponents(playerList, addAIButton);
	}


	private Button createAddAIButton(ListSelect<String> playerList)
	{
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
		return createAIButton;
	}


	private ListSelect<String> createPlayerListComponent()
	{
		ListSelect<String> playerList = new ListSelect<>(
				room.getPlayerCount() + "/" + room.getMaxPlayers() + " Players (" + room.getMinPlayers() + " Minimum)");
		playerList.setItems(room.getPlayerNames());
		playerList.setWidth("350px");
		return playerList;
	}

}
