package decorater;

public class Client {
    public static void main(String[] args) {
        Pizza pizza = new Beef(new OriginalPizza());
        System.out.println("eat: "+pizza.desc+"\ncost: "+pizza.cost());
    }
}
