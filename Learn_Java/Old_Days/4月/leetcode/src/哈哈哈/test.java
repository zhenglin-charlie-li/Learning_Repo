package 哈哈哈;

import java.util.ArrayList;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        String[] str = {"Three","Two","One"};
        for (int i = 0; i < str.length; ++i) {
            System.out.println(str[i]+"/"); }
    }

    public String getHint(String secret, String guess) {
        int length = secret.length();
        char[] array1=secret.toCharArray();
        char[] array2=guess.toCharArray();

        int m=0;
        int n=0;
        for (int i=0;i<length;i++){
            if (array1[i]==array2[i]){
                m++;
            }
        }
        for (int i=0;i<length;i++){
            for (int j=0;j<length;j++){
                if (array1[i]==array1[j]){
                    n++;
                }
            }
        }
        n=n-m;
        return m+"A"+n+"B";
    }

}
