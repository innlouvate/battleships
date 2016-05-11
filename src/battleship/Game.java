package battleship;

import java.util.Scanner;

/**
 * Created by louisefranklin on 10/05/2016.
 */
public class Game {

    private int[] locationCells;
    private int hitCount = 0;

    public int[] getLocationCells() {
        return locationCells;
    }
    public int getHitCount() {
        return hitCount;
    }

    public void setLocationCells(int[] locations) {
        this.locationCells = locations;
    }

    public String moveResult(String cell) {
        if(checkMove(cell)) {
            hitCount ++;
            return hitCount >= locationCells.length ? "Sink" : "Hit";
        }
        else {
            return "Miss";
        }
    }

    public boolean checkMove(String cell) {
        int testcell = Integer.parseInt(cell);
        for(int n: locationCells) {
            if(n == testcell) {
                return true;
            }
        }
        return false;
    }

}
