interface I{
    // Interfaces can have default methods with body and static methods with body.
    public void abc();
    public static void def(){
        System.out.println("Hello, World! from static method");
    }
    public default void ghi(){
        System.out.println("Hello, World! from default method");
    }
    private void jkl(){}
}

interface X {
    public default void hello(){
        System.out.println("From interface X hello method");
    }
}

interface Y {
    public default void hello(){
        System.out.println("From interface Y hello method");
    }
}
class B implements X, Y {
    public void hello(){
        // call default method from interface X
        X.super.hello();
        Y.super.hello();
    }
}
class A implements I{
    public void abc(){
        System.out.println("Hello, World! from abc()");
    }
}

public interface LatestInterface{
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        I.def();
        A a1 = new A();
        a1.abc();
        a1.ghi();

        B b1 = new B();
        b1.hello();

    }
}