package Jan14;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Menu{
    private static int maxChoice;
    private static int minChoice;
    public static int readChoice(int minC, int maxC){
        maxChoice = maxC;
        minChoice = minC;
        while(true){
            System.out.print("Enter Choice: ");
            try{
                int choice = new Scanner(System.in).nextInt();
                if (choice < minChoice || choice > maxChoice) {
                    throw new InvalidChoiceException();
                }
                return choice;
            }
            catch (InputMismatchException e){
                System.out.println("Please Enter a number");
            }
            catch (InvalidChoiceException e){
                e.displayMessage(minChoice, maxChoice);
            }
        } 
    }
    public static String readName(){
        while (true){
            String textInput = new Scanner(System.in).nextLine();
            String namePattern = "[A-Z][a-zA-Z]* [A-Z][a-zA-Z]*";
            Pattern pattern = Pattern.compile(namePattern);
            Matcher matcher = pattern.matcher(textInput);
            if (matcher.matches()){
                return textInput;
            }
            else{
                System.out.println("Please make sure the first letter is capital and there is space between Firstname and Lastname");
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
    public void displayMessage(int minChoice, int maxChoice){
        System.out.println("Please enter number between "+ minChoice + " to " + maxChoice);
    }
}

// // Either this way is fine
// class AgeReader{
//     public static int readAge(int min, int max){}
// }

// class NameReader{
//     public static String readName(){}
// }

// // Or this way is fine
// class EmployeeDetailReader{
//     public static int readAge(int min,  int max){}
//     public static String readName(){}
// }

abstract class Emp{
    String name;
    int age;
    float salary;
    String designation;

    static int countEmp = 0;
    Emp(float salary, String designation) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name");
        name = Menu.readName();
        System.out.println("Enter your age");
        age = Menu.readChoice(18, 60);
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
        // Scanner sc = new Scanner(System.in);
        do{
            System.out.println("-------------------------------------");
            System.out.println("1. Create Employee");
            System.out.println("2. Display");
            System.out.println("3. Raise Salary");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.println("-------------------------------------");
            ch1 = Menu.readChoice(1, 5);
            switch(ch1){
                case 1:
                do{
                    System.out.println("---------------------------------------------");
                    System.out.println("1. Create Clerk");
                    System.out.println("2. Create Programmer");
                    System.out.println("3. Create Manager");
                    System.out.println("4. Back");
                    System.out.println("--------------------------------------------");
                    ch2 = Menu.readChoice(1, 4);
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
        // sc.close();
        System.out.println("Total Employees Present in the Company: " + Emp.countEmp);
    }
}
