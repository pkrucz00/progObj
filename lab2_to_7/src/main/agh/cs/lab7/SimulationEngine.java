package agh.cs.lab7;

public class SimulationEngine implements IEngine{
    private MoveDirection[] directions;
    private IWorldMap map;
    private Vector2d[] positions;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions){
        this.directions = directions;
        this.map = map;
        this.positions = positions;

        for (int i = 0; i < positions.length; i++){
            Animal gacek = new Animal(this.map, this.positions[i]);
            this.map.place(gacek);
        }
    }


    @Override
    public void run() {
        int n = this.positions.length;
        for (int i = 0; i < this.directions.length; i++){
            Object gacus = map.objectAt(this.positions[i%n]);
            if (gacus instanceof Animal){
                ((Animal) gacus).move(this.directions[i]);
                this.positions[i%n] = ((Animal)gacus).getPosition();
            }

        }
    }
}
