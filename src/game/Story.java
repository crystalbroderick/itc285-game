package game;

import java.awt.GridBagConstraints;

import inventory.Item;
import inventory.Potion_Heal;


public class Story {
	GameMain m;
	UI ui;
	
	public Story(GameMain main, UI userInterface) {
		m = main;
		ui = userInterface;
	}	
	// STORY START
	// first
	public void titleToToria() {
		ui.textA.setText("Hey, traveler- we are passing by the Sacred Thicket outside of Kingdom of Toria.");
		ui.textA2.setText("Who are you, anyway?");
		ui.frame.setFocusable(true);
		ui.frame.requestFocus();
		m.game.conChoices();
		m.nextPosition1 = "playerName";
		
	}
	
	// second
	public void questGiver() {
		ui.statsB.setVisible(true);
		ui.textA.setText("\"Hmm.. You're a " + m.game.p.showClassName()
				+ ", you say?" + " Here's a " + m.game.p.currentWeapon.wName + ".");
		ui.textA2.setText("Will you find a gold crown inside the Sacred Thicket?...We can split the profit!\"");
		ui.choiceB1.setText("Accept");
		ui.choiceB2.setText("Reject");
		ui.choiceB3.setText("");

		m.nextPosition1 = "forestIntro";
		m.nextPosition2 = "toTitle";
		m.nextPosition3 = "";
	}

	// third
	public void forestIntro() {
		ui.textA.setText("Very Good! Here's 3 heal potions. Uhh, I'll wait here for you outside the thicket. Moral support.");
		ui.textA2.setText("\n*mumbles*\"For some reason, no one has returned..\"");
		m.game.healPotionCount = 3;
		m.game.potionItem[0] = m.game.healPotion;
		
		m.game.conChoices();

		m.nextPosition1 = "gameEntrance";
	}
	
	// forth
	public void gameEntrance() {
		
		ui.textA.setText("You're inside the Sacred Thicket\n \n");
		ui.textA2.setText("Keep going?");
		ui.choiceB1.setText("Yes");
		ui.choiceB2.setText("No");
		ui.choiceB3.setText("");

		m.nextPosition1 = "beginFight";
		m.nextPosition2 = "leaveEntrance";
		m.nextPosition3 = "";
	}
	
	public void ending() {
		ui.textA.setText("WHAT! You found the gold crown?! Congrats!");
		ui.textA2.setText("Let me take this off your hands!");
		ui.choiceB1.setText("Yes");
		ui.choiceB2.setText("No");
		ui.choiceB3.setText("");
		m.nextPosition1 = "endingScreen";
		m.nextPosition2 = "gameEntrance";
	}

	public void lost() {
		ui.textA.setText("Something doesn't feel right. Haven't you been here before?");
		m.game.conChoices();

		m.nextPosition1 = "beginFight";
	}

	public void leaveEntrance() {
		ui.textA.setText("You wander around..");
		m.game.main2Clear();
		m.game.conChoices();

		m.nextPosition1 = "lost";
		m.nextPosition2 = " ";
		m.nextPosition3 = " ";
	}
	
	public void explore() {

		m.game.p.currentWeapon = m.game.p.getWeapons()[1];

		ui.textA.setText("You stumble upon a new weapon!" + "\nYou recieve: " + m.game.p.currentWeapon.wName);
		m.game.main2Clear();
		m.game.conChoices();

		m.nextPosition1 = "beginFight";
		m.nextPosition2 = " ";
		m.nextPosition3 = " ";
	}
	
	public void end() {
		m.game.vm.gameOver();
		ui.textA2.setText(" ");
		ui.hpBar.setValue(0);
		ui.hpBar.setString(" ");
		ui.enemyL.setText("Enemy");
		ui.enemyHpBar.setValue(0);
		ui.enemyHpBar.setString("HP: ");
		ui.choiceB1.setText("EXIT");

		ui.frame.getRootPane().setDefaultButton(ui.startB);
		
		m.nextPosition1 = "exit";
		m.nextPosition2 = "exit";
		m.nextPosition3 = " ";
	}
	
	public void endingScreen() {
		m.game.vm.endingScreen();
		ui.textA2.setText(" ");
		ui.endLabel.setText("You Win!");
		
		ui.enemyHpBar.setValue(0);
		ui.enemyHpBar.setString("HP: ");
		ui.choiceB1.setText("EXIT");

		ui.frame.getRootPane().setDefaultButton(ui.startB);
		
		m.nextPosition1 = "exit";
		m.nextPosition2 = "";
		m.nextPosition3 = " ";
	}
}
