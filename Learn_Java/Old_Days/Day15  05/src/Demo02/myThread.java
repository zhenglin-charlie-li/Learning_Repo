package Demo02;

public class myThread extends Thread {
    public myThread(String name){
        super(name);
    }

    @Override
    public void run(){
        for (int i = 0; i < 20; i++) {
            System.out.println(i+getName()+" is running   ");
        }
    }

}
