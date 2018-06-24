package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import model.Game;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {
	
	private static final Dimension SIZE = new Dimension(400, 700);


	public GameFrame(Game game) {
		setTitle("Tiles by CJ");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(SIZE);
		setResizable(false);
		setLayout(new BorderLayout());
//		getRootPane().setBorder(BorderFactory.createEmptyBorder(0, 30, 5, 30));
		getRootPane().setBackground(Color.DARK_GRAY);
		getContentPane().setBackground(Color.DARK_GRAY);

		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("File");
		JMenuItem openSave = new JMenuItem("Open");
		this.setJMenuBar(menuBar);
		menuBar.add(menu);
		menu.add(openSave);

		ScorePanel scorePanel = new ScorePanel(game);
		GamePanel gamePanel = new GamePanel(game);
		add(scorePanel, BorderLayout.NORTH);
		add(gamePanel, BorderLayout.CENTER);
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				game.saveBeforeExit();
			}
		});



	}
	
}
