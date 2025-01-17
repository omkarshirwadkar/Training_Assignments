package ClassWork.Jan10.Afternoon;

class A{
    // abstract method
    // there can be even 0 number of abstract methods in an abstract class
    // public void abc(){}
    // };

    // static 
    static int x;
    static{
        x = 10;
        System.out.println("Here From Static Block");
    }

}
abstract class FinalMethodInAbstractClass{
    // final method without a body in a abstract class won't work
    // This method requires a body instead of a semicolon
    // final void display();

    // final method with a body in a abstract class
    final void display(){
        System.out.println("Final method in abstract class");
    }
}

final class finalClass{
    // final class cannot be extended
    // no other class can inherit finalClass
}
abstract class C extends A{
    public void abc() {
        System.out.println("C");    
    }
    final void xyz(){};
}
class B extends C{
    public void abc() {
        System.out.println("Hello");
    }
}
public class NonAccessModifiersDemo {
    static class CanAClassBeStatic{
        public static void main(String[] args) {

            A a1 = new B();
            A a2 = new B();

            // when calling a static method, we don't need to create an object
            // Here x variable is accessed not by a1 or a2 but by class A
            // We don't get any error but this is not a good practice
            a1.x = 50;
            a2.x = 60;
            System.out.println(A.x);
        }
    }
}
