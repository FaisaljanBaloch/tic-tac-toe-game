package org.example;

import com.github.lalyos.jfiglet.FigletFont;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            showAppTitle(); // show app banner

            TicTacToeGame game = new TicTacToeGame();
            game.play(); // start the game

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showAppTitle() throws IOException {
        String asciiTitle = FigletFont.convertOneLine("Tic Tac Toe");
        System.out.println(asciiTitle);
    }
}