package com.factracing.beans;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Janik on 29.05.2017.
 */
public class DeckTest {
    private static String CATEGORY = "Doctor Who";
    private Deck simpleDeck = new Deck(CATEGORY);
    private Deck emptyDeck = new Deck("");
    private Card simpleCard = new Card("", new String[0], "", 0);

    @Before
    public void setUp(){
        simpleDeck.addCard(simpleCard);
    }

    @Test
    public void getCategory() throws Exception {
        assertEquals("", emptyDeck.getCategory());
        assertEquals(CATEGORY, simpleDeck.getCategory());
    }

    @Test
    public void getCards() throws Exception {
        assertEquals(0, emptyDeck.getCards().size());
        assertEquals(1, simpleDeck.getCards().size());
    }

    @Test
    public void setCards() throws Exception {
        assertEquals(0, emptyDeck.getCards().size());
        assertEquals(1, simpleDeck.getCards().size());
    }

    @Test
    public void addCard() throws Exception {
        assertEquals(1, simpleDeck.getCards().size());
        simpleDeck.addCard(simpleCard);
        assertEquals(2, simpleDeck.getCards().size());
    }

}