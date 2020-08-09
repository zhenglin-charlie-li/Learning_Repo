package 哈哈哈;

import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String str2=new String();
        char[] chars = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            for (int j = str.length()-1; j >= i+1; j--) {


                int t=j;

                if (i == j+1) {
                    for (int k = i; k <= t; k++) {
                        System.out.print(chars[k]);
                    }
                }
            }
        }
    }
}
