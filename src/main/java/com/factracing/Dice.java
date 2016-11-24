package com.factracing;

import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by janik on 22/11/2016.
 */
@Service
public class Dice {
    private Random random;

    public Dice() {
        random =new Random();
    }

    public int getValue(){
        return random.nextInt(6)+1;
    }
}
