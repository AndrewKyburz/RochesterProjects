import java.util.Random;

public class UncommonCard extends Card {

	Random randomGen = new Random();
	
	//Assigns a set of random values that determine the unique aspects of the card
	public UncommonCard() {
		super();

		int nameFinder = randomGen.nextInt(4);

		switch (nameFinder) {
		case 0:
			setName("Warlock Baby-Eater");
			break;
		case 1:
			setName("Rude Potion Monger");
			break;
		case 2:
			setName("Knife-Wielding Gnome");
			break;
		case 3:
			setName("Well-trained Horse");
		}

		setRarity("Uncommon");
		setAttack(randomGen.nextInt(12));
		setHealth(12 - getAttack());
		setCurrentHealth(getHealth());
		setResourceCost(randomGen.nextInt(4) + 2);

	}

}