package player;

import java.util.Random;

import Weapon_Caster.ArchWizardStaff;
import Weapon_Caster.Basic_Wand;
import Weapon_Caster.Scepter;
import Weapons_Melee.*;
import game.GameMain;
import game.UI;
import inventory.SuperWeapon;

public class Warrior extends Player {
	
	public Warrior() {
		block = 25;
	}

	public String getAbility1Name() {
		return "Reckless Strike";
	}

	public String getAbility2Name() {
		return "Dragon Charge";
	}

	public int getAbility1Dmg() {
		return 7;
	}

	public int getAbility2Dmg() {
		return 10;
	}

	public int getAbility1CD() {
		return 0;
	}

	public int getAbility2CD() {
		return 2;
	}

	public int getHp() {
		return super.getHp() + 15;
	}

	public int getMaxHp() {
		maxHp += this.getHp();
		return maxHp;
	}

	public int getAttackDmg() {
		return super.getAttackDmg() + 2;
	}

	public int getSpeed() {
		return super.getSpeed() + 3;
	}

	public SuperWeapon[] getWeapons() {
		SuperWeapon[] weapons = { new Training_Sword(), new Sword(), new LongSword(), new MorningStar() };
		return weapons;
	}

	public static String showClassExtras() {
		return "Warriors have a chance to block attacks\n";
	}

	public String showClassName() {
		return "warrior";
	}

	// Warrior bonus: Block
	// Block entire attack
	public String showBonusAbility() {
		return "Block attack";
	}
	
	public int getBlock() {
		return block;
	}
	
	public void setBlock(int block) {
		this.block = block;
	}

	public String showClass() {
		return "Warrior";
	}

}
