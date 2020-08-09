package 哈哈哈;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class April09 {
    public static void main(){
        ArrayList<Integer> randomList = getRandom(9);
        for (int i=0;i<randomList.size();i++){
            System.out.print(randomList.get(i)+"  ");
        }
    }

    public static ArrayList<Integer> getRandom(int number){
        Random r = new Random();
        ArrayList<Integer> outList = new ArrayList<>();
        outList.add(r.nextInt(number));
        for (int i=0;i<number;i++){
            int is = 1;
            int temp = r.nextInt(number);
            for (int j=0;j<outList.size();j++){
                if (temp==outList.get(i)){
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
