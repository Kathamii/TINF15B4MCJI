package com.factracing.service;

import com.factracing.dao.UserSessionDAO;
import com.factracing.model.UserSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserSessionServiceImpl implements UserSessionService {
    private UserSessionDAO userSessionDAO;

    public void setUserSessionDAO(UserSessionDAO userSessionDAO) {
        this.userSessionDAO = userSessionDAO;
    }

    @Override
    @Transactional
    public void addUserSession(UserSession c) {
        this.userSessionDAO.addUserSession(c);
    }

    @Override
    @Transactional
    public void updateUserSession(UserSession c) {
        this.userSessionDAO.updateUserSession(c);
    }

    @Override
    @Transactional
    public List<UserSession> listUserSessions() {
        return this.userSessionDAO.listUserSessions();
    }

    @Override
    @Transactional
    public UserSession getUserSessionById(int id) {
        return this.userSessionDAO.getUserSessionById(id);
    }

    @Override
    @Transactional
    public void removeUserSession(int id) {
        this.userSessionDAO.removeUserSession(id);
    }

}
