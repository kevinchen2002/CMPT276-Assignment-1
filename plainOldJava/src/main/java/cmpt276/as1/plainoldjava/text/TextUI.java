package cmpt276.as1.plainoldjava.text;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cmpt276.as1.plainoldjava.model.Game;
import cmpt276.as1.plainoldjava.model.GameManager;

public class TextUI {
    private GameManager manager;

    public TextUI(GameManager manager) {
        this.manager = manager;
    }

    public void showMenu() {
        boolean isDone = false;
        while (!isDone) {
            System.out.println("\n\n1. List games\n" +
                    "2. New game\n" +
                    "3. Delete game\n" +
                    "0. Exit\n:");
            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    List<Game> gameList = manager.getAllGames();

                    //for each loop to access each game
                    int count = 0;
                    for (Game game : gameList) {
                        ArrayList<Integer> scores = game.getScores();
                        int gameNum = count+1;
                        System.out.println("\n\n" + gameNum + ". ");
                        for (int i = 0; i < scores.size(); i++) {
                            if (i != scores.size()-1) {
                                System.out.print(scores.get(i) + " vs. ");
                            }
                            else {
                                System.out.print(scores.get(i));
                            }
                        }
                        System.out.print(", winner player(s): " + game.getWinners());
                        System.out.print(", " + game.getTime());
                        count++;
                    }
                    break;

                case 2:

                    int numPlayers = 0;
                    while (numPlayers < 1 || numPlayers > 4) {
                        System.out.println("How many players? (must be between 1 and 4)\n");
                        numPlayers = in.nextInt();
                    }

                    Game game = new Game();

                    for (int i = 0; i < numPlayers; i++) {
                        int playerNum = i + 1;
                        System.out.println("Player " + playerNum + ": ");
                        System.out.println("    How many cards?");
                        int numCards = in.nextInt();
                        int cardPoints;
                        int wagers;
                        if (numCards == 0) {
                            cardPoints = 0;
                            wagers = 0;
                        }
                        else {
                            System.out.println("    Sum of cards?");
                            cardPoints = in.nextInt();
                            System.out.println("    How many wagers?");
                            wagers = in.nextInt();
                        }
                        game.playGame(i+1, numCards, cardPoints, wagers);
                    }
                    //print out the game
                    ArrayList<Integer> scores = game.getScores();
                    for (int i = 0; i < scores.size(); i++) {
                        if (i != scores.size()-1) {
                            System.out.print(scores.get(i) + " vs. ");
                        }
                        else {
                            System.out.print(scores.get(i));
                        }
                    }
                    System.out.print(", winner player(s): " + game.getWinners());
                    System.out.print(", " + game.getTime());

                    manager.add(game);
                    break;

                case 3:
                    System.out.println("case 3");

                case 0:
                    isDone = true;

                default:
                    System.out.println("Pick one of the above options!");
            }
        }


    }
}