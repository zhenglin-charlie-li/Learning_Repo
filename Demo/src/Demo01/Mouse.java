package Demo01;

public class Mouse implements USB {
	
	@Override
	public void open() {
		System.out.println("Mouse is on with red light");
	}
	
	@Override
	public void close() {
		System.out.println("Mouse is down");
	}
	
	public void click() {
		System.out.println("Click!!!");
	}

}
