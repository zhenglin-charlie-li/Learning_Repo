package Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {
        String str= new Scanner(System.in).nextLine();
        char[] charArray = str.toCharArray();
        System.out.println(Arrays.toString(charArray));

        Arrays.sort(charArray);
        System.out.println(Arrays.toString(charArray));
    }
}
