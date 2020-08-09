package decorater1;

public class Red extends Decorator {

    public Red(Shape shape){
        super(shape);
    }

    @Override
    public void draw(){
        Decorator.draw();
        setRed(Decorator);
    }

    private void setRed(Shape shape){
        System.out.println("Color: Red");
    }

}
