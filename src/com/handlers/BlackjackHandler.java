package com.handlers;

import com.card.Deck;
import com.games.Blackjack;

public class BlackjackHandler implements Runnable {

	private Deck cards;
	private int numOfPlayers;
	private Blackjack blackjack;

	public BlackjackHandler(Deck deck, int players) {
		this.cards = deck;
		this.numOfPlayers = players;
		blackjack = new Blackjack(deck);
	}

	@Override
	public void run() {
		blackjack.dealBlackjack(5);
	}

}
