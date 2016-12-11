package com.factracing.service;

import com.factracing.dao.PlayingFieldDAO;
import com.factracing.model.PlayingField;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlayingFieldServiceImpl implements PlayingFieldService {
    private PlayingFieldDAO playingFieldDAO;

    public void setPlayingFieldDAO(PlayingFieldDAO playingFieldDAO) {
        this.playingFieldDAO = playingFieldDAO;
    }

    @Override
    @Transactional
    public void addPlayingField(PlayingField c) {
        this.playingFieldDAO.addPlayingField(c);
    }

    @Override
    @Transactional
    public void updatePlayingField(PlayingField c) {
        this.playingFieldDAO.updatePlayingField(c);
    }

    @Override
    @Transactional
    public List<PlayingField> listPlayingFields() {
        return this.playingFieldDAO.listPlayingFields();
    }

    @Override
    @Transactional
    public PlayingField getPlayingFieldById(int id) {
        return this.playingFieldDAO.getPlayingFieldById(id);
    }

    @Override
    @Transactional
    public void removePlayingField(int id) {
        this.playingFieldDAO.removePlayingField(id);
    }

}
