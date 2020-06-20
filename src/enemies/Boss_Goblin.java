package enemies;

public class Boss_Goblin extends Goblin {
	public Boss_Goblin() {
		name = "Hob Goblin";
		enemyHP = super.enemyHP * 2;
		attack += super.attack;
		speed = rand.nextInt(3);
		attackMessage = "The boss hit you with his GIANT club!";
	}

}
