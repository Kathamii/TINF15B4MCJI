package com.factracing.service;

import com.factracing.dao.DecksDAO;
import com.factracing.model.Decks;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DecksServiceImpl implements DecksService {
    private DecksDAO decksDAO;

    public void setDecksDAO(DecksDAO decksDAO) {
        this.decksDAO = decksDAO;
    }

    @Override
    @Transactional
    public void addDecks(Decks c) {
        this.decksDAO.addDecks(c);
    }

    @Override
    @Transactional
    public void updateDecks(Decks c) {
        this.decksDAO.updateDecks(c);
    }

    @Override
    @Transactional
    public List<Decks> listDeckss() {
        return this.decksDAO.listDeckss();
    }

    @Override
    @Transactional
    public Decks getDecksById(int id) {
        return this.decksDAO.getDecksById(id);
    }

    @Override
    @Transactional
    public void removeDecks(int id) {
        this.decksDAO.removeDecks(id);
    }

}
