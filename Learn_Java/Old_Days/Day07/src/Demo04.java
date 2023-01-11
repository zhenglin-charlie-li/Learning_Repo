import java.util.ArrayList;
import java.util.Random;

public class Demo04 {
    public static void main(String[] args) {
        Random r=new Random();
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(r.nextInt(33)+1);
            System.out.println(list.get(i));
        }

    }
}
