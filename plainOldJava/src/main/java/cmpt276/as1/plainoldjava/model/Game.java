package cmpt276.as1.plainoldjava.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents one game played by 1 to 4 players
 */

public class Game {
    private LocalDateTime time;
    private int highscore;
    private ArrayList<Integer> scores;
    private ArrayList<Integer> winners;
    //possibly unused
    private int numPlayers;

    public Game() {
        time = LocalDateTime.now();
        time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        scores = new ArrayList<>();
        winners = new ArrayList<>();
        highscore = Integer.MIN_VALUE;
        numPlayers = 0;
    }

    public void playGame(int player, int numCards, int cardPoints, int numWagers) {
        PlayerScore pscore = new PlayerScore(numCards, cardPoints, numWagers);
//        //Number score = new Number(pscore.getScore());
//
        scores.add(pscore.getScore());
        if (pscore.getScore() > highscore) {
            highscore = pscore.getScore();
            winners.clear();
            winners.add(player);
        }
        else if (pscore.getScore() == highscore) {
            winners.add(player);
        }
    }

    public String getTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return time.format(formatter);
    }

    public int getHighscore() {
        return highscore;
    }

    public ArrayList<Integer> getScores() {
        return scores;
    }

    public ArrayList<Integer> getWinners() {
        return winners;
    }
}
