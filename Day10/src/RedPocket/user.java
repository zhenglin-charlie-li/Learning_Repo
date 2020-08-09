package RedPocket;

public class user {
    private String name;
    private int money;

    public user() {

    }

    public user(String initialNme, int initialMoney) {
        this.name = initialNme;
        this.money = initialMoney;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public void show() {
        System.out.println(name + " has " + money);
    }

}
