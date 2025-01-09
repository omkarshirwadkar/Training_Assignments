package Morning;


// interface A{
//     // interfaces variables are final by default therefore we have to initialize it can't be left blank
//     //int a;
//     // can't do this either
//     // a = 10;

//     // we can do this
//     int a = 20;
//     void methodA();
// }

// interface B{
//     void methodB();
// }

// interface C extends A, B{
//     void methodC();
// }


// // Client Side code could be interface to avoid the client over writing the methods on the client side
// interface ClientSide{
//     void methodClient();
// }


// // Server Side code to implement the interfaces
// class ServerMethod implements ClientSide{
//     public void methodClient() {
//         System.out.println("Server methodClient");
//     }
// }

// Interfaces are used in JDBC
// Makes us Vendor Independent
// We can switch from one vendor to another without changing the code
// Specifications are done in the interface

//-----------------------------Interfaces are the GOAT------------------------------------

interface X{
    int a = 50;
    void add();
    void sub();
}

interface Y{
    int b = 10;
    void mul();
    void div();
}

interface Z extends X, Y{

}

class Calculator implements Z{
    public void add() {
        System.out.println("Addition: " + (X.a + Y.b));
    }
    public void sub() {
        System.out.println("Subtraction: " + (X.a - Y.b));
    }
    public void mul() {
        System.out.println("Multiplication: " + (X.a * Y.b));
    }
    public void div() {
        System.out.println("Division: " + (X.a / Y.b));
    }
}

// class D implements C{
//     public void methodA(){
//         System.out.println("Method A");
//     }
//     public void methodB(){
//         System.out.println("Method B");
//     }
//     public void methodC(){
//         System.out.println("Method C");
//     }
// }
public class LearnInterface {
    // Creating a client 
    public static void main(String[] args) {
        // ClientSide client = new ServerMethod();
        // client.methodClient();

        // instead of creating new objects for each X, Y, and Z
        // We can Create a single object of Calculator and use it 
        Calculator calculator = new Calculator();

        //don't do this
        // X x = new Calculator();

        X x = calculator;
        x.add();
        x.sub();
        // Cannot called mul() and div() because they are not in X interface
        // x.mul();
        // x.div();

        //don't do this
        // Y y = new Calculator();

        Y y = calculator;
        y.mul();
        y.div();
        // Cannot called add() and sub() because they are not in Y interface
        // y.add();
        // y.sub();

        // Avoid creating multiple objects for each interface
        // Z z = new Calculator();

        Z z = calculator;
        z.add();
        z.sub();
        z.mul();
        z.div();
    }
}
