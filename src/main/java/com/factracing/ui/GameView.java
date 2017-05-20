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
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;


@SpringView(name = GameView.VIEW_NAME)
public class GameView extends VerticalLayout implements View
{

	public static final String VIEW_NAME = "gameView";


	public GameView()
	{
		setSpacing(true);
		setMargin(true);
		setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
	}


	/**
	 * Initializes layout on each enter.
	 */
	private void initializeLayout()
	{
		removeAllComponents();
		Label factRacingLabel = new Label("<h1>Fact Racing<h1>", ContentMode.HTML);
		Label roomLabel = new Label("<h2>Game Room<h2>", ContentMode.HTML);

		HorizontalLayout gameFieldLayout = createNewGameFieldLayout();

		addComponents(factRacingLabel, roomLabel, gameFieldLayout);
	}


	private HorizontalLayout createNewGameFieldLayout()
	{
		HorizontalLayout gameFieldLayout = new HorizontalLayout();

		VerticalLayout questionLayout = createQuestionLayout();
		VerticalLayout gameLayout = createGameLayout();
		VerticalLayout gameLogLayout = createGameLogLayout();

		gameFieldLayout.addComponents(questionLayout, gameLayout, gameLogLayout);

		return gameFieldLayout;
	}


	private VerticalLayout createQuestionLayout()
	{
		VerticalLayout questionLayout = new VerticalLayout();
		questionLayout.setDefaultComponentAlignment(Alignment.TOP_LEFT);

		TextArea questionArea = new TextArea();
		questionArea.setWidth("250px");

		ListSelect<String> questionList = new ListSelect<>();
		questionList.setWidth("250px");

		Button answerButton = new Button("Answer");

		questionLayout.addComponents(questionArea, questionList, answerButton);
		questionLayout.setComponentAlignment(answerButton, Alignment.MIDDLE_CENTER);

		return questionLayout;
	}


	private VerticalLayout createGameLayout()
	{
		VerticalLayout gameLayout = new VerticalLayout();
		return gameLayout;
	}


	private VerticalLayout createGameLogLayout()
	{
		VerticalLayout gameLogLayout = new VerticalLayout();
		return gameLogLayout;
	}


	@Override
	public void enter(ViewChangeEvent event)
	{
		initializeLayout();
	}

}
