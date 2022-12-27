package 方法的重载;

import java.util.ArrayList;
import java.util.Random;

public class Demo02 {
    public static void main(String[] args) {
        ArrayList<Integer> randomList = getRandom(4);
        for (int i=0;i<randomList.size();i++){
            System.out.print(randomList.get(i)+"  ");
        }
    }

    public static ArrayList<Integer> getRandom(int number){
        Random r = new Random();
        ArrayList<Integer> outList = new ArrayList<>();
        outList.add(r.nextInt(number));
        for (int i=0;i<number-1;i++){
            int is = 1;
            int temp = r.nextInt(number);
            for (int j=0;j<outList.size();j++){
                if (temp==outList.get(j)){
                    is = 0;
                    break;
                }
            }
            if (is == 0){
                i--;
            }else{
                outList.add(temp);
            }
        }
        return outList;
    }
}
