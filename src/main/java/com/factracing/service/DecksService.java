package com.factracing.service;

import com.factracing.model.Decks;

import java.util.List;

public interface DecksService {
    void addDecks(Decks p);

    void updateDecks(Decks p);

    List<Decks> listDeckss();

    Decks getDecksById(int id);

    void removeDecks(int id);
}
