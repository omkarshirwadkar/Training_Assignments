abstract class AbstractWithNoAbstractMethod{
    public AbstractWithNoAbstractMethod(){
        System.out.println("AbstractWithNoAbstractMethod constructor");
    }
    public void method1(){
        System.out.println("Method 1");
    }
}

class ConcreteClass extends AbstractWithNoAbstractMethod{
    public void method2(){
        System.out.println("Method 2");
    }
}

interface AbstractInterface{
    // No Constructors allowed in interfaces
    // public AbstractInterface(){  
    //     System.out.println("AbstractInterface constructor");
    // }
    void method3();
    static void method4(){
        System.out.println("Method 4");
    };      
}

class ConcreteClass2 implements AbstractInterface{
    public void method3(){
        System.out.println("Method 3");
    }
}

public class AbstractClassInterface{
    public static void main(String[] args) {
        AbstractWithNoAbstractMethod obj = new ConcreteClass();
        obj.method1();

        ConcreteClass concreteObj = new ConcreteClass();
        concreteObj.method1();
        concreteObj.method2();

        AbstractInterface abstractInterface = new ConcreteClass2();
        abstractInterface.method3();

        AbstractInterface.method4();
        new AbstractClassInterface();

    }
}