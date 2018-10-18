
public class Player {

	private Deck playerDeck;
	private Hand playerHand;
	private DiscardPile grave;

	private int playerHealth = 30;
	private int resourceCount = 0;
	private int resourceCurrent = 0;
	private int cardCounter = 0;

	public Player() {
		playerDeck = new Deck();
		playerHand = new Hand();
		grave = new DiscardPile();

	}

	// Getters

	public Deck getPlayerDeck() {
		return playerDeck;
	}

	public Hand getPlayerHand() {
		return playerHand;
	}

	public DiscardPile getDiscardPile() {
		return grave;
	}

	public int getPlayerHealth() {
		return playerHealth;
	}

	public int getCardCounter() {
		return cardCounter;
	}

	public int getResourceCount() {
		return resourceCount;
	}

	public int getResourceCurrent() {
		return resourceCurrent;
	}

	// Setters

	public void setPlayerDeck(Deck playerDeck) {
		this.playerDeck = playerDeck;
	}

	public void setPlayerHand(Hand playerHand) {
		this.playerHand = playerHand;
	}

	public void setDiscardPile(DiscardPile grave) {
		this.grave = grave;
	}

	public void setPlayerHealth(int playerHealth) {
		this.playerHealth = playerHealth;
	}

	public void setCardCounter(int cardCounter) {
		this.cardCounter = cardCounter;
	}

	public void setResourceCount(int resourceCount) {
		this.resourceCount = resourceCount;
	}

	public void setResourceCurrent(int resourceCurrent) {
		this.resourceCurrent = resourceCurrent;
	}

}
