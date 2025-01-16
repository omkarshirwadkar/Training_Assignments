import java.util.InputMismatchException;
import java.util.Scanner;

abstract class Emp{
    private String name;
    private int age;
    private String designation;
    double salary;
    static int countEmp = 0; 
    protected Emp(float salary, String designation) {
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Enter your name: ");
        name = sc1.nextLine();
        do {
            try{
                System.out.print("Enter your age: ");
                age = sc1.nextInt();
                if (age < 18 || age > 60) {
                    throw new InputMismatchException();
                }
            }
            catch (InputMismatchException e){
                System.out.println("------------------------------------");
                System.out.println("Invalid input. Please enter a number.");
                sc1.next();
            }
            catch (Exception e){
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

final class CEO extends Emp {
    private static final CEO b1 = new CEO();
    private CEO() {
        super(1000000, "CEO");
    }
    public static CEO getCEO() {
        return b1;
    }
    public void raiseSalary(){
        salary += 100000;
    }
}

class Manager extends Emp {
    private static int managerCount = 0;
    private Manager(){
        super(50000, "Manager");
    }
    public static Manager getManager(){
        if (managerCount < 7){
            managerCount++;
            return new Manager();
        }
        else {
            return null;
        }
    }
    public void raiseSalary(){
        salary += 20000;
    }
}
class Clerk extends Emp {
    private Clerk(){
        super(20000, "Clerk");
    }
    public static Clerk getClerk(){
        return new Clerk();
    }
    public void raiseSalary(){
        salary += 3000;
    }
}
class Programmer extends Emp {
    private Programmer(){
        super(40000, "Programmer");
    }
    public static Programmer getProgrammer(){
        return new Programmer();
    }
    public void raiseSalary(){
        salary += 5000;
    }
}

// abstract class Employee{
//     public static Employee getEmployee(String designation){
//         if (designation.equals("CEO")){
//             return CEO.getInstance();
//         }
//         else if (designation.equals("Manager")){
//             return Manager.getManager();
//         }
//         else if (designation.equals("Programmer")){
//             return Programmer.getProgrammer();
//         }
//         else if (designation.equals("Clerk")){
//             return Clerk.getClerk();
//         }
//         else{
//             return null;
//         }
//     }
// }
public class EmpManageApp {
    
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
                        System.out.println("1. CEO");
                        System.out.println("2. Clerk");
                        System.out.println("3. Programmer");
                        System.out.println("4. Manager");
                        System.out.println("5. Back");
                        System.out.println("------------------------------------------------------");
                        System.out.print("Enter your choice: ");
                        try{
                            ch2 = sc.nextInt();
                            switch(ch2){
                                case 1:
                                emp[Emp.countEmp] = CEO.getCEO();
                                case 2:
                                emp[Emp.countEmp] = Clerk.getClerk();
                                break;
                                case 3:
                                emp[Emp.countEmp] = Programmer.getProgrammer();
                                break;
                                case 4:
                                emp[Emp.countEmp] = Manager.getManager();
                                break;
                                case 5:
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
