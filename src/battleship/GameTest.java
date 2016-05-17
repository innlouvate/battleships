package battleship;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)

/**
 * Created by louisefranklin on 10/05/2016.
 */
public class GameTest extends Game {

    @Mock
    private ShipFactory shipFactory;

    @Mock
    private Ship ship;

    @Mock
    private Grid grid;

    @InjectMocks
    private Game game;

    @Before
    public void initGame() {
        when(shipFactory.getShip()).thenReturn(ship);
        when(ship.moveResult("2")).thenReturn("Test");
        when(ship.inPlay()).thenReturn(true);
        game.innit(1, shipFactory, grid);
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
    public void testMoveMade() {
        game.makeMove("2");
        verify(ship, times(1)).moveResult("2");

    }

    @Test
    public void testGameOverFalse() {
        assertEquals(false, game.gameOver());
    }

    @Test
    public void testGameOverTrue() {
        when(ship.inPlay()).thenReturn(false);
        assertEquals(true, game.gameOver());
    }

}