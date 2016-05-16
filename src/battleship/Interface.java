package battleship;

import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by louisefranklin on 11/05/2016.
 */
public class Interface {

    public static void main(String[] args){
        GameHelper helper = new GameHelper();
        ShipFactory shipFactory = new ShipFactory();
        Game game = new Game();

        game.innit(1,shipFactory);

        while(!game.gameOver()) {
            String move = helper.getUserInput("Make your move");
            System.out.println(game.makeMove(move));
        }
        System.out.println("You took " + game.getGuessesSize() + " guesses!");

    }
}
