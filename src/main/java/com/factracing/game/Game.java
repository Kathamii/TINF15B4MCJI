package com.factracing.game;


import com.factracing.beans.GameRoom;


public class Game
{

	private GameRoom room;
	private GameThread thread;


	public Game(GameRoom room)
	{
		this.room = room;
		thread = new GameThread();
	}


	public void start()
	{
		thread.start();
	}

}
