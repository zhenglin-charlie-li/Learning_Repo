package decorater1;

public abstract class Decorator implements Shape{

    protected Shape Decorator;

    public Decorator(Shape shape){
        this.Decorator=shape;
    }

    @Override
    public void draw(){
        Decorator.draw();
    }

}
