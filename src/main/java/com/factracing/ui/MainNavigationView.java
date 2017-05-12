package com.factracing.ui;


import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.UserError;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupView;
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
		welcomeLabel.setValue("<h2><center>Welcome, <center><br>" + FactRacingUI.getUserSession().getUserName() + "!<h2>");
		UI.getCurrent().getPage().setTitle(FactRacingUI.getUserSession().getUserName() + " - Fact Racing");
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
		manualButton.setSizeFull();
		manualButton.addClickListener(e -> {
		});

		Button joinRandomRoomButton = new Button("Join Random Game Room");
		joinRandomRoomButton.setSizeFull();
		manualButton.addClickListener(e -> {
		});

		Button createRoomButton = new Button("Create Game Room");
		createRoomButton.setSizeFull();
		manualButton.addClickListener(e -> {
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
			nameField.setValue(FactRacingUI.getUserSession().getUserName());

			Button button = new Button("Use this name");
			button.addClickListener(ev -> {
				String userName = nameField.getValue();
				if (userName == null || userName.length() <= 0)
				{
					nameField.setComponentError(new UserError("Invalid name!"));
					return;
				}
				FactRacingUI.getUserSession().setUserName(userName);
				popUp.close();
				enter(null); // change name on page and title
			});

			popUpLayout.addComponents(welcomeLabel, nameField, button);

			popUp.setContent(popUpLayout);

			UI.getCurrent().addWindow(popUp);
		});

		userConfigLayout.addComponent(changeNameButton);

		return userConfigLayout;
	}

}
