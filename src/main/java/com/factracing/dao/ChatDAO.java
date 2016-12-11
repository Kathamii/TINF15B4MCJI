package com.factracing.dao;


import com.factracing.model.Chat;

import java.util.List;


public interface ChatDAO {
    void addChat(Chat c);

    void updateChat(Chat c);

    List<Chat> listChats();

    Chat getChatById(int id);

    void removeChat(int id);

}
