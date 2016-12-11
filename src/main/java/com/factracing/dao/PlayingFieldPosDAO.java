package com.factracing.dao;


import com.factracing.model.PlayingFieldPos;

import java.util.List;


public interface PlayingFieldPosDAO {
    void addPlayingFieldPos(PlayingFieldPos c);

    void updatePlayingFieldPos(PlayingFieldPos c);

    List<PlayingFieldPos> listPlayingFieldPoss();

    PlayingFieldPos getPlayingFieldPosById(int id);

    void removePlayingFieldPos(int id);

}
