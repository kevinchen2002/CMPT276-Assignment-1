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
                        System.out.println(count + ". ");
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
                    break;

                case 2:
                    System.out.println("case 2");

                case 3:
                    System.out.println("case 3");

                case 0:
                    isDone = true;
                    System.out.println("case 0");

                default:
                    System.out.println("Pick one of the above options!");
            }
        }


    }
}