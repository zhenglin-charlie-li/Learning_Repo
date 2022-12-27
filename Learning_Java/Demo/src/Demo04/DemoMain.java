package Demo04;

public class DemoMain {

	public static void main(String[] args) {
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println(123);
			}
		}).start();
		
	}

}
