package com.factracing.dao;


import com.factracing.model.Game;

import java.util.List;


public interface GameDAO {
    void addGame(Game c);

    void updateGame(Game c);

    List<Game> listGames();

    Game getGameById(int id);

    void removeGame(int id);

}
