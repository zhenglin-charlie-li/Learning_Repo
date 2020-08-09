package Demo02;

public class test {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner in = outer.new Inner();
        in.show();
        outer.showInner();
    }
}
