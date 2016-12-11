package com.factracing.dao;


import com.factracing.model.GameRoom;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GameRoomDAOImpl implements GameRoomDAO {
    private static final Logger logger = LoggerFactory.getLogger(GameRoomDAOImpl.class);
    private SessionFactory sessionFactory;
    private GameRoomDAOImpl gameRoomDAO;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addGameRoom(GameRoom p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("GameRoom saved successfully, GameRoom Details=" + p);
    }

    @Override
    public void updateGameRoom(GameRoom p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("GameRoom updated successfully, GameRoom Details=" + p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<GameRoom> listGameRooms() {
        Session session = this.sessionFactory.getCurrentSession();
        List<GameRoom> GameRoomsList = session.createQuery("from GameRoom").list();
        for (GameRoom p : GameRoomsList) {
            logger.info("GameRoom List::" + p);
        }
        return GameRoomsList;
    }

    @Override
    public GameRoom getGameRoomById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        GameRoom p = session.load(GameRoom.class, new Integer(id));
        logger.info("GameRoom loaded successfully, GameRoom details=" + p);
        return p;
    }

    @Override
    public void removeGameRoom(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        GameRoom p = session.load(GameRoom.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
        logger.info("GameRoom deleted successfully, GameRoom details=" + p);
    }

    public void setGameRoomDAO(GameRoomDAOImpl gameRoomDAO) {
        this.gameRoomDAO = gameRoomDAO;
    }

    public GameRoomDAOImpl getGameRoomDAO() {
        return gameRoomDAO;
    }
}
