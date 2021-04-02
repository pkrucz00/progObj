package agh.cs.lab7;

public class RectangularMap extends AbstractWorldMap{
    private final int height;
    private final int width;

    public RectangularMap(int width, int height){
        this.height = height;
        this.width = width;
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        return (position.x >= 0 && position.x < this.width &&
                position.y >= 0 && position.y < this.height &&
                super.canMoveTo(position));

    }


    @Override
    public Vector2d[] getBounds() {
        return new Vector2d[]{new Vector2d(0, 0), new Vector2d(this.width - 1, this.height - 1)};
    }


}
