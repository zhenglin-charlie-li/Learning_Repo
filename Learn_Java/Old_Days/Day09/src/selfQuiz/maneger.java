package selfQuiz;

import java.util.ArrayList;

public class maneger extends user {
    public maneger(){

    }

    public maneger(String name,int money){
        super(name, money);
    }

    public ArrayList<Integer> send(int moneyToSend,int numberOfPeople){
        int leftMoney = super.getMoney();
        if (leftMoney<moneyToSend){
            System.out.println("Not Enough Money");
            return null;
        }else{
            ArrayList<Integer> redList = new ArrayList<>();
            int m=moneyToSend/numberOfPeople;
            int n=moneyToSend%numberOfPeople;
            for (int i=0;i<numberOfPeople-1;i++){
                redList.add(m);
            }
            redList.add(m+n);
            super.setMoney(leftMoney-moneyToSend);
            return redList;

        }
    }
}
