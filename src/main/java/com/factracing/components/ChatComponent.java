package com.factracing.components;


import com.factracing.beans.GameRoom;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


public class ChatComponent extends VerticalLayout implements GameRoomListener
{

	private GameRoom room;
	private TextArea chatArea;


	public ChatComponent(GameRoom room)
	{
		this.room = room;
		room.addGameRoomListener(this);

		initChatArea();
		HorizontalLayout messageFieldLayout = createMessageFieldLayout();

		addComponents(chatArea, messageFieldLayout);
	}


	private void initChatArea()
	{
		chatArea = new TextArea("Chat:");
		chatArea.setEnabled(false);
		chatArea.setHeight("420px");
		chatArea.setWidth("100%");
	}


	private HorizontalLayout createMessageFieldLayout()
	{
		HorizontalLayout messageFieldLayout = new HorizontalLayout();
		messageFieldLayout.setWidth("100%");

		TextField messageField = new TextField();
		messageField.setSizeFull();
		Button sendButton = new Button("Send");
		sendButton.setSizeFull();
		sendButton.setId("sendButton");
		sendButton.setClickShortcut(KeyCode.ENTER, 0);
		sendButton.addClickListener(event -> {
			String message = messageField.getValue();
			if(message == null || message.trim().equals(""))
				return;
			messageField.clear();
			room.sendChatMessage(message);
		});

		messageFieldLayout.addComponents(messageField, sendButton);
		messageFieldLayout.setExpandRatio(messageField, 4);
		messageFieldLayout.setExpandRatio(sendButton, 1);

		return messageFieldLayout;
	}


	private void addNewMessage(String message)
	{
		UI.getCurrent().access(new Runnable() {

			@Override
			public void run()
			{
				chatArea.setValue(chatArea.getValue() + "\n " + message);
			}
		});
	}


	@Override
	public void playerRemoved()
	{
	}


	@Override
	public void playerAdded()
	{
	}


	@Override
	public void decksChanged()
	{
	}


	@Override
	public void gameStarted()
	{
	}


	@Override
	public void receiveChatMessage(String message)
	{
		addNewMessage(message);
	}

}
