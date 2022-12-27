public class Demo01 {
    public static void main(String[] args) {
        pandabear panda01 = new pandabear();
        System.out.println(panda01.getName());
        System.out.println(panda01.getAge());

        panda01.setName("dadada");
        panda01.setAge(9999);

        System.out.println(panda01.getName());
        System.out.println(panda01.getAge());
    }
}
