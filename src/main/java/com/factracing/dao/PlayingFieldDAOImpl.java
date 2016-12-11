package com.factracing.dao;


import com.factracing.model.PlayingField;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayingFieldDAOImpl implements PlayingFieldDAO {
    private static final Logger logger = LoggerFactory.getLogger(PlayingFieldDAOImpl.class);
    private SessionFactory sessionFactory;
    private PlayingFieldDAOImpl playingFieldDAO;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addPlayingField(PlayingField p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("PlayingField saved successfully, PlayingField Details=" + p);
    }

    @Override
    public void updatePlayingField(PlayingField p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("PlayingField updated successfully, PlayingField Details=" + p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PlayingField> listPlayingFields() {
        Session session = this.sessionFactory.getCurrentSession();
        List<PlayingField> PlayingFieldsList = session.createQuery("from PlayingField").list();
        for (PlayingField p : PlayingFieldsList) {
            logger.info("PlayingField List::" + p);
        }
        return PlayingFieldsList;
    }

    @Override
    public PlayingField getPlayingFieldById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        PlayingField p = session.load(PlayingField.class, new Integer(id));
        logger.info("PlayingField loaded successfully, PlayingField details=" + p);
        return p;
    }

    @Override
    public void removePlayingField(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        PlayingField p = session.load(PlayingField.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
        logger.info("PlayingField deleted successfully, PlayingField details=" + p);
    }

    public void setPlayingFieldDAO(PlayingFieldDAOImpl playingFieldDAO) {
        this.playingFieldDAO = playingFieldDAO;
    }

    public PlayingFieldDAOImpl getPlayingFieldDAO() {
        return playingFieldDAO;
    }
}
