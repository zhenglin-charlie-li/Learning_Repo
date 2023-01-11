package Demo04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DemoMain {
    public static void main(String[] args) {
        ArrayList<String> pokerBox = new ArrayList<>();
        ArrayList<String> colors = new ArrayList<>();
        ArrayList<String> number = new ArrayList<>();

        colors.add("♥");
        colors.add("♠");
        colors.add("♣");
        colors.add("♦");

        for (int i=1;i<=10;i++){
            number.add(i+"");
        }
        number.add("J");
        number.add("Q");
        number.add("K");

        for (int i=0;i<13;i++){
            for (int j=0;j<4;j++){
                pokerBox.add(number.get(i)+colors.get(j));
            }
        }
        pokerBox.add("Big KING");
        pokerBox.add("Small KING");

        System.out.println(pokerBox);

        Collections.shuffle(pokerBox);

        System.out.println(pokerBox);

        ArrayList<String> player1 =new ArrayList<>();
        ArrayList<String> player2 =new ArrayList<>();
        ArrayList<String> player3 =new ArrayList<>();
        ArrayList<String> diPai =new ArrayList<>();

        System.out.println(pokerBox.size());

        for (int i=0;i<54;i++){
            if (i>=51){
                diPai.add(pokerBox.get(i));
            }else{
                if (i%3==0){
                    player1.add(pokerBox.get(i));
                }else if(i%3==1){
                    player2.add(pokerBox.get(i));
                }else {
                    player3.add(pokerBox.get(i));
                }
            }
        }
    }
}
