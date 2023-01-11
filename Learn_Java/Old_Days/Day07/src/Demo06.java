import java.util.ArrayList;
import java.util.Random;

public class Demo06 {
    public static void main(String[] args) {
        ArrayList<Integer> BigList =new ArrayList<>();
        Random random=new Random();
        for (int i = 0; i < 10; i++) {
            BigList.add(random.nextInt(100)+1);
        }
        ArrayList<Integer> Result=GetOutList(BigList);

        for (int i=0;i<BigList.size();i++){
            System.out.print(BigList.get(i)+"  ");
        }

        System.out.println();

        for (int i=0;i<Result.size();i++){
            System.out.print(Result.get(i)+"  ");
        }

    }

    public static ArrayList<Integer> GetOutList(ArrayList<Integer> InList){
        ArrayList<Integer> OutList=new ArrayList<>();
        for (int i=0;i<InList.size();i++){
            if (InList.get(i)%2==0){
                OutList.add(InList.get(i));
            }
        }
        return OutList;
    }

}
