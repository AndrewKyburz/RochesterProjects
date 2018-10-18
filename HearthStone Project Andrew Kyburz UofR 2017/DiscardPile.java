
public class DiscardPile {

	private Card[] graveyard;
	private Card[] emptyGraveyard;
	private int graveyardSize = 0;

	// Creates new graveyard which is empty
	public DiscardPile() {
		graveyard = new Card[0];

		emptyGraveyard = graveyard;
	}

	// Getters

	public Card[] getGraveyard() {
		return graveyard;
	}

	public int getGraveyardSize() {
		return graveyardSize;
	}

	public Card getGraveyardCard(int grave) {
		return graveyard[grave];
	}

	// Resets graveyard to empty
	public void resetGraveyard() {
		graveyard = emptyGraveyard;
		graveyardSize = 0;
	}

	// adds card to graveyard
	public void addDeadCard(Card dead) {
		Card[] graveYardInterm = new Card[graveyard.length + 1];
		graveYardInterm[graveyard.length] = dead;
		for (int i = 0; i < graveyard.length; i++) {
			graveYardInterm[i] = graveyard[i];
		}
		graveyardSize++;
		graveyard = graveYardInterm;
	}

}
