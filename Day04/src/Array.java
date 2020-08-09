import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("This application is to calculate");
        System.out.println("the min, max, sum, avg");
        System.out.println("please input the number of ints");
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int[] end=getresult(arr);

        System.out.println("min   "+end[0]);
        System.out.println("max   "+end[1]);
        System.out.println("sum   "+end[2]);
        System.out.println("avg   "+getavg(arr));

    }

    public static int[] getresult(int[] a) {
        int max = a[0];
        int min=a[0];
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
            sum += a[i];
            if(min>a[i]){
                min=a[i];
            }
        }
        int result[] = {min, max, sum};
        return result;
    }

    public static double getavg(int[] a){
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        double avg=(double)sum/a.length;
        System.out.println(a.length);
        return avg;
    }
}
