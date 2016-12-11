package com.factracing.dao;


import com.factracing.model.Decks;

import java.util.List;


public interface DecksDAO {
    void addDecks(Decks c);

    void updateDecks(Decks c);

    List<Decks> listDeckss();

    Decks getDecksById(int id);

    void removeDecks(int id);

}
