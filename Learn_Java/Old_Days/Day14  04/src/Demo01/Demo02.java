package Demo01;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo02 {
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(9999,"panda bear   001");
        map.put(8888,"panda bear   002");
        map.put(7777,"panda bear   003");

        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();

        for (Map.Entry<Integer,String> entry : entrySet){
            System.out.println(entry.getValue()+"_____"+entry.getKey());
        }

    }
}
