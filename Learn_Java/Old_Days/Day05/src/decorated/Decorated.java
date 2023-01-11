package decorated;

public abstract class Decorated implements Shape {
    public Shape DecoratedShape;

    public Decorated(Shape shape){
        this.DecoratedShape = shape;
    }

    @Override
    public void draw(){
        DecoratedShape.draw();
    }
}
