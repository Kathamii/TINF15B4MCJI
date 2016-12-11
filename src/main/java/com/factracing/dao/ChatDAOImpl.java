package com.factracing.dao;


import com.factracing.model.Chat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChatDAOImpl implements ChatDAO {
    private static final Logger logger = LoggerFactory.getLogger(ChatDAOImpl.class);
    private SessionFactory sessionFactory;
    private ChatDAOImpl chatDAO;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addChat(Chat p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Chat saved successfully, Chat Details=" + p);
    }

    @Override
    public void updateChat(Chat p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Chat updated successfully, Chat Details=" + p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Chat> listChats() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Chat> ChatsList = session.createQuery("from Chat").list();
        for (Chat p : ChatsList) {
            logger.info("Chat List::" + p);
        }
        return ChatsList;
    }

    @Override
    public Chat getChatById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Chat p = session.load(Chat.class, new Integer(id));
        logger.info("Chat loaded successfully, Chat details=" + p);
        return p;
    }

    @Override
    public void removeChat(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Chat p = session.load(Chat.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
        logger.info("Chat deleted successfully, Chat details=" + p);
    }

    public void setChatDAO(ChatDAOImpl chatDAO) {
        this.chatDAO = chatDAO;
    }

    public ChatDAOImpl getChatDAO() {
        return chatDAO;
    }
}
