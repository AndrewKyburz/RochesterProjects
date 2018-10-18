import java.util.Random;

public class RareCard extends Card {

	Random randomGen = new Random();
	
	//Assigns a set of random values that determine the unique aspects of the card
	public RareCard() {
		super();

		int nameFinder = randomGen.nextInt(4);

		switch (nameFinder) {
		case 0:
			setName("Roided-up Man-Eater");
			break;
		case 1:
			setName("Murloc Brute-Banger");
			break;
		case 2:
			setName("Booty-bay Bruiser");
			break;
		case 3:
			setName("Murderous Kodo");
		}

		setRarity("Rare");
		setAttack(randomGen.nextInt(16));
		setHealth(16 - getAttack());
		setCurrentHealth(getHealth());
		setResourceCost(randomGen.nextInt(4) + 4);

	}

}