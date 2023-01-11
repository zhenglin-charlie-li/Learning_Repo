package 随机数;

import java.util.Random;

public class April07 {

    public static void main(String[] args) {
        int[] arr = new int[3];
        int num=4;
        randomArr(arr,num);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }




    public static int[] randomArr(int[] arr,int num) {
        Random rd = new Random();
        for (int i = 0; i < arr.length; i++){
            arr[i]=-1;
        }
            for (int i = 0; i < arr.length; i++) {
            int count = 0;
//            arr[i]=rd.nextInt(10)+1;//常规来说是这样.但是我想输出不重复的随机数
            int temp = rd.nextInt(num);//先将随机数赋值给一个中间变量
            //然后再遍历一遍数组,如果有相同的,就不算,并且i--重新随机.
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == temp) {
                    count=1;//在外循环定义一个计数器,在内循环内判断是否重复.否则循环结束
                    break;  //内循环中的变量不能用于外循环
                }
            }if (count==1){//内循环结束,在外循环判断是否计数器>0,如果是,就i--,重新随机.
                //否则赋值给数组
                i--;
            }else{
                arr[i] = temp;
            }
        }
        return arr;
    }

}
