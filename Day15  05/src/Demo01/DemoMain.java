package Demo01;

import java.util.Scanner;

public class DemoMain {

    public static String[] names = {"panda","white","brown"};

    public static void main(String[] args) {

        String yourName = new Scanner(System.in).nextLine();

        try {
            checkIfRepeat(yourName);
            System.out.println("Register Succeed!");
        }catch(RegisterException e) {
            e.printStackTrace();
        }

    }

    public static boolean checkIfRepeat(String name) throws RegisterException{

        for(String eachName:names) {
            if(name.equals(eachName)) {
                throw new RegisterException("asd");
            }
        }

        return true;
    }

}
