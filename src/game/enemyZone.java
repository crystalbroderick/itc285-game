package game;



import enemies.*;

public class enemyZone {
	public static int quadrant;
	public int zone;
	public static SuperMonster[] getEnemies() {
	SuperMonster[] enemies = {new Spider(), new Goblin(), new Snake(), new Wolf_Pack(), new Bat()};
	return enemies;
	}
	
	public static SuperMonster[] getBosses() {
		SuperMonster[] bosses = {new Boss_BroodMother(), new Boss_AlphaWolf(), new Boss_Goblin()};
		return bosses;
	}
	
	
	
	
	public static int getQuadrant() {
		return quadrant;
	}
	
	public int getZone() {
		return zone;
	}
	
	public enemyZone() {

		
	}

	
}
