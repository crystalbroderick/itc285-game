package enemies;

import java.util.Random;
import inventory.SuperWeapon;

public class SuperMonster {
	static Random rand = new Random();
	public String name;
	public int enemyHP;
	public int attack;
	public int speed;
	public int maxEnemyHP;
	public String attackMessage;
	public String type;
	public SuperWeapon dropLoot;
	
	
	
	public static SuperMonster[] getEnemies() {
		SuperMonster[] enemies = {new Spider(), new Goblin(), new Snake(), new Wolf_Pack(), new Bat()};
	return enemies;
	}
	
	public String getName() {
		return name;
	}
	public String setName(String name) {
		return name;
	}
	public int getEnemyHP() {
		return enemyHP;
	}
	public void setEnemyHP(int enemyHP) {
		this.enemyHP = enemyHP;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getMaxEnemyHP() {
		return maxEnemyHP;
	}
	public void setMaxEnemyHP(int maxEnemyHP) {
		this.maxEnemyHP = maxEnemyHP;
	}
	public String getAttackMessage() {
		return attackMessage;
	}
	public void setAttackMessage(String attackMessage) {
		this.attackMessage = attackMessage;
	}

}