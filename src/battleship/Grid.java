package battleship;

/**
 * Created by louisefranklin on 16/05/2016.
 */
public class Grid {

    private int gridLength = 7;
    private int[][] grid = new int[gridLength][gridLength];

//    public void printGrid() {
//        for (int r = 0; r<grid.length; r++) {
//            for (int c = 0; c<grid.length; c++){
////                grid[r][c] = Integer.parseInt("?");  // Initialize the cell
//                System.out.print("[" +grid[r][c] + "]"); // Display the content of cell board
//            }
//            System.out.println();  // go to next line
//        }
//    }

    private String[][] board = new String [gridLength][gridLength];

    public void initBoard() {
        for (int r = 0; r<board.length;r++) {
            for (int c = 0; c < board.length; c++) {
                board[r][c] = "?";
            }
        }
    }

    public void printBoard() {
        for (int r = 0; r<board.length;r++){
            for (int c = 0; c <board.length;c++){
                System.out.print (board[r][c] + " ");
            }
            System.out.println();
        }
    }

}
