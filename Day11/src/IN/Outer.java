package IN;

public class Outer {
    int num = 30;

    class Inner{
        int num = 20;

        public void method(){
            int num = 10;
            System.out.println(num);
            System.out.println(this.num);
            System.out.println(Outer.this.num);
        }

    }


}
