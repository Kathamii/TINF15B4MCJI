package com.factracing.dao;


import com.factracing.model.Card;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardDAOImpl implements CardDAO {
    private static final Logger logger = LoggerFactory.getLogger(CardDAOImpl.class);
    private SessionFactory sessionFactory;
    private CardDAOImpl cardDAO;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addCard(Card p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Card saved successfully, Card Details=" + p);
    }

    @Override
    public void updateCard(Card p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Card updated successfully, Card Details=" + p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Card> listCards() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Card> CardsList = session.createQuery("from Card").list();
        for (Card p : CardsList) {
            logger.info("Card List::" + p);
        }
        return CardsList;
    }

    @Override
    public Card getCardById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Card p = session.load(Card.class, new Integer(id));
        logger.info("Card loaded successfully, Card details=" + p);
        return p;
    }

    @Override
    public void removeCard(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Card p = session.load(Card.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
        logger.info("Card deleted successfully, Card details=" + p);
    }

    public void setCardDAO(CardDAOImpl cardDAO) {
        this.cardDAO = cardDAO;
    }

    public CardDAOImpl getCardDAO() {
        return cardDAO;
    }
}
