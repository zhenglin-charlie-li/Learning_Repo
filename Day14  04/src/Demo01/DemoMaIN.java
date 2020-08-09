package Demo01;

import java.util.HashMap;

public class DemoMaIN {
    public static void main(String[] args) {
        HashMap<String, Integer> relationship = new  HashMap<>();

        relationship.put("panda bear",9999);
        relationship.put("white bear",8888);
        relationship.put("sdf",123);
        System.out.println(relationship);

        System.out.println(relationship.remove("brown bear"));
        System.out.println(relationship);

        System.out.println(relationship.get("panda bear"));
        System.out.println(relationship.get("white bear"));

    }
}
