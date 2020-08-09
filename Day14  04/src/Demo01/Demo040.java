package Demo01;

import java.util.*;

public class Demo040 {
    public static void main(String[] args) {
        String string= new Scanner(System.in).nextLine();
        HashMap<Character,Integer> map = new HashMap<>();

        for (int i=0;i<string.length();i++){
            char temp = string.charAt(i);
            if (!map.containsKey(temp)){
                map.put(temp,1);
            }else{
                Integer temp1 = map.get(temp);
                temp1++;
                map.put(temp,temp1);
            }
        }

        System.out.println(map);

        Set<Map.Entry<Character,Integer>> set=map.entrySet();
        for (Map.Entry each : set) {
            Character character = (Character) each.getKey();
            System.out.println(each.getKey()+"_____"+each.getValue());
        }
    }

    public static void count(String string){


    }
}
