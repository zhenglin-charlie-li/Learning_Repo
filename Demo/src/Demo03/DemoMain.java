package Demo03;

public class DemoMain {

	public static void main(String[] args) {
		
		myRunnable mr = new myRunnable();
		Thread t =new Thread(mr);
		t.start();
		
		for(int i=1;i<=20;i++) {
			System.out.println(i+"main is running.");
		}
		
		
	}
	
}
