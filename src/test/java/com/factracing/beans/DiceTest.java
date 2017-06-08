package com.factracing.beans;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Janik on 29.05.2017.
 */
public class DiceTest {
    private static int MIN = 0;
    private static int MAX = 6;
    private static int TESTS = 100;
    private Dice dice = new Dice();
    @Test
    public void getValue() throws Exception {
        for(int i = 0; i < TESTS; i++){
            int value = dice.getValue();
            assertTrue(MIN <= value && value <= MAX);
        }

    }

}