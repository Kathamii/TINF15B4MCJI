package com.factracing.ui;


import org.springframework.context.annotation.Configuration;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.EnableVaadin;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


/**
 * This UI is the application entry point. A UI may either represent a browser window (or tab) or some part of a html page where a
 * Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be overridden to add component to the user
 * interface and initialize non-component functionality.
 */
@Theme("valo")
@SpringUI
public class FactRacingUI extends UI
{

	private Navigator navigator;


	@Configuration
	@EnableVaadin
	public static class MyConfiguration
	{
	}


	@Override
	protected void init(VaadinRequest vaadinRequest)
	{
		getPage().setTitle("Fact Racing");

		final VerticalLayout layout = new VerticalLayout();
		layout.setDefaultComponentAlignment(Alignment.TOP_CENTER);

		Label welcomeLabel = new Label("<h1>Fact Racing<h1>", ContentMode.HTML);
		Label nameLabel = new Label("<h2><center>Welcome!<center><br>What's your name?<h2>", ContentMode.HTML);
		final TextField nameField = new TextField();

		Button button = new Button("Use This Name");
		button.addClickListener(e -> {
		});

		layout.addComponents(welcomeLabel, nameLabel, nameField, button);

		setContent(layout);
	}
}
