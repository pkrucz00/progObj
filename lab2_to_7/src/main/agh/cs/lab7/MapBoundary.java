package agh.cs.lab7;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{
    Comparator<AbstractWorldElement> xComp = new XComparator();
    Comparator<AbstractWorldElement> yComp = new YComparator();

    SortedSet<AbstractWorldElement> xSorted = new TreeSet<AbstractWorldElement>(xComp);
    SortedSet<AbstractWorldElement> ySorted = new TreeSet<AbstractWorldElement>(yComp);

    IWorldMap map;
    public MapBoundary(IWorldMap map){
        this.map = map;
    }

    public void addElement(AbstractWorldElement element){
        xSorted.add(element);
        ySorted.add(element);
    }

    public void removeElement(AbstractWorldElement element){
        xSorted.remove(element);
        ySorted.remove(element);
    }

    public Vector2d[] getBoundaries(){
        Vector2d firstVector = new Vector2d(this.xSorted.first().getPosition().x, this.ySorted.first().getPosition().y);
        Vector2d secondVector = new Vector2d(this.xSorted.last().getPosition().x, this.ySorted.last().getPosition().y);
        return new Vector2d[]{firstVector, secondVector};
    }


    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        this.removeElement(map.objectAt(oldPosition));
        this.addElement(map.objectAt(newPosition));
    }
}
