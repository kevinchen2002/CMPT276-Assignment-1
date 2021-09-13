package cmpt276.as1.plainoldjava.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores a collection of past games
 */

public class GameManager {
    private List<Game> gameList = new ArrayList<>();

    public void add(Game newGame) {
        gameList.add(newGame);
    }
}
