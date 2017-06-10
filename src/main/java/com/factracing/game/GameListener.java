package com.factracing.game;

import com.factracing.beans.Card;

public interface GameListener
{
	
	public void remainingTimeUpdate(long remainingTime);
	
	/**
	 * Game has started. The first question is given as a parameter.
	 * 
	 * @param question
	 */
	public void gameStart(Card question);
	
	public void gameEnd();
	
}
