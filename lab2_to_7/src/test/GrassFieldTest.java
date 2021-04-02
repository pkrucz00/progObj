import agh.cs.lab7.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class GrassFieldTest {
    @Test
    public void canMoveAndIsOccupiedTest(){
        GrassField testMap = new GrassField(10);

        Animal gacus = new Animal(testMap, new Vector2d(2,3));
        Animal jacus = new Animal(testMap, new Vector2d(2,2));
        testMap.place(gacus);
        testMap.place(jacus);

        assertTrue(testMap.isOccupied(new Vector2d(2, 3)));
        assertFalse(testMap.isOccupied(new Vector2d(5, 3)) ||
                testMap.objectAt(new Vector2d(5, 3)) instanceof Grass);

        assertTrue(testMap.canMoveTo(new Vector2d(2,4)));
        assertFalse(testMap.canMoveTo(new Vector2d(2,3)));
        assertTrue(testMap.canMoveTo(new Vector2d(2,6)));
    }

    @Test
    public void objectAtTest(){
        GrassField testMap = new GrassField(10);

        Animal gacus = new Animal(testMap, new Vector2d(2,3));
        testMap.place(gacus);
        assertEquals(gacus, testMap.objectAt(new Vector2d(2,3)));

        Animal jacus = new Animal(testMap, new Vector2d(2,2));
        testMap.place(jacus);
        jacus.move(MoveDirection.FORWARD);
        assertEquals(jacus, testMap.objectAt(new Vector2d(2,2)));
        assertEquals(gacus, testMap.objectAt(new Vector2d(2,3)));
    }

    @Test
    public void placeTest(){
        GrassField testMap = new GrassField(10);

        Animal gacus = new Animal(testMap, new Vector2d(2,3));
        Animal jacus = new Animal(testMap, new Vector2d(2,3));
        testMap.place(gacus);
        testMap.place(jacus);

        assertEquals(gacus, testMap.objectAt(new Vector2d(2,3)));

        Animal placus = new Animal(testMap, new Vector2d(7,10));
        testMap.place(placus);
        assertTrue(testMap.isOccupied(placus.getPosition()));


    }
}
