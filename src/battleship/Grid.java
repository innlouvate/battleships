package battleship;

import java.util.ArrayList;

import static com.sun.tools.doclint.Entity.alpha;

/**
 * Created by louisefranklin on 16/05/2016.
 */
public class Grid {

    private int gridLength = 7;
    private int[] grid = new int[gridLength*gridLength];
    private String[] alpha = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private int shipCount = 0;
    private int shipSize = 3;

    public void initGrid() {
        for (int r = 0; r<grid.length;r++) {
            grid[r] = 0;
        }
    }

    private String[][] board = new String [gridLength][gridLength];

    public void initBoard() {
        for (int r = 0; r<board.length;r++) {
            for (int c = 0; c < board.length; c++) {
                board[r][c] = "?";
            }
        }
    }

    public void printBoard() {
        System.out.print("  ");
        for (int c = 0; c <board.length; c++){
            System.out.print (c + " ");
        }
        System.out.println();
        for (int r = 0; r<board.length; r++){
            System.out.print (alpha[r] + " ");
            for (int c = 0; c<board.length; c++){
                System.out.print (board[r][c] + " ");
            }
            System.out.println();
        }
    }

    public void placeShip(int size) {
        int[] coords = new int[size];
        int attempts = 0;
        boolean success = false;
        int directionRand = (int) (Math.random() * 2);
        int increment = directionRand == 1 ? 1 : gridLength;

        shipCount++;

        while (!success & attempts++ < 200) {
            int location = (int) (Math.random() * (grid.length));
            int x = 0;
            success = true;

            while(success && x < shipSize) {
                if(grid[location] == 0) {
                    coords[x++] = location;
                    if(increment == 1 && location % gridLength == 0) {
                        success = false;
                    }
                    if(location >= grid.length) {
                        success = false;
                    }
                    location += increment;
                } else {
                    success = false;
                }
            }

        }

        ArrayList<String > alphaCoords = convertAlpha(coords);
        for (String n: alphaCoords) {
            System.out.print(n + " ");
        }


    }

    private ArrayList convertAlpha(int[] coords) {
        ArrayList<String> gridCoords = new ArrayList<>();
        int x = 0;
        int row;
        int col;

        while(x < shipSize) {
            grid[coords[x]] = 1;
            row = (int) (coords[x] / gridLength);
            col = coords[x] % gridLength;
            gridCoords.add(alpha[col] + row);
            x++;
        }

        return gridCoords;
    }

}
