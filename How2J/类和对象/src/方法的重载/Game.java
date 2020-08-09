package 方法的重载;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        int isRight = 0;
        Scanner in = new Scanner(System.in);
        int random = new Random().nextInt(10)+1;
        System.out.println("这是一个猜数字的游戏，正确的答案为1--10。");
        while (isRight==0){
            int temp = in.nextInt();
            if(temp>random){
                System.out.println("猜大了");
            }else if(temp<random){
                System.out.println("猜小了");
            }else{
                System.out.println("猜对了");
                break;
            }
        }
    }
}
