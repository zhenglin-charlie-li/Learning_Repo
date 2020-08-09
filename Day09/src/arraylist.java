import java.util.ArrayList;

public class arraylist {
    public static void main(String[] args) {
        ArrayList<Integer>  list = new ArrayList<>(5);
        list.add(1);
        list.add(10);
        list.add(3);
        list.add(4);
        list.add(5);
        for (int i = 0; i < 5; i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
        System.out.println(list.remove(1));

        for (int i = 0; i < 4; i++) {
            System.out.print(list.get(i)+" ");
        }
    }
}
