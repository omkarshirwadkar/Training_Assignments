// package Jan24;
import java.util.*;

public class MoreGenerics {
    // init block called when an object is created
    // All init blocks are clubbed together in a single init block just like static block 
    {
        System.out.println("Init block");
        // Do all the common logic here which is repeated in all the constructors
        // Following the DRY principle

        // System.exit(0); // --> This is allowed
        // return --> This is not allowed

    }

    // Constructor block is called after the init block
    MoreGenerics(){
        System.out.println("Constructor....");
    }
    MoreGenerics(int i){
        System.out.println("Parameterized Integer Constructor....");
    }
    MoreGenerics(String s){
        System.out.println("Parameterized String Constructor....");
    }
    
    static{
        System.out.println("Static block");
    }
    {
        System.out.println("Second block");
    }
    public static void main(String[] args) {
        // Invariant
        // List<String> string = new ArrayList<String>();
        // List<Object> object = string;
        
        // Covariant
        // List<? extends Number> number = new ArrayList<Integer>();
        // Number i = number.get(0);
        // number.add(1);

        // Contravariant
        // List<? super Integer> integer = new ArrayList<Number>();
        // integer.add(1);
        // Integer i = integer.get(0);



        System.out.println("Second...");
        MoreGenerics moreGenerics = new MoreGenerics();
        MoreGenerics moreGenerics2 = new MoreGenerics();
        MoreGenerics moreGenerics3 = new MoreGenerics(10);
        MoreGenerics moreGenerics4 = new MoreGenerics("Hello");
    }
    {
        System.out.println("Third block");
    }
}
