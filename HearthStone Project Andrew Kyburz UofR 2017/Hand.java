
public class Hand {

	private Card[] hand;
	private Card[] handMemory;
	private int handCount = 0;

	public Hand() {
		hand = new Card[0];

		handMemory = hand;
	}

	// Getters

	public Card[] getHand() {
		return hand;
	}

	public int getHandCount() {
		return handCount;
	}

	public Card getSpecificCard(int cardPosition) {
		return hand[cardPosition];
	}

	// Setters

	public void setHandSize(Card[] hand) {
		this.hand = hand;
	}

	public void setHandCount(int handCount) {
		this.handCount = handCount;
	}

	// Methods for interacting with hand
	
	//Method for drawing a card, creates new temp array
	//and assigns old values to array and then back to original array.
	public void drawCard(Card drawn) {
		Card[] handIntermediate = new Card[hand.length + 1];
		handIntermediate[hand.length] = drawn;
		if (hand.length != 0) {
			for (int i = 0; i < (hand.length); i++) {
				handIntermediate[i] = hand[i];
			}
		}
		handCount++;
		hand = handIntermediate;
	}

	// Resets Hand

	public void resetHand() {
		hand = handMemory;
		handCount = 0;
	}

	// Removes card from hand
	public void playCard(int played) {
		Card[] handPlay = new Card[hand.length - 1];

		for (int i = 0; i < played - 1; i++) {
			handPlay[i] = hand[i];
		}

		for (int i = (played); i < hand.length; i++) {
			handPlay[i - 1] = hand[i];
		}
		handCount--;

		hand = handPlay;

	}

}
