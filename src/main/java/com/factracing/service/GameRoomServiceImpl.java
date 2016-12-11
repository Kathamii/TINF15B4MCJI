package com.factracing.service;

import com.factracing.dao.GameRoomDAO;
import com.factracing.model.GameRoom;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameRoomServiceImpl implements GameRoomService {
    private GameRoomDAO gameRoomDAO;

    public void setGameRoomDAO(GameRoomDAO gameRoomDAO) {
        this.gameRoomDAO = gameRoomDAO;
    }

    @Override
    @Transactional
    public void addGameRoom(GameRoom c) {
        this.gameRoomDAO.addGameRoom(c);
    }

    @Override
    @Transactional
    public void updateGameRoom(GameRoom c) {
        this.gameRoomDAO.updateGameRoom(c);
    }

    @Override
    @Transactional
    public List<GameRoom> listGameRooms() {
        return this.gameRoomDAO.listGameRooms();
    }

    @Override
    @Transactional
    public GameRoom getGameRoomById(int id) {
        return this.gameRoomDAO.getGameRoomById(id);
    }

    @Override
    @Transactional
    public void removeGameRoom(int id) {
        this.gameRoomDAO.removeGameRoom(id);
    }

}
