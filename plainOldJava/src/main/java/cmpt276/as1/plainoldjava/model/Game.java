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

    public Game() {
        time = LocalDateTime.now();
        time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        scores = new ArrayList<>();
        winners = new ArrayList<>();
        highscore = Integer.MIN_VALUE;
    }

    public void playGame(int player, int numCards, int cardPoints, int numWagers) {
        PlayerScore pscore = new PlayerScore(numCards, cardPoints, numWagers);

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

    public ArrayList<Integer> getScores() {
        return scores;
    }

    public ArrayList<Integer> getWinners() {
        return winners;
    }
}
