package Self;

public class Green extends Decorator {

    public Green(Shape shape){
        super(shape);
    }

    @Override
    public void draw() {
        super.draw();
        setGreen();
    }

    public void setGreen(){
        System.out.println("Be Green");
    }


}
