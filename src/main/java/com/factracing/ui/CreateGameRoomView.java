package com.factracing.ui;


import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


@SpringView(name = CreateGameRoomView.VIEW_NAME)
public class CreateGameRoomView extends VerticalLayout implements View
{

	public static final String VIEW_NAME = "createGameRoom";


	public CreateGameRoomView()
	{
		setSpacing(true);
		setMargin(true);
		setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

		Label factRacingLabel = new Label("<h1>Fact Racing<h1>", ContentMode.HTML);
		Label createRoomLabel = new Label("<h2>Create Game Room<h2>", ContentMode.HTML);
		TextField minPlayersField = new TextField("Minimum Players:");
		TextField maxPlayersField = new TextField("Maximum Players:");

		HorizontalLayout deckChooserLayout = createDeckChooserLayout();

		Button createRoomButton = new Button("Create Game Room");
		createRoomButton.addClickListener(e -> {
		});

		Button backButton = new Button("Back");
		backButton.addClickListener(e -> {
			UI.getCurrent().getNavigator().navigateTo(MainNavigationView.VIEW_NAME);
		});

		addComponents(factRacingLabel, createRoomLabel, minPlayersField, maxPlayersField, deckChooserLayout, createRoomButton, backButton);
	}


	/**
	 * Creates the deck chooser lists.
	 * 
	 * @return
	 */
	private HorizontalLayout createDeckChooserLayout()
	{
		HorizontalLayout layout = new HorizontalLayout();
		layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

		ListSelect<String> availableDecks = new ListSelect<>("Available");
		availableDecks.setItems("Deck1", "Deck2", "Deck3");
		availableDecks.setWidth("150px");

		ListSelect<String> usedDecks = new ListSelect<>("In Use");
		usedDecks.setItems("Deck4", "Deck5", "Deck6");
		usedDecks.setWidth("150px");

		VerticalLayout buttonLayout = new VerticalLayout();
		Button removeButton = new Button("<--");
		removeButton.setWidth("100px");
		Button addButton = new Button("-->");
		addButton.setWidth("100px");

		buttonLayout.addComponents(removeButton, addButton);

		layout.addComponents(availableDecks, buttonLayout, usedDecks);
		return layout;
	}


	@Override
	public void enter(ViewChangeEvent event)
	{
		UI.getCurrent().getPage().setTitle("Create Game Room - Fact Racing");
	}

}
