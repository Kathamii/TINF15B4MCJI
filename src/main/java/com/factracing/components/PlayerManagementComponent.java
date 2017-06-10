package com.factracing.components;


import com.factracing.beans.GameRoom;
import com.factracing.beans.UserSession;
import com.factracing.database.DataHandler;
import com.factracing.ui.FactRacingUI;
import com.factracing.ui.GameView;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;


public class PlayerManagementComponent extends VerticalLayout
{

	private GameRoom room;
	private int aiCount = 0; // amount of AI players in the room
	private static final String BUTTON_WIDTH = "150px";
	private PlayerList playerList;


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

		playerList = new PlayerList(room.getPlayerCount() + "/" + room.getMaxPlayers() + " Players (" + room.getMinPlayers() + " Minimum)",
				room);

		VerticalLayout buttonLayout = createButtonsForPlayerListLayout();

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
	private VerticalLayout createButtonsForPlayerListLayout()
	{
		VerticalLayout buttonLayout = new VerticalLayout();
		buttonLayout.setDefaultComponentAlignment(Alignment.TOP_LEFT);

		Button startGameButton = createStartGameButton();
		Button addAIButton = createAddAIButton();
		Button kickButton = createKickButton();
		Button leaveButton = createLeaveButton();

		buttonLayout.addComponents(startGameButton, addAIButton, kickButton, leaveButton);

		return buttonLayout;
	}


	private Button createStartGameButton()
	{
		Button startGameButton = new Button("Start Game");
		startGameButton.setWidth(BUTTON_WIDTH);
		startGameButton.setId("startGameButton");
		startGameButton.addClickListener(e -> {
			if (room.getPlayerCount() < room.getMinPlayers())
			{
				showTextPopUp("Not enough players!");
				return;
			}
			if (room.getPlayerCount() > room.getMaxPlayers())
			{
				showTextPopUp("Too many players!");
				return;
			}
			if (room.getUsedDecks().size() <= 0)
			{
				showTextPopUp("At least one deck is needed!");
				return;
			}
			room.start();
		});

		UserSession user = ((FactRacingUI) UI.getCurrent()).getUserSession();
		startGameButton.setEnabled(room.getCreator().equals(user));

		return startGameButton;
	}


	private Button createAddAIButton()
	{
		Button addAIButton = new Button("Add Computer");
		addAIButton.setWidth(BUTTON_WIDTH);
		addAIButton.setId("createAIButton");
		addAIButton.addClickListener(e -> {
			if (room.getMaxPlayers() == room.getPlayerCount())
			{
				showTextPopUp("Can't add more players!");
				return;
			}
			UserSession newAI = new UserSession(true);
			newAI.setUserName("Comp" + aiCount++);
			room.addPlayer(newAI);
		});

		UserSession user = ((FactRacingUI) UI.getCurrent()).getUserSession();
		addAIButton.setEnabled(room.getCreator().equals(user));

		return addAIButton;
	}


	private Button createKickButton()
	{
		Button kickButton = new Button("Kick");
		kickButton.setWidth(BUTTON_WIDTH);
		kickButton.setId("kickButton");
		kickButton.addClickListener(e -> {
			UserSession user = ((FactRacingUI) UI.getCurrent()).getUserSession();
			UserSession[] selectedPlayers = playerList.getSelectedPlayers();
			for (UserSession player : selectedPlayers)
			{
				if (user.equals(player))
				{
					showTextPopUp("You can't kick yourself!");
					return;
				}
			}
			DataHandler.removeUsersFromGameRoom(room, selectedPlayers);
		});

		UserSession user = ((FactRacingUI) UI.getCurrent()).getUserSession();
		kickButton.setEnabled(room.getCreator().equals(user));

		return kickButton;
	}


	private Button createLeaveButton()
	{
		Button leaveButton = new Button("Leave");
		leaveButton.setWidth(BUTTON_WIDTH);
		leaveButton.setId("leaveButton");
		leaveButton.addClickListener(e -> {
			UserSession user = ((FactRacingUI) UI.getCurrent()).getUserSession();
			DataHandler.removeUserFromGameRoom(user, room);
		});
		return leaveButton;
	}


	private void showTextPopUp(String text)
	{
		Window popUp = new Window("Warning");
		popUp.setWidth("20%");
		popUp.setHeight("20%");
		popUp.setResizable(false);
		popUp.center();
		popUp.setModal(true);

		VerticalLayout popUpLayout = new VerticalLayout();
		popUpLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

		Label welcomeLabel = new Label("<h2>" + text + "<h2>", ContentMode.HTML);

		Button button = new Button("Accept");
		button.setId("acceptButton");
		button.setClickShortcut(KeyCode.ENTER, 0);
		button.addClickListener(ev -> {
			popUp.close();
		});

		popUpLayout.addComponents(welcomeLabel, button);

		popUp.setContent(popUpLayout);
		UI.getCurrent().addWindow(popUp);
	}

}
