package com.github.zipcodewilmington;

// @author mahala
// @version 2.0.0

import java.util.Random;
import java.util.Scanner;

public class WordGuess {

    // instance variables
    private String[] words = {"cat", "dog", "bog", "cut", "hat", "run", "fun", "sun", "big", "dig"};
    private char[] secretWord;
    private char[] guesses;
    private int triesLeft;
    private boolean wordGuessed;

    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public WordGuess() {}

    public static void main(String[] args) {
        WordGuess game = new WordGuess();
        game.runGame();
    }

    public void runGame() {
        announceGame();
        boolean playAgain = true;
        while (playAgain) {
            initializeGameState();
            wordGuessed = false;

            while (triesLeft > 0 && !wordGuessed) {
                printCurrentState();
                char guess = getNextGuess();

                if (guess == '-') {
                    System.out.println("Quitting game.");
                    return;
                }

                process(guess);

                if (isWordGuessed()) {
                    wordGuessed = true;
                    playerWon();
                } else {
                    triesLeft--;
                    if (triesLeft == 0) {
                        playerLost();
                    }
                }
            }

            playAgain = askToPlayAgain();
        }
        gameOver();
    }

    public void announceGame() {
        System.out.println("Let's Play Wordguess version 2.0");
    }

    public void gameOver() {
        System.out.println("Game Over.");
    }

    public void initializeGameState() {
        String word = words[random.nextInt(words.length)];
        secretWord = word.toCharArray();
        guesses = new char[secretWord.length];
        for (int i = 0; i < guesses.length; i++) {
            guesses[i] = '_';
        }
        triesLeft = secretWord.length;
    }

    public char getNextGuess() {
        System.out.println("Enter a single character: ");
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) return ' ';
        return input.charAt(0);
    }

    public boolean isWordGuessed() {
        for (char c : guesses) {
            if (c == '_') return false;
        }
        return true;
    }

    public boolean askToPlayAgain() {
        System.out.println("Would you like to play again? (yes/no) ");
        String answer = scanner.nextLine().trim().toLowerCase();
        return answer.equals("yes");
    }

    public void printCurrentState() {
        System.out.println("Current Guesses: ");
        printArray(guesses);
        System.out.println("You have " + triesLeft + " tries left.");
    }

    public void printArray(char[] a) {
        for (char c : a) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public void process(char guess) {
        for (int i = 0; i < secretWord.length; i++) {
            if (secretWord[i] == guess) {
                guesses[i] = guess;
            }
        }
    }

    public void playerWon() {
        System.out.println("**** ****");
        printArray(guesses);
        System.out.println("Congratulations, You Won!");
    }

    public void playerLost() {
        System.out.println(":-( :-( :-(");
        printArray(guesses);
        System.out.println("You Lost! You ran out of guesses.");
    }
}
