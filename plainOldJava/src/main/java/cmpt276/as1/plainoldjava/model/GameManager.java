package cmpt276.as1.plainoldjava.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Stores a collection of past games
 */

public class GameManager implements Iterable<Game>{
    private List<Game> gameList = new ArrayList<>();

    public void add(Game newGame) {
        gameList.add(newGame);
    }

    public Game getGame(int index) {
        return gameList.get(index);
    }

    public List<Game> getAllGames() {
        return gameList;
    }

    @Override
    public Iterator<Game> iterator() {
        return gameList.iterator();
    }
}
