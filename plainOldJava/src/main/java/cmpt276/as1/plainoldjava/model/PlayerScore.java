package cmpt276.as1.plainoldjava.model;

/**
 * Stores information about a single player's score
 */

public class PlayerScore {
    private int numCards;
    private int cardPoints;
    private int numWagers;

    private final int POINT_DIFF = 20;
    private final int CARD_BONUS = 8;

    public PlayerScore(int numCards, int cardPoints, int numWagers) {
        if (numCards < 0) {
            throw new IllegalArgumentException("Number of cards must be non-negative");
        }
        if (cardPoints < 0) {
            throw new IllegalArgumentException("Point total must be non-negative");
        }
        if (numWagers < 0) {
            throw new IllegalArgumentException("Number of wagers must be non-negative");
        }
        if (numCards == 0) {
            if (cardPoints + numWagers != 0) {
                throw new IllegalArgumentException("If 0 cards, points and wagers must also be 0");
            }
        }
        this.numCards = numCards;
        this.cardPoints = cardPoints;
        this.numWagers = numWagers;
    }

    public int getScore() {
        if (numCards == 0) {
            return 0;
        }
        int Score = cardPoints - POINT_DIFF;
        Score *= (numWagers + 1);
        if (numCards + numWagers >= CARD_BONUS) {
            Score += POINT_DIFF;
        }
        return Score;
    }
}
