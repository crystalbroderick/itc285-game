package enemies;

public class Snake extends SuperMonster {
	public Snake() {
	name = "Snake";
	enemyHP = rand.nextInt(5 - 3) + 3;
	maxEnemyHP += enemyHP;
	attack = 2;
	speed = rand.nextInt(7);
	//TODO: add more attackMessages
	attackMessage = "*HIss* Snake lunges and bites your ankle";
	
}}