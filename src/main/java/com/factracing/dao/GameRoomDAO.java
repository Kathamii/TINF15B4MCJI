package com.factracing.dao;


import com.factracing.model.GameRoom;

import java.util.List;


public interface GameRoomDAO {
    void addGameRoom(GameRoom c);

    void updateGameRoom(GameRoom c);

    List<GameRoom> listGameRooms();

    GameRoom getGameRoomById(int id);

    void removeGameRoom(int id);

}
