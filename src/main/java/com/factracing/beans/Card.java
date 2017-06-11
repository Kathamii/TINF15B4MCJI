package com.factracing.beans;


import org.springframework.stereotype.Service;


@Service
public class Card
{

	private String question;
	private String[] answers;
	private String correctAnswer;


	public Card(String question, int correctAnswer, String... answers)
	{
		this.question = question;
		this.answers = answers;
		this.correctAnswer = answers[correctAnswer];
	}


	public String getQuestion()
	{
		return question;
	}


	public String[] getAnswers()
	{
		return answers;
	}


	public String getCorrectAnswer()
	{
		return correctAnswer;
	}
}
