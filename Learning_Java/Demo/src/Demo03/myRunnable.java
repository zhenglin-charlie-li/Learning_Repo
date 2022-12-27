package Demo03;

public class myRunnable implements Runnable {
	
	@Override
	public void run() {
		for(int i=1;i<=20;i++) {
			System.out.println(i+"myRunnable is running.");
		}
	}

}
