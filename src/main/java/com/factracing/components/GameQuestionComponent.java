package com.factracing.components;


import java.util.ArrayList;
import java.util.List;

import com.factracing.beans.Card;
import com.factracing.beans.Game;
import com.factracing.beans.UserSession;
import com.factracing.game.GameListener;
import com.factracing.ui.FactRacingUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


public class GameQuestionComponent extends VerticalLayout implements GameListener
{

	private Game game;
	private TextArea questionArea;
	private List<Button> answerButtons;
	private Card currentQuestion;


	public GameQuestionComponent(Game game)
	{
		this.game = game;
		game.register(this);

		setDefaultComponentAlignment(Alignment.TOP_LEFT);
		setSizeFull();

		questionArea = new TextArea("Current Question:");
		questionArea.setEnabled(false);
		questionArea.setWidth("100%");

		answerButtons = new ArrayList<>(4);
		for (int i = 0; i < 4; i++)
			answerButtons.add(createAnswerButton(i));

		HorizontalLayout upperButtons = createUpperButtonsLayout();
		HorizontalLayout lowerButtons = createLowerButtonsLayout();

		addComponents(questionArea, upperButtons, lowerButtons);
	}


	private HorizontalLayout createUpperButtonsLayout()
	{
		HorizontalLayout upperButtons = new HorizontalLayout();
		upperButtons.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		upperButtons.setSizeFull();
		upperButtons.setSpacing(true);
		upperButtons.setMargin(true);

		upperButtons.addComponents(answerButtons.get(0), answerButtons.get(1));

		return upperButtons;
	}


	private HorizontalLayout createLowerButtonsLayout()
	{
		HorizontalLayout lowerButtons = new HorizontalLayout();
		lowerButtons.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		lowerButtons.setSizeFull();
		lowerButtons.setSpacing(true);
		lowerButtons.setMargin(true);

		lowerButtons.addComponents(answerButtons.get(2), answerButtons.get(3));

		return lowerButtons;
	}


	private Button createAnswerButton(int index)
	{
		Button answerButton = new Button(String.valueOf(index + 1));
		answerButton.setSizeFull();
		answerButton.setId("answerButton" + index);
		answerButton.setEnabled(false);
		answerButton.addClickListener(event -> {
			String answer = answerButton.getCaption();

			boolean isAnswerCorrect = answer.equals(currentQuestion.getCorrectAnswer());
			UserSession user = ((FactRacingUI) UI.getCurrent()).getUserSession();

			updateQuestion(game.getNextQuestion(isAnswerCorrect, user));
		});

		return answerButton;
	}


	private void updateQuestion(Card question)
	{
		if(question == null) {
			questionArea.setValue("All questions answered!");
			for (int i = 0; i < 4; i++)
			{
				Button button = answerButtons.get(i);
				button.setCaption(String.valueOf(i + 1));
				button.setEnabled(false);
			}
			return;
		}
		currentQuestion = question;

		questionArea.setValue(question.getQuestion());
		for (int i = 0; i < 4; i++)
		{
			Button button = answerButtons.get(i);
			button.setCaption(question.getAnswers()[i]);
			button.setEnabled(true);
		}
	}


	@Override
	public void remainingTimeUpdate(long remainingTime)
	{

	}


	@Override
	public void gameStart(Card question)
	{
		updateQuestion(question);
	}


	@Override
	public void gameEnd()
	{
		questionArea.setValue("");
		for (int i = 0; i < 4; i++)
		{
			Button button = answerButtons.get(i);
			button.setCaption(String.valueOf(i + 1));
			button.setEnabled(false);
		}
	}

}
