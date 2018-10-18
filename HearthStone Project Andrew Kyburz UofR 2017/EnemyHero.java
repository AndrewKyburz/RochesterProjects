
public class EnemyHero {

	private int hitPoints;
	private int attack;

	public EnemyHero() {
		hitPoints = 100;
		attack = 0;

	}

	// Enemy Power up

	public void enemyPowerUp() {
		attack = attack + 1;
	}

	// Getters

	public int getHitPoints() {
		return hitPoints;
	}

	public int getAttack() {
		return attack;
	}

	// Setters

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

}