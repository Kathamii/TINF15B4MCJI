package com.factracing.ui;


import com.factracing.beans.UserSession;
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
		Label rule1 = new Label("1. Everybody starts on the field in the top left corner.");
		Label rule2 = new Label("2. The starting player is decided at random.");
		Label rule3 = new Label("3. If it's your turn, you first roll your dice before moving.");
		Label rule4 = new Label("4. Red fields are easy questions, black fields are hard questions.");
		Label rule5 = new Label("5. If you get the question right, you get points.");
		Label rule6 = new Label("6. If you get the question wrong, you get a penalty.");
		Label rule7 = new Label("7. If you complete a round, you get points.");
		Label rule8 = new Label("8. Accumulating a certain amount of points will win you the game.");
		Label rule9 = new Label("9. The game ends if there are no more questions. Winner is the player with the most points.");

		popUpLayout.addComponent(welcomeLabel);
		popUpLayout.setDefaultComponentAlignment(Alignment.TOP_LEFT);
		popUpLayout.addComponents(rule1, rule2, rule3, rule4, rule5, rule6, rule7, rule8, rule9);

		popUp.setContent(popUpLayout);
		UI.getCurrent().addWindow(popUp);
	}

}
