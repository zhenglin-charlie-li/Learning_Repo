package 方法的重载;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 3;
        int[] array = new int[n*2];
        ArrayList<Integer> listOf1 = getRandom(2 * n, n);
//
        for (int i = 0; i < listOf1.size(); i++) {
            System.out.print(listOf1.get(i) + " ");
        }

        for (int i = 0; i < array.length; i++) {
            for (int j=0;j<listOf1.size();j++){
                if (i==listOf1.get(j)){
                    array[i]=1;
                    listOf1.remove(j);
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i]!=1){
                array[i]=-1;
            }
        }
        //
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }


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

