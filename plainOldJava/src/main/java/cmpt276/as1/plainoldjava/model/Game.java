package cmpt276.as1.plainoldjava.model;

import java.time.LocalDateTime;

/**
 * Represents one game played by 1 to 4 players
 */

public class Game {
    private LocalDateTime time;
    private int highscore;
    private int winner;
    //possibly unused
    //private int numPlayers;

    public Game() {
        time = LocalDateTime.now();
        highscore = 0;
        winner = 0;
    }

    public void playGame(int player, int numCards, int cardPoints, int numWagers) {
        PlayerScore pscore = new PlayerScore(numCards, cardPoints, numWagers);
        if (pscore.getScore() > highscore) {
            highscore = pscore.getScore();
            winner = player;
        }
    }

    public LocalDateTime getTime() {
        return time;
    }

    public int getHighscore() {
        return highscore;
    }

    public int getWinner() {
        return winner;
    }
}
