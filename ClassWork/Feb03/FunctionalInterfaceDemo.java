// package ClassWork.Feb03;
@FunctionalInterface
interface I{
    public void m1();
    public boolean equals(Object obj);
    public int hashCode();

}
class A implements I{
    public void m1() {
        System.out.println("m1() method by class A");
    }
}

class B{
    public void demo(){
        System.out.println("demo() method by class B");
    }
}
public interface FunctionalInterfaceDemo {
    public static void main(String[] args) {
        I i = new A();
        i.m1();
        I i2 = new I()
                {
                    
                    public void m1() {
                        System.out.println("m1() method by interface I");
                    }
                };
        i2.m1();
        B b = new B(){
            public void demo(){
                System.out.println("demo() method by class which has main class");
            }
        };
        b.demo();

        // lambda expression
        I i3 = () -> {
            System.out.println("m1() method by lambda expression");
            System.out.println("There are 2 statements therefore brackets else not needed");
        };
        i3.m1();
    }
}
