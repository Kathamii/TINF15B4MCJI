package com.factracing.service;

import com.factracing.model.Chat;

import java.util.List;

public interface ChatService {
    void addChat(Chat p);

    void updateChat(Chat p);

    List<Chat> listChats();

    Chat getChatById(int id);

    void removeChat(int id);
}
