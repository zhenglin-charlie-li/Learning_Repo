package Demo01;

import java.util.Objects;

public class Demo01<E> {
    private E e;
    
    public <E> void show(E asd){
        System.out.println(asd.getClass());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Demo01<?> demo01 = (Demo01<?>) o;
        return Objects.equals(e, demo01.e);
    }

    @Override
    public int hashCode() {
        return Objects.hash(e);
    }

    public <M> M show2(M mnb){
        return  mnb;
    }
    

    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }

    public Demo01(E e) {
        this.e = e;
    }

    public Demo01() {
    }

    public void show() {
    }
}
