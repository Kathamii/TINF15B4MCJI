package com.factracing.dao;


import com.factracing.model.Game;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GameDAOImpl implements GameDAO {
    private static final Logger logger = LoggerFactory.getLogger(GameDAOImpl.class);
    private SessionFactory sessionFactory;
    private GameDAOImpl gameDAO;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addGame(Game p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Game saved successfully, Game Details=" + p);
    }

    @Override
    public void updateGame(Game p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Game updated successfully, Game Details=" + p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Game> listGames() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Game> GamesList = session.createQuery("from Game").list();
        for (Game p : GamesList) {
            logger.info("Game List::" + p);
        }
        return GamesList;
    }

    @Override
    public Game getGameById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Game p = session.load(Game.class, new Integer(id));
        logger.info("Game loaded successfully, Game details=" + p);
        return p;
    }

    @Override
    public void removeGame(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Game p = session.load(Game.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
        logger.info("Game deleted successfully, Game details=" + p);
    }

    public void setGameDAO(GameDAOImpl gameDAO) {
        this.gameDAO = gameDAO;
    }

    public GameDAOImpl getGameDAO() {
        return gameDAO;
    }
}
