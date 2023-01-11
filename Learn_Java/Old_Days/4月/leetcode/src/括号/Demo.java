package 括号;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        char ch1='a';
        int ch2=ch1-32;
        char s=(char) ch2;
        System.out.println(s);
    }

    public static ArrayList<Integer> getRandom(int bound, int number) {
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
