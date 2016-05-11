package battleship;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by louisefranklin on 10/05/2016.
 */
public class GameTest extends Game {

    public Game game = new Game();

    @Before
    public void initGame() {
        int[] locations = {2,3,4};
        game.setLocationCells(locations);
    }

    @Test
    public void testInit() {
        assertEquals(0, game.getHitCount());
        assertEquals(3, game.getBoatLength());
    }

    @Test
    public void testHitCountIncreases() {
        game.makeMove("2");
        assertEquals(1, game.getHitCount());
    }

    @Test
    public void testGuessesIncreasesWhenHit() {
        game.makeMove("2");
        assertEquals(1, game.getGuessesSize());
    }

    @Test
    public void testGuessesIncreasesWhenMiss() {
        game.makeMove("1");
        assertEquals(1, game.getGuessesSize());
    }

    @Test
    public void testMakeMoveMiss() {
        assertEquals("Miss", game.makeMove("1"));
    }

    @Test
    public void testMakeMoveHit() {
        assertEquals("Hit", game.makeMove("2"));
    }

    @Test
    public void testMakeMoveSink() {
        game.makeMove("2");
        game.makeMove("3");
        assertEquals("Sink", game.makeMove("4"));
    }

    @Test
    public void testMakeMoveError() {
        game.makeMove("2");
        assertEquals("You already tried that cell!", game.makeMove("2"));
    }

}