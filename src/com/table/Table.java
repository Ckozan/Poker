package com.table;

import com.card.Deck;
import com.handlers.BlackjackHandler;

public class Table {

	public void createTable() {
		Deck deckOfCards = new Deck();

		/*new Thread(() -> {
			while (true) {
*/				new BlackjackHandler(deckOfCards, 5).run();
			/*}
		}).start();*/
	}

}
