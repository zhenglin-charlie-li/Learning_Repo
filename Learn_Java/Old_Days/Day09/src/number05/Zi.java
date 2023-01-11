package number05;

public class Zi extends Fu {
    int num=20;

    public void method(int num){
        System.out.println(num);
        System.out.println(this.num);
        System.out.println(super.num);
    }

    @Override
    public void show(){
        super.show();
        System.out.println("zi show");
    }
}
