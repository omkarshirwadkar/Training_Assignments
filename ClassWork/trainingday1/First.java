// package Training_Assignments.ClassWork.trainingday1;
import java.util.ArrayList;

// only 3 types(constants) were specified therefore enums
enum EmployeeType{
    // UPPERCASE ONLY
    CLERK,
    PROGRAMMER,
    MANAGER
}

class Employee{
    // id int, name string, age integer, salary float, designation string
    int id;
    String name;
    int age;
    float salary;
    EmployeeType designation;

    // Arraylist to store employees
    static ArrayList<Employee> employees = new ArrayList<>();
    //Constructor
    Employee(int id, String name, int age, float salary, EmployeeType designation){
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.designation = designation;
    }

    // display() --> display all details
    void display(){
        System.out.println("ID: "+id);
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Salary: "+salary);
        System.out.println("Designation: "+designation);
    }

    // raisesalary(id int, amount float)
    void raiseSalary(int id, float amount){
        for (Employee e : employees) {
            if (e.id == id) {
                e.salary += amount;
            }
        }
    }
}

class First{
    public static void main(String [] args){
        System.out.println("FASAa");
        Employee emp = new Employee(1, "Omkar", 21, 1000000, EmployeeType.PROGRAMMER);
        emp.display();
        emp.raiseSalary(1, 50000);
        emp.display();
    }
}

