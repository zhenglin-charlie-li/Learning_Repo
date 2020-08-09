package number04;

public class Fu {
    String s;
    public Fu(String s){
        this.s=s;
        System.out.println("有参构造方法执行"+this.s);
    }
    public Fu(){
        System.out.println("无参构造方法执行");
    }
}
