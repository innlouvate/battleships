package battleship;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by louisefranklin on 10/05/2016.
 */
public class GameTest extends Game {

    private Game game;
    private Ship ship;

    @Before
    public void initGame() {
        game = new GameTest();
        ship = mock(Ship.class);
        game.setShip(ship);
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
    public void testMakeMoveError() {
        game.makeMove("2");
        assertEquals("You already tried that cell!", game.makeMove("2"));
    }

    @Test
    public void testMakeMovePassesResult() {
        when(ship.moveResult("2")).thenReturn("Hit");
        assertEquals("Hit", game.makeMove("2"));
    }

    @Test
    public void testMoveMade() {

        game.makeMove("2");
        verify(ship, times(1)).moveResult("2");
    }

}