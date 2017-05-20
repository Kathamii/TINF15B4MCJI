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
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;


@SpringView(name = GameView.VIEW_NAME)
public class GameView extends VerticalLayout implements View
{

	public static final String VIEW_NAME = "gameView";


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

		VerticalLayout questionLayout = createQuestionLayout();
		VerticalLayout gameLayout = createGameLayout();
		VerticalLayout gameLogLayout = createGameLogLayout();

		gameFieldLayout.addComponents(questionLayout, gameLayout, gameLogLayout);
		
		// make sure that the gamefield gets the most space available
		gameFieldLayout.setExpandRatio(questionLayout, 1);
		gameFieldLayout.setExpandRatio(gameLayout, 3);
		gameFieldLayout.setExpandRatio(gameLogLayout, 1);

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
	private VerticalLayout createGameLayout()
	{
		VerticalLayout gameLayout = new VerticalLayout();
		gameLayout.setSizeFull();
		
		Panel gamePanel = new Panel("Game Field");
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


	/**
	 * Creates the log on the right of the playing field.
	 * 
	 * @return
	 */
	private VerticalLayout createGameLogLayout()
	{
		VerticalLayout gameLogLayout = new VerticalLayout();
		
		TextArea gameLog = new TextArea("Log:");
		gameLog.setEnabled(false);
		gameLog.setHeight("420px");
		gameLog.setWidth("100%");
		
		gameLogLayout.addComponent(gameLog);
		
		return gameLogLayout;
	}


	@Override
	public void enter(ViewChangeEvent event)
	{
		initializeLayout();
	}

}
