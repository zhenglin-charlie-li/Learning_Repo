package decorater;

public class Beef extends Decorator {

    public Beef(Pizza pizza){
        super(pizza);
        this.desc += "牛肉";
    }

    @Override
    public String getDesc(){
        return desc;
    }

    @Override
    public double cost(){
        return pizza.cost()+10.0;
    }

}
