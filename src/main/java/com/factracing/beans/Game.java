package com.factracing.beans;


import java.util.ArrayList;
import java.util.List;

import com.factracing.game.GameListener;
import com.factracing.game.GameThread;


public class Game
{

	private GameRoom room;
	private GameThread thread;
	private List<GameListener> listeners;


	public Game(GameRoom room)
	{
		this.room = room;
		thread = new GameThread();
		listeners = new ArrayList<>();
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
