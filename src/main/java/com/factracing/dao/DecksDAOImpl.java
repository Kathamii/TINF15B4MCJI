package com.factracing.dao;


import com.factracing.model.Decks;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DecksDAOImpl implements DecksDAO {
    private static final Logger logger = LoggerFactory.getLogger(DecksDAOImpl.class);
    private SessionFactory sessionFactory;
    private DecksDAOImpl decksDAO;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addDecks(Decks p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Decks saved successfully, Decks Details=" + p);
    }

    @Override
    public void updateDecks(Decks p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Decks updated successfully, Decks Details=" + p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Decks> listDeckss() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Decks> DeckssList = session.createQuery("from Decks").list();
        for (Decks p : DeckssList) {
            logger.info("Decks List::" + p);
        }
        return DeckssList;
    }

    @Override
    public Decks getDecksById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Decks p = session.load(Decks.class, new Integer(id));
        logger.info("Decks loaded successfully, Decks details=" + p);
        return p;
    }

    @Override
    public void removeDecks(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Decks p = session.load(Decks.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
        logger.info("Decks deleted successfully, Decks details=" + p);
    }

    public void setDecksDAO(DecksDAOImpl decksDAO) {
        this.decksDAO = decksDAO;
    }

    public DecksDAOImpl getDecksDAO() {
        return decksDAO;
    }
}
