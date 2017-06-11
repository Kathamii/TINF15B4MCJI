package com.factracing.beans;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.factracing.components.EndscreenWindow;
import com.factracing.database.DataHandler;
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
	private Map<UserSession, Integer> userCorrectQuestionsMap;
	private long remainingTime;
	private static final long TOTAL_SECONDS = 30;


	public Game(GameRoom room)
	{
		this.room = room;
		resetRemainingTime();
		thread = new GameThread(this, remainingTime);
		listeners = new ArrayList<>();
		resetUserDataMaps();
	}


	private void resetUserDataMaps()
	{
		userQuestionIndexMap = new HashMap<>();
		userCorrectQuestionsMap = new HashMap<>();
		for (UserSession user : room.getPlayers())
		{
			userQuestionIndexMap.put(user, 1);
			if (!user.isAI())
			{
				userCorrectQuestionsMap.put(user, 0);
				continue;
			}
			userCorrectQuestionsMap.put(user, new Random().nextInt(totalQuestions));
		}
	}


	private void generateQuestionOrder()
	{
		questions = new ArrayList<>();
		List<Deck> decks = room.getUsedDecks();
		int questionsPerDeck = totalQuestions / decks.size();
		for (Deck deck : decks)
		{
			List<Card> cards = deck.getCards();
			List<Integer> usedIndices = new ArrayList<>(cards.size());
			Random rng = new Random();
			for (int i = 0; i < questionsPerDeck; i++)
			{
				if (cards.size() <= 0)
					break;
				int rand = rng.nextInt(cards.size());
				// make sure the same question isn't used twice
				while (usedIndices.contains(rand))
					rand = rng.nextInt(cards.size());
				questions.add(cards.get(rand));
				usedIndices.add(rand);
			}
		}
		Collections.shuffle(questions);
	}


	private void resetRemainingTime()
	{
		remainingTime = (TOTAL_SECONDS) * 1000;
	}


	public long getRemainingTime()
	{
		return remainingTime;
	}


	public Card getNextQuestion(boolean prevAnswer, UserSession user)
	{
		if (prevAnswer)
			userCorrectQuestionsMap.put(user, userCorrectQuestionsMap.get(user) + 1);
		int index = userQuestionIndexMap.get(user);
		if (index >= totalQuestions)
		{
			userQuestionIndexMap.put(user, index + 1);
			return null;
		}
		Card question = questions.get(index);
		userQuestionIndexMap.put(user, index + 1);

		return question;
	}


	public int getAnsweredQuestionsCount(UserSession user)
	{
		return userQuestionIndexMap.get(user) - 1;
	}


	public int getCorrectQuestionsCount(UserSession user)
	{
		return userCorrectQuestionsMap.get(user);
	}


	public void start()
	{
		generateQuestionOrder();
		thread = new GameThread(this, remainingTime);
		thread.start();
		fireGameStartEvent();
	}


	private void end()
	{
		resetRemainingTime();
		for (UserSession user : room.getPlayers())
		{
			DataHandler.showWindowToUserSession(user, new EndscreenWindow(this));
		}
		resetUserDataMaps();
	}


	public List<UserSession> getLeaderboard()
	{
		List<UserSession> players = new ArrayList<>();
		players.addAll(room.getPlayers());

		players.sort(new Comparator<UserSession>() {

			public int compare(UserSession user1, UserSession user2)
			{
				return getCorrectQuestionsCount(user2) - getCorrectQuestionsCount(user1);
			}
		});
		return players;
	}


	public void register(GameListener listener)
	{
		listeners.add(listener);
	}


	public void fireGameStartEvent()
	{
		for (GameListener listener : listeners)
		{
			listener.gameStart(questions.get(0));
		}
	}


	public void fireRemainingTimeUpdateEvent(long remainingTime)
	{
		this.remainingTime = remainingTime;
		for (GameListener listener : listeners)
		{
			listener.remainingTimeUpdate(remainingTime);
		}
	}


	public void fireGameEndEvent()
	{
		for (GameListener listener : listeners)
		{
			listener.gameEnd();
		}
		end();
	}

}
