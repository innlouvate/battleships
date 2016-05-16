package battleship;

import java.util.ArrayList;

/**
 * Created by louisefranklin on 10/05/2016.
 */
public class Game {

    private ArrayList<String> guesses = new ArrayList<>();
    private ArrayList<Object> ships = new ArrayList<>();
    private Ship ship;

    public void innit (int numShips, ShipFactory factory) {
        ShipFactory shipFactory = factory;
        for(int x=0; x<numShips; x++) {
            Object shipRef = shipFactory.getShip();
            ships.add(shipRef);
        }
        ship = (Ship) ships.get(0);
    }

    public ArrayList<String> getGuesses() {
        return guesses;
    }
    public int getGuessesSize() {
        return guesses.size();
    }

    public ArrayList<Object> getShips() {
        return ships;
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
        return !ship.inPlay();
    }

}
