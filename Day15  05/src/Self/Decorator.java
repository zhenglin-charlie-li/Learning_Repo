package Self;

public abstract class Decorator implements Shape{

    private Shape shape;

    public Decorator(Shape shape){
        this.shape = shape;
    }

    @Override
    public void draw() {
        shape.draw();
    }
}
