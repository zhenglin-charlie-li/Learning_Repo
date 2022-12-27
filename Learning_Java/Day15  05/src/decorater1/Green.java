package decorater1;

public class Green extends Decorator{

    public Green(Shape shape){
        super(shape);
    }

    @Override
    public void draw(){
        Decorator.draw();
        setRed(Decorator);
    }

    private void setRed(Shape shape){
        System.out.println("Color: Green");
    }

}
