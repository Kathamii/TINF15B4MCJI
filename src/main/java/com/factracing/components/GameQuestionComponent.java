package com.factracing.components;


import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;


public class GameQuestionComponent extends VerticalLayout
{
	
	public GameQuestionComponent()
	{
		setDefaultComponentAlignment(Alignment.TOP_LEFT);

		TextArea questionArea = new TextArea("Current Question:");
		questionArea.setEnabled(false);
		questionArea.setWidth("100%");

		ListSelect<String> questionList = new ListSelect<>("Choose an answer:");
		questionList.setWidth("100%");

		Button answerButton = new Button("Answer");

		addComponents(questionArea, questionList, answerButton);
		setComponentAlignment(answerButton, Alignment.MIDDLE_CENTER);
	}

}
