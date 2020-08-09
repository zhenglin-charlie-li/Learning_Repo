package decorater1;

public class Demo {
    public static void main(String[] args) {
        Shape circleOfRed = new Green(new Red(new Circle()));
        circleOfRed.draw();
    }
}
