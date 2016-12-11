package com.factracing.model;


import com.factracing.model.Card;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.LinkedList;


@Entity
@Table(name = "DECK")
public class Decks
{

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDeck;

	private String category;
	@OneToMany(mappedBy = "")//TODO
	private LinkedList<Card> Cards;

	public Decks()
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

	public int getIdDeck() {
		return idDeck;
	}

	public void setIdDeck(int idDeck) {
		this.idDeck = idDeck;
	}
}
