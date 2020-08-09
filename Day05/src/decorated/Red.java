package decorated;

public class Red extends Decorated {
    public Shape shape;

    public Red(Shape shape){
        super(shape);
        this.shape = shape;
    }
    @Override
    public void draw(){
        shape.draw();
        this.Red();
    }

    public void Red(){
        System.out.println("Be Red");
    }
}
