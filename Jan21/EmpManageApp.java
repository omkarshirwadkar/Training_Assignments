package Jan21;
// package Jan16;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.HashMap;

// Class to take input from user
class InputTaker{
    
    public static int getID( HashMap <Integer, Emp> mp){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID:");
        int id = sc.nextInt();
        while (!mp.containsKey(id)){
            System.out.println("ID already exists. Enter new ID:");
            id = sc.nextInt();
        }
        return id;

    }
    public static String getName(){
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc1.nextLine();
        return name;
    }
    public static int getAge(){
        Scanner sc2 = new Scanner(System.in);
        int age = 0;
        do {
            try{
                System.out.print("Enter your age: ");
                age = sc2.nextInt();
                if (age < 18 || age > 60) {
                    throw new NullPointerException();
                }
            }
            catch (InputMismatchException e){
                System.out.println("------------------------------------");
                System.out.println("Invalid input. Please enter a number.");
                sc2.next();
            }
            catch (Exception e){
                System.out.println("---------------" + e.getMessage() + "----------------");
            }
        } while (age < 18 || age > 60);
        return age;
    }
}

// 
abstract class Emp{
    private int id;
    private String name;
    private int age;
    private String designation;
    private double salary;
    private static boolean isFirstEmployeeCEO = false;
    public static HashMap <Integer, Emp> mp = new HashMap<>();
    protected Emp(float salary, String designation) {
        // to ensure that the first employee is always the CEO
        if ((isFirstEmployeeCEO == false) && (designation.equals("CEO"))) {
            isFirstEmployeeCEO = true;
            this.salary = salary;
            this.designation = designation;
            this.id = InputTaker.getID(mp);
            this.name = InputTaker.getName();
            this.age = InputTaker.getAge();
            mp.put(id, this);

        }
        else if (isFirstEmployeeCEO == false){
            System.out.println("-----------------First Employee must be CEO-------------------");
        }
        else{
            this.id = InputTaker.getID(mp);
            this.name = InputTaker.getName();
            this.age = InputTaker.getAge();
            this.salary = salary;
            this.designation = designation;
            mp.put(id, this);
        }
    }
    public void search(int id) {
        if (mp.containsKey(id)) {
            System.out.println("Name: " + mp.get(id).name);
            System.out.println("Age: " + mp.get(id).age);
            System.out.println("Salary: "+mp.get(id).salary);
            System.out.println("Designation: "+mp.get(id).designation);
        }
        else{
            System.out.println("Employee not found");
        }
    }

    public void displayAll(){
        for (Emp e : mp.values()) {
            System.out.println("Name: " + e.name);
            System.out.println("Age: " + e.age);
            System.out.println("Salary: "+e.salary);
            System.out.println("Designation: "+e.designation);
        }
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public abstract void raiseSalary();
}

// Singleton class for CEO as there can be only one CEO
final class CEO extends Emp {
    private static CEO b1 = null;
    private CEO() {
        super(1000000, "CEO");
    }
    public static CEO getCEO() {
        if (b1 == null) {
            b1 = new CEO();
        }
        else{
            System.out.println("-------------------CEO already exists-------------------------");
        }
        return b1;
    }
    public void raiseSalary(){
        double salary = getSalary();
        salary += 100000;
        setSalary(salary);
    }
}

// Factory class for Manager and limiting the number of Manager to 7
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
        double salary = getSalary();
        salary += 10000;
        setSalary(salary);
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
        double salary = getSalary();
        salary += 10000;
        setSalary(salary);
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
        double salary = getSalary();
        salary += 5000;
        setSalary(salary);
    }
}
public class EmpManageApp {
    
    public static void main(String[] args) {
        int ch1 = 0, ch2 = 0;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("----------------Main Menu---------------------");
            System.out.println("1. Create Employee");
            System.out.println("2. Display");
            System.out.println("3. Raise Salary");
            System.out.println("4. Remove Employee");
            System.out.println("5. Search Employee");
            System.out.println("6. Exit");
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
                                CEO.getCEO();
                                break;

                                case 2:
                                Clerk.getClerk();
                                break;

                                case 3:
                                Programmer.getProgrammer();
                                break;

                                case 4:
                                Manager.getManager();
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
                    }while(ch2 != 5);
                    break;

                    case 2:
                    if 
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