package com.factracing.beans;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class Deck
{

	private String category;
	private List<Card> cards;


	public Deck(String category)
	{
		this.category = category;
		this.cards = new ArrayList<>();
	}


	public String getCategory()
	{
		return category;
	}


	public List<Card> getCards()
	{
		return cards;
	}


	public void setCards(List<Card> cards)
	{
		this.cards = cards;
	}


	public boolean addCard(Card card)
	{
		return cards.add(card);
	}


	public enum DefaultDeck
	{
		SPORTS("Sports"),
		// MATH("Math"),
		ANIMALS("Animals");
		// HISTORY("History"),
		// CARS("Cars");

		Deck deck;


		DefaultDeck(String category)
		{
			deck = new Deck(category);
			fillDeck(category);
		}


		private void fillDeck(String category)
		{
			if (category.equals("Sports"))
			{
				deck.addCard(new Card("Wo wurde die Bundesrepublik Deutschland zum zweitenmal Fußballweltmeister der Herren?", 1, "in Bern",
						"in München", "in Berlin", "in Rom"));
				deck.addCard(new Card("Süper Lig heißt die höchste Fußballspielklasse in ...?", 0, "der Türkei", "Finnland", "der Ukraine",
						"Andorra"));
				deck.addCard(new Card("Wer gewann achtmal die DDR-Fußballmeisterschaft der Herren?", 1, "1.FC Magdeburg", "Dynamo Dresden",
						"1.FC Lok Leipzig", "FC Carl Zeiss Jena"));
				deck.addCard(new Card("Welches Bundesliga-Team warb als erstes mit einem Brustsponsor?", 2, "Hertha BSC Berlin",
						"Schalke 04", "Eintracht Braunschweig", "FC Bayern München"));
				deck.addCard(new Card("Wer ist vielfacher österreichischer Fußballmeister?", 3, "Turbo Innsbruck", "Rasant Graz",
						"Tempo Salzburg", "Rapid Wien"));
				deck.addCard(new Card("Wer ist beim FC Bayern als der Kaiser bekannt?", 1, "Uli Hoeneß", "Franz Beckenbauer",
						"Paul Breitner", "Franck Ribery"));
				deck.addCard(new Card("In welchem Jahr wurden zum ersten Mal gelbe und rote Karten im Fußball eingesetzt?", 0, "1970",
						"1965", "1960", "1955"));
				deck.addCard(new Card("Wer ist der erfolgreichste Torjäger aller bisherigen ausländischen Fußball-Bundesligaspieler?", 3,
						"Ailton", "Giovane Elber", "Stephane Chapuisat", "Claudio Pizarro"));
				deck.addCard(new Card("Wie heißt der Fußballtrainer vollständig Ottmar ...?", 2, "Frierlich", "Warmling", "Hitzfeld",
						"Kaltschnautz"));
				deck.addCard(new Card("Welcher Umfang entspricht der Ballgröße 5, die im Profi-Fußball eingesetzt wird?", 2, "75 - 80 cm",
						"genau 77 cm", "68 - 70 cm", "59 - 61 cm"));
				deck.addCard(new Card("Wie nennt man im Fußball den Versuch eines Spielers, ein Foul vorzutäuschen?", 2, "Ente", "Sperling",
						"Schwalbe", "Taube"));
				deck.addCard(new Card("Wann fand erstmals eine Fußball-WM der Herren in Asien statt?", 0, "2002", "1998", "1994", "2006"));
				deck.addCard(new Card("Wo spielte Miroslav Klose von 2004-2007?", 3, "bei Bayern München", "beim 1. FC Kaiserslautern",
						"beim VfB Stuttgart", "bei Werder Bremen"));
				deck.addCard(new Card("Welchen Freistoß gibt es?", 3, "defensiven und offensiven", "einen rechten und linken",
						"einen absoluten und relativen", "einen direkten und indirekten"));
				deck.addCard(new Card("Welches Land war nicht mindestens dreimal Fußballweltmeister der Männer?", 2, "Italien",
						"Deutschland", "Frankreich", "Brasilien"));
				deck.addCard(new Card("Wann wurde Deutschland zum ersten Mal Fußball-Weltmeister?", 3, "1982", "1936", "1974", "1954"));

				return;
			}
			if (category.equals("Animals"))
			{
				deck.addCard(new Card("Welches dieser Insekten erreicht eine Fluggeschwindigkeit von bis zu 50 km/h?", 1, "Fliege",
						"Libelle", "Biene", "Motte"));
				deck.addCard(
						new Card("Welche Käferart hat das höchste Gewicht?", 2, "Ölkäfer", "Prachtkäfer", "Goliathkäfer", "Speckkäfer"));
				deck.addCard(new Card("Wie nennt man ein männliches Schaf?", 3, "Bulle", "Widder", "Hengst", "Keiler"));
				deck.addCard(
						new Card("Welches dieser Insekten krabbelt am schnellsten?", 0, "Hundefloh", "Kakerlake", "Mistkäfer", "Ohrwurm"));
				deck.addCard(new Card("Womit werden Pferde gebürstet?", 0, "Striegel", "Koppel", "Mash", "Halfter"));
				deck.addCard(new Card("Wie nennt man die Kreuzung aus einem männlichen Löwen und einem weiblichen Tiger?", 3, "Tigon",
						"Töwe", "Gibt es nicht", "Liger"));
				deck.addCard(new Card("Welche Raubkatzen haben Pinselohren?", 2, "Leoparden", "Pumas", "Luchse", "Geparden"));
				deck.addCard(new Card("Wo werden gefährdete Tierarten erfasst?", 0, "auf einer roten Liste", "auf einem grünen Zettel",
						"in einem schwarzen Buch", "in einer blauen Tabelle"));
				deck.addCard(new Card("Wie nennt man ein junges Reh?", 2, "Ricke", "Frischling", "Kitz", "Fähe"));
				deck.addCard(
						new Card("Welches dieser Tiere schläft die meisten Stunden am Tag?", 2, "Panda", "Faultier", "Koala", "Braunbär"));
				deck.addCard(new Card("Wie wird ein männliches Kaninchen bezeichnet?", 3, "Schaufler", "Ganter", "Zibbe", "Rammler"));
				deck.addCard(new Card("Welches Tier ist am giftigsten?", 1, "Schrecklicher Pfeilgiftfrosch", "Seewespe",
						"Sydney-Trichternetzspinne", "Gelber Mittelmeerskorpion"));
				deck.addCard(new Card("Welcher Zugvogel legt während eines Jahres die längste Strecke zurück?", 1, "Weißstorch",
						"Küstenseeschwalbe", "Mauersegler", "Grauer Kranich"));
				deck.addCard(new Card("Welches dieser Tiere hält einen Winterschlaf?", 1, "Krokodil", "Haselmaus", "Braunbär",
						"Blindschleiche"));
				deck.addCard(new Card("Wie nennt man ein Pferd mit rötlichem Fell?", 2, "Schimmel", "Rappe", "Fuchs", "Falbe"));

				return;
			}
		}


		public static Deck[] getAllDefaultDecks()
		{
			DefaultDeck[] defaultDecks = values();
			Deck[] decks = new Deck[defaultDecks.length];
			for (int i = 0; i < defaultDecks.length; i++)
			{
				decks[i] = defaultDecks[i].getDeck();
			}
			return decks;
		}


		public static List<Deck> getAllDefaultDecksAsList()
		{
			List<Deck> decks = new ArrayList<>();
			for (DefaultDeck deck : values())
			{
				decks.add(deck.getDeck());
			}
			return decks;
		}


		public Deck getDeck()
		{
			return deck;
		}
	}
}
