package enemies;

import java.util.Random;

public class Zombie extends SuperMonster {
	Random rand = new Random();
	public Zombie() {
		name = "Zombie";
		enemyHP = rand.nextInt(40 + 1 - 20) + 20;
		maxEnemyHP += enemyHP;
		attack = rand.nextInt(20 + 1 - 10) + 10;
		speed = rand.nextInt(2);
		attackMessage = "The zombie lunges forward once you're in range- scratching your arm!";
	}
	
	public int getAttack() {
		return attack;
	}
	public int getMaxEnemyHP() {
		return maxEnemyHP;
	}
	public int getEnemyHP() {
		return enemyHP;
	}

}
