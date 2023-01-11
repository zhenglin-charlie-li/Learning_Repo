package 哈哈哈;

import java.util.ArrayList;
import java.util.Scanner;

public class April08 {
    public static int movingCount(int m, int n, int k) {
        int count = 0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                ArrayList<Integer> list = getList(i,j);
                if (getSum(list)<=k){
                    count++;
                }
            }
        }
        return count;
    }

    public static ArrayList<Integer> getList(int m, int n){
        ArrayList<Integer> out = new ArrayList<>();
        int k = m;
        if (k<10){
            out.add(k);
        }else{
            while(k!=0){
                int t =k%10;
                k=k/10;
                out.add(t);
            }
        }
        k = n;
        if (k<10){
            out.add(k);
        }else{
            while(k!=0){
                int t =k%10;
                k=k/10;
                out.add(t);
            }
        }
        return out;
    }


    public static int getSum(ArrayList<Integer> list){
        int total=0;
        for (int i=0; i<list.size(); i++){
            total += list.get(i);
        }
        return total;
    }


    public static void main(String[] args) {
        int result = movingCount(16,8,4);
        System.out.println(result);
    }
}
