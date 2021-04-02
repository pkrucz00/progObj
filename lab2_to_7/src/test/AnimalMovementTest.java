import agh.cs.lab7.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalMovementTest {

    @Test
    public void test(){
        String[] args = {"f", "b","r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertEquals("S", map.objectAt(new Vector2d(2,0)).toString());
        assertEquals("N", map.objectAt(new Vector2d(3,4)).toString());
        assertEquals(new Vector2d(2,0), ((Animal) map.objectAt(new Vector2d(2,0))).getPosition());
        assertEquals(new Vector2d(3,4), ((Animal) map.objectAt(new Vector2d(3,4))).getPosition());
    }


}
