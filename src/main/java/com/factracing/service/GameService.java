package com.factracing.service;

import com.factracing.model.Game;

import java.util.List;

public interface GameService {
    void addGame(Game p);

    void updateGame(Game p);

    List<Game> listGames();

    Game getGameById(int id);

    void removeGame(int id);
}
