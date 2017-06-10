package com.factracing.game;


import com.factracing.beans.Game;


public class GameThread extends Thread
{

	private long remainingTime;
	boolean isRunning;
	private Game game;


	public GameThread(Game game, long remainingTime)
	{
		this.game = game;
		this.remainingTime = remainingTime;
		isRunning = false;
	}


	@Override
	public void run()
	{
		isRunning = true;
		long lastUpdateTime = System.currentTimeMillis();
		while (isRunning)
		{
			long delta = System.currentTimeMillis() - lastUpdateTime;
			if (delta >= 500)
			{
				remainingTime -= delta;
				if (remainingTime <= 0L)
				{
					setRunning(false);
					game.fireGameEndEvent();
					break;
				}
				lastUpdateTime = System.currentTimeMillis();
				game.fireRemainingTimeUpdateEvent(remainingTime);
			}
		}
	}


	public boolean isRunning()
	{
		return isRunning;
	}


	public void setRunning(boolean isRunning)
	{
		this.isRunning = isRunning;
	}

}
