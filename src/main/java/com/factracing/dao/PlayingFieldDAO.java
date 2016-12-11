package com.factracing.dao;


import com.factracing.model.PlayingField;

import java.util.List;


public interface PlayingFieldDAO {
    void addPlayingField(PlayingField c);

    void updatePlayingField(PlayingField c);

    List<PlayingField> listPlayingFields();

    PlayingField getPlayingFieldById(int id);

    void removePlayingField(int id);

}
