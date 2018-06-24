package view;

import model.Game;

import javax.swing.*;
import java.awt.*;

public class ContentPanel extends JPanel {



    public ContentPanel(Game game){
        ScorePanel scorePanel = new ScorePanel(game);
        GamePanel gamePanel = new GamePanel(game);
        add(scorePanel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);
    }

}
