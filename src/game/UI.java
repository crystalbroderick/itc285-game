package game;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import game.GameMain.InventoryHandler;
import game.GameMain.KeyHandler;
import game.GameMain.nameInputHandler;
import game.GameMain.potionHandler;
import game.GameMain.statsHandler;

public class UI {
	JFrame frame;
	// Title Screen
	JPanel titlePanel, startP, endPanel;
	JLabel titleLabel, endLabel;
	JButton startB;
	JPanel contentPane;

	// Player
	JPanel playerP, nameP, HpP, hpBarP, nameInputPanel;
	JLabel nameL, hpL;
	JProgressBar hpBar;
	JButton enterN;
	JTextField ntf; // name text field

	// Stats, Inventory, Weapons, Potions
	JPanel statsP, inventoryPanel, potionP;
	JButton statsB, inventoryButton, itemButton1, itemButton2, itemButton3, itemButton4, itemButton5, potionB, potion1,
			potion2, potion3, potion4, potion5;
	ImageIcon statsIcon;
	ImageIcon inventoryIcon, potionIcon;
	JLabel statsIconL, statsSpeed, statsLives, statsBlock, statsAttack, weaponL, weaponDmgL, potionL, potionN;

	// Choices
	JPanel choiceP;
	JButton choiceB1, choiceB2, choiceB3;

	// Main Text Area
	JPanel textP;
	JTextArea textA, textA2;

	// Enemy
	JPanel enemyP, enemyHpBarP;
	JLabel enemyL, enemyHpBarL, quadL, quadLValue, enemyLvlL, enemyLvlValue;
	JProgressBar enemyHpBar;

	// Font
	Font normalFont = new Font("Monospaced", Font.BOLD, 20);
	Font titleFont = new Font("Monospaced", Font.PLAIN, 60);
	Color hookGreen = new Color(82, 121, 111);
	Color brickWhite = new Color(234, 224, 213);
	Color cocoaBeige = new Color(198, 172, 143);
	Color greenGray = new Color(202, 210, 197);
	Color darkSeaGreen = new Color(132, 169, 140);
	Color darkGray = new Color(53, 79, 82);
	Color coolGray = new Color(47, 62, 70);
	Color richBlack = new Color(10, 9, 8);
	Color coolGray2 = new Color(34, 51, 59);
	Color peacan = new Color(94, 80, 63);

	final boolean shouldFill = true;
	final boolean shouldWeightX = true;
	final boolean RIGHT_TO_LEFT = false;

