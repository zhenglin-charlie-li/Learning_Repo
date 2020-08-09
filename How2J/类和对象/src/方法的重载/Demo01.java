package 方法的重载;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Demo01 {
    public static void main(String[] args) {
       int[][] array = {{1},{2},{9},{128}};
       List<Integer> list = luckyNumbers(array) ;
    }

    public static List<Integer> luckyNumbers (int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> out = new ArrayList<>();
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=0;i<m;i++){
            int min=100000;
            for(int j=0;j<n;j++){
                if(matrix[i][j]<min){
                    min=matrix[i][j];
                }
            }
            list.add(min);
        }
        System.out.println(list);
        for(int j=0;j<n;j++){
            int max=1;
            for(int i=0;i<m;i++){
                if(matrix[i][j]>max){
                    max=matrix[i][j];
                }
            }
            list.add(max);
        }
        System.out.println(list);
        int temp1;
        int temp2;
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                temp1=list.get(i);
                temp2=list.get(j);
                if (temp1==temp2){
                    out.add(temp1);
                }
            }
        }
        System.out.println(out);
        return out;
    }
}
