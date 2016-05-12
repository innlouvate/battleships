package battleship;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by louisefranklin on 12/05/2016.
 */
public class ShipTest {

    public Ship ship = new Ship();

    @Before
    public void initship() {
        ship.addLocationCells("2");
        ship.addLocationCells("3");
        ship.addLocationCells("4");
    }

    @Test
    public void testLocationCellsDecreases() {
        ship.moveResult("2");
        assertEquals(2, ship.getLocationCells().size());
    }

    @Test
    public void testMoveResultMiss() {
        assertEquals("Miss", ship.moveResult("1"));
    }

    @Test
    public void testMoveResultHit() {
        assertEquals("Hit", ship.moveResult("2"));
    }

    @Test
    public void testMoveResultSink() {
        ship.moveResult("2");
        ship.moveResult("3");
        assertEquals("Sink", ship.moveResult("4"));
    }

}