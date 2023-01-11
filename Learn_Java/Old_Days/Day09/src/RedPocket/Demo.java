package RedPocket;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        Master s = new Master("群主", 100);
        Member one = new Member("1", 0);
        Member two = new Member("2", 0);
        Member three = new Member("3", 0);

        s.show();
        one.show();
        two.show();
        three.show();

        ArrayList<Integer> redList = s.send(88,3);
        one.openRedPocket(redList);
        two.openRedPocket(redList);
        three.openRedPocket(redList);

        s.show();
        one.show();
        two.show();
        three.show();
    }
}
