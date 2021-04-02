package agh.cs.lab7;

import java.util.LinkedList;

import static agh.cs.lab7.MapDirection.NORTH;

public class Animal extends AbstractWorldElement {
    private MapDirection orientation;
    private IWorldMap map;
    LinkedList<IPositionChangeObserver> observers = new LinkedList<>();

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
        this.orientation = NORTH;
    }

    public String toString(){
        return switch(this.orientation) {
            case NORTH -> "N";
            case EAST -> "E";
            case SOUTH -> "S";
            case WEST -> "W";
        };
    }

    public void move(MoveDirection direction){
        if (direction == MoveDirection.RIGHT){
            this.orientation = this.orientation.next();
        }
        else if (direction == MoveDirection.LEFT){
            this.orientation = this.orientation.previous();
        }
        else if (direction == MoveDirection.FORWARD || direction == MoveDirection.BACKWARD) {
            Vector2d aux = this.orientation.toUnitVector();
            Vector2d oldPosition = this.position;
            if (direction == MoveDirection.BACKWARD) {
                aux = aux.opposite();
            }
            Vector2d newPosition = this.position.add(aux);

            if (this.map.canMoveTo(newPosition)){
                this.map.remove(this);
                this.position = newPosition;
                this.map.place(this);
                this.positionChanged(oldPosition, newPosition);
            }
        }
    }


    public MapDirection getOrientation(){
        return this.orientation;
    }

    public Vector2d getPosition(){
        return this.position;
    }

    void addObserver(IPositionChangeObserver observer){
        this.observers.add(observer);
    }

    void removeObserver(IPositionChangeObserver observer){
        this.observers.remove(observer);
    }

    void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver observer: observers){
            observer.positionChanged(oldPosition, newPosition);
        }
    }

}
