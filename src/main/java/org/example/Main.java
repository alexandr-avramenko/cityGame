package org.example;

import org.example.fileReader.MyFileReader;
import org.example.game.Game;
import org.example.welcomeWindow.GameFrameWelcome;
import org.example.welcomeWindow.GamePanelWelcome;

public class Main {
    public static void main(String[] args) {
        /*
        1. Зчитуємо файл
        2. Створюємо гру
        3. Старт гри
         */
        MyFileReader myFileReader = new MyFileReader("src/main/resources/cities.txt");
        Game round = new Game(myFileReader.readCitiesFromFile());
        GameFrameWelcome welcomeWindow = new GameFrameWelcome(round);

    }
}