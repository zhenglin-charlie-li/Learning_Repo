package A;

public class panda {
    private String name;
    private int price;
    private int id;
    private static int idCounter;
     static String room;

    public panda(){
        this.id=++idCounter;
    }

    public panda(String name,int price){
        this.id=++idCounter;
        this.name=name;
        this.price=price;
    }

    public void show(){
        System.out.println(id);
    }
}
