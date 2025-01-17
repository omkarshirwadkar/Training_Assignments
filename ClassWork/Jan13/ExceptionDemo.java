package ClassWork.Jan13;
// package ClassWork.trainingday5;
import java.io.*;
import java.sql.SQLException;

public class ExceptionDemo {
    public static void main(String[] args) throws IOException, SQLException, UserException {
        try{
            System.out.println(" Program ended");
            A a = new A();
            a.methodA();
        }
        catch (IOException e){
            System.out.println("IOException Handler.");
        }
        //Multiple Exception handling
        catch (ArrayIndexOutOfBoundsException | NullPointerException e){
            System.out.println("ArithmeticException or NullPointerException Handler.");
        }
        catch (UserException e){
            System.out.println("UserException Handler.");
            System.out.println("Reason: " + e.getMessage());
            e.display();
            e.printStackTrace();
            System.out.println();
        }
        catch(Exception e){
            System.out.println("General Exception Handler.");
        }
        finally{
            System.out.println("This is finally block");
            System.out.println("Finally block can be used to release system resources.");
        }
    }
}

class A{
    public void methodA() throws IOException, SQLException, UserException{
        methodAA();
    }

    public void methodAA() throws IOException, SQLException, UserException{
        methodAB();
    }
    public void methodAB() throws IOException, SQLException, UserException{
        try{
            // int a = 50;
            for (int i = 0; i <= 10; i++){

                System.out.println(i);
                // int res = a /(a - i);

                // The code will be complied but will throw ArithmeticException at runtime
                if (i == 15){
                    throw new ArithmeticException("Arithmetic Exception");
                }

                // The code will not be compiled because IOException is not a checked exception
                if (i == 120){
                    throw new IOException();
                }

                // Compiled successfully but throws NullPointerException at runtime
                if (i == 100){
                    throw new NullPointerException();
                }

                if (i == 18){
                    throw new ArithmeticException();
                }

                // Finally block still runs even after returning from the method
                if (i == 80){
                    return;
                }

                // The finally block isn't executed after System teminaion
                if (i == 100){
                    System.out.println("Terminated :(");
                    System.out.println("No Execution of finally block.");
                    System.exit(0);
                }
                if (i == 5){
                    throw new UserException("i == 5");
                }
        }
        }
        finally{
            System.out.println("This is finally block");
            System.out.println("Finally block can be used to release system resources.");
            }
    }
}

class UserException extends Exception {
    public UserException(){
        super();
    }
    public UserException(String msg) {
        super(msg);
    }
    public void display(){
        System.out.println("UserException display method.");
    }
}
