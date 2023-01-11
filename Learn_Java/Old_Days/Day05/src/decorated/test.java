package decorated;

public class test {
    public static void main(String[] args) {
        new Red(new Circle()).draw();
        System.out.println("=============");
        new Green(new Red(new Circle())).draw();
        System.out.println("=============");
        new Circle().draw();
    }
}
