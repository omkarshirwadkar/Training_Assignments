// package Training_Assignments.Day1;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


enum EmployeeType {
  // enums with all caps
  CLERK,
  PROGRAMMER,
  MANAGER
}

class Employee{
  // making everything private and providing getter setter methods --> Encapsulation
  private int id;
  private String ename;
  EmployeeType designation;
  private int age;
  private double salary;

  // List to store Employee objects
  static List<Employee> employee = new ArrayList<>();

  // Constructor
  Employee(String ename, EmployeeType designation, int age, double salary) {
    // assigning id based on the count of employees
    if(Employee.employee.size() == 0){
      this.id = 1;
    }
    else{
      this.id = Employee.employee.get(Employee.employee.size()-1).id + 1;
    }
    // assigning values to the fields
    this.ename = ename;
    this.designation = designation;
    this.age = age;
    this.salary = salary;
  }

  // getter methods
  public int getId(){
    return id;
  }
  public String getEname(){
    return ename;
  }
  public EmployeeType getDesignation(){
    return designation;
  }
  public int getAge(){
    return age;
  }
  public double getSalary(){
    return salary;
  }

  // setter methods
  public void setEname(String ename ){
    this.ename = ename;
  }
  public void setDesignation(EmployeeType designation ){
    this.designation = designation;
  }
  public void setAge(int age ){
    this.age = age;
  }
  public void setSalary(double salary ){
    this.salary = salary;
  }


  String display(){
    String data = "---------------------------------------------------------------------\nEmployee ID: " + this.id + "\nEmployee Name: " + this.ename + "\nAge: " + this.age + "\nSalary: "+this.salary+"\nEmployee Type: "+ this.designation+"\n---------------------------------------------------------------------\n";
    return data;
  }

  static void raiseSalary(){
    for (int i = 0; i < Employee.employee.size(); i++) {

      // Incrementing Clerk salary
      if(Employee.employee.get(i).designation == EmployeeType.CLERK){
          Employee.employee.get(i).salary = Employee.employee.get(i).salary + 2000;
      }

      // Incrementing Programmer salary
      else if(Employee.employee.get(i).designation == EmployeeType.PROGRAMMER){
          Employee.employee.get(i).salary = Employee.employee.get(i).salary + 5000;
      }

      // Incrementing Manager salary
      else if(Employee.employee.get(i).designation == EmployeeType.MANAGER){
          Employee.employee.get(i).salary = Employee.employee.get(i).salary + 10000;
      }
    }
  }
}

public class FirstDay {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.println("-------------------------------------EMPLOYEE MANAGEMENT APP--------------------------------------------");
    while (true) {
      System.out.println("----------------MAIN MENU-----------------");
      System.out.println("1. Create");    
      System.out.println("2. Display");
      System.out.println("3. Raise Salary");
      System.out.println("4. Exit");
      System.out.println("-------------------------------------------------");
      System.out.print("Enter choice: ");
      int choice = scanner.nextInt();
      scanner.nextLine();
      switch (choice) {
          case 1:
          while (true) {
              System.out.println("----------------SUB MENU--------------------");
              System.out.println("Choose Employee Type: ");
              System.out.println("1. Clerk");
              System.out.println("2. Programmer");
              System.out.println("3. Manager");
              System.out.println("4. Exit");
              System.out.println("---------------------------------------------------------");
              System.out.print("Enter choice: ");
              int choice1 = scanner.nextInt();
              scanner.nextLine();

              switch (choice1) {

                  case 1:
                  System.out.println("Enter name: ");
                  String nameClerk = scanner.nextLine();
                  System.out.print("Enter Age: ");
                  int ageClerk = scanner.nextInt();
                  scanner.nextLine();
                  Employee e1 = new Employee(nameClerk, EmployeeType.CLERK, ageClerk, 20000);
                  Employee.employee.add(e1);
                  break;

                  case 2:
                  System.out.println("Enter name: ");
                  String nameProgrammer = scanner.nextLine();
                  System.out.print("Enter Age: ");
                  int ageProgrammer = scanner.nextInt();
                  scanner.nextLine();
                  Employee e2 = new Employee(nameProgrammer, EmployeeType.PROGRAMMER, ageProgrammer, 30000);
                  Employee.employee.add(e2);
                  break;

                  case 3:
                  System.out.println("Enter name: ");
                  String nameManager = scanner.nextLine();
                  System.out.print("Enter Age: ");
                  int ageManager = scanner.nextInt();
                  scanner.nextLine();
                  Employee e3 = new Employee(nameManager, EmployeeType.MANAGER, ageManager, 100000);
                  Employee.employee.add(e3);
                  break;

                  case 4:
                  System.out.println("Exitting the Sub Menu");
                  break;

                  default:
                  System.out.println("Invalid choice");
              }
              if (choice1 == 4) {
                  break;
              }
          }
          break;

          case 2:
          System.out.println("Displaying all the employees: ");
          for (Employee e : Employee.employee) {
              System.out.println(e.display());
          }
          System.out.println("Employee Count: " + Employee.employee.size());
          break;

          case 3:
              Employee.raiseSalary();
          break;

          case 4:
          System.out.println("Exitting the Main Menu.");
          break;
          default:
          System.out.println("Invalid choice");
      }
      if (choice == 4) {
          break;
      }
    }
    scanner.close();
  }
}
