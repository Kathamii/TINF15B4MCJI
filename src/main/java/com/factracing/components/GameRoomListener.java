package com.factracing.components;


public interface GameRoomListener
{

	public void playerRemoved();


	public void playerAdded();


	public void decksChanged();


	public void gameStarted();
	
	
	public void receiveChatMessage(String message);

}
