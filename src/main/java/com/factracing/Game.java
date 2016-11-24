package com.factracing;

import org.springframework.stereotype.Service;

import java.util.LinkedList;

/**
 * Created by janik on 22/11/2016.
 */
@Service
public class Game {
    private LinkedList<Decks> decks;
    private Dice dice = new Dice();
    private final PlayingField field;


    public Game() {
        //TODO
        field = null;
    }

    public LinkedList<Decks> getDecks() {
        return decks;
    }

    public void setDecks(LinkedList<Decks> decks) {
        this.decks = decks;
    }
}
