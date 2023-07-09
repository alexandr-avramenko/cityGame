package org.example.gameWindow;

import org.example.game.Game;

import javax.swing.*;

public class GameFrame extends JFrame {
    GamePanel panel;

    public GameFrame(String nickName) {
        panel = new GamePanel(nickName);
        this.add(panel);
        this.setTitle("City Game");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
