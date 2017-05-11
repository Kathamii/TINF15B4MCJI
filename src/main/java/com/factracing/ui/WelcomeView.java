package com.factracing.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;


public class WelcomeView extends VerticalLayout implements View
{
	
	public WelcomeView()
	{
		setDefaultComponentAlignment(Alignment.TOP_CENTER);

		Label welcomeLabel = new Label("<h1>Fact Racing<h1>", ContentMode.HTML);
		Label nameLabel = new Label("<h2><center>Welcome!<center><br>What's your name?<h2>", ContentMode.HTML);
		final TextField nameField = new TextField();

		Button button = new Button("Use");
		button.addClickListener(e -> {
			FactRacingUI.navigator.navigateTo("mainNav");
		});

		addComponents(welcomeLabel, nameLabel, nameField, button);
	}

	@Override
	public void enter(ViewChangeEvent event)
	{

	}

}
