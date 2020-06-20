package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoiceHandler implements ActionListener {
	 GameMain main;
	 public ChoiceHandler(GameMain m) {
	     // Constructor
	 main = m;

	 }
		public void actionPerformed(ActionEvent event) {
			String yourChoice = event.getActionCommand();
			
			switch (yourChoice) {
			case "start":
				main.vm.titleToGame();
				main.s.titleToToria();
				break;
			case "c1":
				main.game.selectPosition(main.nextPosition1);
				break;
			case "c2":
				main.game.selectPosition(main.nextPosition2);
				break;
			case "c3":
				main.game.selectPosition(main.nextPosition3);
				break;
			}

		}

	}

