package com.factracing;


import org.junit.Test;

import com.factracing.beans.Card;

import static org.junit.Assert.assertEquals;


public class CardTest
{

	@Test
    public void difficultyTest(){
        assertEquals(new Card("", new String[0], "", 0).getDifficulty(), 0);
    }
}