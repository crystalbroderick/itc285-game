package enemies;

public class Wolf_Pack extends SuperMonster {
	public Wolf_Pack() {
		name = "Wolf Pack";
		enemyHP = rand.nextInt(30) + 10;
		maxEnemyHP += enemyHP;
		attack = rand.nextInt(7) + 2;
		speed = rand.nextInt(7);
		// TODO: add more attackMessages
		attackMessage = "The pack surrounds you and oen strikes from behind";
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