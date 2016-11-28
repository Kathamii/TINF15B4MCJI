package com.factracing;

import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class Decks {
    private String category;
    private LinkedList<Card> Cards;

    public Decks() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LinkedList<Card> getCards() {
        return Cards;
    }

    public void setCards(LinkedList<Card> cards) {
        Cards = cards;
    }
}
