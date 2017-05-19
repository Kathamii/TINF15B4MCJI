package com.factracing.ui;


import com.factracing.validation.NameValidator;
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


@SpringView(name = WelcomeView.VIEW_NAME)
public class WelcomeView extends VerticalLayout implements View
{

	public static final String VIEW_NAME = "";


	public WelcomeView()
	{
		setMargin(true);
		setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

		Label factRacingLabel = new Label("<h1>Fact Racing<h1>", ContentMode.HTML);
		Label welcomeLabel = new Label("<h2><center>Welcome!<center><br>What's your name?<h2>", ContentMode.HTML);
		final TextField nameField = new TextField();

		Button button = new Button("Submit");
		button.setClickShortcut(KeyCode.ENTER, 0);
		button.addClickListener(e -> {
			String username = new NameValidator().validate(nameField.getValue());
			if (username == null)
			{
				nameField.setComponentError(new UserError("Invalid name!"));
				return;
			}
			((FactRacingUI) UI.getCurrent()).updateUserSessionCookie(username);
			UI.getCurrent().getNavigator().navigateTo(MainNavigationView.VIEW_NAME);
		});

		addComponents(factRacingLabel, welcomeLabel, nameField, button);
	}


	@Override
	public void enter(ViewChangeEvent event)
	{
		// if the user is already known don't allow him to go here
		if (((FactRacingUI) UI.getCurrent()).getUserSession().getUserName() != null)
		{
			UI.getCurrent().getNavigator().navigateTo(MainNavigationView.VIEW_NAME);
		}
	}

}
