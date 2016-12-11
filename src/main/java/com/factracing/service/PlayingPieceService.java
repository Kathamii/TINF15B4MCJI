package com.factracing.service;

import com.factracing.model.PlayingPiece;

import java.util.List;

public interface PlayingPieceService {
    void addPlayingPiece(PlayingPiece p);

    void updatePlayingPiece(PlayingPiece p);

    List<PlayingPiece> listPlayingPieces();

    PlayingPiece getPlayingPieceById(int id);

    void removePlayingPiece(int id);
}
