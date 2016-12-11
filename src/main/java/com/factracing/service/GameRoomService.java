package com.factracing.service;

import com.factracing.model.GameRoom;

import java.util.List;

public interface GameRoomService {
    void addGameRoom(GameRoom p);

    void updateGameRoom(GameRoom p);

    List<GameRoom> listGameRooms();

    GameRoom getGameRoomById(int id);

    void removeGameRoom(int id);
}
