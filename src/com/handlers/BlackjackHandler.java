package com.handlers;

import java.util.HashMap;
import java.util.Set;

import com.card.Card;
import com.card.Deck;

public class BlackjackHandler implements Runnable {

	private Deck cards;
	private int numOfPlayers;

	public BlackjackHandler(Deck deck, int players) {
		this.cards = deck;
		this.numOfPlayers = players;
	}

	@Override
	public void run() {
		cards.dealBlackjack(numOfPlayers);
	}

}
