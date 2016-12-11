package com.factracing.dao;


import com.factracing.model.PlayingPiece;

import java.util.List;


public interface PlayingPieceDAO {
    void addPlayingPiece(PlayingPiece c);

    void updatePlayingPiece(PlayingPiece c);

    List<PlayingPiece> listPlayingPieces();

    PlayingPiece getPlayingPieceById(int id);

    void removePlayingPiece(int id);

}
