package org.example.welcomeWindow;

import org.example.game.Game;
import org.example.gameWindow.GameFrame;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GamePanelWelcome extends JPanel{

    private static final int GAME_WIDTH = 500;
    private static final int GAME_HEIGHT = 100;
    private static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);

    private String nickName;
    private JButton startButton;
    private JLabel welcomeLabel;
    private JTextField playerName;


    GamePanelWelcome() {
        this.setPreferredSize(SCREEN_SIZE);
        this.setLayout(new BorderLayout());

        welcomeLabel = new JLabel("Вітаємо Вас у грі 'Міста'. Будь ласка, напишіть своє ігрове ім'я");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        this.add(welcomeLabel, BorderLayout.NORTH);

        createButton();
        createPlayerName();
    }

    private void createButton() {
        startButton = new JButton("Start");
        this.add(startButton, BorderLayout.SOUTH);
        startButton.addActionListener(e -> {
            nickName = playerName.getText();
            if(nickName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Будь ласка, введіть своє ім'я", "Помилка", JOptionPane.ERROR_MESSAGE);
            } else {
                SwingUtilities.getWindowAncestor(GamePanelWelcome.this).dispose();
                GameFrame gameFrame = new GameFrame(nickName);
                gameFrame.setVisible(true);
            }
        });
    }

    private void createPlayerName() {
        JPanel panel = new JPanel(new BorderLayout());
        playerName = new JTextField();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        int topPadding = 10;
        int leftPadding = 0;
        int bottomPadding = 0;
        int rightPadding = 0;

        Border emptyBorder = BorderFactory.createEmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding);
        playerName.setBorder(emptyBorder);

//        panel.add(welcomeLabel, BorderLayout.NORTH);
//        panel.add(plyerName, BorderLayout.CENTER);
        panel.add(welcomeLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(playerName);
        this.add(panel, BorderLayout.NORTH);
    }
}
