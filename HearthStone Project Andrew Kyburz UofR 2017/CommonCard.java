import java.util.Random;

public class CommonCard extends Card {

	Random randomGen = new Random();
	
	//Assigns a set of random values that determine the unique aspects of the card
	public CommonCard() {
		super();
		
		
		//Random generator determines name
		int nameFinder = randomGen.nextInt(4);

		switch (nameFinder) {
		case 0:
			setName("Kobold Blood-Ripper");
			break;
		case 1:
			setName("Goldshire Footman");
			break;
		case 2:
			setName("Orc Bruiser");
			break;
		case 3:
			setName("Murloc Fish-slinger");
		}

		setRarity("Common");
		setAttack(randomGen.nextInt(8));
		setHealth(8 - getAttack());
		setCurrentHealth(getHealth());
		setResourceCost(randomGen.nextInt(3) + 1);

	}

}
