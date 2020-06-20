package player;

import Weapon_Caster.*;
import game.*;
import inventory.SuperWeapon;

public class Mage extends Player {

	public String getAbility1Name() {
		return "Fireball";
	}

	public String getAbility2Name() {
		return "Pyroblast";
	}
	
	public int getLives() {
		return super.getLives() + 1;
	}

	public int getAbility1Dmg() {
		return 5;
	}

	public int getAbility2Dmg() {
		return 15;
	}

	public int getAbility1CD() {
		return 0;
	}

	public int getAbility2CD() {
		return 3;
	}
	
	public int getBlock() {
		return 0;
	}

	public int getHp() {
		return super.getHp() + 3;
	}

	public int getMaxHp() {
		maxHp += this.getHp();
		return maxHp;
	}

	public int getAttackDmg() {
		return super.getAttackDmg() + 5;
	}

	public int getSpeed() {
		return super.getSpeed() + 2;
	}

	public SuperWeapon[] getWeapons() {
		SuperWeapon[] weapons = { new Basic_Wand(), new Scepter(), new Staff(), new ArchWizardStaff() };
		return weapons;
	}

	// Mage bonus: resurrection
	// extra life per game
	public String showBonusAbility() {
		return "Single use resurrection spell";
	}

	public static String showClassExtras() {
		return "Mages have a single-use resurrection spell saved for emergencies. ";
	}

	public String showClassName() {
		return "mage";
	}



}
