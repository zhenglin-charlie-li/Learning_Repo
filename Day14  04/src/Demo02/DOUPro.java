package Demo02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class DOUPro {
    public static void main(String[] args) {
        HashMap<Integer,String> pokerMap=new HashMap<>();
        ArrayList<String> colors=new ArrayList<>();
        ArrayList<String> numbers=new ArrayList<>();

        Collections.addAll(colors,"♥","♣","♦","♠");
        Collections.addAll(numbers,"2","A","K","Q","J","10","9","8","7","6","5","4","3");

        int count=1;
        pokerMap.put(count++,"Big");
        pokerMap.put(count++,"Small");
        for (String color:colors){
            for (String number:numbers){
                pokerMap.put(count++,color+number);
            }
        }

        Set<Integer> numberSet=pokerMap.keySet();

        ArrayList<Integer> numberList=new ArrayList<>();
        numberList.addAll(numberSet);

        Collections.shuffle(numberList);

        ArrayList<Integer> noP1=new ArrayList<>();
        ArrayList<Integer> noP2=new ArrayList<>();
        ArrayList<Integer> noP3=new ArrayList<>();
        ArrayList<Integer> noDiPai=new ArrayList<>();

        for (int i=0;i<numberList.size();i++){
            Integer no = numberList.get(i);
            if (i>=51){
                noDiPai.add(no);
            }else{
                if (i%3==0){
                    noP1.add(no);
                }
                if (i%3==1){
                    noP2.add(no);
                }
                if (i%3==2){
                    noP3.add(no);
                }
            }
        }

        Collections.sort(noP1);
        Collections.sort(noP2);
        Collections.sort(noP3);
        Collections.sort(noDiPai);

        ArrayList<String> player1=new ArrayList<>();
        ArrayList<String> player2=new ArrayList<>();
        ArrayList<String> player3=new ArrayList<>();
        ArrayList<String> dipai=new ArrayList<>();

        for (Integer i :noP1){
            player1.add(pokerMap.get(i));
        }
        for (Integer i :noP2){
            player2.add(pokerMap.get(i));
        }
        for (Integer i :noP3){
            player3.add(pokerMap.get(i));
        }
        for (Integer i :noDiPai){
            dipai.add(pokerMap.get(i));
        }

        System.out.println(player1);
        System.out.println(player2);
        System.out.println(player3);
        System.out.println(dipai);

    }
}
