
public class Deck {

	private Card[] collection;
	private Card[] deckMemory;

	// Creates new deck of 30 cards in an array with 18 common cards, 8 uncommon
	// cards, and 4 rare cards.
	public Deck() {

		collection = new Card[30];

		for (int collectionIndex = 0; collectionIndex <= 17; collectionIndex++) {
			collection[collectionIndex] = new CommonCard();
		}

		for (int collectionIndex = 18; collectionIndex <= 25; collectionIndex++) {
			collection[collectionIndex] = new UncommonCard();

		}

		for (int collectionIndex = 26; collectionIndex <= 29; collectionIndex++) {
			collection[collectionIndex] = new RareCard();
		}

		deckMemory = collection;

	}

	// Getter and setter for collection

	public Card[] getCollection() {
		return collection;
	}

	public void setCollection(Card[] collection) {
		this.collection = collection;
	}

	public void resetDeck() {
		collection = deckMemory;
	}

	// Shuffle Mechanism: Works by assigning the original deck in to smaller
	// piles,
	// and then adding those piles back in to the original deck form. Used in
	// real life
	// card games as a pretty efficient sorting mechanism. I used the concept of
	// arrays to accomplish this.
	// Note: shuffle function only works with full deck, but in the case of our
	// game we have no cards
	// that require them to be shuffled.

	public void shuffleDeck() {
		Card[] pileOne = { collection[0], collection[6], collection[12], collection[18], collection[24] };
		Card[] pileTwo = { collection[1], collection[7], collection[13], collection[19], collection[25] };
		Card[] pileThree = { collection[2], collection[8], collection[14], collection[20], collection[26] };
		Card[] pileFour = { collection[3], collection[9], collection[15], collection[21], collection[27] };
		Card[] pileFive = { collection[4], collection[10], collection[16], collection[22], collection[28] };
		Card[] pileSix = { collection[5], collection[11], collection[17], collection[23], collection[29] };

		for (int i = 0; i <= 4; i++) {
			collection[i] = pileOne[i];

		}
		for (int i = 5; i <= 9; i++) {
			collection[i] = pileTwo[i - 5];

		}
		for (int i = 10; i <= 14; i++) {
			collection[i] = pileThree[i - 10];

		}
		for (int i = 15; i <= 19; i++) {
			collection[i] = pileFour[i - 15];

		}
		for (int i = 20; i <= 24; i++) {
			collection[i] = pileFive[i - 20];

		}
		for (int i = 25; i <= 29; i++) {
			collection[i] = pileSix[i - 25];

		}

	}

	// Method for drawing cards from the deck, creates a new array with
	// which to store the deck. Cards are always drawn from the top down
	// and randomness comes from shuffling the deck at the beginning.

	public Card drawCard() {
		Card[] deckDrawn = new Card[collection.length - 1];
		for (int i = 0; i < deckDrawn.length; i++) {
			deckDrawn[i] = collection[i + 1];
		}

		Card drawn = collection[0];
		collection = deckDrawn;

		return drawn;
	}

	// toString method to give information on deck. Mostly just for test
	// purposes.

	public String toString() {
		String myString = "[";
		for (int i = 0; i <= 29; i++) {
			myString = myString + collection[i].toString();
		}

		myString = myString + "]";

		return myString;
	}

}