	public void createUI(ChoiceHandler cHandler, statsHandler sHandler, KeyHandler kHandler, nameInputHandler niHandler,
			InventoryHandler iHandler, potionHandler pHandler) {
		frame = new JFrame("Text based Dungeon Crawler");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		// Set Layout Manger
		frame.setLayout(new GridBagLayout());
		frame.getContentPane().setBackground(brickWhite);
		frame.addKeyListener(kHandler);

		GridBagConstraints title_gbc = new GridBagConstraints(); // get cordinates of buttons for title screen
		GridBagConstraints gbc = new GridBagConstraints(); // get cordinates of buttons for game screen
		GridBagConstraints sc = new GridBagConstraints(); // TODO stats info

		// Create Swing Component

		// #TITLE SCREEN#
		// title
		titlePanel = new JPanel();
		titlePanel.setBounds(200, 180, 600, 90);
		titlePanel.setBackground(brickWhite);
		titleLabel = new JLabel("SACRED THICKET");
		titleLabel.setForeground(hookGreen);
		titleLabel.setFont(titleFont);
		titlePanel.add(titleLabel);
		title_gbc.gridx = 0;
		title_gbc.gridy = 0;
		title_gbc.gridwidth = 4;
		frame.add(titlePanel, title_gbc);

		// start
		startB = new JButton("START");
		startB.setBackground(hookGreen);
		startB.setForeground(Color.WHITE);
		startB.setFont(normalFont);
		startB.addActionListener(cHandler);
		startB.setActionCommand("start");
		startB.setFocusPainted(false);
		title_gbc.insets = new Insets(10, 3, 3, 3);
		title_gbc.gridx = 1;
		title_gbc.gridy = 4;
		frame.add(startB, title_gbc);

		// ##GAME SCREEN##
		// Player
		playerP = new JPanel();
		playerP.setBackground(greenGray);
		playerP.setPreferredSize(new Dimension(250, 130));
		nameL = new JLabel("Player"); // player name
		nameL.setFont(normalFont);
		nameL.setForeground(hookGreen);
		playerP.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(1, 5, 0, 0, coolGray),
				nameL.getText(), 0, TitledBorder.TOP, normalFont, Color.black));
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.insets = new Insets(10, 0, 0, 0);
		gbc.weightx = .5;
		gbc.weighty = .5;
		gbc.gridx = 0;
		gbc.gridy = 0;
		// gbc.gridwidth=4;
		frame.add(playerP, gbc);

		// Player Health Bar
		hpBarP = new JPanel();
		hpBarP.setBackground(Color.BLACK);
		playerP.add(hpBarP);
		hpBar = new JProgressBar();
		hpBar.setPreferredSize(new Dimension(200, 30));
		hpBar.setValue(0);
		hpBar.setStringPainted(true);
		hpBar.setString("HP ");
		hpBar.setFont(normalFont);
		hpBar.setBackground(Color.WHITE);
		hpBar.setForeground(Color.blue);
		hpBarP.add(hpBar);

		statsIcon = new ImageIcon(getClass().getClassLoader().getResource("flathammer_50x50.png"));

		// View Player Stats

		statsB = new JButton();
		statsB.setPreferredSize(new Dimension(50, 50));
		statsB.setBackground(null);
		statsB.setIcon(statsIcon);
		statsB.setBorderPainted(false);
		statsB.setFocusPainted(false);
		statsB.addActionListener(sHandler);
		statsB.setActionCommand("statsButton");
		playerP.add(statsB);

		statsP = new JPanel();
		statsP.setBackground(darkSeaGreen);
		statsP.setPreferredSize(new Dimension(200, 130));
		statsP.setLayout(new GridLayout(6, 1));
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.gridx = 0;
		gbc.gridy = 0;
		frame.add(statsP, gbc);

		weaponL = new JLabel(" ");
		weaponL.setBackground(Color.BLACK);
		weaponL.setForeground(Color.WHITE);
		weaponL.setFont(normalFont);
		statsP.add(weaponL);

		weaponDmgL = new JLabel(" ");
		weaponDmgL.setBackground(Color.BLACK);
		weaponDmgL.setForeground(Color.WHITE);
		weaponDmgL.setFont(normalFont);
		statsP.add(weaponDmgL);

		statsAttack = new JLabel();
		statsAttack.setBackground(Color.BLACK);
		statsAttack.setForeground(Color.WHITE);
		statsAttack.setFont(normalFont);
		statsP.add(statsAttack);

		statsSpeed = new JLabel();
		statsSpeed.setBackground(Color.BLACK);
		statsSpeed.setForeground(Color.WHITE);
		statsSpeed.setFont(normalFont);
		statsP.add(statsSpeed);

		statsLives = new JLabel();
		statsLives.setBackground(Color.BLACK);
		statsLives.setForeground(Color.WHITE);
		statsLives.setFont(normalFont);
		statsP.add(statsLives);

		statsBlock = new JLabel();
		statsBlock.setBackground(Color.BLACK);
		statsBlock.setForeground(Color.WHITE);
		statsBlock.setFont(normalFont);
		statsP.add(statsBlock);

		statsP.setVisible(false);

		// INVENTORY
		inventoryIcon = new ImageIcon(getClass().getClassLoader().getResource("inventoryIcon_50x50.png"));

		inventoryButton = new JButton();
		inventoryButton.setPreferredSize(new Dimension(50, 50));
		inventoryButton.setBackground(null);
		inventoryButton.setIcon(inventoryIcon);
		inventoryButton.setBorderPainted(false);
		inventoryButton.setFocusPainted(false);
		inventoryButton.addActionListener(iHandler);
		inventoryButton.setActionCommand("inventoryButton");
		playerP.add(inventoryButton);

		inventoryPanel = new JPanel();
		inventoryPanel.setPreferredSize(new Dimension(200, 130));
		inventoryPanel.setBackground(darkSeaGreen);
		inventoryPanel.setLayout(new GridLayout(6, 1));
		gbc.anchor = GridBagConstraints.PAGE_START;
		// gbc.weightx =.5;
		gbc.gridx = 0;
		gbc.gridy = 0;

		frame.add(inventoryPanel, gbc);

		itemButton1 = new JButton("");
		itemButton1.setBackground(null);
		itemButton1.setForeground(Color.white);
		itemButton1.setFont(normalFont);
		itemButton1.setFocusPainted(false);
		itemButton1.addActionListener(iHandler);
		itemButton1.setActionCommand("item1");
		inventoryPanel.add(itemButton1);
		itemButton2 = new JButton("");
		itemButton2.setBackground(null);
		itemButton2.setForeground(Color.white);
		itemButton2.setFont(normalFont);
		itemButton2.setFocusPainted(false);
		itemButton2.addActionListener(iHandler);
		itemButton2.setActionCommand("item2");
		inventoryPanel.add(itemButton2);
		itemButton3 = new JButton("");
		itemButton3.setBackground(null);
		itemButton3.setForeground(Color.white);
		itemButton3.setFont(normalFont);
		itemButton3.setFocusPainted(false);
		itemButton3.addActionListener(iHandler);
		itemButton3.setActionCommand("item3");
		inventoryPanel.add(itemButton3);
		itemButton4 = new JButton("");
		itemButton4.setBackground(null);
		itemButton4.setForeground(Color.white);
		itemButton4.setFont(normalFont);
		itemButton4.setFocusPainted(false);
		itemButton4.addActionListener(iHandler);
		itemButton4.setActionCommand("item4");
		inventoryPanel.add(itemButton4);
		itemButton5 = new JButton("");
		itemButton5.setBackground(null);
		itemButton5.setForeground(Color.white);
		itemButton5.setFont(normalFont);
		itemButton5.setFocusPainted(false);
		itemButton5.addActionListener(iHandler);
		itemButton5.setActionCommand("item5");
		inventoryPanel.add(itemButton5);

		inventoryPanel.setVisible(false);

		// POTIONS
		potionIcon = new ImageIcon(getClass().getClassLoader().getResource("healthpotion_50x50.png"));

		potionB = new JButton();
		potionB.setPreferredSize(new Dimension(50, 50));
		potionB.setBackground(null);
		potionB.setIcon(potionIcon);
		potionB.setBorderPainted(false);
		potionB.setFocusPainted(false);
		potionB.addActionListener(pHandler);
		potionB.setActionCommand("potionButton");
		playerP.add(potionB);
		

		potionP = new JPanel();
		potionP.setPreferredSize(new Dimension(200, 130));
		potionP.setBackground(darkSeaGreen);
		potionP.setLayout(new GridLayout(5, 1));
		gbc.anchor = GridBagConstraints.PAGE_START;
		// gbc.weightx =.5;
		gbc.gridx = 0;
		gbc.gridy = 0;

		frame.add(potionP, gbc);
		

		potion1 = new JButton("DRINK");
		potion1.setBackground(null);
		potion1.setForeground(Color.white);
		potion1.setFont(normalFont);
		potion1.setFocusPainted(false);
		potion1.addActionListener(pHandler);
		potion1.setActionCommand("item1");
		potionP.add(potion1);

		potion2 = new JButton("");
		potion2.setBackground(null);
		potion2.setForeground(Color.white);
		potion2.setFont(normalFont);
		potion2.setFocusPainted(false);
		potion2.addActionListener(pHandler);
		potion2.setActionCommand("item2");
		potionP.add(potion2);

		potion3 = new JButton("");
		potion3.setBackground(null);
		potion3.setForeground(Color.white);
		potion3.setFont(normalFont);
		potion3.setFocusPainted(false);
		potion3.addActionListener(pHandler);
		potion3.setActionCommand("item3");
		potionP.add(potion3);
		potion4 = new JButton("");
		potion4.setBackground(null);
		potion4.setForeground(Color.white);
		potion4.setFont(normalFont);
		potion4.setFocusPainted(false);
		potion4.addActionListener(pHandler);
		potion4.setActionCommand("item4");
		potionP.add(potion4);
		potion5 = new JButton("");
		potion5.setBackground(null);
		potion5.setForeground(Color.white);
		potion5.setFont(normalFont);
		potion5.setFocusPainted(false);
		potion5.addActionListener(pHandler);
		potion5.setActionCommand("item5");
		potionP.add(potion5);

		potionP.setVisible(false);
		
		
		// Enemy
		enemyP = new JPanel();
		enemyP.setPreferredSize(new Dimension(250, 130));
		enemyP.setBackground(Color.LIGHT_GRAY);
		enemyL = new JLabel("Enemy"); // Enemy Name
		enemyL.setFont(normalFont);
		enemyL.setForeground(hookGreen);
		enemyP.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(1, 5, 0, 0, coolGray),
				enemyL.getText(), 0, TitledBorder.TOP, normalFont, Color.black));
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		gbc.insets = new Insets(10, 0, 0, 0);
		gbc.weightx = .5;
		frame.add(enemyP, gbc);

		// Enemy Health Bar
		enemyHpBarP = new JPanel();
		enemyHpBarP.setBackground(Color.BLACK);
		enemyP.add(enemyHpBarP);
		enemyHpBar = new JProgressBar();
		enemyHpBar.setPreferredSize(new Dimension(200, 30));
		enemyHpBar.setValue(0);
		enemyHpBar.setStringPainted(true);
		enemyHpBar.setString("HP ");
		enemyHpBar.setFont(normalFont);
		enemyHpBar.setBackground(Color.WHITE);
		enemyHpBar.setForeground(Color.blue);
		enemyHpBarP.add(enemyHpBar);

		quadL = new JLabel("Quadrant: ");
		quadL.setFont(normalFont);
		enemyP.add(quadL);
		quadLValue = new JLabel();
		quadLValue.setFont(normalFont);
		enemyP.add(quadLValue);

		enemyLvlL = new JLabel("Level: ");
		enemyLvlL.setFont(normalFont);
		enemyP.add(enemyLvlL);
		enemyLvlValue = new JLabel(" ");
		enemyLvlValue.setFont(normalFont);
		enemyP.add(enemyLvlValue);

		// Choice Panel
		choiceP = new JPanel();
		// choiceP.setBounds(325, 500, 275, 100);
		choiceP.setBackground(cocoaBeige);
		choiceP.setLayout(new GridLayout(3, 1));
		gbc.insets = new Insets(0, 10, 10, 10);
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
		gbc.weightx = .5;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridwidth = 4;
		//
		gbc.weightx = 0;
		frame.add(choiceP, gbc);

		// Choices

		choiceB1 = new JButton("Choice 1");
		choiceB1.setBackground(cocoaBeige);
		choiceB1.setForeground(richBlack);
		choiceB1.setFont(normalFont);
		choiceB1.setFocusPainted(false);
		choiceB1.addActionListener(cHandler);
		choiceB1.setActionCommand("c1");
		choiceP.add(choiceB1);

		choiceB2 = new JButton("Choice 2");
		choiceB2.setBackground(cocoaBeige);
		choiceB2.setForeground(richBlack);
		choiceB2.setFont(normalFont);
		choiceB2.setFocusPainted(false);
		choiceB2.addActionListener(cHandler);
		choiceB2.setActionCommand("c2");
		choiceP.add(choiceB2);

		choiceB3 = new JButton("Choice 3");
		choiceB3.setBackground(cocoaBeige);
		choiceB3.setForeground(richBlack);
		choiceB3.setFont(normalFont);
		choiceB3.setFocusPainted(false);
		choiceB3.addActionListener(cHandler);
		choiceB3.setActionCommand("c3");
		choiceP.add(choiceB3);

		// Main text Panel
		textP = new JPanel();
		textP.setPreferredSize(new Dimension(600, 300));
		textP.setBackground(null);

		textP.setLayout(new GridLayout(3, 1));
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.ipady = 40;
		gbc.weightx = 1;
		gbc.weighty = .5;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.gridheight = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		frame.add(textP, gbc);

		// Main text
		textA = new JTextArea("Main Text Area");
		// textA.setBounds(250, 250, 600, 225);
		// textA.setBackground(greenGray);
		textA.setForeground(richBlack);
		textA.setFont(normalFont);
		textA.setLineWrap(true);
		textA.setWrapStyleWord(true);
		textA.setEditable(false);
		textP.add(textA);

		// Main text
		textA2 = new JTextArea(" ");
		// textA2.setBounds(250, 300, 600, 225);
		// textA2.setBackground(Color.BLACK);
		textA2.setForeground(richBlack);
		textA2.setFont(normalFont);
		textA2.setLineWrap(true);
		textA2.setWrapStyleWord(true);
		textA2.setEditable(false);
		textP.add(textA2);

		// Player Name
		nameInputPanel = new JPanel();
		nameInputPanel.setPreferredSize(new Dimension(400, 50));
		nameInputPanel.setBackground(brickWhite);
		nameInputPanel.setLayout(new GridLayout(3, 2));

		ntf = new JTextField();
		ntf.setFont(normalFont);
		ntf.addActionListener(niHandler);
		nameInputPanel.add(ntf);

		enterN = new JButton("ENTER");
		enterN.setBackground(null);
		enterN.setForeground(Color.black);
		enterN.addActionListener(niHandler);
		enterN.setFont(normalFont);
		nameInputPanel.add(enterN);
		textP.add(nameInputPanel);

		endPanel = new JPanel();
		endPanel.setBounds(200, 180, 600, 90);
		endPanel.setBackground(brickWhite);
		endLabel = new JLabel("~GAME OVER~");
		endLabel.setForeground(hookGreen);
		endLabel.setFont(titleFont);
		endPanel.add(endLabel);
		title_gbc.gridx = 0;
		title_gbc.gridy = 2;
		title_gbc.gridwidth = 4;
		frame.add(endPanel, title_gbc);

		// Display window
		frame.setSize(new Dimension(850, 600));
		// frame.pack();
		frame.setVisible(true);
		frame.getRootPane().setDefaultButton(startB);

	}

}
