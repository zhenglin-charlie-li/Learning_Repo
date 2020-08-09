package RedPocket;

import java.util.ArrayList;

public class DemoMain {
    public static void main(String[] args) {
        manger master=new manger("panda bear",9999);
        member one =new member("1",10);
        member two =new member("2",20);
        member three =new member("3",30);

        master.show();
        one.show();
        two.show();
        three.show();

        ArrayList<Integer> redList = master.sendPocket(100,3);
        one.getPocket(redList);
        two.getPocket(redList);
        three.getPocket(redList);

        master.show();
        one.show();
        two.show();
        three.show();
    }
}
