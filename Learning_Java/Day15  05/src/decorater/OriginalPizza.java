package decorater;

public class OriginalPizza extends Pizza{

    public OriginalPizza(){
        this.desc="普通披萨";
    }

    @Override
    public double cost(){
        return 10;
    }

}
