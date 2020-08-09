
package homework;

import java.util.*;

public class homework {
	public static void main(String[] args) {
        long n,total=1;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            total *= i ;
        }
        System.out.println(total);
    }

}
