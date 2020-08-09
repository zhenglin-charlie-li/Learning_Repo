package 随机数;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SelfMade {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("你要获得多少个随机数？范围是多少？");
        int number = in.nextInt();
        int bound = in.nextInt();
        ArrayList<Integer> list = getRandom(bound,number);
        showArrayList(list);
    }
    public static void showArrayList(ArrayList<Integer> inList){
        for (int i=0;i<inList.size();i++){
            System.out.print(inList.get(i)+"  ");
        }
    }

    //这个方法用来获得[0,(n-1)]的无重复随机数，需输入边界和个数
    public static ArrayList<Integer> getRandom(int bound, int number) {
        if (bound < number) {
            System.out.println("ERROR");
            return null;
        } else {
            Random r = new Random();
            ArrayList<Integer> list = new ArrayList<>();
            list.add(r.nextInt(bound));
            for (int i = 0; i < number - 1; i++) {
                int temp = r.nextInt(bound);
                int count = 1;
                for (int j = 0; j < list.size(); j++) {

                    if (list.get(j) == temp) {
                        count = 0;
                    }
                }
                if (count == 0) {
                    i--;
                } else {
                    list.add(temp);
                }
            }
            return list;
        }
    }
}