package 随机数;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("你要获得多少个随机数？范围是多少？");
        int number = in.nextInt();
        int bound = in.nextInt();
        Random r = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(r.nextInt(bound));
        for (int i=0; i<number-1 ;i++){
            int temp = r.nextInt(bound);
            int count = 1;
            for (int j=0;j<list.size() ;j++){

                if (list.get(j)==temp){
                    count = 0;
                }
            }
            if (count==0){
                i--;
            }else{
                list.add(temp);
            }
        }
        for (int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }

    }
}
