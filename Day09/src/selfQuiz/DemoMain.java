package selfQuiz;

import java.util.ArrayList;

public class DemoMain {

    public static void main(String[] args) {

        maneger s = new maneger("panda bear", 100);
        member one = new member("1", 0);
        member two = new member("2", 0);
        member three = new member("3", 0);

        s.show();
        one.show();
        two.show();
        three.show();

        ArrayList<Integer> list=s.send(77,3);
        one.get(list);
        two.get(list);
        three.get(list);


        s.show();
        one.show();
        two.show();
        three.show();
    }
}
