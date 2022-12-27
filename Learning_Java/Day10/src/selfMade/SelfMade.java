package selfMade;

import org.w3c.dom.ls.LSOutput;

public class SelfMade {
    public static void main(String[] args) {

        person one = new person("panda");
        one.show();

        Vehicle car1 = new car(123);
        System.out.println(car1.getPrice());
    }
}

class Vehicle{
    private int price;
    public Vehicle(int price){
        this.price = price;
    }
    public int getPrice(){
        return this.price;
    }
}

class car extends Vehicle{
    public car(int price){
        super(price);
    }
}

class person{
    String name;
    public person(String name){
        this.name = name ;
    }
    public void show() {
        System.out.println(name);
    }
}
