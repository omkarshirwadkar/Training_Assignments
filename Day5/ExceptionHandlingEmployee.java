import java.util.InputMismatchException;
import java.util.Scanner;

class WrongAge extends RuntimeException{
    public WrongAge() {
        super("Age should be between 18 and 60");
    }
    public WrongAge(String message) {
        super(message);
    }
}
abstract class Emp{
    String name;
    int age;
    float salary;
    String designation;

    static int countEmp = 0;

    Emp(float salary, String designation) {
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Enter your name: ");
        name = sc1.nextLine();
        do {
            try{
                System.out.print("Enter your age: ");
                age = sc1.nextInt();
                if (age < 18 || age > 60) {
                    throw new WrongAge("Age Should be between 18 and 60");
                }
            }
            catch (InputMismatchException e){
                System.out.println("------------------------------------");
                System.out.println("Invalid input. Please enter a number.");
                sc1.next();
            }
            catch (WrongAge e){
                System.out.println("---------------" + e.getMessage() + "----------------");
            }
        } while (age < 18 || age > 60);
        this.salary = salary;
        this.designation = designation;
        countEmp += 1;
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
        super(20000, "Clerk");
    }
    public void raiseSalary(){
        salary += 2000;
    }
}

class Programmer extends Emp{
    Programmer(){
        super(30000, "Programmer");
    }
    public void raiseSalary(){
        salary += 5000;
    }
}

class Manager extends Emp{
    Manager(){
        super(100000, "Manager");
    }
    public void raiseSalary(){
        salary += 15000;
    }
}

public class ExceptionHandlingEmployee {
    
    public static void main(String[] args) {
        int ch1 = 0, ch2 = 0;
        Emp emp[] = new Emp[100];
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("----------------Main Menu---------------------");
            System.out.println("1. Create Employee");
            System.out.println("2. Display");
            System.out.println("3. Raise Salary");
            System.out.println("4. Exit");
            System.out.println("----------------------------------------------");
            System.out.print("Enter your choice: ");
            try{
                ch1 = sc.nextInt();
                switch(ch1){
                    case 1:
                    do{
                        System.out.println("---------------Create Employee------------------------");
                        System.out.println("1. Create Clerk");
                        System.out.println("2. Create Programmer");
                        System.out.println("3. Create Manager");
                        System.out.println("4. Back");
                        System.out.println("------------------------------------------------------");
                        System.out.print("Enter your choice: ");
                        try{
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
                                case 4:
                                break;
                                default:
                                System.out.println("Message: Enter Valid choice");
                                break;
                            }
                        }
                        catch (InputMismatchException e){
                            System.out.println("------------------------------------");
                            System.out.println("Invalid input. Please enter a number.");
                            System.out.println("Exception: " + e);
                            sc.next();
                        }
                    }while(ch2 != 4);
                    break;
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
                    case 4:
                    System.out.println("Exiting...");
                    break;
                    default:
                    System.out.println("Message: Enter Valid Choice");
                    break;
                }
            }
            catch (InputMismatchException e){
                System.out.println("------------------------------------");
                System.out.println("Invalid input. Please enter a number.");
                System.out.println("Exception: " + e);
                sc.next();
            }
        }while(ch1 != 4);
        System.out.println("Total Employees Present in the Company: " + Emp.countEmp);
    }
}
