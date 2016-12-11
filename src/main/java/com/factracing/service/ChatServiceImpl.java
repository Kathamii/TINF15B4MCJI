package com.factracing.service;

import com.factracing.dao.ChatDAO;
import com.factracing.model.Chat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    private ChatDAO chatDAO;

    public void setChatDAO(ChatDAO chatDAO) {
        this.chatDAO = chatDAO;
    }

    @Override
    @Transactional
    public void addChat(Chat c) {
        this.chatDAO.addChat(c);
    }

    @Override
    @Transactional
    public void updateChat(Chat c) {
        this.chatDAO.updateChat(c);
    }

    @Override
    @Transactional
    public List<Chat> listChats() {
        return this.chatDAO.listChats();
    }

    @Override
    @Transactional
    public Chat getChatById(int id) {
        return this.chatDAO.getChatById(id);
    }

    @Override
    @Transactional
    public void removeChat(int id) {
        this.chatDAO.removeChat(id);
    }

}
