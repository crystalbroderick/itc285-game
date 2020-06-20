package enemies;

import java.util.Random;

public class Goblin extends SuperMonster{
	static Random rand = new Random();
	public Goblin() {
		name = "Goblin";
		enemyHP = rand.nextInt(10 - 5) + 5;
		maxEnemyHP += enemyHP;
		attack = 3;
		speed = rand.nextInt(7);
		//TODO: add more attackMessages
		attackMessage = "The goblin hit you with his club!";
		
	}
	
	public int getAttack() {
		return this.attack;
	}
	public int getMaxEnemyHP() {
		return this.maxEnemyHP;
	}
	public int getEnemyHP() {
		return this.enemyHP;
	}
}
