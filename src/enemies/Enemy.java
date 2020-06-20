package enemies;

import java.util.Random;

public class Enemy {
	static Random rand = new Random();
	static String[] enemies = { "Skeleton", "Zombie", "Bat" };

	// Enemy Variables
	public static int maxEnemyHP = 75;
	public static int enemyAttackDmg = 5;
	public static int enemySpeed = 7;

	public static int getEnemyHP() {
		int enemyHP = rand.nextInt(maxEnemyHP);
		return enemyHP;
	}

	public static int getEnemyDmg() {
		int enemyDmg = rand.nextInt(enemyAttackDmg);
		return enemyDmg;
	}

	public static int getEnemySpeed() {
		int enemySpd = rand.nextInt(enemySpeed);
		return enemySpd;
	}

}