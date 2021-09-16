package cmpt276.as1.plainoldjava.text;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cmpt276.as1.plainoldjava.model.Game;
import cmpt276.as1.plainoldjava.model.GameManager;

public class TextUI {
    private GameManager manager;
    private final int MINPLAYERS = 1;
    private final int MAXPLAYERS = 4;

    public TextUI(GameManager manager) {
        this.manager = manager;
    }

    //helper function for displaying a game
    private void displayGame(Game game, int count) {
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
                //case 1: viewing all games
                case 1:
                    List<Game> gameList = manager.getAllGames();
                    if (gameList.isEmpty()) {
                        System.out.println("NO GAMES");
                    }

                    //for each loop to access each game
                    int count = 0;
                    for (Game game : gameList) {
                        displayGame(game, count);
                        count++;
                    }
                    break;

                //case 2: adding new games
                case 2:
                    int numPlayers = 0;
                    while (numPlayers < MINPLAYERS || numPlayers > MAXPLAYERS) {
                        System.out.println("How many players? (must be between 1 and 4)\n");
                        numPlayers = in.nextInt();
                    }

                    Game game = new Game();

                    for (int i = 0; i < numPlayers; i++) {
                        int playerNum = i + 1;
                        System.out.println("Player " + playerNum + ": ");
                        int numCards = -1;
                        while (numCards < 0) {
                            System.out.println("    How many cards?");
                            numCards = in.nextInt();
                        }
                        int cardPoints = -1;
                        int wagers = -1;
                        if (numCards == 0) {
                            cardPoints = 0;
                            wagers = 0;
                        }
                        else {
                            while (cardPoints < 0) {
                                System.out.println("    Sum of cards?");
                                cardPoints = in.nextInt();
                            }
                            while (wagers < 0) {
                                System.out.println("    How many wagers?");
                                wagers = in.nextInt();
                            }
                        }
                        game.playGame(i+1, numCards, cardPoints, wagers);
                    }
                    displayGame(game, 0);

                    manager.add(game);
                    break;

                //case 3: deleting a game
                case 3:

                    int listSize = manager.getSize();

                    int deleteIndex = -1;
                    while (deleteIndex < 0 || deleteIndex > listSize) {
                        System.out.println("Which game to delete? (0 for none)\n");
                        deleteIndex = in.nextInt();
                    }

                    if (deleteIndex == 0) {
                        break;
                    }

                    manager.delete(deleteIndex);
                    System.out.println("Game " + deleteIndex + " deleted.");
                    break;

                //case 0: exiting the menu
                case 0:
                    isDone = true;
                    break;

                //default case: a number outside of the range 0 - 3 was picked
                default:
                    System.out.println("Pick one of the above options!");
            }
        }
    }
}