package com.factracing;


import org.springframework.stereotype.Service;

import java.util.Random;


@Service
public class Dice
{

	private Random random;


	public Dice()
	{
		random = new Random();
	}


	public int getValue()
	{
		return random.nextInt(6) + 1;
	}
}
