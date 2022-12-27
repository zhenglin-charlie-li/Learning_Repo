package RedPocket;

public class user {
    private String name;
    private int balance;

    public void show(){
        System.out.println("I am "+name+
                ". I have "+balance+".");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public user(){

    }
    public user(String name, int balance){
        this.name=name;
        this.balance=balance;
    }
}
