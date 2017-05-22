package com.factracing.beans;


import org.springframework.stereotype.Service;


@Service
public class Card
{

	private int difficulty;
	private String question;
	private String[] answers;
	private String correctAnswer;


	public Card(String question, String[] answers, String correctAnswer, int difficulty)
	{
		this.question = question;
		this.answers = answers;
		this.correctAnswer = correctAnswer;
		this.difficulty = difficulty;
	}


	public int getDifficulty()
	{
		return difficulty;
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
