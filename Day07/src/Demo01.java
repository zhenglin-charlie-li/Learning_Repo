import java.util.*;

public class Demo01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < 100; i++) {
            Random r = new Random();
            int number = r.nextInt(n);
            System.out.println(number);
        }
    }
}
