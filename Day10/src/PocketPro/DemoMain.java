package PocketPro;

import RedPocketPlus.user;

import java.util.ArrayList;
import java.util.Random;
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
            System.out.println("发几个红包呢？请输入可获得红包的人数。");

            int peopleSend = in.nextInt();
            int moneySend = in.nextInt();
            int peopleGetNumber = in.nextInt();

//            System.out.println("好的，最后一个问题，发红包的人能强红包吗？1代表能，0代表不能。请输入1或0。");
//            int choice = in.nextInt();

            ArrayList<Integer> peopleList = getRandom(n, peopleGetNumber);

            SendAndGet(peopleSend, moneySend, n, users, peopleList);

            System.out.println();

            showWhoHasHowMuch(users);

        }
    }

    public static void SendAndGet(int p, int m, int n, user[] users, ArrayList<Integer> peopleWhoGet) {
        ArrayList<Integer> redList = users[p - 1].sendPocket(m, peopleWhoGet.size());
        System.out.print("编号为"+p+"的"+users[p-1].getName()+"发了"+m+"元钱。");
        for (int j = 0; j < peopleWhoGet.size(); j++) {

            System.out.println("编号为"+(j+1)+"的"+users[j].getName()+"得到了红包。");
            users[j].getPocket(redList);
        }
    }


    public static void showWhoHasHowMuch(user[] users) {
        for (int i = 0; i < users.length; i++) {
            System.out.print("编号为" + (i + 1) + "的 ");
            users[i].show();
            System.out.println();
        }
    }

    public static ArrayList<Integer> getRandom(int bound, int number) {


        if (bound < number) {
            System.out.println("ERROR");
            return null;
        } else {
            Random r = new Random();
            ArrayList<Integer> list = new ArrayList<>();
            list.add(r.nextInt(bound));
            for (int i = 0; i < number - 1; i++) {
                int temp = r.nextInt(bound);
                int count = 1;
                for (int j = 0; j < list.size(); j++) {

                    if (list.get(j) == temp) {
                        count = 0;
                    }
                }
                if (count == 0) {
                    i--;
                } else {
                    list.add(temp);
                }
            }
            return list;
        }
    }
}



