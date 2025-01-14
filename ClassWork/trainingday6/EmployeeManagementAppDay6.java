import java.util.InputMismatchException;
import java.util.Scanner;

class Menu{
    private static int maxChoice;
    public static int readChoice(int mc){
        maxChoice = mc;
        while(true){
            System.out.println("Enter Choice: ");
            try{
                int choice = new Scanner(System.in).nextInt();
                if (choice < 1 || choice > maxChoice) {
                    throw new InvalidChoiceException();
                }
                return choice;
            }
            catch (InputMismatchException e){
                System.out.println("Please Enter a number");
            }
            catch (InvalidChoiceException e){
                e.display(maxChoice);
            }
        } 
    }
}
class InvalidChoiceException extends RuntimeException{
    public InvalidChoiceException() {
        super();
    }
    public InvalidChoiceException(String msg){
        super(msg);
    }
    public void display(int maxChoice){
        System.out.println("Please enter number between 1 to " + maxChoice);
    }
}
abstract class Emp{
    String name;
    int age;
    float salary;
    String designation;

    static int countEmp = 0;
    Emp(float salary, String designation) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name");
        name = sc.nextLine();
        System.out.println("Enter your age");
        age = sc.nextInt();
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

public class EmployeeManagementAppDay6 {
    public static void main(String[] args) {
        int ch1 = 0, ch2 = 0;
        Emp emp[] = new Emp[100];
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("-------------------------------------");
            System.out.println("1. Create Employee");
            System.out.println("2. Display");
            System.out.println("3. Raise Salary");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.println("-------------------------------------");
            ch1 = Menu.readChoice(5);
            switch(ch1){
                case 1:
                do{
                    System.out.println("---------------------------------------------");
                    System.out.println("1. Create Clerk");
                    System.out.println("2. Create Programmer");
                    System.out.println("3. Create Manager");
                    System.out.println("4. Back");
                    System.out.println("--------------------------------------------");
                    ch2 = Menu.readChoice(4);
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
                case 4:
                System.out.println("Yet to write the logic");
                break;
                
            }
        }while(ch1 != 5);
        sc.close();
        System.out.println("Total Employees Present in the Company: " + Emp.countEmp);
    }
}
