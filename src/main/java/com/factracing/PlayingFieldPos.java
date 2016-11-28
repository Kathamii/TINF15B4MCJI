package com.factracing;

import org.springframework.stereotype.Service;

@Service
public class PlayingFieldPos {
    private Difficulty difficulty;
    private int pos;
    private int nextPos;

    public PlayingFieldPos() {
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getNextPos() {
        return nextPos;
    }

    public void setNextPos(int nextPos) {
        this.nextPos = nextPos;
    }
}
