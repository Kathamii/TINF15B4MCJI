package com.factracing.service;

import com.factracing.model.Card;

import java.util.List;

public interface CardService {
    void addCard(Card p);

    void updateCard(Card p);

    List<Card> listCards();

    Card getCardById(int id);

    void removeCard(int id);
}
