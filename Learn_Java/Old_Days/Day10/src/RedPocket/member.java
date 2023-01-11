package RedPocket;

import java.util.ArrayList;
import java.util.Random;

public class member extends user {

    public member(){

    }

    public member(String Name, int Money){
        super(Name,Money);
    }

    public void getPocket(ArrayList<Integer> integerArrayList){
        int index = new Random().nextInt(integerArrayList.size());

        int delta=integerArrayList.remove(index);

        setMoney(getMoney()+delta);
    }
}
