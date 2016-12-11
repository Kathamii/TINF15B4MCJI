package com.factracing.service;

import com.factracing.model.PlayingField;

import java.util.List;

public interface PlayingFieldService {
    void addPlayingField(PlayingField p);

    void updatePlayingField(PlayingField p);

    List<PlayingField> listPlayingFields();

    PlayingField getPlayingFieldById(int id);

    void removePlayingField(int id);
}
