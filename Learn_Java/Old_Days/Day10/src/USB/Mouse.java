package USB;

public class Mouse implements USB {
    @Override
    public void open(){
        System.out.println("Mouse open, green light on");
    }

    @Override
    public void close(){
        System.out.println("Mouse close");
    }

    public void click(){
        System.out.println("click!!!");
    }

}
