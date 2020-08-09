package decorater;

public abstract class Decorator extends Pizza {

    protected Pizza pizza;

    public Decorator(Pizza pizza){
        this.pizza=pizza;
        this.desc=pizza.desc;
    }

    @Override
    public abstract double cost();

}
