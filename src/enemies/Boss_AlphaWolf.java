package enemies;

import java.util.Random;

public class Boss_AlphaWolf extends SuperMonster {
	Random rand = new Random();

	public Boss_AlphaWolf() {
		name = "Alpha Wolf";
		enemyHP = rand.nextInt(60 - 50) + 50;
		maxEnemyHP = +enemyHP;
		attack = rand.nextInt(13 - 5) + 5;
		speed = rand.nextInt(7);
		attackMessage = "bites you";
	}
	
	public int getAttack() {
		attack = rand.nextInt(5 - 3) + 3;
		return attack;
	}

	/*public int getEnemyHP() {
		this.enemyHP = rand.nextInt(6 - 5) + 5;
		return enemyHP;
	}*/
	public int getMaxEnemyHP() {
		maxEnemyHP += this.enemyHP;
		return maxEnemyHP;
	}
	public int getSpeed() {
		speed = rand.nextInt(7);
		return speed;
	}
}
