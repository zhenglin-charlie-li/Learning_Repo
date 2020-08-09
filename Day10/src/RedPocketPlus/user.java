package RedPocketPlus;

import java.util.ArrayList;
import java.util.Random;

public class user {
    private String name;
    private int money;
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public user(String name, int money, int number) {
        this.name = name;
        this.money = money;
        this.number = number;
    }

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
        System.out.print(name + " 有 " + money+"元钱。");
    }

    public ArrayList<Integer> sendPocket(int moneyToSend, int numberOfPeople) {
        if (moneyToSend > getMoney()) {
            System.out.println("余额不足");
            return null;
        } else {
            int m = moneyToSend / numberOfPeople;
            int n = moneyToSend % numberOfPeople;

            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < numberOfPeople - 1; i++) {
                arrayList.add(m);
            }
            arrayList.add(m + n);
            setMoney(getMoney() - moneyToSend);
            return arrayList;
        }
    }

    public void getPocket(ArrayList<Integer> integerArrayList) {
        int index = new Random().nextInt(integerArrayList.size());

        int delta = integerArrayList.remove(index);

        setMoney(getMoney() + delta);
    }
}
