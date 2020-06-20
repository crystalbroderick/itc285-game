package game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;

import inventory.Item;
import player.Player;

public class GameMain {
	UI ui = new UI();
	VisibilityManager vm = new VisibilityManager(ui);
	ChoiceHandler cHandler = new ChoiceHandler(this);
	statsHandler sHandler = new statsHandler();
	KeyHandler kHandler = new KeyHandler();
	nameInputHandler niHandler = new nameInputHandler();
	InventoryHandler iHandler = new InventoryHandler();
	potionHandler pHandler = new potionHandler();
	Item i = new Item();
	CreatePlayer cp = new CreatePlayer(this, ui);
	Story s = new Story(this, ui);
	Game game = new Game(this, ui, vm, cp, s, i);

	String nextPosition1;
	String nextPosition2;
	String nextPosition3;
	String inventoryStatus;
	String statsStatus;
	String potionStatus;

	public static void main(String[] args) {

		new GameMain();

	}

	public GameMain() {

		ui.createUI(cHandler, sHandler, kHandler, niHandler, iHandler, pHandler);
		game.defaultSetup();
		vm.showTitleScreen();
		ui.frame.getRootPane().setDefaultButton(ui.startB); // TODO:fix to be able to press enter

	}

	// Opens inventory if you click on inventory button, close when click again.
	// Use item if there is anything stored.
	public class InventoryHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			String yourChoice = event.getActionCommand();

			switch (yourChoice) {
			case "inventoryButton":
				if (inventoryStatus.equals("open")) {
					ui.choiceP.setVisible(false);
					ui.statsP.setVisible(false);
					ui.choiceB1.setVisible(false);
					ui.choiceB2.setVisible(false);
					ui.choiceB3.setVisible(false);
					// ui.choice4.setVisible(false);

					ui.inventoryPanel.setVisible(true);
					ui.itemButton1.setText(game.pItem[0].getName());
					ui.itemButton2.setText(game.pItem[1].getName());
					ui.itemButton3.setText(game.pItem[2].getName());
					ui.itemButton4.setText(game.pItem[3].getName());
					ui.itemButton5.setText(game.pItem[4].getName());

					inventoryStatus = "close";

				} else if (inventoryStatus.equals("close")) {
					ui.choiceP.setVisible(true);
					ui.choiceB1.setVisible(true);
					ui.choiceB2.setVisible(true);
					ui.choiceB3.setVisible(true);
					ui.inventoryPanel.setVisible(false);
					inventoryStatus = "open";

				}

				break;
			// Use item
			case "item1":
				game.itemUsed(0);
				break;
			case "item2":
				game.itemUsed(1);
				break;
			case "item3":
				game.itemUsed(2);
				break;
			case "item4":
				game.itemUsed(3);
				break;
			case "item5":
				game.itemUsed(4);
				break;
			}
			ui.frame.requestFocus();
			ui.frame.setFocusable(true);

		}

	}

	public class potionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String yourChoice = e.getActionCommand();

			switch (yourChoice) {
			case "potionButton":
				if (potionStatus.equals("open")) {
					ui.choiceP.setVisible(false);
					ui.statsP.setVisible(false);
					ui.inventoryPanel.setVisible(false);
					ui.potionP.setVisible(true);
					ui.potion1.setText(game.potionItem[0].getName());
					ui.potion2.setText(game.potionItem[1].getName());
					ui.potion3.setText(game.potionItem[2].getName());
					ui.potion4.setText(game.potionItem[3].getName());
					ui.potion5.setText(game.potionItem[4].getName());
					
					potionStatus = "close";

				} else if (potionStatus.equals("close")) {
					ui.choiceP.setVisible(true);
					ui.choiceB1.setVisible(true);
					ui.choiceB2.setVisible(true);
					ui.choiceB3.setVisible(true);
					ui.statsP.setVisible(false);
					ui.potionP.setVisible(false);
					potionStatus = "open";
					
					
				}

				break;
				// Use item
			case "item1":
				game.potionUsed(0);
				break;
			case "item2":
				game.potionUsed(1);
				break;
			case "item3":
				game.potionUsed(2);
				break;
			case "item4":
				game.potionUsed(3);
				break;
			case "item5":
				game.potionUsed(4);
				break;
			}
			ui.frame.requestFocus();
			ui.frame.setFocusable(true);
		}
	}

	public class statsHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String yourChoice = e.getActionCommand();

			switch (yourChoice) {
			case "statsButton":
				if (statsStatus.equals("open")) {
					ui.choiceP.setVisible(false);
					ui.statsP.setVisible(true);
					ui.inventoryPanel.setVisible(false);
					if (!ui.weaponL.getText().contains("No weapon")) {
						ui.weaponL.setText(" " + game.p.currentWeapon.wName);
						ui.weaponDmgL.setText("Weapon Dmg: " + game.p.currentWeapon.wDmg);
						ui.statsAttack.setText("Attack: " + game.p.getAttackDmg());
						ui.statsSpeed.setText("Speed: " + game.p.getSpeed());
						ui.statsLives.setText("Res: " + game.p.getLives());
						ui.statsBlock.setText("Block: " + game.p.getBlock() + "%");
					}
					statsStatus = "close";

				} else if (statsStatus.equals("close")) {
					ui.choiceP.setVisible(true);
					ui.choiceB1.setVisible(true);
					ui.choiceB2.setVisible(true);
					ui.choiceB3.setVisible(true);
					ui.statsP.setVisible(false);
					statsStatus = "open";

				}

				break;

			}
			ui.frame.requestFocus();
			ui.frame.setFocusable(true);
		}
	} // choose game choice with up down keys

	// choose game choice with up down keys
	public class KeyHandler implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				switch (game.buttonPosition) {
				case 1:
					game.buttonPosition = 1;
					break;
				case 2:
					game.buttonPosition = 1;
					break;
				case 3:
					game.buttonPosition = 2;
					break;
				case 4:
					game.buttonPosition = 3;
					break;
				}
				break;
			case KeyEvent.VK_DOWN:
				switch (game.buttonPosition) {
				case 1:
					game.buttonPosition = 2;
					break;
				case 2:
					game.buttonPosition = 3;
					break;
				case 3:
					game.buttonPosition = 4;
					break;
				case 4:
					game.buttonPosition = 4;
					break;
				}
			}
			// highlights selected button position from above based on up down keys
			game.buttonHighlight();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}
	}

	// Name Input Handler
	public class nameInputHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			String playerName = ui.ntf.getText();
			ui.nameL.setText(playerName);
			game.cp.selectClass();
			ui.choiceP.setVisible(true);
			ui.playerP.setBorder(
					BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(1, 5, 0, 0, ui.coolGray),
							ui.nameL.getText(), 0, TitledBorder.TOP, ui.normalFont, Color.black));

		}

	}
}
