package com.factracing.dao;


import com.factracing.model.Card;

import java.util.List;


public interface CardDAO {
    void addCard(Card c);

    void updateCard(Card c);

    List<Card> listCards();

    Card getCardById(int id);

    void removeCard(int id);

}
