package Demo02;

public class Outer {
    private int num = 30;

    public class Inner{
        int a=20;
        public void show(){
            System.out.println(num);
        }
    }

    public void showInner(){
        System.out.println(new Inner().a);
    }

}
