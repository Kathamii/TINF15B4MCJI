package com.factracing.service;

import com.factracing.dao.PlayingPieceDAO;
import com.factracing.model.PlayingPiece;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlayingPieceServiceImpl implements PlayingPieceService {
    private PlayingPieceDAO playingPieceDAO;

    public void setPlayingPieceDAO(PlayingPieceDAO playingPieceDAO) {
        this.playingPieceDAO = playingPieceDAO;
    }

    @Override
    @Transactional
    public void addPlayingPiece(PlayingPiece c) {
        this.playingPieceDAO.addPlayingPiece(c);
    }

    @Override
    @Transactional
    public void updatePlayingPiece(PlayingPiece c) {
        this.playingPieceDAO.updatePlayingPiece(c);
    }

    @Override
    @Transactional
    public List<PlayingPiece> listPlayingPieces() {
        return this.playingPieceDAO.listPlayingPieces();
    }

    @Override
    @Transactional
    public PlayingPiece getPlayingPieceById(int id) {
        return this.playingPieceDAO.getPlayingPieceById(id);
    }

    @Override
    @Transactional
    public void removePlayingPiece(int id) {
        this.playingPieceDAO.removePlayingPiece(id);
    }

}
