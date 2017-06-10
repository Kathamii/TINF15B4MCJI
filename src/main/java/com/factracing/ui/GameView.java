package com.factracing.ui;


import com.factracing.components.ChatComponent;
import com.factracing.database.DatabaseController;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import java.sql.SQLException;


@SpringView(name = GameView.VIEW_NAME)
public class GameView extends VerticalLayout implements View
{

	public static final String VIEW_NAME = "gameView";
	DatabaseController databaseController = new DatabaseController();


	public GameView()
	{
		setMargin(true);
		setDefaultComponentAlignment(Alignment.TOP_LEFT);
		setWidth("100%");
	}


	/**
	 * Initializes layout on each enter.
	 */
	private void initializeLayout()
	{
		removeAllComponents();
		Label factRacingLabel = new Label("<h1>Fact Racing<h1>", ContentMode.HTML);

		HorizontalLayout gameFieldLayout = createNewGameFieldLayout();

		addComponents(factRacingLabel, gameFieldLayout);
		setComponentAlignment(factRacingLabel, Alignment.MIDDLE_CENTER);
	}


	/**
	 * The top half of the layout that has all the game related stuff.
	 *
	 * @return
	 */
	private HorizontalLayout createNewGameFieldLayout()
	{
		HorizontalLayout gameFieldLayout = new HorizontalLayout();
		gameFieldLayout.setSizeFull();

		VerticalLayout statusLayout = createStatusLayout();
		VerticalLayout questionLayout = createQuestionLayout();
		ChatComponent chat = new ChatComponent(((FactRacingUI) UI.getCurrent()).getUserSession().getCurrentGameRoom());

		gameFieldLayout.addComponents(statusLayout, questionLayout, chat);

		// make sure that the question part gets the most space available
		gameFieldLayout.setExpandRatio(statusLayout, 1.25f);
		gameFieldLayout.setExpandRatio(questionLayout, 1.5f);
		gameFieldLayout.setExpandRatio(chat, 1.25f);

		return gameFieldLayout;
	}


	/**
	 * Creates the fields on the left for the current question.
	 *
	 * @return
	 */
	private VerticalLayout createQuestionLayout()
	{
		VerticalLayout questionLayout = new VerticalLayout();
		questionLayout.setDefaultComponentAlignment(Alignment.TOP_LEFT);

		TextArea questionArea = new TextArea("Current Question:");
		questionArea.setEnabled(false);
		questionArea.setWidth("100%");
		try
		{
			questionArea.setValue(databaseController.getQuestion());
		}
		catch (SQLException e)
		{

		}

		ListSelect<String> questionList = new ListSelect<>("Choose an answer:");
		questionList.setWidth("100%");

		Button answerButton = new Button("Answer");

		questionLayout.addComponents(questionArea, questionList, answerButton);
		questionLayout.setComponentAlignment(answerButton, Alignment.MIDDLE_CENTER);

		return questionLayout;
	}


	/**
	 * Creates the actual playing field.
	 *
	 * @return
	 */
	private VerticalLayout createStatusLayout()
	{
		VerticalLayout gameLayout = new VerticalLayout();
		gameLayout.setSizeFull();

		Panel gamePanel = new Panel("Status");
		gamePanel.setSizeFull();

		VerticalLayout panelContent = new VerticalLayout();
		panelContent.setSizeFull();

		Label placeHolderLabel = new Label("");
		placeHolderLabel.setHeight("420px");
		panelContent.addComponent(placeHolderLabel);

		gamePanel.setContent(panelContent);

		gameLayout.addComponent(gamePanel);

		return gameLayout;
	}


	@Override
	public void enter(ViewChangeEvent event)
	{
		initializeLayout();
	}

}
