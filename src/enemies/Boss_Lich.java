package enemies;

import java.util.Random;

public class Boss_Lich extends SuperMonster{
	Random rand = new Random();
	public Boss_Lich() {
		name = "Lich King";
		enemyHP = rand.nextInt(80 - 70) + 70;
		maxEnemyHP += enemyHP;
		attack = rand.nextInt(20 - 15) + 15;
		speed = rand.nextInt(2);
		attackMessage = "The Lich King calls upon the undead to attack then casts ice attack!";
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
