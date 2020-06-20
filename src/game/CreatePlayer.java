package game;

import player.*;

public class CreatePlayer {
	GameMain main;
	UI ui;
	
	public CreatePlayer(GameMain m, UI userInterface) {
		main = m;
		ui = userInterface;
	}	
	
	public void playerName() {
		ui.nameInputPanel.setVisible(true);
		ui.choiceP.setVisible(false);
		ui.textA.setText("{Please enter your name.}");
		ui.textA2.setText(" ");

	}

	// SELECT PLAYER CLASS
	public void selectClass() {
		ui.nameInputPanel.setVisible(false);
		ui.textA.setText("Hello, " + ui.nameL.getText() + "! What class are you?");
		// ui.textA.setText(" ");
		ui.frame.setFocusable(true);
		ui.textA2.setText("Select Class:");
		ui.choiceB1.setText("Warrior");
		ui.choiceB2.setText("Mage");
		ui.choiceB3.setText("Ranger");

		main.nextPosition1 = "warrior";
		main.nextPosition2 = "mage";
		main.nextPosition3 = "ranger";
	}

	// PLAYER CLASS INTRO
	public void classIntro(String classIntro) {
		if (classIntro.equals("warrior")) {
			ui.textA.setText(Warrior.showClassExtras());
		} else if (classIntro.equals("mage")) {
			ui.textA.setText(Mage.showClassExtras());
		} else if (classIntro.equals("ranger")) {
			ui.textA.setText(Ranger.showClassExtras());
		}
		introChoices();
	}

	//INTRO CHOICES
	public void introChoices() {
		ui.textA2.setText("\nSelect Class:");
		ui.choiceB1.setText("Yes");
		ui.choiceB2.setText("No");
		ui.choiceB3.setText("");

		main.nextPosition1 = "questGiver";
		main.nextPosition2 = "selectClass";
		main.nextPosition3 = " ";
	}
}
