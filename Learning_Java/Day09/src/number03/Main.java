package number03;

public class Main {
    static class Animal {
        public void eat() {
            System.out.println("animal : eat");
        }
    }
    static class Cat extends Animal {
        public void eat() {
            System.out.println("cat : eat");
        }
        public void eatTest() {
            this.eat(); // this 调用本类的方法
            super.eat(); // super 调用父类的方法
        }
    }

        public static void main(String[] args) {
            Animal a = new Animal();
            a.eat();
            Cat c = new Cat();
            c.eatTest();
        }

}
