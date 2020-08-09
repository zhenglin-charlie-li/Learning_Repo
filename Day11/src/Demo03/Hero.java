package Demo03;

public class Hero {
    private String name;
    private int price;

    public Hero(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void releaseSkill() {
        System.out.println(name + " spend " + price + " and :");
        //SkillImp imp = new SkillImp();
        new Skill() {
            @Override
            public void skill() {
                System.out.println("start to release skill.");
                System.out.println("pa pa pa.");
                System.out.println("skill released.");
            }
        }.skill();
        //imp.skill();
    }

}
