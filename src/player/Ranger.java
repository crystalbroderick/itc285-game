package player;

import Weapons_Melee.Stick;
import Weapons_Ranged.*;
import game.GameMain;
import game.UI;
import inventory.SuperWeapon;

public class Ranger extends Player {

	public String getAbility1Name() {
		return "Double Tap";
	}

	public String getAbility2Name() {
		return "Snipe";
	}

	public int getAbility1Dmg() {
		return 4;
	}

	public int getAbility2Dmg() {
		return 20;
	}
	public int getBlock() {
		return 0;
	}

	public int getAbility1CD() {
		return 0;
	}

	public int getAbility2CD() {
		return 5;
	}

	public int getHp() {
		return super.getHp() + 7;
	}

	public int getMaxHp() {
		maxHp += this.getHp();
		return maxHp;
	}

	public int getAttackDmg() {
		return super.getAttackDmg() + 3;
	}

	public int getSpeed() {
		return super.getSpeed() + 6;
	}

	// Ranger bonus: speed
	// Almost always goes first

	public SuperWeapon[] getWeapons() {
		SuperWeapon[] weapons = { new SlingShot(), new Bow(), new Crossbow(), new Javelin() };
		return weapons;
	}

	public static String showClassExtras() {
		return "Rangers have more speed which gives them higher opportunity to go first ";
	}

	public String showClassName() {
		return "ranger";
	}

}