package com.factracing.service;

import com.factracing.dao.GameDAO;
import com.factracing.model.Game;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    private GameDAO gameDAO;

    public void setGameDAO(GameDAO gameDAO) {
        this.gameDAO = gameDAO;
    }

    @Override
    @Transactional
    public void addGame(Game c) {
        this.gameDAO.addGame(c);
    }

    @Override
    @Transactional
    public void updateGame(Game c) {
        this.gameDAO.updateGame(c);
    }

    @Override
    @Transactional
    public List<Game> listGames() {
        return this.gameDAO.listGames();
    }

    @Override
    @Transactional
    public Game getGameById(int id) {
        return this.gameDAO.getGameById(id);
    }

    @Override
    @Transactional
    public void removeGame(int id) {
        this.gameDAO.removeGame(id);
    }

}
