package enemies;

import java.util.Random;

public class Bat extends SuperMonster {
	static Random rand = new Random();

	public Bat() {
		name = "Bat";
		attackMessage = "The bat bites you!";
	}
	
	public int getAttack() {
		attack = rand.nextInt(5 - 3) + 3;
		return attack;
	}

	public int getEnemyHP() {
		this.enemyHP = rand.nextInt(15 - 10) + 10;
		return enemyHP;
	}
	public int getMaxEnemyHP() {
		maxEnemyHP += this.enemyHP;
		return maxEnemyHP;
	}
	public int getSpeed() {
		speed = rand.nextInt(7);
		return speed;
	}
	
	
	
}
