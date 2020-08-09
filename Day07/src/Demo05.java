import java.util.ArrayList;

public class Demo05 {
    public static void main(String[] args) {
        ArrayList<panda> list=new ArrayList();
        panda one = new panda("a",10);
        panda two = new panda("bb",20);
        panda three = new panda("ccc",30);

        list.add(one);
        list.add(two);
        list.add(three);

        print(list);
    }

    public static void print(ArrayList<panda> in){
        for (int i = 0; i < 3; i++) {
            panda temp=in.get(i);
            System.out.println(temp.getName()+"-----"+temp.getAge());
        }
    }
}
