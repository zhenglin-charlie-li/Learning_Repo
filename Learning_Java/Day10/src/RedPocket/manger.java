package RedPocket;

import java.util.ArrayList;

public class manger extends user{

    public manger(){

    }

    public manger(String Name, int Money){
        super(Name,Money);
    }

    int leftMoney=super.getMoney();

    public ArrayList<Integer> sendPocket(int moneyToSend, int numberOfPeople){
        if(moneyToSend>leftMoney){
            System.out.println("Not Enough Money");
            return null;
        }else{
            int m=moneyToSend/numberOfPeople;
            int n=moneyToSend%numberOfPeople;

            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i=0;i<numberOfPeople-1;i++){
                arrayList.add(m);
            }
            arrayList.add(m+n);
            setMoney(getMoney()-moneyToSend);
            return arrayList;
        }
    }

}
