package decorated;

public class Green extends Decorated{
    public Shape shape;

    public Green(Shape shape){
        super(shape);
        this.shape = shape;
    }
    @Override
    public void draw(){
        shape.draw();
        this.Green();
    }

    public void Green(){
        System.out.println("Be Green");
    }
}
