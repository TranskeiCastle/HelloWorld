package edu.bnuz;

public class DeckOfCards {

	public static void main(String[] args) {
		int[] deck = new int[52];
		String[] suits = { "Spades", "Hearts", "Diamonds", "Clubs" };
		String[] ranks = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };

		// Initialize cards
		for (int i = 0; i < deck.length; i++) {
			deck[i] = i;
		}
		// play 50 times
		for (int j = 0; j < 50; j++) {

			// Shuffle the cards
			for (int i = 0; i < deck.length; i++) {
				// Generate an index randomly
				int index = (int) (Math.random() * deck.length);
				int temp = deck[i];
				deck[i] = deck[index];
				deck[index] = temp;
			}

			System.out.println("times for " + (j + 1) + ": ");
			for (int i = 0; i < 4; i++) {
				String suit = suits[deck[i] / 13];
				String rank = ranks[deck[i] % 13];
				System.out.println("Card number " + deck[i] + ": " + rank + " of " + suit);
			}
			System.out.println();
		}
	}
}