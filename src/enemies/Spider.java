package enemies;

public class Spider extends SuperMonster {
	public Spider() {
		name = "Spider";
		enemyHP = rand.nextInt(7 - 3) + 3;
		maxEnemyHP += enemyHP;
		attack = 2;
		speed = rand.nextInt(7);
		attackMessage = "A spider lunges at you and bites";
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
