package selfQuiz;

import java.util.ArrayList;
import java.util.Random;

public class member extends user {
    public member(){

    }

    public member(String name,int money){
        super(name, money);
    }

    public void get(ArrayList<Integer> list){
        int index = new Random().nextInt(list.size());
        int delta = list.remove(index);
        setMoney(delta+getMoney());
    }

}
