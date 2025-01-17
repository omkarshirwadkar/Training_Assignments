package ClassWork.Jan14.Program2;
// package ClassWork.trainingday6.Program2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;

class A implements AutoCloseable{
    A(){
        System.out.println("Allocating Resources to A class object.");
    }
    public void display(){
        System.out.println("Perrforming the required operations of A class.");
    }
    @Override
    public void close() {
        System.out.println("Releasing the resources of A class object.");
    }
}

class B implements AutoCloseable{
    B(){
        System.out.println("Allocating Resources to B class object.");
    }
    public void display(){
        System.out.println("Perrforming the required operations of B class.");
    }
    @Override
    public void close() {
        System.out.println("Releasing the resources of B class object.");
    }
}

public class TryWithResources {
    public static void main(String[] args) {
        // Only the classes that implement AutoCloseable interface can be used in try-with-resources statement
        
        try (A a = new A(); B b = new B()) {
            a.display();
            if (true) {
                throw new RuntimeException("Test");
            }
            b.display();
        }
        System.out.println("DADADA");
    }
}
