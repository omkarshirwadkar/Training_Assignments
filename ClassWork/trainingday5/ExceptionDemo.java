// package ClassWork.trainingday5;
import java.io.*;

public class ExceptionDemo {
    public static void main(String[] args) {
        try{
            int a = 50;
            for (int i = 1; i <= 20; i++) {
                System.out.println(i);
                int res = a /(a - i);

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
                if (i == 8){
                    return;
                }

                // The finally block isn't executed after System teminaion
                if (i == 10){
                    System.exit(0);
                }

            }
        }
        catch (IOException e){
            System.out.println("IOException Handler.");
        }
        //Multiple Exception handling
        catch (ArrayIndexOutOfBoundsException | NullPointerException e){
            System.out.println("ArithmeticException or NullPointerException Handler.");
        }
        catch(Exception e){
            System.out.println("General Exception Handler.");
        }
        finally{
            System.out.println("This is finally block");
            System.out.println("Finally block can be used to release system resources.");
        }
        System.out.println(" Program ended");
    }
}
