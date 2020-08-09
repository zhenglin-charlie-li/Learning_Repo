package 哈哈哈;

public class April16 {

    public static void main(String[] args) {
        int[][] a = {{1,3},{2,6},{8,10},{15,18}};
        int[][] b =merge(a);
        for (int i=0;i<b.length;i++){
            for (int j=0;j<b[i].length;j++){
                System.out.print(b[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] merge(int[][] intervals){
        int length = intervals.length;
        int[][] result = new int[length][2];
        int count=0;
        for (int i=0;i<length;i++){
            int min = intervals[i][0];
            int max = intervals[i][1];
            for (int j=i+1;j<length;j++){
                if (intervals[j][0]<min){
                    intervals[j][0] = min;
                }
                if (intervals[j][1]>max){
                    intervals[j][0] = max;
                }
                if (min != intervals[i][0] || max != intervals[i][1]){
                    int[] temp = {min,max};
                    result[j] = temp;
                    count++;
                }
            }

        }
        return result;
    }
}


