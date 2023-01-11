package Demo01;

public class Test {
	
	public static void main(String[] args) {
		
		LapTop computer = new LapTop();
		
		computer.poweron();
		
		Mouse mouse = new Mouse();
		KeyBoard kb = new KeyBoard();
		
		computer.useDevice(mouse);
		computer.useDevice(kb);
		
		computer.poweroff();
		
	}
}
