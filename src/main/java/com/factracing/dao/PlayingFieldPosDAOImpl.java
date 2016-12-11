package com.factracing.dao;


import com.factracing.model.PlayingFieldPos;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayingFieldPosDAOImpl implements PlayingFieldPosDAO {
    private static final Logger logger = LoggerFactory.getLogger(PlayingFieldPosDAOImpl.class);
    private SessionFactory sessionFactory;
    private PlayingFieldPosDAOImpl playingFieldPosDAO;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addPlayingFieldPos(PlayingFieldPos p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("PlayingFieldPos saved successfully, PlayingFieldPos Details=" + p);
    }

    @Override
    public void updatePlayingFieldPos(PlayingFieldPos p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("PlayingFieldPos updated successfully, PlayingFieldPos Details=" + p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PlayingFieldPos> listPlayingFieldPoss() {
        Session session = this.sessionFactory.getCurrentSession();
        List<PlayingFieldPos> PlayingFieldPossList = session.createQuery("from PlayingFieldPos").list();
        for (PlayingFieldPos p : PlayingFieldPossList) {
            logger.info("PlayingFieldPos List::" + p);
        }
        return PlayingFieldPossList;
    }

    @Override
    public PlayingFieldPos getPlayingFieldPosById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        PlayingFieldPos p = session.load(PlayingFieldPos.class, new Integer(id));
        logger.info("PlayingFieldPos loaded successfully, PlayingFieldPos details=" + p);
        return p;
    }

    @Override
    public void removePlayingFieldPos(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        PlayingFieldPos p = session.load(PlayingFieldPos.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
        logger.info("PlayingFieldPos deleted successfully, PlayingFieldPos details=" + p);
    }

    public void setPlayingFieldPosDAO(PlayingFieldPosDAOImpl playingFieldPosDAO) {
        this.playingFieldPosDAO = playingFieldPosDAO;
    }

    public PlayingFieldPosDAOImpl getPlayingFieldPosDAO() {
        return playingFieldPosDAO;
    }
}
