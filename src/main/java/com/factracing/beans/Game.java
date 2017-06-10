package com.factracing.beans;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.factracing.game.GameListener;
import com.factracing.game.GameThread;


public class Game
{

	private GameRoom room;
	private GameThread thread;
	private List<GameListener> listeners;
	private List<Card> questions;
	private int totalQuestions = 12;
	private Map<UserSession, Integer> userQuestionIndexMap;


	public Game(GameRoom room)
	{
		this.room = room;
		thread = new GameThread();
		listeners = new ArrayList<>();
		userQuestionIndexMap = new HashMap<>();
		for (UserSession user : room.getPlayers())
		{
			userQuestionIndexMap.put(user, 0);
		}
		generateQuestionOrder();
	}


	private void generateQuestionOrder()
	{
		questions = new ArrayList<>();
		List<Deck> decks = room.getUsedDecks();
		int questionsPerDeck = totalQuestions / decks.size();
		for (Deck deck : decks)
		{
			List<Card> cards = deck.getCards();
			for (int i = 0; i < questionsPerDeck; i++)
			{
				if(cards.size() <= 0)
					break;
				int rand = new Random().nextInt(cards.size());
				questions.add(cards.get(rand));
				cards.remove(rand);
			}
		}
	}


	public Card getNextQuestion(UserSession user)
	{
		int index = userQuestionIndexMap.get(user);
		Card question = questions.get(index);
		userQuestionIndexMap.put(user, index + 1);
		
		return question;
	}


	public void start()
	{
		thread.start();
	}


	public void register(GameListener listener)
	{
		listeners.add(listener);
	}

}
