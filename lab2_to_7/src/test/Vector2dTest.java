import agh.cs.lab7.Vector2d;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Vector2dTest {
    Vector2d v1 = new Vector2d(1,2);
    Vector2d v2 = new Vector2d(2,3);
    Vector2d v3 = new Vector2d(2,4);

    @Test
    public void equalsTest(){
        assertFalse(v1.equals(new ArrayList()));
        assertFalse(v1.equals(v2));
        assertTrue(v1.equals(v1));
    }

    @Test
    public void toStringTest(){
        assertEquals(v1.toString(), "(1,2)");
        assertEquals(v2.toString(), "(2,3)");
        assertEquals(v3.toString(), "(2,4)");
    }

    @Test
    public void precedesTest(){
        assertTrue(v1.precedes(v2));
        assertTrue(v2.precedes(v3));
        assertFalse(v2.precedes(v1));
        assertTrue(v1.precedes(v1));
    }

    @Test
    public void followsTest(){
        assertFalse(v1.follows(v2));
        assertFalse(v2.follows(v3));
        assertTrue(v2.follows(v1));
        assertTrue(v1.follows(v1));
    }

    @Test
    public void upperRightTest(){
        assertEquals(v1.upperRight(v2), v2);
        assertEquals(v2.upperRight(v1), v2);
        assertEquals(v2.upperRight(v3), v3);
    }

    @Test
    public void lowerLeftTest(){
        assertEquals(v1.lowerLeft(v2), v1);
        assertEquals(v2.lowerLeft(v1), v1);
        assertEquals(v3.lowerLeft(v2), v2);
    }

    @Test
    public void addTest(){
        assertEquals(v1.add(v2), new Vector2d(3,5));
        assertEquals(v2.add(v1), new Vector2d(3,5));
        assertEquals(v2.add(v3), new Vector2d(4,7));
    }

    @Test
    public void subtractTest(){
        assertEquals(v1.subtract(v2), new Vector2d(-1,-1));
        assertEquals(v2.subtract(v1), new Vector2d(1,1));
        assertEquals(v2.subtract(v3), new Vector2d(0,-1));
    }

    @Test
    public void oppositeTest(){
        assertEquals(v1.opposite(), new Vector2d(-1, -2));
        assertEquals(v1.opposite().opposite(), v1);
        assertEquals(v2.subtract(v1).opposite(), new Vector2d(-1,-1));
    }
}
