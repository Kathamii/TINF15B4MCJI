package com.factracing;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest{
    @Test
    public void difficultyTest(){
        Card c = new Card();
        int d = c.getDifficulty();
        assertEquals(0, d);
    }
        }