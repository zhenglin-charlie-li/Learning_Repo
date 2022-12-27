package decorater;

public abstract class Pizza {

    protected String desc;

    public String getDesc() {
        return desc;
    }


    public abstract double cost();
}