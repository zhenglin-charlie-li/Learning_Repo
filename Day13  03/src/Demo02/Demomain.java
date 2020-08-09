package Demo02;

import java.util.ArrayList;
import java.util.Iterator;

public class Demomain {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("panda");
        list1.add("bear");

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);

        printArray(list2);
    }

    public static void printArray(ArrayList<?> list){
        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext()){
            Object object = iterator.next();
            System.out.println(object);
        }
    }
}
