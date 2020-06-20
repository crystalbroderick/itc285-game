package player;

import java.awt.List;
import java.util.LinkedList;

import Weapons_Melee.Stick;
import game.Game;
import game.GameMain;
import game.UI;
import inventory.SuperWeapon;

public class Player {

	public int hp;
	public int maxHp;
	public SuperWeapon currentWeapon;
	public int AttackDmg;
	public int potions;
	public int lives;
	public int block;
	public int speed;
	public String Ability1Name;
	public String Ability2Name;
	public String Ability3Name;
	public int Ability1Dmg;
	public int Ability2Dmg;
	public int Ability3Dmg;
	public int Ability1CD;
	public int Ability2CD;
	public int Ability3CD;

	public String getAbility1Name() {
		return Ability1Name;
	}

	public void setAbility1Name(String ability1Name) {
		Ability1Name = ability1Name;
	}

	public String getAbility2Name() {
		return Ability2Name;
	}

	public void setAbility2Name(String ability2Name) {
		Ability2Name = ability2Name;
	}

	public int getAbility1Dmg() {
		return Ability1Dmg;
	}

	public void setAbility1Dmg(int ability1Dmg) {
		Ability1Dmg = ability1Dmg;
	}

	public int getAbility2Dmg() {
		return Ability2Dmg;
	}

	public void setAbility2Dmg(int ability2Dmg) {
		Ability2Dmg = ability2Dmg;
	}

	public int getAbility1CD() {
		return Ability1CD;
	}

	public void setAbility1CD(int ability1cd) {
		Ability1CD = ability1cd;
	}

	public int getAbility2CD() {
		return Ability2CD;
	}

	public void setAbility2CD(int ability2cd) {
		Ability2CD = ability2cd;
	}

	public String Ability1() {
		return "Ability one";
	}

	public String Ability2() {
		return "Ability 2";
	}

	public SuperWeapon[] getWeapons() {
		SuperWeapon[] weapons = { new Stick() };
		return weapons;
	}

	public String showClassName() {
		return "Player";
	}

	public int getHp() {
		hp = 50;
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHP) {
		maxHP = this.getHp();
		this.maxHp = maxHP;
	}

	public SuperWeapon getCurrentWeapon() {
		return currentWeapon;
	}

	public void setCurrentWeapon(SuperWeapon currentWeapon) {
		this.currentWeapon = currentWeapon;
	}

	public int getAttackDmg() {
		return AttackDmg;
	}

	public void setAttackDmg(int attackDmg) {
		AttackDmg = attackDmg;
	}

	public int getPotions() {
		return potions;
	}

	public void setPotions(int potions) {
		this.potions = potions;
	}

	public int getLives() {
		lives = 0;
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public int getBlock() {
		return 0;
	}

	public void setBlock(int block) {
		this.block = block;
	}

	public int getSpeed() {
		return speed;
	}

	public int setSpeed(int speed) {
		return this.speed;
	}

}
