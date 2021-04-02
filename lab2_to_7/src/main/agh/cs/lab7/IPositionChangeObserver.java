package agh.cs.lab7;

public interface IPositionChangeObserver {

    /**
     * Place a animal on the map.
     *
     * @param oldPosition
     *            The old position of the animal on map.
     * @param newPosition
     *            New position of the animal on map.
     */
    void positionChanged(Vector2d oldPosition, Vector2d newPosition);

}
