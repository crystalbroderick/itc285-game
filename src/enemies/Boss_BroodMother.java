package enemies;

import java.util.Random;


public class Boss_BroodMother extends SuperMonster{
	Random rand = new Random();
	public Boss_BroodMother() {
		name = "Brood Mother";
		enemyHP = rand.nextInt(30 - 20) + 20;
		maxEnemyHP =+ enemyHP;
		attack = rand.nextInt(10 - 5) + 5;
		speed = rand.nextInt(7);
		attackMessage = "hits you with web shot.";
		
	}
	
	public int getAttack() {
		return attack;
	}
	public int getMaxEnemyHP() {
		return maxEnemyHP;
	}

}
