package battleship;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by louisefranklin on 10/05/2016.
 */
public class Game {

    private int randNum = (int) (Math.random() * 5);
    private int[] locationCells = {randNum, randNum+1, randNum+2};
    private int hitCount = 0;
    private Set<String> guesses = new HashSet<>();
    private int boatLength = 3;

    public int[] getLocationCells() {
        return locationCells;
    }
    public int getHitCount() {
        return hitCount;
    }
    public Set<String> getGuesses() {
        return guesses;
    }
    public int getBoatLength() {
        return boatLength;
    }
    public int getGuessesSize() {
        return guesses.size();
    }
    public void setLocationCells(int[] locations) {
        this.locationCells = locations;
    }
    public void setBoatLength(int boatLength) {
        this.boatLength = boatLength;
    }

    public String makeMove(String move) {
        if(guesses.contains(move)) {
            return "You already tried that cell!";
        } else {
            String result = moveResult(move);
            guesses.add(move);
            return result;
        }
    }

    public boolean inPlay() {
        return hitCount < boatLength;
    }

    private String moveResult(String cell) {
        if(checkMove(cell)) {
            hitCount ++;
            return hitCount >= locationCells.length ? "Sink" : "Hit";
        }
        else {
            return "Miss";
        }
    }

    private boolean checkMove(String cell) {
        int testcell = Integer.parseInt(cell);
        for(int n: locationCells) {
            if(n == testcell) {
                return true;
            }
        }
        return false;
    }

}
