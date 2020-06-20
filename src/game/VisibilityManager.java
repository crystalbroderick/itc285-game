package game;



public class VisibilityManager {

	UI ui;

	public VisibilityManager(UI userInterface) {

		ui = userInterface;
	}

	public void showTitleScreen() {
		// Show the title screen
		ui.titlePanel.setVisible(true);
		ui.startB.setVisible(true);

		// Hide the game screen
		ui.playerP.setVisible(false);
		ui.enemyP.setVisible(false);
		ui.endLabel.setVisible(false);
		ui.statsP.setVisible(false);
		ui.textP.setVisible(false);
		ui.choiceP.setVisible(false);
		ui.enemyHpBarP.setVisible(false);
		ui.hpBarP.setVisible(false);
		ui.statsB.setVisible(false);
		ui.potionB.setVisible(false);
		ui.inventoryButton.setVisible(false);
		ui.inventoryPanel.setVisible(false);
		

	}

	public void titleToGame() {
		// Request focus to main frame to use keyhandler
		ui.frame.setFocusable(true);
		ui.frame.requestFocus();
		ui.endPanel.setVisible(false);
		// Hide title screen and user input
		ui.titlePanel.setVisible(false);
		ui.startB.setVisible(false);
		ui.nameInputPanel.setVisible(false);

		// Show the game screen
		ui.playerP.setVisible(true);
		ui.enemyP.setVisible(true);
		ui.statsP.setVisible(false);
		ui.textP.setVisible(true);
		ui.choiceP.setVisible(true);
		ui.enemyHpBarP.setVisible(true);
		ui.hpBarP.setVisible(true);
		ui.statsB.setVisible(true);
		ui.potionB.setVisible(true);
		ui.inventoryButton.setVisible(true);

	}

	public void gameOver() {
		// Display end screen with choices to retry/quit
		ui.endPanel.setVisible(true);
		ui.endLabel.setVisible(true);
		ui.startB.setVisible(false);
		ui.choiceP.setVisible(true);
		
		// Hide the game screen
		ui.playerP.setVisible(false);
		ui.enemyP.setVisible(false);
		ui.statsP.setVisible(false);
		ui.textP.setVisible(false);
		ui.enemyHpBarP.setVisible(false);
		ui.hpBarP.setVisible(false);
		ui.statsB.setVisible(false);
		ui.potionB.setVisible(false);
		ui.inventoryButton.setVisible(false);
		ui.inventoryPanel.setVisible(false);
		
	}
	
	public void endingScreen() {
		// Display end screen with choices to retry/quit
		ui.endPanel.setVisible(true);
		ui.endLabel.setVisible(true);
		ui.startB.setVisible(false);
		ui.choiceP.setVisible(true);
		
		// Hide the game screen
		ui.playerP.setVisible(false);
		ui.enemyP.setVisible(false);
		ui.statsP.setVisible(false);
		ui.textP.setVisible(false);
		ui.enemyHpBarP.setVisible(false);
		ui.hpBarP.setVisible(false);
		ui.statsB.setVisible(false);
		ui.potionB.setVisible(false);
		ui.inventoryButton.setVisible(false);
		ui.inventoryPanel.setVisible(false);
		
	}

}
