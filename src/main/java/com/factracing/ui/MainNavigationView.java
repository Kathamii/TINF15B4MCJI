package com.factracing.ui;


import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


public class MainNavigationView extends VerticalLayout implements View
{

	private Label welcomeLabel;


	public MainNavigationView()
	{
		setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

		Label factRacingLabel = new Label("<h1>Fact Racing<h1>", ContentMode.HTML);
		welcomeLabel = new Label("<h2><center>Welcome!<center><br><h2>", ContentMode.HTML);

		VerticalLayout buttonLayout = new VerticalLayout();
		buttonLayout.setSizeFull();
		buttonLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

		Button manualButton = new Button("Read Manual");
		manualButton.addClickListener(e -> {
		});

		Button joinRandomRoomButton = new Button("Join Random Game Room");
		manualButton.addClickListener(e -> {
		});

		Button createRoomButton = new Button("Create Game Room");
		manualButton.addClickListener(e -> {
		});

		Button changeNameButton = new Button("Change Name");
		manualButton.addClickListener(e -> {
		});

		buttonLayout.addComponents(manualButton, joinRandomRoomButton, createRoomButton);

		addComponents(factRacingLabel, welcomeLabel, buttonLayout, changeNameButton);
	}


	@Override
	public void enter(ViewChangeEvent event)
	{
		welcomeLabel.setValue("<h2><center>Welcome, <center><br>" + FactRacingUI.getUserSession().getUserName() + "!<h2>");
		UI.getCurrent().getPage().setTitle(FactRacingUI.getUserSession().getUserName() + " - Fact Racing");
	}

}
