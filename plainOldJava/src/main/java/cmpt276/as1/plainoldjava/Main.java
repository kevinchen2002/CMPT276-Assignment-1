package cmpt276.as1.plainoldjava;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;

import cmpt276.as1.plainoldjava.model.Car;
import cmpt276.as1.plainoldjava.model.Game;
import cmpt276.as1.plainoldjava.model.GameManager;
import cmpt276.as1.plainoldjava.model.PlayerScore;

public class Main {
//    public MyClass() {
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Hello Java world from Android Studio!");
//
//        Car myCar = new Car("Some epic thing!");
//        System.out.println(myCar.getModel());
//    }
    public static int getFive() {
        return 5;
    }

    public static void main(String[] args) {

        System.out.println("Hello world, from Java only!");

        //TESTING PLAYER SCORE
        PlayerScore p1 = new PlayerScore(4, 15, 1);
        System.out.println("\nPlayer 1 score = " + p1.getScore());

        PlayerScore p2 = new PlayerScore(10, 30, 2);
        System.out.println("\nPlayer 2 score = " + p2.getScore());

        //TESTING GAME
        Game g1 = new Game();
        g1.playGame(1, 4, 15, 1);
        g1.playGame(2, 10, 30, 2);
        System.out.println("\nGame time: " + g1.getTime());
        System.out.println("Game highscore: " + g1.getHighscore());
        System.out.println("Game winner: player " + g1.getWinner());

        GameManager manager = new GameManager();

    }

}