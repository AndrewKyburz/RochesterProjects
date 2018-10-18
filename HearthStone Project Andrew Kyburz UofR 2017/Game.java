import java.util.Scanner;
import java.util.Random;

public class Game {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Random randomGen = new Random();

		// Initialize booleans for while loops
		boolean program = true;
		boolean match = false;
		boolean round = false;
		int score = 30;
		int turnCounter = 0;

		System.out.println("Hello and welcome to Hearthstone-Lite");

		// Creates player with deck of cards

		Player playerOne = new Player();
		EnemyHero enemy = new EnemyHero();
		Board field = new Board();

		// Outer program loop, for starting new matches, giving player option to
		// quit.

		while (program) {

			// Resets deck to full capacity
			playerOne.getPlayerDeck().resetDeck();

			// Resets Hand to empty
			playerOne.getPlayerHand().resetHand();

			// Resets graveyard to empty
			playerOne.getDiscardPile().resetGraveyard();

			// Resets field to empty
			field.resetField();

			// Resets Player health and resource
			playerOne.setPlayerHealth(30);
			playerOne.setResourceCount(0);

			// Set enemy health
			enemy.setHitPoints(100);
			enemy.setAttack(0);

			// set turn counter to zero
			turnCounter = 0;

			// Shuffles Deck.. a lot.

			for (int i = 0; i <= randomGen.nextInt(40); i++) {
				playerOne.getPlayerDeck().shuffleDeck();
				playerOne.getPlayerDeck().shuffleDeck();
				playerOne.getPlayerDeck().shuffleDeck();
			}

			System.out.println("You currently have a score of : " + score);
			System.out.print("Would you like to: \n[1] Play a match\n[2] Quit\nResponse:");

			int response = scanner.nextInt();

			System.out.println("_______________________________________");

			if (response == 1) {
				match = true;
				System.out.println("Match started! Have fun!");
			}

			if (response == 2) {
				program = false;
			}

			// Inner Loop for Match: While loop for a game
			while (match) {// Match Begin

				System.out.println("Round " + (turnCounter + 1) + " start");
				System.out.println("The enemy has " + enemy.getHitPoints() + " hit points.");
				System.out.println("Your hero has " + playerOne.getPlayerHealth() + " hit points.");

				round = true;

				while (round) {
					// Round Begin
					// Turn Counter goes up as well as resource counter
					turnCounter++;

					// Enemy Powers up

					// Draw four cards if first turn, otherwise draw one.
					if (turnCounter == 1) {
						playerOne.getPlayerHand().drawCard(playerOne.getPlayerDeck().drawCard());
						playerOne.getPlayerHand().drawCard(playerOne.getPlayerDeck().drawCard());
						playerOne.getPlayerHand().drawCard(playerOne.getPlayerDeck().drawCard());
						playerOne.getPlayerHand().drawCard(playerOne.getPlayerDeck().drawCard());
						System.out.println("You drew your first four cards!");

					} else {
						playerOne.getPlayerHand().drawCard(playerOne.getPlayerDeck().drawCard());
						System.out.println("You drew a card!");
					}

					// Enemy attack increases until 15

					if (enemy.getAttack() < 15) {
						enemy.enemyPowerUp();
					}

					// Resource counter goes up if less than 10
					if (playerOne.getResourceCount() < 10) {
						playerOne.setResourceCount(playerOne.getResourceCount() + 1);
					}

					// Sets current resource for the turn
					playerOne.setResourceCurrent(playerOne.getResourceCount());

					// Cause player behavior loop to activate
					boolean behaviorLoop = true;

					// Loop which allows for continuous player activity, ended
					// with 4(End turn)
					while (behaviorLoop) {

						// Gives player information about current resources

						System.out.println("_______________________________________");
						System.out.println("You have " + playerOne.getResourceCurrent() + " resource points to use.");

						// Option-pane for responses
						System.out.print("What would you like to do during the round?\n "
								+ "[1]Look at hand [2] play a card [3] GetBoard State [4]End turn [5] View Discard-Pile\n Response:");
						int responseRound = scanner.nextInt();

						System.out.println("_______________________________________");

						// Gives information of hand
						if (responseRound == 1) {
							if (playerOne.getPlayerHand().getHandCount() == 0) {
								System.out.println("Your hand is empty");
							} else {
								System.out.println("Hand:");
								for (int i = 0; i < playerOne.getPlayerHand().getHandCount(); i++) {

									System.out.println("Card " + (i + 1) + ":"
											+ playerOne.getPlayerHand().getSpecificCard(i).toString() + "");
								}
							}

						}
						// Opens respons pane for picking a card to play with an
						// integer value
						else if (responseRound == 2) {

							// If you have no cards, skips and tells you you
							// have no cards

							if (playerOne.getPlayerHand().getHandCount() == 0) {
								System.out.println("You have no cards in your hand!");
							} else {

								// If you have no resources skips and tells you
								// that you have no resources.

								if (playerOne.getResourceCurrent() == 0) {
									System.out.println("You have no resources.");
								} else {

									// Allows you to pick a card with an integer
									// value

									System.out.print(
											"Please enter the card number you wish to play (Integer from : 1 to "
													+ playerOne.getPlayerHand().getHandCount() + ")\nResponse:");
									int responseCard = scanner.nextInt();

									// If the resource cost of the card you pick
									// is too high, tells you.
									if (playerOne.getPlayerHand().getSpecificCard(responseCard - 1)
											.getResourceCost() > playerOne.getResourceCurrent()) {
										System.out.println("You don't have the resources to play that card!");
									} else {

										// Sets resourceCurrent
										playerOne.setResourceCurrent(playerOne.getResourceCurrent() - playerOne
												.getPlayerHand().getSpecificCard(responseCard - 1).getResourceCost());

										field.playCard(playerOne.getPlayerHand().getSpecificCard(responseCard - 1));

										playerOne.getPlayerHand().playCard(responseCard);

									}
								}
							}

							// End of nested card selection

						}
						// Gives board information from left to right (top to
						// bottom)
						else if (responseRound == 3) {
							if (field.getBoardSize() == 0) {
								System.out.println("Your field is empty");
							} else {
								System.out.println("Board:");
								for (int i = 0; i < field.getBoardSize(); i++) {
									System.out.println("Card " + (i + 1) + ":" + field.getBoardCard(i).toString());
								}
							}

						}

						// End turn function, also applies damage step and card
						// removal step

						else if (responseRound == 4) {
							behaviorLoop = false;
							// Sets behavior loop to false, so will end
							// and does end of round calculations regarding
							// enemy hero attacking, and card removal on field.

							if (field.getBoardSize() == 0) {

								playerOne.setPlayerHealth(playerOne.getPlayerHealth() - enemy.getAttack());
								System.out.println(
										"The enemy attacked your hero for:" + enemy.getAttack() + " points of damage.");

							} else {
								
								// For loop that calculates my field damage
								for (int i = 0; i < field.getBoardSize(); i++) {
									enemy.setHitPoints(enemy.getHitPoints() - field.getBoardCard(i).getAttack());
									System.out.println(field.getBoardCard(i).getName() + " did "
											+ field.getBoardCard(i).getAttack() + " points of damage. ");

								}

								// Calculates damage between left most monster
								// and enemy
								field.getBoardCard(0)
										.setCurrentHealth(field.getBoardCard(0).getCurrentHealth() - enemy.getAttack());

								enemy.setHitPoints(enemy.getHitPoints() - field.getBoardCard(0).getAttack());

								System.out.println("The enemy hero took " + field.getBoardCard(0).getAttack()
										+ " points of damage from attacking.");

								// Conditional if my leftmost monster drops
								// below 0
								if (field.getBoardCard(0).getCurrentHealth() <= 0) {

									// Deals piercing damage, adds to discard
									// pile, and removes from field.
									playerOne.setPlayerHealth(
											playerOne.getPlayerHealth() + field.getBoardCard(0).getCurrentHealth());
									System.out.println(field.getBoardCard(0).getName() + " died.");
									System.out.println("Your hero took " + (-field.getBoardCard(0).getCurrentHealth())
											+ " points of piercing damage.");
									playerOne.getDiscardPile().addDeadCard(field.getBoardCard(0));
									field.removeCard(0);
								}

							}
						} else if (responseRound == 5) {
							if (playerOne.getDiscardPile().getGraveyardSize() == 0) {
								System.out.println("Your discard pile is empty");
							} else {
								System.out.println("Discard Pile:");
								for (int i = 0; i < playerOne.getDiscardPile().getGraveyardSize(); i++) {
									System.out.println(
											"Card " + (i + 1) + ":" + playerOne.getDiscardPile().getGraveyardCard(i));
								}
							}

						}

					} // Behaviorloop ends

					round = false;

				} // Round End

				// Checks if playerHealth or enemy hero health is below 0.
				if ((playerOne.getPlayerHealth() <= 0) || enemy.getHitPoints() <= 0) {
					match = false;
					if (playerOne.getPlayerHealth() <= 0) {
						System.out.println("Oh no you lost the game!");
						System.out.println("_______________________________________");
						score = score - 1;
					} else {
						System.out.println("Congratulations, you won the game!");
						System.out.println("_______________________________________");
						score = score + 2;
					}
				}

			} // Match

			if (score <= 0) {
				program = false;
			}

		} // Program End

		scanner.close();
	}// Main method end

}// Game class end
