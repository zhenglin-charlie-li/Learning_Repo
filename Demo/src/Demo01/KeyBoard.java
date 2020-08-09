package Demo01;

public class KeyBoard implements USB {
	
	@Override
	public void open() {
		System.out.println("KeyBoard is on with green light");
	}
	
	@Override
	public void close() {
		System.out.println("KeyBoard is down");
	}
	
	public void type() {
		System.out.println("Type!!!");
	}

}
