package Demo06;

public class myClass implements myInterface{
    @Override
    public void show(){
        System.out.println("实现类");
    }
    @Override
    public int get(){
        return 999;
    }
}
