package microstrategy;

public class GoldenRetriever  extends Dog
{
    public void makenoise()
    {
        super.makenoise();
        System.out.println("Make Golden Retriever Noise");
    }
    public static void main(String ... arg)
    {
        Dog dog=new GoldenRetriever();
        dog.makenoise();
    }
}

