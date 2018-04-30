package com.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Deck {
	
	private ArrayList<Card> currentDeck = new ArrayList<>();
	//Contains all the hands at the 'table'
	private ArrayList<HashMap> hands = new ArrayList<>();
	// Integer is index, Card is phyiscal card
	private HashMap<Integer, Card> dealersHand = new HashMap<>();
	// Integer is index, Card is phyiscal card
	private HashMap<Integer, Card> playerHand = new HashMap<>();

	public Deck() {
		for (int i = 0; i < 4; i++) {
			for (Cards card : Cards.values()) {
				Card tempCard = new Card(card.name());
				tempCard.setValue(card.getValue());
				tempCard.setSuit(card.getSuitForNum(i));
				currentDeck.add(tempCard);
			}
		}

		Collections.shuffle(currentDeck);
	}

	public void shuffleDeck() {
		System.out.println("Shuffling my dude");
		for (int i = 0; i < 4; i++) {
			for (Cards card : Cards.values()) {
				Card tempCard = new Card(card.name());
				tempCard.setValue(card.getValue());
				tempCard.setSuit(card.getSuitForNum(i));
				currentDeck.add(tempCard);
			}
		}

		Collections.shuffle(currentDeck);
	}

	public boolean isEmpty() {
		return currentDeck.size() == 0;
	}

	public ArrayList<Card> getCurrentDeck() {
		return currentDeck;
	}


	public ArrayList<HashMap> getHands() {
		return hands;
	}
	
	

	public HashMap<Integer, Card> getDealersHand() {
		return dealersHand;
	}

}
