package Demo01;

import org.w3c.dom.ls.LSOutput;

public class DemoMain {
    public static void main(String[] args) {

        Demo01 one = new Demo01(456.1);

        System.out.println(one.getE());
        one.show(123);
        one.show2(123);
    }
}
