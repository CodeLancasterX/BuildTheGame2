package controller;

import model.Game;
import view.GameFrame;
import view.GamePanel;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GameController {
	
	private Game game;
	private JFileChooser fileChooser;
	private GamePanel gamePanel;
	private GameFrame gameFrame;
	
	public GameController() {
		fileChooser = new JFileChooser();
		game = new Game();
		
		gameFrame = new GameFrame(game, this);
		
		game.loadGame();
	}

	public void readFile(){
		//read savegames and cheatmodes.
		fileChooser.setCurrentDirectory(new File(".\\data"));
		int result = fileChooser.showOpenDialog(fileChooser);

		if (result == JFileChooser.APPROVE_OPTION) {

			Path path = fileChooser.getSelectedFile().toPath();

			String contentString = "";

			try {
				for (String x : Files.readAllLines(path)) {

					contentString += x + "\r \n";

				}



			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

}
