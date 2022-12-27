package Demo06;

public class DemoMain02 {
    public static void main(String[] args) {
        System.out.println(new myInterface() {
            @Override
            public void show() {
                System.out.println("匿名内部类");
            }

            @Override
            public int get() {
                return 666;
            }
        }.get());

    }
}
