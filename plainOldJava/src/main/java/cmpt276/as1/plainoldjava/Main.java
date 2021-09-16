package cmpt276.as1.plainoldjava;

/*
citation: used https://mkyong.com/java8/java-8-how-to-format-localdatetime/ for LocalDateTime formatting
 */

import cmpt276.as1.plainoldjava.model.GameManager;
import cmpt276.as1.plainoldjava.text.TextUI;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello world, from Java only!");

        GameManager manager = new GameManager();

        TextUI ui = new TextUI(manager);
        ui.showMenu();

    }
}