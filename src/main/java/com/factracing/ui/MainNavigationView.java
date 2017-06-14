package com.factracing.ui;


import com.factracing.beans.UserSession;
import com.factracing.database.DataHandler;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.UserError;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;


@SpringView(name = MainNavigationView.VIEW_NAME)
public class MainNavigationView extends VerticalLayout implements View
{

	public static final String VIEW_NAME = "mainNav";

	private Label welcomeLabel;


	public MainNavigationView()
	{
		setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

		Label factRacingLabel = new Label("<h1>Fact Racing<h1>", ContentMode.HTML);
		welcomeLabel = new Label("<h2><center>Welcome!<center><br><h2>", ContentMode.HTML);

		VerticalLayout buttonLayout = createButtonLayout();
		VerticalLayout userConfigLayout = createConfigLayout();

		addComponents(factRacingLabel, welcomeLabel, buttonLayout, userConfigLayout);
	}


	@Override
	public void enter(ViewChangeEvent event)
	{
		// If the game room is already set then it means the user went here "illegally" or followed a game room link
		// In both cases they should be directed to the gameroomview which is going to display the correct data
		UserSession currentUser = ((FactRacingUI) UI.getCurrent()).getUserSession();
		if (currentUser.getCurrentGameRoom() != null)
		{
			DataHandler.addUserToGameRoom(currentUser, currentUser.getCurrentGameRoom().getRoomID());
			UI.getCurrent().getNavigator().navigateTo(GameRoomView.VIEW_NAME);
		}
		updateNameOnPage();
	}


	private void updateNameOnPage()
	{
		UserSession session = ((FactRacingUI) UI.getCurrent()).getUserSession();
		welcomeLabel.setValue("<h2><center>Welcome, <center><br>" + session.getUserName() + "!<h2>");
		UI.getCurrent().getPage().setTitle(session.getUserName() + " - Fact Racing");
	}


	/**
	 * Creates the buttons on the main navigation page.
	 *
	 * @return
	 */
	private VerticalLayout createButtonLayout()
	{
		VerticalLayout buttonLayout = new VerticalLayout();
		buttonLayout.setWidth("25%");
		buttonLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

		Button manualButton = new Button("Read Manual");
		manualButton.setId("manualButton");
		manualButton.setSizeFull();
		manualButton.addClickListener(e -> {
			showManualWindow();
		});

		Button joinRandomRoomButton = new Button("Join Random Game Room");
		joinRandomRoomButton.setId("randomRoomButton");
		joinRandomRoomButton.setSizeFull();
		joinRandomRoomButton.addClickListener(e -> {
			UserSession user = ((FactRacingUI) UI.getCurrent()).getUserSession();
			DataHandler.joinRandomGameRoom(user);
		});

		Button createRoomButton = new Button("Create Game Room");
		createRoomButton.setId("crateRoomButton");
		createRoomButton.setSizeFull();
		createRoomButton.addClickListener(e -> {
			UI.getCurrent().getNavigator().navigateTo(CreateGameRoomView.VIEW_NAME);
		});

		buttonLayout.addComponents(manualButton, joinRandomRoomButton, createRoomButton);

		return buttonLayout;
	}


	/**
	 * Creates the user specific buttons, at this point only name change.
	 *
	 * @return
	 */
	private VerticalLayout createConfigLayout()
	{
		VerticalLayout userConfigLayout = new VerticalLayout();
		userConfigLayout.setWidth("25%");

		Button changeNameButton = new Button("Change Name");
		changeNameButton.setId("changeNameButton");
		changeNameButton.setSizeFull();
		changeNameButton.addClickListener(e -> {
			Window popUp = new Window("Namechange");
			popUp.setWidth("40%");
			popUp.setHeight("30%");
			popUp.setResizable(false);
			popUp.center();
			popUp.setModal(true);

			VerticalLayout popUpLayout = new VerticalLayout();
			popUpLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

			Label welcomeLabel = new Label("<h2>What do you want your name to be?<h2>", ContentMode.HTML);
			final TextField nameField = new TextField();
			nameField.setValue(((FactRacingUI) UI.getCurrent()).getUserSession().getUserName());

			Button button = new Button("Use This Name");
			button.setId("useNameButton");
			button.setClickShortcut(KeyCode.ENTER, 0);
			button.addClickListener(ev -> {
				String username = nameField.getValue();
				if (username == null || username.length() <= 0)
				{
					nameField.setComponentError(new UserError("Invalid name!"));
					return;
				}
				((FactRacingUI) UI.getCurrent()).updateUserSessionCookie(username);
				updateNameOnPage();
				popUp.close();
			});

			popUpLayout.addComponents(welcomeLabel, nameField, button);

			popUp.setContent(popUpLayout);
			UI.getCurrent().addWindow(popUp);
			nameField.setSelection(0, nameField.getValue().length());
		});

		userConfigLayout.addComponent(changeNameButton);

		return userConfigLayout;
	}


	private void showManualWindow()
	{
		Window popUp = new Window();
		popUp.setWidth("700px");
		popUp.setHeight("500px");
		popUp.setResizable(false);
		popUp.center();
		popUp.setModal(true);

		VerticalLayout popUpLayout = new VerticalLayout();
		popUpLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

		Label welcomeLabel = new Label("<h2>Fact Racing Manual<h2>", ContentMode.HTML);
		Label rule1 = new Label("1. Create a game room on your own or follow a link.");
		Label rule2 = new Label("2. In the game room the creator can choose the decks for the game.");
		Label rule3 = new Label("3. Use the chat to communicate with other players.");
		Label rule4 = new Label("4. Once everybody is ready the creator can switch to the game view.");
		Label rule5 = new Label("5. There you can play as many rounds as you want.");
		Label rule6 = new Label("6. Each round lasts for 60 seconds and has a set of 12 questions each.");
		Label rule7 = new Label("7. The goal is to answer as many questions correctly in the given amount of time.");
		Label rule8 = new Label("8. Once the time elapsed the round is over.");
		Label rule9 = new Label("9. The winner is the player that answered the most questions correctly.");

		popUpLayout.addComponent(welcomeLabel);
		popUpLayout.setDefaultComponentAlignment(Alignment.TOP_LEFT);
		popUpLayout.addComponents(rule1, rule2, rule3, rule4, rule5, rule6, rule7, rule8, rule9);

		popUp.setContent(popUpLayout);
		UI.getCurrent().addWindow(popUp);
	}

}
