package game;

import java.awt.Color;
import java.util.Arrays;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import enemies.*;
import inventory.Item;
import inventory.Item_Empty;
import inventory.Potion_GreaterHeal;
import inventory.Potion_Heal;
import inventory.Potion_SuperHeal;
import inventory.Quest_GoldCrown;
import player.*;

public class Game {
	GameMain main;
	UI ui;
	VisibilityManager vm;
	CreatePlayer cp;
	Story s;
	Item i;

	Random rand = new Random();

	public Game(GameMain m, UI userInterface, VisibilityManager vManager, CreatePlayer create, Story story, Item item) {
		main = m;
		ui = userInterface;
		vm = vManager;
		cp = create;
		s = story;
		i = item;
	}

	// Player Info
	Player p = new Player();
	int potions = p.getPotions();
	int hp = p.getHp();
	int potionChance = 5;
	int block = p.getBlock();
	int speed = p.getSpeed();
	int quadrant = 1;
	int maxHP = p.getMaxHp();
	int lives = p.getLives();
	int buttonPosition = 1;
	String none;
	String ability1;
	String ability2;

	int ability1CD;
	int ability2CD;

	// Inventory
	Item[] pItem = new Item[5];
	Item goldCrown = new Quest_GoldCrown();
	Item[] potionItem = new Item[5];
	Item healPotion = new Potion_Heal();
	int healPotionCount = healPotion.getQuantity();
	Item greatHeal = new Potion_GreaterHeal();
	int greatHealCount = greatHeal.getQuantity();
	Item superHeal = new Potion_SuperHeal();
	int superHealCount = superHeal.getQuantity();
	Item empty = new Item_Empty();

	// Enemies
	SuperMonster monster;
	int enemyLvl;
	private int abilityDmg;
	private String abilityName;

	// Switches screen by calling method
	public void selectPosition(String nextPosition) {
		switch (nextPosition) {
		case "toTitle":
			vm.showTitleScreen();
			defaultSetup();
			ui.titleLabel.setText("SACRED THICKET");
			break;
		case "gameEntrance":
			s.gameEntrance();
			break;
		case "playerName":
			cp.playerName();
			break;
		case "selectClass":
			cp.selectClass();
			break;
		case "leaveEntrance":
			s.leaveEntrance();
			break;
		case "warrior":
			cp.classIntro("warrior");
			classSetup("warrior");
			break;
		case "mage":
			cp.classIntro("mage");
			classSetup("mage");
			break;
		case "ranger":
			cp.classIntro("ranger");
			classSetup("ranger");
			break;
		case "beginFight":
			beginFight();
			break;
		case "attack":
			attack(none);
			break;
		case "end":
			s.end();
			break;
		case "fight":
			fight();
			break;
		case "explore":
			s.explore();
			break;
		case "newEnemy":
			newEnemy();
			break;
		case "questGiver":
			s.questGiver();
			break;
		case "forestIntro":
			s.forestIntro();
			break;
		case "lost":
			s.lost();
			break;
		case "lives":
			lives();
			break;
		case "attackChoices":
			attackChoices();
			break;
		case "ability1":
			attack("ability1");
			break;
		case "ability2":
			attack("ability2");
			break;
		case "ending":
			s.ending();
			break;
		case "endingScreen":
			s.endingScreen();
			break;
		case "exit":
			System.exit(0);
			break;
		}
	}

	public void defaultSetup() {

		main.inventoryStatus = "close";
		main.statsStatus = "close";
		main.potionStatus = "close";
		ui.weaponL.setText("No weapon");
		ui.hpBar.setMaximum(maxHP);
		ui.hpBar.setValue(hp);
		ui.quadLValue.setText(" " + quadrant);
		ui.enemyL.setText(" ");

		pItem[0] = empty;
		pItem[1] = empty;
		pItem[2] = empty;
		pItem[3] = empty;
		pItem[4] = empty;

		potionItem[0] = empty;
		potionItem[1] = empty;
		potionItem[2] = empty;
		potionItem[3] = empty;
		potionItem[4] = empty;
	}

	public void classSetup(String playerClass) {
		if (playerClass.equals("warrior")) {
			p = new Warrior();
			p.currentWeapon = p.getWeapons()[0];
		} else if (playerClass.equals("mage")) {
			p = new Mage();
			p.currentWeapon = p.getWeapons()[0];
		} else if (playerClass.equals("ranger")) {
			p = new Ranger();
			p.currentWeapon = p.getWeapons()[0];
		}
		hp = p.getHp();
		maxHP = p.getMaxHp();
		ui.hpBar.setString("HP: " + hp);
		ui.weaponL.setText(p.currentWeapon.wName);
		ui.hpBar.setValue(hp);
		ui.hpBar.setMaximum(maxHP);
		speed = p.getSpeed();
		lives = p.getLives();
		block = p.getBlock();
	}

