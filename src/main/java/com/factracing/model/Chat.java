package com.factracing.model;


import org.springframework.stereotype.Service;

import javax.persistence.*;


@Entity
@Table(name = "CHAT")
public class Chat
{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idChat;

	public Chat()
	{
	}

	public int getIdChat() {
		return idChat;
	}

	public void setIdChat(int idChat) {
		this.idChat = idChat;
	}
}
