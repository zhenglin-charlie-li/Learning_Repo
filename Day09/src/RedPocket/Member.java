package RedPocket;

import java.util.ArrayList;
import java.util.Random;

public class Member extends user {
    public Member(){

    }

    public Member(String name,int leftMoney){
        super(name,leftMoney);
    }

    public void openRedPocket(ArrayList<Integer> list){
        int index=new Random().nextInt(list.size());

        int delta=list.remove(index);

        int money = super.getBalance();

        super.setBalance(money+delta);
    }
}
