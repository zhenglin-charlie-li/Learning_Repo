package IN;

public class test {
    public static void main(String[] args) {
        Outer.Inner obj = new Outer().new Inner();
        obj.method();
    }
}
