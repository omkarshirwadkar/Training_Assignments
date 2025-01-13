package emp.assignment;
import java.util.Scanner;

public abstract class Emp{
    int id;
    String name;
    int age;
    public float salary;
    String designation;

    static public int countEmp = 0;
    static public int trackId = -1;

    Emp(float salary, String designation) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee ID");
        id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your name");
        name = sc.nextLine();
        System.out.println("Enter your age");
        age = sc.nextInt();
        this.salary = salary;
        this.designation = designation;
        trackId = id;

    }

    final public void display() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Salary: "+salary);
        System.out.println("Designation: "+designation);
        System.out.println();
    }
    public abstract void raiseSalary();
}
