package com.factracing.components;

import com.factracing.beans.UserSession;

public interface GameRoomListener
{
	
	public void playerRemoved();
	
	public void playerAdded();
	
	/**
	 * Called when the room is closed (usually creator leaves the room)
	 */
	public void roomClosed();
	
	public void gameStarted();

}
