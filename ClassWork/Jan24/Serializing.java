// package ClassWork.Jan24;
import java.io.*;
class Person implements Serializable{
    String name;
    transient private int age; // static also not serialized
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
}
public class Serializing {
    public static void main(String[] args) {
        try{
            Person p1 = new Person("John", 25);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"));
            oos.writeObject(p1);
            oos.close();
            System.out.println("Successfully serialized the object");
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
