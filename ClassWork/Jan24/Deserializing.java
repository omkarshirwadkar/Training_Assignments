// package ClassWork.Jan24;
import java.io.*;
public class Deserializing {
    public static void main(String[] args) {
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"));
            Person p = (Person) ois.readObject();
            System.out.println("Name: " + p.getName());
            System.out.println("Age: " + p.getAge());
            ois.close();
        }
        catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
}
