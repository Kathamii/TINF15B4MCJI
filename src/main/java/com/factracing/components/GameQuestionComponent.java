package com.factracing.components;


import com.factracing.beans.Game;
import com.factracing.game.GameListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;


public class GameQuestionComponent extends VerticalLayout implements GameListener
{

	private Game game;


	public GameQuestionComponent(Game game)
	{
		this.game = game;
		game.register(this);
		
		setDefaultComponentAlignment(Alignment.TOP_LEFT);

		TextArea questionArea = new TextArea("Current Question:");
		questionArea.setEnabled(false);
		questionArea.setWidth("100%");

		ListSelect<String> questionList = new ListSelect<>("Choose an answer:");
		questionList.setWidth("100%");

		Button answerButton = new Button("Answer");
		answerButton.setWidth("150px");
		answerButton.setId("answerButton");

		addComponents(questionArea, questionList, answerButton);
		setComponentAlignment(answerButton, Alignment.MIDDLE_CENTER);
	}


	@Override
	public void remainingTimeUpdate(long remainingTime)
	{

	}

}
