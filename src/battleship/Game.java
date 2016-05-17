package battleship;

import java.util.ArrayList;

/**
 * Created by louisefranklin on 10/05/2016.
 */
public class Game {

    private ArrayList<String> guesses = new ArrayList<>();
    private ArrayList<Ship> ships = new ArrayList<>();
//    private Ship ship;

    public void innit (int numShips, ShipFactory factory, Grid grid) {
        ShipFactory shipFactory = factory;
        for(int x=0; x<numShips; x++) {
            Ship shipRef = shipFactory.getShip();
            shipRef.initLocations();
            ships.add(shipRef);
            createGrid(grid, numShips);
        }
//        ship = (Ship) ships.get(0);
    }

    public ArrayList<String> getGuesses() {
        return guesses;
    }
    public int getGuessesSize() {
        return guesses.size();
    }

    public ArrayList<Ship> getShips() {
        return ships;
    }

    public String makeMove(String move) {
        if(guesses.contains(move)) {
            return "You already tried that cell!";
        } else {
            guesses.add(move);
            for(Ship boat: ships) {
                String result = boat.moveResult(move);
                if(result == "Hit") {
                    return result;
                }
                if(result == "Sink") {
                    ships.remove(boat);
                    return result;
                }
                return result;
            }

            return "error";
        }
    }

    public boolean gameOver() {
        for(Ship boat: ships) {
            if(boat.inPlay()) {
                return false;
            }
        }
        return true;
    }

    private void createGrid(Grid grid, int shipNo) {
        grid.initGrid();
        grid.initBoard();

        for(int x=0; x<shipNo; x++) {
            grid.placeShip(3);
            System.out.println();
        }
    }



}
