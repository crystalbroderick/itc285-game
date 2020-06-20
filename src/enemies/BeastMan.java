package enemies;

import java.util.Random;

public class BeastMan extends SuperMonster {
	Random rand = new Random();
	public BeastMan() {
		name = "Beast Man";
		enemyHP = rand.nextInt(40 + 1 - 10) + 30;
		maxEnemyHP += enemyHP;
		attack = rand.nextInt(20 + 1 - 10) + 10;
		speed = rand.nextInt(10);
		attackMessage = "The beast man rampages towards you and strikes!";
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
