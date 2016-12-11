package com.factracing.dao;


import com.factracing.model.UserSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserSessionDAOImpl implements UserSessionDAO {
    private static final Logger logger = LoggerFactory.getLogger(UserSessionDAOImpl.class);
    private SessionFactory sessionFactory;
    private UserSessionDAOImpl userSessionDAO;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addUserSession(UserSession p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("UserSession saved successfully, UserSession Details=" + p);
    }

    @Override
    public void updateUserSession(UserSession p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("UserSession updated successfully, UserSession Details=" + p);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<UserSession> listUserSessions() {
        Session session = this.sessionFactory.getCurrentSession();
        List<UserSession> UserSessionsList = session.createQuery("from UserSession").list();
        for (UserSession p : UserSessionsList) {
            logger.info("UserSession List::" + p);
        }
        return UserSessionsList;
    }

    @Override
    public UserSession getUserSessionById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserSession p = session.load(UserSession.class, new Integer(id));
        logger.info("UserSession loaded successfully, UserSession details=" + p);
        return p;
    }

    @Override
    public void removeUserSession(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        UserSession p = session.load(UserSession.class, new Integer(id));
        if (null != p) {
            session.delete(p);
        }
        logger.info("UserSession deleted successfully, UserSession details=" + p);
    }

    public void setUserSessionDAO(UserSessionDAOImpl userSessionDAO) {
        this.userSessionDAO = userSessionDAO;
    }

    public UserSessionDAOImpl getUserSessionDAO() {
        return userSessionDAO;
    }
}
