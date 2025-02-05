// package ClassWork.Feb05;
import java.util.Optional;
public class OptionalDemo {
    public static void add(Integer i1, Integer i2) {
        System.out.println( i1 + i2 );
    }

    public static void add(Optional <Integer> i1, Optional<Integer> i2) {
        Integer a1 = i1.orElse(0);
        Integer a2 = i2.orElse(0);
        System.out.println(a1 + a2);
    }
    public static void main(String[] args) {
        Integer i1 = 10;
        Integer i2 = null;

        Optional<Integer> o1 = Optional.ofNullable(i1);
        Optional<Integer> o2 = Optional.ofNullable(i2);
        add(o1, o2); // prints 30
    }  
}
