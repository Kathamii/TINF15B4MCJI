package com.factracing.dao;


import com.factracing.model.UserSession;

import java.util.List;


public interface UserSessionDAO {
    void addUserSession(UserSession c);

    void updateUserSession(UserSession c);

    List<UserSession> listUserSessions();

    UserSession getUserSessionById(int id);

    void removeUserSession(int id);

}
