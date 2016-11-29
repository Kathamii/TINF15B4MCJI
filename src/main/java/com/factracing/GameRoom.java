package com.factracing;

import org.springframework.stereotype.Service;

@Service
public class GameRoom
{
    private long grid;
    private int minP;
    private int maxP;
    private boolean join;
    private int players;

    public long getGrid() {
        return grid;
    }

    public void setGrid(long grid) {
        this.grid = grid;
    }

    public int getMinP() {
        return minP;
    }

    public void setMinP(int minP) {
        this.minP = minP;
    }

    public int getMaxP() {
        return maxP;
    }

    public void setMaxP(int maxP) {
        this.maxP = maxP;
    }

    public boolean isJoin() {
        return join;
    }

    public void setJoin(boolean join) {
        this.join = join;
    }

    public int getPlayers() {
        return players;
    }

    public void setPlayers(int players) {
        this.players = players;
    }
}
