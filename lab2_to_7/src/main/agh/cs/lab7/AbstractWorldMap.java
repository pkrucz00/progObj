package agh.cs.lab7;

import java.util.LinkedHashMap;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    Map<Vector2d,Animal> animals = new LinkedHashMap<>();
    protected MapBoundary boundaries = new MapBoundary(this);

    @Override
    public boolean isOccupied(Vector2d position){
        return animals.containsKey(position);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (!isOccupied(position));
    }

    @Override
    public boolean place(Animal animal) {
        Vector2d position = animal.getPosition();
        if (!canMoveTo(position)) {
            throw new IllegalArgumentException("Invalid argument. Can't place animal to" + position + "Position occupied by " + this.objectAt(position).toString());
        }
        this.animals.put(animal.getPosition(), animal);
        this.boundaries.addElement(animal);
        return true;
    }

    @Override
    public boolean remove(Animal animal){
        Vector2d position = animal.getPosition();
        if (canMoveTo(position)) {
            return false;
        }
        this.animals.remove(animal.getPosition());
        this.boundaries.removeElement(animal);
        return true;
    }

    @Override
    public AbstractWorldElement objectAt(Vector2d position) {
        return animals.get(position);
    }

    @Override
    public String toString(){
        MapVisualizer visual = new MapVisualizer(this);
        Vector2d[] bounds = this.getBounds();
        return visual.draw(bounds[0], bounds[1]);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal tmp = this.animals.get(oldPosition);
        this.animals.remove(oldPosition);
        this.animals.put(newPosition, tmp);
    }


}
