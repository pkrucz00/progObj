package agh.cs.lab7;

import java.util.Comparator;

public class XComparator implements Comparator<AbstractWorldElement> {

    @Override
    public int compare(AbstractWorldElement o1, AbstractWorldElement o2) {
        if (o1 instanceof Animal && o2 instanceof Animal){
            if (o1.equals(o2)){
                return 0;
            }
        }
        Vector2d position1 = o1.getPosition();
        Vector2d position2 = o2.getPosition();
        if (position1.x > position2.x){
            return 1;
        } else if (position1.x < position2.x){
            return -1;
        } else{
            if (position1.y > position2.y){
                return 1;
            } else if (position1.y < position2.y){
                return -1;
            } else if (o1 instanceof Animal){   // jezeli mamy dwa obiekty na tym samym miejsc, to porownujemy typy obiektów
                return 1;
            } else{
                return -1;
            }
        }
    }
}
