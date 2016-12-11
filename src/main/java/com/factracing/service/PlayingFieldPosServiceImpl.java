package com.factracing.service;

import com.factracing.dao.PlayingFieldPosDAO;
import com.factracing.model.PlayingFieldPos;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlayingFieldPosServiceImpl implements PlayingFieldPosService {
    private PlayingFieldPosDAO playingFieldPosDAO;

    public void setPlayingFieldPosDAO(PlayingFieldPosDAO playingFieldPosDAO) {
        this.playingFieldPosDAO = playingFieldPosDAO;
    }

    @Override
    @Transactional
    public void addPlayingFieldPos(PlayingFieldPos c) {
        this.playingFieldPosDAO.addPlayingFieldPos(c);
    }

    @Override
    @Transactional
    public void updatePlayingFieldPos(PlayingFieldPos c) {
        this.playingFieldPosDAO.updatePlayingFieldPos(c);
    }

    @Override
    @Transactional
    public List<PlayingFieldPos> listPlayingFieldPoss() {
        return this.playingFieldPosDAO.listPlayingFieldPoss();
    }

    @Override
    @Transactional
    public PlayingFieldPos getPlayingFieldPosById(int id) {
        return this.playingFieldPosDAO.getPlayingFieldPosById(id);
    }

    @Override
    @Transactional
    public void removePlayingFieldPos(int id) {
        this.playingFieldPosDAO.removePlayingFieldPos(id);
    }

}
