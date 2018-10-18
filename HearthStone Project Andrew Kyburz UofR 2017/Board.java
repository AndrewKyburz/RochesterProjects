
public class Board {

	// Board has an array and a size

	private Card[] boardState;
	private Card[] emptyField;
	private int boardSize = 0;

	// Creates new board that is empty

	public Board() {
		boardState = new Card[0];
		emptyField = boardState;
	}

	// Getter
	public Card[] getBoardState() {
		return boardState;
	}

	public Card getBoardCard(int card) {

		return boardState[card];
	}

	public int getBoardSize() {
		return boardSize;
	}

	// Setter
	public void setBoardState(Card[] newBoardState) {
		boardState = newBoardState;
	}
	
	//Plays card on to board
	public void playCard(Card played) {
		Card[] boardStateNew = new Card[boardState.length + 1];
		boardStateNew[boardState.length] = played;
		for (int i = 0; i < boardState.length; i++) {
			boardStateNew[i] = boardState[i];
		}
		boardSize++;
		boardState = boardStateNew;

	}
	
	//Resets the field
	public void resetField() {
		boardState = emptyField;
		boardSize = 0;
	}
	
	//Removes card from board
	public void removeCard(int cardPosition) {

		Card[] boardRemoval = new Card[boardState.length - 1];

		for (int i = 0; i < cardPosition; i++) {
			boardRemoval[i] = boardState[i];
		}

		for (int i = (cardPosition + 1); i < boardState.length; i++) {
			boardRemoval[i - 1] = boardState[i];
		}
		boardSize--;

		boardState = boardRemoval;

	}

}
