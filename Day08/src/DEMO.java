public class DEMO {
    public static void main(String[] args) {
        int counter=0;
        int min = (int)(-10.8);
        int max = (int) Math.floor(5.9);
        for (int i = min ; i<=max; i++){
            if (Math.abs(i)>6 || Math.abs(i)<2.1){
                counter++;
            }
        }
        System.out.println(counter);
    }
}
