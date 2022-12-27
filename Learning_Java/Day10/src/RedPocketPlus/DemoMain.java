package RedPocketPlus;

import java.util.ArrayList;
import java.util.Scanner;

public class DemoMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("有多少人呢？");
        int n = in.nextInt();
        if (n == 1) {
            System.out.println("一个人没发玩这个游戏哦");
        } else {
            user[] users = new user[n];
            //获取每个成员的信息
            for (int i = 0; i < n; i++) {
                System.out.println("请输入第" + (i + 1) + "个人的姓名和余额，以空格为分界");
                users[i] = new user(in.next(), in.nextInt());
            }

            //遍历打印
            for (int i = 0; i < n; i++) {
                System.out.print("编号为" + (i + 1) + "的 ");
                users[i].show();
                if (i == n - 1) {
                    System.out.println();
                    System.out.println("录入全部完成");
                    System.out.println();
                }
                System.out.println();
            }

            System.out.println("谁来发红包呢？请输入编号。");
            System.out.println("红包金额是多少呢？请输入金额。");
            //System.out.println("发几个红包呢？请输入可获得红包的人数。");
            int peopleSend = in.nextInt();
            int moneySend = in.nextInt();
            //int peopleGet = in.nextInt();

            SendAndGet(peopleSend, moneySend, n, users);
            showWhoHasHowMuch(users);

        }
    }

    public static void SendAndGet(int p,int m,int n,user[] users){
        ArrayList<Integer> redList = users[p - 1].sendPocket( m,n - 1);
        for (int j = 0; j < n; j++) {
            if (j != p - 1) {
                users[j].getPocket(redList);
            }
        }

    }

    public static void showWhoHasHowMuch(user[] users){
        for (int i = 0; i < users.length; i++) {
            System.out.print("编号为" + (i + 1) + "的 ");
            users[i].show();
            System.out.println();
        }
    }

}
