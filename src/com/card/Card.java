package com.card;

public class Card {
	
	private String name;
	private char suit;
	private int value;

	public Card(String name) {
		this.name = name;
	}
	
	public void setSuit(char suit) {
		this.suit = suit;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public char getSuit() {
		return suit;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int val) {
		this.value = val;
	}
	
	public String toString() {
		return name+suit;
	}
	
}
