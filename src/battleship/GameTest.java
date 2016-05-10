package battleship;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by louisefranklin on 10/05/2016.
 */
public class GameTest extends Game {

    @Test
    public void testGameSetup() {
        Game game = new Game();
        assertEquals(null, game.getLocationCells());
    }

    @Test
    public void testCheckPlayTrue() {
        Game game = new Game();
        int[] locations = {2,3,4};
        game.setLocationCells(locations);
        assertEquals(true, game.checkMove("2"));
    }

    @Test
    public void testCheckPlayFalse() {
        Game game = new Game();
        int[] locations = {2,3,4};
        game.setLocationCells(locations);
        assertEquals(false, game.checkMove("1"));
    }

    @Test
    public void testHitCountIncreases() {
        Game game = new Game();
        int[] locations = {2,3,4};
        game.setLocationCells(locations);
        game.moveResult("2");
        assertEquals(1, game.getHitCount());
    }

    @Test
    public void testMoveResultMiss() {
        Game game = new Game();
        int[] locations = {2,3,4};
        game.setLocationCells(locations);
        assertEquals("Miss", game.moveResult("1"));
    }

    @Test
    public void testMoveResultHit() {
        Game game = new Game();
        int[] locations = {2,3,4};
        game.setLocationCells(locations);
        assertEquals("Hit", game.moveResult("2"));
    }

    @Test
    public void testMoveResultSink() {
        Game game = new Game();
        int[] locations = {2,3,4};
        game.setLocationCells(locations);
        game.moveResult("2");
        game.moveResult("3");
        assertEquals("Sink", game.moveResult("4"));
    }

}