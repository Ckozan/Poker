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

	public void dealBlackjack(int players) {
		for (int i = 0; i < players; i++) {
			for (int j = 0; j < 2; j++) {
				if (isEmpty()) {
					shuffleDeck();
				}
				playerHand.put(j, currentDeck.get(0));
				currentDeck.remove(0);
			}
			hands.add(playerHand);
			playerHand = new HashMap<>();
		}
		for (int j = 0; j < 2; j++) {
			if (isEmpty()) {
				shuffleDeck();
			}
			dealersHand.put(j, currentDeck.get(0));
			currentDeck.remove(0);
		}

		int counter = 1;
		for (HashMap<Integer, Card> list : hands) {
			System.out.println("Player #" + counter);
			for (Integer index : list.keySet())
				System.out.println(list.get(index).getName() + "" + list.get(index).getSuit());
			System.out.println("Players total: " + calcTotal(list));
			counter++;
		}
		System.out.println("Dealer's Hand:");
		for (int i = 0; i < 2; i++) {
			System.out.println(dealersHand.get(i).toString());
		}
		System.out.println("Dealer's total: " + calcTotal(dealersHand));
	}

	public String calcTotal(HashMap<Integer, Card> deck) {
		StringBuilder builder = new StringBuilder();
		int val = 0;
		int numOfAces = 0;
		boolean blackjack = false;
		for (int i = 0; i < deck.size(); i++) {
			if (hasBlackjack(deck.get(0), deck.get(1))) {
				blackjack = true;
			}
			if (deck.get(i).getValue() == 1) {
				numOfAces++;
				val += deck.get(i).getValue();
			} else
				val += deck.get(i).getValue();
		}
		if (blackjack) {
			builder.append("Blackjack!");
			return builder.toString();
		} else if (numOfAces > 0) {
			builder.append(val + "/" + (val + 10));
		} else {
			builder.append(val);
		}

		return builder.toString();
	}

	public boolean hasBlackjack(Card card1, Card card2) {
		if (card1.getName().equalsIgnoreCase("ace") || card2.getName().equalsIgnoreCase("ace")) {
			if (card1.getName().equalsIgnoreCase("ace")) {
				if (card2.getName().equalsIgnoreCase("king") || card2.getName().equalsIgnoreCase("queen")
						|| card2.getName().equalsIgnoreCase("jack") || card2.getName().equalsIgnoreCase("ten")) 
					return true;
					
			} else {
				if (card1.getName().equalsIgnoreCase("king") || card1.getName().equalsIgnoreCase("queen")
						|| card1.getName().equalsIgnoreCase("jack") || card1.getName().equalsIgnoreCase("ten")) 
					return true;
				}
			}
			return false;
	}

	public ArrayList<HashMap> getHands() {
		return hands;
	}

	public HashMap<Integer, Card> getDealersHand() {
		return dealersHand;
	}

}
