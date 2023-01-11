package USB;

public class KeyBoard implements USB {
    @Override
    public void open(){
        System.out.println("Keyboard open, red light on");
    }

    @Override
    public void close(){
        System.out.println("Keyboard close");
    }

    public void type(){
        System.out.println("type!!!");
    }

}
