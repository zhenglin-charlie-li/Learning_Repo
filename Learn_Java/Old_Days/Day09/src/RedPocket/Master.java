package RedPocket;

import java.util.ArrayList;

public class Master extends user {

    public Master() {

    }

    public Master(String name, int money) {
        super(name, money);
    }

    int leftMoney = super.getBalance();

    public ArrayList<Integer> send(int money, int number) {
        if (money > leftMoney) {
            System.out.println("ERROR,not enough money");
            return null;
        } else {
            super.setBalance(leftMoney - money);

            ArrayList<Integer> list = new ArrayList<>();

            int m = money / number;
            int n = money % number;

            for (int i = 0; i < number - 1; i++) {
                list.add(m);
            }
            list.add(m + n);

            return list;
        }
    }

}
