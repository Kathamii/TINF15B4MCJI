package com.factracing.beans;


import org.springframework.stereotype.Service;

import java.util.LinkedList;


@Service
public class Deck
{

	private String category;
	private LinkedList<Card> Cards;


	public Deck()
	{
	}


	public String getCategory()
	{
		return category;
	}


	public void setCategory(String category)
	{
		this.category = category;
	}


	public LinkedList<Card> getCards()
	{
		return Cards;
	}


	public void setCards(LinkedList<Card> cards)
	{
		Cards = cards;
	}
}
