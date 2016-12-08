package com.factracing.service;

import com.factracing.dao.CardDAO;
import com.factracing.model.Card;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    private CardDAO cardDAO;

    public void setCardDAO(CardDAO cardDAO) {
        this.cardDAO = cardDAO;
    }

    @Override
    @Transactional
    public void addCard(Card c) {
        this.cardDAO.addCard(c);
    }

    @Override
    @Transactional
    public void updateCard(Card c) {
        this.cardDAO.updateCard(c);
    }

    @Override
    @Transactional
    public List<Card> listCards() {
        return this.cardDAO.listCards();
    }

    @Override
    @Transactional
    public Card getCardById(int id) {
        return this.cardDAO.getCardById(id);
    }

    @Override
    @Transactional
    public void removeCard(int id) {
        this.cardDAO.removeCard(id);
    }

}
