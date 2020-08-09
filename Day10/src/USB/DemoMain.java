package USB;

public class DemoMain {
    public static void main(String[] args) {

        LapTop computer = new LapTop();

        computer.powerOn();

        USB mouse = new Mouse();
        USB ketBoard = new KeyBoard();

        computer.useDevice(mouse);
        computer.useDevice(ketBoard);

        computer.powerOff();
    }
}
