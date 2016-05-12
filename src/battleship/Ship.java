package battleship;

import java.util.ArrayList;

/**
 * Created by louisefranklin on 12/05/2016.
 */
public class Ship {

    private ArrayList<String> locationCells = new ArrayList<>();

    public void initLocations() {
        int randNum = (int) (Math.random() * 5);
        addLocationCells(Integer.toString(randNum));
        addLocationCells(Integer.toString(randNum+1));
        addLocationCells(Integer.toString(randNum+2));
    }

    public ArrayList getLocationCells() {
        return locationCells;
    }

    public int getLocationCellsSize() {
        return locationCells.size();
    }

    public void addLocationCells(String location) {
        this.locationCells.add(location);
    }

    public boolean inPlay() {
        return locationCells.size() > 0;
    }

    public String moveResult(String cell) {
        if(checkMove(cell)) {
            locationCells.remove(cell);
            return inPlay() ? "Hit" : "Sink";
        }
        else {
            return "Miss";
        }
    }

    private boolean checkMove(String cell) {
        return locationCells.contains(cell);
    }
}
