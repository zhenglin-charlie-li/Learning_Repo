package Demo02;

public class DemoMAIN {

    public static void main(String[] args) {

        myThread one = new myThread("panda");
        one.start();
        new myThread("asd").start();
        for (int i = 0; i < 20; i++) {
            System.out.println(i+" main is running");
        }

    }

}
