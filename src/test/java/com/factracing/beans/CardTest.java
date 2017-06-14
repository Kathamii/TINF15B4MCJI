package com.factracing.beans;


import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class CardTest
{

	private static String QUESTION = "Where", CORRECT_ANSWER = "There";
	private static String[] ANSWERS = { "Somewhere", "Nowhere", "Everywhere" };
	private Card emptyCard = new Card("", 0, "");
	private Card simpleCard = new Card(QUESTION, 1, ANSWERS);


	@Test
	public void questionTest()
	{
		assertEquals("", emptyCard.getQuestion());
		assertEquals(QUESTION, simpleCard.getQuestion());
	}
}