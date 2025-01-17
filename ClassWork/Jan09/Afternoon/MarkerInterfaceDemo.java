package ClassWork.Jan09.Afternoon;
// package Afternoon;


/// To Create a duplicate object we have to add Implements Cloneable interface in our class and override clone() method.
class Student implements Cloneable {
    String name;
    int standard;
    Student(String name, int standard){
        this.name = name;
        this.standard = standard;
    }
    public Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }
    public void display(){
        System.out.println("Name: "+ name);
        System.out.println("Standard: "+ standard);
        System.out.println();
    }
}

interface I{

}

class A implements I{
    public void m1(){
        if (this instanceof I){
            System.out.println("I");
        }
        else{
            System.out.println("A");
        }
    }
}

public class MarkerInterfaceDemo  {
    public static void main(String[] args) throws CloneNotSupportedException{
        Student s1 = new Student("Rahul", 5);
        s1.display();
        Student s2 = s1;
        s1.name = "Manoj";
        s2.display();
        Student s3 = s1.clone();
        s1.name = "Rahul";
        s3.display();
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());

        A a1 = new A();
        a1.m1();
    }
}