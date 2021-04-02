package agh.cs.lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap{
    private int n;
    private List<Grass> grasses = new ArrayList<>();


    public GrassField(int numberOfGrassSquares){
        this.n = numberOfGrassSquares;

        Random rand = new Random();
        int i = 0;
        Vector2d upperBound = new Vector2d((int) (sqrt(10 * numberOfGrassSquares)), (int) (sqrt(10 * numberOfGrassSquares)));
        while (i < n) {
            Vector2d randomVector = new Vector2d(rand.nextInt(upperBound.x), rand.nextInt(upperBound.y));
            if (!isOccupied(randomVector)){
                Grass tmp = new Grass(randomVector);
                this.grasses.add(tmp);
                this.boundaries.addElement(tmp);
                i++;
            }
        }
    }

    @Override
    public boolean isOccupied(Vector2d position){
        for (Grass tmp: this.grasses){
            if (position.equals(tmp.getPosition())){
                return true;
            }
        }
        return super.isOccupied(position);
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        return (super.canMoveTo(position) || objectAt(position) instanceof Grass);
    }

    @Override
    public AbstractWorldElement objectAt(Vector2d position) {
        AbstractWorldElement object = super.objectAt(position);
        if (object != null){
            return object;
        }
        for (Grass tmp : this.grasses){
            if (tmp.getPosition().equals(position)){
                return tmp;
            }
        }
        return null;
    }

    @Override
    public Vector2d[] getBounds() {
        return this.boundaries.getBoundaries();
    }
}
