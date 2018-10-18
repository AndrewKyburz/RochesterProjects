

public abstract class Card {

	//Fields for Card
	private int attack;
	private int health;
	private int currentHealth;
	private int resourceCost;
	private String rarity;
	private String name;

	public Card() {

	}

	//Accessors
	
	public int getAttack() {
		return attack;
	}

	public int getHealth() {
		return health;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public int getResourceCost() {
		return resourceCost;
	}

	public String getRarity() {
		return rarity;
	}

	public String getName() {
		return name;
	}

	
	//Mutators
	
	public void setAttack(int attack) {
		this.attack = attack;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}

	public void setResourceCost(int resourceCost) {
		this.resourceCost = resourceCost;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	public void setName(String name) {
		this.name = name;
	}

	//Take Damage Method
	
	

	/*public void takeDamageHero(EnemyHero enemy){
		int enemyDamage = enemy.getAttack();
		currentHealth = (health - enemyDamage);
		
	}*/
	
	public String toString(){
		return "N:" + name + ", A:"+attack+", H:" + currentHealth + ", RC:" + resourceCost + " Rar:" + rarity;
	}
	
	
		

}