	// CHOICES
	// continue to next screen
	public void conChoices() {
		ui.choiceB1.setText(">");
		ui.choiceB2.setText(" ");
		ui.choiceB3.setText(" ");
	}

	// clear textA2
	public void main2Clear() {
		ui.textA2.setText(" ");
	}

	// Encounter
	public void beginFight() {
		if (hp > 1) {
			newEnemy();
			enemyLevels();
			ui.enemyHpBar.setMaximum(monster.maxEnemyHP = monster.getEnemyHP());
			ui.enemyL.setText(monster.name);
			ui.enemyHpBar.setString("HP: " + monster.enemyHP);
			ui.enemyHpBar.setValue(monster.enemyHP);
			ui.enemyP.setBorder(
					BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(1, 5, 0, 0, ui.coolGray),
							ui.enemyL.getText(), 0, TitledBorder.TOP, ui.normalFont, Color.black));
			ui.textA.setText("You have encountered a " + monster.name + "!!");

			fight();
		} else if (hp < 1) {
			lives();
		}
	}

	public void fight() {
		ui.textA2.setText("What would you like to do?");
		ui.choiceB1.setText("Attack");
		ui.choiceB2.setText("Run");
		ui.choiceB3.setText("");
		// main2Clear();
		main.nextPosition1 = "attackChoices";
		main.nextPosition2 = "leaveEntrance";
		main.nextPosition3 = "";
	}

	public void fight2() {
		ui.choiceB1.setText("Attack");
		ui.choiceB2.setText("Run");
		ui.choiceB3.setText("");
		// main2Clear();
		main.nextPosition1 = "attackChoices";
		main.nextPosition2 = "leaveEntrance";
		main.nextPosition3 = "";
	}

	public void newEnemy() {

		if (quadrant <= 4) {
			ui.enemyLvlValue.setText("1");
			SuperMonster enemyRandom[] = { new Spider(), new Goblin() };
			monster = enemyRandom[(int) Math.floor(Math.random() * enemyRandom.length)];
		} else if (quadrant == 5) {
			monster = new Boss_BroodMother();
		} else if (quadrant <= 9) {
			enemyLvl++;
			ui.enemyLvlValue.setText(" " + enemyLvl);
			SuperMonster enemyRandom[] = { new Spider(), new Goblin(), new Snake(), new Wolf_Pack() };
			monster = enemyRandom[(int) Math.floor(Math.random() * enemyRandom.length)];
		} else if (quadrant == 10) {
			monster = new Boss_AlphaWolf();
		} else if (quadrant <= 15) {
			enemyLvl++;
			SuperMonster enemyRandom[] = { new Spider(), new Goblin(), new Snake(), new Wolf_Pack(), new Bat() };
			monster = enemyRandom[(int) Math.floor(Math.random() * enemyRandom.length)];
		} else if (quadrant == 16) {
			monster = new Boss_Goblin();
		} else if (quadrant <= 19) {
			SuperMonster enemyRandom[] = { new Wolf_Pack(), new Bat(), new Zombie(), new BeastMan() };
			monster = enemyRandom[(int) Math.floor(Math.random() * enemyRandom.length)];
		} else if (quadrant == 20) {
			monster = new Boss_Lich();
		} else if (quadrant >= 21) {
			SuperMonster enemyRandom[] = { new Wolf_Pack(), new Bat(), new Zombie(), new BeastMan() };
			monster = enemyRandom[(int) Math.floor(Math.random() * enemyRandom.length)];
		}

	}

	public void enemyLevels() {
		if (enemyLvl < 2) {
			monster.enemyHP += 2;
			monster.attack += 2;
		} else if (enemyLvl < 5) {
			monster.enemyHP += 4;
			monster.attack += 4;
		} else if (enemyLvl < 10) {
			monster.enemyHP += 6;
			monster.attack += 2;
		} else if (enemyLvl > 11) {
			monster.enemyHP += 7;
			monster.attack += 6;
		} else if (enemyLvl > 15) {
			monster.enemyHP += 9;
			monster.attack += 8;
		}
	}

	public void attackChoices() {

		ui.choiceB1.setText(" " + p.getAbility1Name());
		ui.choiceB2.setText(" " + p.getAbility2Name());
		ui.choiceB3.setText("");

		if (ability2CD <= 0) {
			ui.choiceB2.setText(" " + p.getAbility2Name());
			main.nextPosition1 = "ability1";
			main.nextPosition2 = "ability2";
			main.nextPosition3 = "";
		} else {
			ui.choiceB2.setText(" " + p.getAbility2Name() + "(" + ability2CD + " turn CD)");
			main.nextPosition1 = "ability1";
			main.nextPosition2 = "";
			main.nextPosition3 = "";
		}

	}

	public void attack(String ability) {

		if (monster.enemyHP >= 0) {
			if (ability.equals("ability1")) {
				abilityDmg = p.getAbility1Dmg();
				ability2CD--;
			} else if (ability.equals("ability2")) {
				abilityDmg = p.getAbility2Dmg();
				ability2CD = p.getAbility2CD();
			}

			int dmgDealt = p.getAttackDmg() + rand.nextInt(p.currentWeapon.wDmg) + abilityDmg;
			int dmgTaken = monster.attack;
			int eSpeed = monster.speed;
			monster.enemyHP -= dmgDealt;
			hp -= dmgTaken;
			ui.hpBar.setValue(hp);
			ui.hpBar.setString("HP: " + hp);
			ui.enemyL.setText(monster.name);
			ui.enemyHpBar.setString("HP: " + monster.enemyHP);
			ui.enemyHpBar.setValue(monster.enemyHP);

			if (rand.nextInt(100) < p.getBlock()) {
				ui.textA.setText("You blocked an entire attack!\n");
				hp += dmgTaken;
				ui.hpBar.setValue(hp);
				ui.hpBar.setString("HP: " + hp);
				ui.textA2.setText("You hit the " + monster.name + " for " + dmgDealt + " damage.");
				attackChoices();
			} else if (speed > eSpeed) {
				ui.textA.setText("You struck first. " + p.currentWeapon.wMsg + " dealing " + dmgDealt + " damage");
				if (monster.enemyHP >= 0) {
					ui.textA2.setText("You recieve " + dmgTaken + " points of damage in retaliation\n");
					attackChoices();
				} else if (monster.enemyHP <= 0) {
					hp += dmgTaken;
					ui.hpBar.setValue(hp);
					ui.hpBar.setString("HP: " + hp);
					ui.textA2.setText("You killed the monster before it could attack!");
				}
				attackChoices();

			} else if (eSpeed > speed) {
				ui.textA.setText(
						monster.name + " struck first.\n" + monster.attackMessage + "(" + dmgTaken + " damage)\n");
				ui.textA2.setText(p.currentWeapon.wMsg + " (" + dmgDealt + " damage)");
				attackChoices();
			}

			if (hp <= 0) {
				ui.textA.setText(
						monster.name + " struck first.\n" + monster.attackMessage + "(" + dmgTaken + " damage)\n");
				ui.textA2.setText(p.currentWeapon.wMsg + " (" + dmgDealt + " damage)\n");
				conChoices();

				main.nextPosition1 = "lives";
				main.nextPosition2 = " ";
				main.nextPosition3 = " ";
			}
		}
		if (monster.enemyHP <= 0) {
			quadrant++;
			ui.quadLValue.setText(" " + quadrant);
			won();
		}

	}

	public void won() {
		ui.enemyL.setText(monster.name + ": ");
		ui.enemyHpBar.setString("Dead"); // enemy defeated message
		ui.enemyHpBar.setValue(0);
		ui.textA.setText("~ " + monster.name + " was defeated! ~");
		main2Clear();

		if (monster.name.equals("Brood Mother")) {
			p.currentWeapon = p.getWeapons()[1];
			ui.textA2.setText("You picked up " + p.currentWeapon.getwName());
			p.AttackDmg += 2;
		} else if (monster.name.equals("Alpha Wolf")) {
			p.currentWeapon = p.getWeapons()[2];
			ui.textA2.setText("You picked up " + p.currentWeapon.getwName());
			if (p.showClassName().equals("warrior")) {
				p.setBlock(35);
				ui.textA2.setText("You picked up " + p.currentWeapon.getwName() + " and your block chance increased to "
						+ p.getBlock() + "%");
			}
		} else if (monster.name.equals("Hob Goblin")) {
			p.currentWeapon = p.getWeapons()[3];
			p.AttackDmg += 5;
			ui.textA2.setText("You picked up " + p.currentWeapon.getwName());

		} else if (monster.name.equals("Lich King")) {
			ui.textA2.setText("You found a treasure chest containing the gold crown!\nA portal opens up.");
			pItem[0] = goldCrown;
			ui.choiceB1.setText("Go through portal");
			ui.choiceB2.setText("Keep fighting");

			main.nextPosition1 = "ending";
			main.nextPosition2 = "beginFight";

		}
		if (!monster.name.equals("Lich King")) {
			// potion drop chance when enemy defeated
			if (rand.nextInt(100) > potionChance) {
				int potionDrop = rand.nextInt(50);
				if (potionDrop <= 30) {
					addPotionItem(healPotion);
				} else if (potionDrop <= 45) {
					addPotionItem(greatHeal);
				} else if (potionDrop <= 50) {
					addPotionItem(superHeal);
				}

				ui.textA.setText("The " + monster.name + " was defeated and dropped a potion!\n");
				ui.hpBar.setValue(hp);
			}

			conChoices();

			main.nextPosition1 = "beginFight";
			main.nextPosition2 = " ";
			main.nextPosition3 = " ";
		}
	}

	public void addPotionItem(Item Item) {

		if (Arrays.asList(potionItem).contains(Item)) {
			switch (Item.getName()) {
			case "Heal Potion":
				healPotionCount++;
				break;
			case "Great Potion":
				greatHealCount++;
				break;
			case "Super Potion":
				superHealCount++;
				break;
			}
		} else if (!Arrays.asList(potionItem).contains(Item)) {
			int slotNumber = 0;
			while (potionItem[slotNumber] != empty && slotNumber < 4) {
				slotNumber++;
			}

			if (potionItem[slotNumber] == empty) {
				potionItem[slotNumber] = Item;
			}
		}
	}

	public void potionUsed(int slotNumber) {
		hp = hp + potionItem[slotNumber].getHealAmt();
		if (potionItem[slotNumber].getHealAmt() > 0) {
			ui.textA.setText("You heal for " + potionItem[slotNumber].getHealAmt() + "!");
		}

		switch (potionItem[slotNumber].getName()) {
		case "Heal Potion":
			healPotionCount--;
			if (healPotionCount > 0) {
				ui.textA2.setText("You have " + healPotionCount + " remaining");
			} else {
				ui.textA2.setText("You have 0 remaining - defeat enemies for more!");
				potionItem[slotNumber] = empty;
			}
			break;
		case "Great Potion":
			greatHealCount--;
			if (greatHealCount > 0) {
				ui.textA2.setText("You have " + greatHealCount + " remaining");
			} else {
				ui.textA2.setText("You have 0 remaining - defeat enemies for more!");
				potionItem[slotNumber] = empty;
			}
			break;
		case "Super Potion":
			superHealCount--;
			if (superHealCount > 0) {
				ui.textA2.setText("You have " + superHealCount + " remaining");
			} else {
				ui.textA2.setText("You have 0 remaining - defeat enemies for more!");
				potionItem[slotNumber] = empty;
			}

		}

		ui.hpBar.setString("HP: " + hp);
		ui.hpBar.setValue(hp);
	}

	public void itemUsed(int slotNumber) {

		hp = hp + pItem[slotNumber].getHealAmt();

		if (pItem[slotNumber].getHealAmt() > 0) {
			ui.textA.setText("You heal for " + pItem[slotNumber].getHealAmt() + "!");
		}

		switch (pItem[slotNumber].getName()) {
		case "Gold Crown":
			s.ending();
			break;
		}

		ui.hpBar.setString("HP: " + hp);
		ui.hpBar.setValue(hp);

		pItem[slotNumber] = empty;
		ui.itemButton1.setText(pItem[0].getName());
		ui.itemButton2.setText(pItem[1].getName());
		ui.itemButton3.setText(pItem[2].getName());
		ui.itemButton4.setText(pItem[3].getName());
		ui.itemButton5.setText(pItem[4].getName());
	}

	public void lives() {

		if (lives >= 1) {
			hp = p.getMaxHp();
			lives--;
			ui.hpBar.setString("HP: " + hp);
			ui.hpBar.setValue(hp);
			ui.textA.setText("\n");
			ui.textA2.setText("You cast resurrection! " + lives + " resurrection spells left\n");
			conChoices();
			main.nextPosition1 = "fight";

		} else {
			ui.hpBar.setValue(0);
			ui.textA.setText(" ");
			ui.textA2.setText("You have taken too much damage..(" + hp + " overkill)");
			conChoices();

			main.nextPosition1 = "end";

		}

	}

	// shows what choicebutton is being chosen from up down keys (keyHandler)
	public void buttonHighlight() {
		switch (buttonPosition) {
		case 1:
			ui.frame.getRootPane().setDefaultButton(ui.choiceB1);
			ui.choiceB1.setForeground(ui.brickWhite);
			ui.choiceB2.setForeground(Color.BLACK);
			ui.choiceB3.setForeground(Color.BLACK);
			break;
		case 2:
			ui.frame.getRootPane().setDefaultButton(ui.choiceB2);
			ui.choiceB1.setForeground(Color.BLACK);
			ui.choiceB2.setForeground(ui.brickWhite);
			ui.choiceB3.setForeground(Color.BLACK);
			break;
		case 3:
			ui.frame.getRootPane().setDefaultButton(ui.choiceB3);
			ui.choiceB1.setForeground(Color.BLACK);
			ui.choiceB2.setForeground(Color.BLACK);
			ui.choiceB3.setForeground(ui.brickWhite);
			break;

		}

	}
}