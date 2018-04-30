package com.games;

import java.util.HashMap;

import com.card.Card;
import com.card.Deck;

public class Blackjack {

	private Deck cards;

	public Blackjack(Deck deck) {
		this.cards = deck;
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

	public void dealBlackjack(int players) {
		HashMap<Integer, Card> playerHand = new HashMap<>();
		for (int i = 0; i < players; i++) {
			for (int j = 0; j < 2; j++) {
				if (cards.isEmpty()) {
					cards.shuffleDeck();
				}
				playerHand.put(j, cards.getCurrentDeck().get(0));
				cards.getCurrentDeck().remove(0);
			}
			cards.getHands().add(playerHand);
			playerHand = new HashMap<>();
		}
		for (int j = 0; j < 2; j++) {
			if (cards.isEmpty()) {
				cards.shuffleDeck();
			}
			cards.getDealersHand().put(j, cards.getCurrentDeck().get(0));
			cards.getCurrentDeck().remove(0);
		}

		int counter = 1;
		for (HashMap<Integer, Card> list : cards.getHands()) {
			System.out.println("Player #" + counter);
			for (Integer index : list.keySet())
				System.out.println(list.get(index).getName() + "" + list.get(index).getSuit());
			System.out.println("Players total: " + calcTotal(list));
			counter++;
		}
		System.out.println("Dealer's Hand:");
		for (int i = 0; i < 2; i++) {
			System.out.println(cards.getDealersHand().get(i).toString());
		}
		System.out.println("Dealer's total: " + calcTotal(cards.getDealersHand()));
	}
	
}
