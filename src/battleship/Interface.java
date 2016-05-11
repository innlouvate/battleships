package battleship;

import java.util.Scanner;

/**
 * Created by louisefranklin on 11/05/2016.
 */
public class Interface {

    public static void main(String[] args){
        GameHelper helper = new GameHelper();
        Game game = new Game();
        int numGuesses = 0;

        int randNum = (int) (Math.random() * 5);
        int[] locations = {randNum, randNum+1, randNum+2};
        game.setLocationCells(locations);

        String result = "n/a";
        while(result != "Sink") {
            String move = helper.getUserInput("Make your move");
            result = game.moveResult(move);
            numGuesses++;
            System.out.println(result);
        }
        System.out.println("You took " + numGuesses + " guesses!");

    }
}
