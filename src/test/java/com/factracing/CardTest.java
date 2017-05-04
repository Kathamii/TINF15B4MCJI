package com.factracing;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest{
    @Test
    public void difficultyTest(){
        assertEquals(new Card().getDifficulty(), 0);
    }
}