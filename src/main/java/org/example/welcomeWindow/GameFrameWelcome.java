package org.example.welcomeWindow;

import org.example.game.Game;

import javax.swing.*;

public class GameFrameWelcome extends JFrame{
    GamePanelWelcome welcomePanel;

    public GameFrameWelcome(Game game) {
        welcomePanel = new GamePanelWelcome();
        this.add(welcomePanel);
        this.setTitle("Welcome");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
