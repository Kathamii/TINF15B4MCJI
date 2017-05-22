package com.factracing.beans;


import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


@Service
public class Deck
{

	private String category;
	private List<Card> Cards;


	public Deck(String category)
	{
		this.category = category;
	}


	public String getCategory()
	{
		return category;
	}


	public void setCategory(String category)
	{
		this.category = category;
	}


	public List<Card> getCards()
	{
		return Cards;
	}


	public void setCards(List<Card> cards)
	{
		Cards = cards;
	}
}
