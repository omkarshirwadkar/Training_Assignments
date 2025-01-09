package Morning;
// package ClassWork.trainingday3;

import java.util.Scanner;

abstract class Emp{
    String name;
    int age;
    float salary;
    String designation;

    static int countEmp = 0;
    // not a property of employee so don't declare in the employee class
    // static List<Employee> employee = new ArrayList<>();
    Emp(float salary, String designation) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name");
        name = sc.nextLine();
        System.out.println("Enter your age");
        age = sc.nextInt();
        this.salary = salary;
        this.designation = designation;
        countEmp += 1;
        sc.close();
    }

    public void display() {
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Salary: "+salary);
        System.out.println("Designation: "+designation);
        System.out.println();
    }

    public abstract void raiseSalary();
}

class Clerk extends Emp{
    Clerk(){
        // One method without calling super constructor 
        // salary = 20000;
        // designation = "Clerk";

        // another method
        super(20000, "Clerk");
    }
    public void raiseSalary(){
        salary += 2000;
    }
}

class Programmer extends Emp{
    Programmer(){
        // One method without calling super constructor 
        // salary = 30000;
        // designation = "Programmer";

        // another method
        super(30000, "Programmer");
    }
    public void raiseSalary(){
        salary += 5000;
    }
}

class Manager extends Emp{
    Manager(){
        // One method without calling super constructor 
        // salary = 100000;
        // designation = "Manager";

        // another method
        super(100000, "Manager");
    }
    public void raiseSalary(){
        salary += 15000;
    }
}

public class EmpManageApp {
    public static void main(String[] args) {
        int ch1 = 0, ch2 = 0;
        Emp emp[] = new Emp[100];
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("-------------------------------------");
            System.out.println("1. Create Employee");
            System.out.println("2. Display");
            System.out.println("3. Raise Salary");
            System.out.println("4. Exit");
            System.out.println("-------------------------------------");
            System.out.print("Enter your choice: ");
            ch1 = sc.nextInt();
            switch(ch1){
                case 1:
                do{
                    System.out.println("---------------------------------------------");
                    System.out.println("1. Create Clerk");
                    System.out.println("2. Create Programmer");
                    System.out.println("3. Create Manager");
                    System.out.println("4. Back");
                    System.out.println("--------------------------------------------");
                    System.out.print("Enter your choice: ");
                    ch2 = sc.nextInt();
                    switch(ch2){
                        case 1:
                        emp[Emp.countEmp] = new Clerk();
                        break;
                        case 2:
                        emp[Emp.countEmp] = new Programmer();
                        break;
                        case 3:
                        emp[Emp.countEmp] = new Manager();
                        break;
                    }
                }while(ch2 != 4);

                case 2:
                if (Emp.countEmp == 0){
                    System.out.println("No Employee Present to Display");
                }
                for (int i = 0; i < Emp.countEmp; i++){
                    emp[i].display();
                }
                break;

                case 3:
                if (Emp.countEmp == 0){
                    System.out.println("No Employee Present to Raise Salary");
                }
                for (int i = 0; i < Emp.countEmp; i++){
                    emp[i].raiseSalary();
                }
                break;
            }
        }while(ch1 != 4);
        sc.close();
        System.out.println("Total Employees Present in the Company: " + Emp.countEmp);
    }
}
