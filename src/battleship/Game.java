package battleship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by louisefranklin on 10/05/2016.
 */
public class Game {

    private ArrayList<String> guesses = new ArrayList<>();
    private Ship ship = new Ship();

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public ArrayList<String> getGuesses() {
        return guesses;
    }
    public int getGuessesSize() {
        return guesses.size();
    }

    public String makeMove(String move) {
        if(guesses.contains(move)) {
            return "You already tried that cell!";
        } else {
            String result = ship.moveResult(move);
            guesses.add(move);
            return result;
        }
    }

    public boolean gameOver() {
        return ship.inPlay();
    }

}
