package com.card;

public enum Cards {
	Ace(1), Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), Ten(10), Jack(10), Queen(10), King(10);

	private char suit;
	private int value;
	
	Cards(int val) {
		setValue(val);
	}

	public char getSuit() {
		return suit;
	}

	public void setSuit(char suit) {
		this.suit = suit;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int val) {
		this.value = val;
	}
	

	public char getSuitForNum(int num) {
		switch(num){
		case 0:
			return ('\u2660');
		case 1:
			return ('\u2764');
		case 2:
			return ('\u2663');
		case 3:
			return ('\u2666');
		}
		return ' ';
	}
}

