package Demo01;

import com.sun.source.doctree.StartElementTree;

import java.util.*;

public class Demo03 {
    public static void main(String[] args){
        HashMap<Integer,String> map = new HashMap<>();
        map.put(9999,"panda bear   001");
        map.put(8888,"panda bear   002");
        map.put(7777,"panda bear   003");

        Set<Map.Entry<Integer,String>> set = map.entrySet();

        for (Map.Entry<Integer,String> each : set){
            System.out.println("number"+each.getKey());
        }

    }
}
