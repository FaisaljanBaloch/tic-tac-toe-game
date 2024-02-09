package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeGame {

    private char player;
    private final char[][] board = new char[3][3];

    TicTacToeGame() {
        for (char[] chars : board) {
            Arrays.fill(chars, ' ');
        }
    }

    private final Scanner scan = new Scanner(System.in);

    public void play() {
        // select your player
        choosePlayer();

        boolean gameOver = false;

        while (!gameOver) {
            printBoard(); // show board

            System.out.printf("Player [%c] enter move: ", player);
            int row = scan.nextInt();
            int col = scan.nextInt();

            if (row < board.length && col < board[0].length && board[row][col] == ' ') {
                board[row][col] = player;
                gameOver = haveWon();

                if (gameOver) {
                    System.out.printf("[-_-] Player [%c] has won!\n", player);
                } else {
                    player = (player == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("invalid move, Try again!\n");
            }
        }

        printBoard(); // show board
    }

    private void choosePlayer() {
        System.out.println("### Select your Player ###");
        System.out.println("a. X");
        System.out.println("b. O");
        System.out.println("q. Quit");

        System.out.print("Enter choice: ");
        String choice = scan.nextLine();

        switch (choice.toLowerCase()) {
            case "a":
                player = 'X';
                break;
            case "b":
                player = 'O';
                break;
            case "q":
                System.exit(0);
                break;
            default:
                System.out.println("-> invalid selection");
                this.choosePlayer();
        }
    }

    private void printBoard() {
        for (char[] rows : board) {
            for (char element : rows) {
                System.out.print(element + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean haveWon() {
        // check the rows
        for (char[] row : board) {
            if (row[0] == player && row[1] == player && row[2] == player) {
                return true;
            }
        }

        // check for columns
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        // check for diagonal
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        return board[0][2] == player && board[1][1] == player && board[2][0] == player;
    }
}
