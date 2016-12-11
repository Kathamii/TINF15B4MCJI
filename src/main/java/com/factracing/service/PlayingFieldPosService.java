package com.factracing.service;

import com.factracing.model.PlayingFieldPos;

import java.util.List;

public interface PlayingFieldPosService {
    void addPlayingFieldPos(PlayingFieldPos p);

    void updatePlayingFieldPos(PlayingFieldPos p);

    List<PlayingFieldPos> listPlayingFieldPoss();

    PlayingFieldPos getPlayingFieldPosById(int id);

    void removePlayingFieldPos(int id);
}
