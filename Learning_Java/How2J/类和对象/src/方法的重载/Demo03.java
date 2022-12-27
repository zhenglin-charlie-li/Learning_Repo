package 方法的重载;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class Demo03 {
    public static void main(String[] args) {
        String s = "the sky is blue";
        //System.out.println(getBack(s));
        String[] strS = s.split(" ");

        StringBuffer out = new StringBuffer();
        for (int i=strS.length-1;i>=0;i--){
            if (strS[i].equals(" ")){
                break;
            }
            out.append(strS[i]);
            out.append(" ");
        }
        out.toString();
        System.out.println(out);
    }

    public static String getBack(String s){
        return new StringBuffer(s).reverse().toString();
    }

}