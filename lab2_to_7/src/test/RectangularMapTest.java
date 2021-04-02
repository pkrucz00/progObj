import agh.cs.lab7.Animal;
import agh.cs.lab7.MoveDirection;
import agh.cs.lab7.RectangularMap;
import agh.cs.lab7.Vector2d;
import org.junit.Test;

import static org.junit.Assert.*;

public class RectangularMapTest {
    @Test
    public void canMoveAndIsOccupiedTest(){
        RectangularMap testMap = new RectangularMap(10,6);

        Animal gacus = new Animal(testMap, new Vector2d(2,3));
        Animal jacus = new Animal(testMap, new Vector2d(2,2));
        testMap.place(gacus);
        testMap.place(jacus);

        assertTrue(testMap.isOccupied(new Vector2d(2, 3)));
        assertFalse(testMap.isOccupied(new Vector2d(5, 3)));
        assertTrue(testMap.canMoveTo(new Vector2d(2,4)));
        assertFalse(testMap.canMoveTo(new Vector2d(2,3)));
        assertFalse(testMap.canMoveTo(new Vector2d(2,6)));
    }

    @Test
    public void objectAtTest(){
        RectangularMap testMap = new RectangularMap(10,6);

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
        RectangularMap testMap = new RectangularMap(10,6);

        Animal gacus = new Animal(testMap, new Vector2d(2,3));
        Animal jacus = new Animal(testMap, new Vector2d(2,3));
        testMap.place(gacus);
        testMap.place(jacus);

        assertEquals(gacus, testMap.objectAt(new Vector2d(2,3)));

        Animal placus = new Animal(testMap, new Vector2d(7,10));
        testMap.place(placus);
        assertFalse(testMap.isOccupied(placus.getPosition()));


    }
}
