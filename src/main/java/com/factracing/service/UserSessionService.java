package com.factracing.service;

import com.factracing.model.UserSession;

import java.util.List;

public interface UserSessionService {
    void addUserSession(UserSession p);

    void updateUserSession(UserSession p);

    List<UserSession> listUserSessions();

    UserSession getUserSessionById(int id);

    void removeUserSession(int id);
}
