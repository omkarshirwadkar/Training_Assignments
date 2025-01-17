package Jan15;
// package Day7;

// final class Principal{

//     private static final Principal p1 = new Principal();
//     private Principal(){
//         System.out.println("Object created");
//     }
//     public static Principal getPrincipal(){
//         return p1;
//     }
// }
// final class Principal{
//     private static Principal p1 = null;
//     private Principal(){
//         System.out.println("Inside constructor");
//     }
//     public static Principal getPrincipal(){
//         if(p1 == null){
//             p1 = new Principal();
//         }
//         return p1;
//     }
// }
sealed class A permits B{
    private static A a = null;
    private static Boolean flag = false;
    // private A() {
    //     if (a == null){
    //         flag = true;
    //     }
    //     else{
    //         throw new RuntimeException("1. Object already created");
    //     }
    // }
    public static A getA() {
        if ((a == null) && (!flag)) {
            a = new A();
            return a;
        }
        else{
            throw new RuntimeException("2. Object already created");
        }
    }
}

non-sealed class B extends A {
    private static B b = null;
    private B() {
        System.out.println("B Object is Created");
    }
    public static B getB() {
        if (b == null) {
            b = new B();
            return b;
        }
        else{
            throw new RuntimeException("Object already created");
        }
    }
}
public class SingletonAssignment {
    public static void main(String[] args) {
        A a1 = A.getA();
        B b1 = B.getB();
        // A a2 = B.getA();
        // B b2 = B.getB();
        System.out.println(a1);
        System.out.println(b1);
        // System.out.println(a2);
        // System.out.println(b2);
    }
}
