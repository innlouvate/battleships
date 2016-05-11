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
        Game game = new Game();
        Set<String> guesses = new HashSet<String>();

        int randNum = (int) (Math.random() * 5);
        int[] locations = {randNum, randNum+1, randNum+2};
        game.setLocationCells(locations);

        String result = "n/a";

        while(result != "Sink") {
            String move = helper.getUserInput("Make your move");
            if(guesses.contains(move)) {
                System.out.println("You already tried that cell!");
            } else {
                result = game.moveResult(move);
                guesses.add(move);
                System.out.println(result);
            }
        }
        System.out.println("You took " + guesses.size() + " guesses!");

    }

    private static boolean contains(String test, Set<String> list) {
        for(String x: list) {
            if(x == test) {
                return true;
            }
        }
        return false;
    }
}
