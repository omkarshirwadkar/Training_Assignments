// package ClassWork.trainingday8.Program1;

class InstanceAlreadyExist extends Exception {
    public InstanceAlreadyExist(){
        super();
    }
    public InstanceAlreadyExist(String message) {
        super(message);
    }
}

// Singleton class B inherits Singleton class A
class A {
    private static A a1 = null;

    // Goated Constructor 
    A(){
        if (this instanceof B){
            System.out.println("B instance created");
        }
        else if (this instanceof A && a1 == null){
            a1 = this;
            System.out.println("A instance created");
        }
        else{
            System.out.println("Instance already exist");
        }
    }
    public static A getInstance() {
        if (a1 == null) {
            a1 = new A();
        }
        return a1;
    }
}
class B extends A {
    private static final B b1 = new B();
    private B() {
    }
    public static B getInstance() {
        return b1;
    }
}

public class SingletonInheritence {
    public static void main(String[] args) {
        A a3 = new A();
        System.out.println(a3);
        A a1 = A.getInstance();
        A a2 = A.getInstance();
        B b1 = B.getInstance();
        B b2 = B.getInstance();
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(b1);
        System.out.println(b2);
    }
}
