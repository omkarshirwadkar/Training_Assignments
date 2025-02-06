import java.util.*;
import java.util.function.*;

class A implements Consumer<String> {

    @Override
    public void accept(String str) {
        System.out.println("This is string " + str);

    }

}

class B {
    public static void writeToFile(String str) {
        System.out.println("Writing to a file " + str);
    }
}

public class ForEachDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Shoyab", "Sanjana", "Kaif", "Qais");
        list.forEach(new A()); // with consumer implementation
        list.forEach((String str) -> System.out.println("This is from lamba expression " + str)); // using lambda expression
                                                                                                  
        list.forEach(B::writeToFile); // using method reference

        list.forEach(System.out::println); // this is also method reference where we are directly refering to println method
    }
}