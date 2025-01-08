package Assignments.Day1;
import java.util.*;

enum EmployeeType 
{
  CLERK,
  PROGRAMMER,
  MANAGER
}

class Employee
{
  private int id;
  String ename;
  EmployeeType designation;
  int age;
  double salary;
  String password;

  static List<Employee> employee = new ArrayList<>();

  Employee(String ename, EmployeeType designation, int age, double salary, String password) {
    if(Employee.employee.size() == 0)
    {
      this.id = 1;
    }
    else
    {
      this.id = Employee.employee.get(Employee.employee.size()-1).id + 1;
    }
    this.ename = ename;
    this.designation = designation;
    this.age = age;
    this.salary = salary;
  }

  int getId()
  {
    return id;
  }

  String display()
  {
    String data = "---------------------------------------------------------------------\nEmployee ID: " + this.id + "\nEmployee Name: " + this.ename + "\nAge: " + this.age + "\nSalary: "+this.salary+"\nEmployee Type: "+"\n-------------------------------------------------------";
    return data;
  }

  void raiseSalary(double increment)
  {
    this.salary += increment;
  }
}

public class Main {
  public static void main(String[] args) throws InterruptedException 
  {
    Employee e1 = new Employee("Omkar", EmployeeType.MANAGER, 21, 100000.0, "login");
    Employee.employee.add(e1);
    while(true)
    {
      System.out.println("1. Add Employee");
      System.out.println("2. Display Single Employee");
      System.out.println("3. Display All Employee");
      System.out.println("4. Raise Salary");
      System.out.println("5. Delete Employee");
      System.out.println("6. Exit");
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter your choice");
      int choice = sc.nextInt();
      switch(choice)
      {
        case 1:
          System.out.println("Enter Employee Name");
          String ename = sc.next();
          System.out.println("Enter Employee Age");
          int age = sc.nextInt();
          System.out.println("Enter Employee Type");
          EmployeeType type = EmployeeType.valueOf(sc.next());
          System.out.println("Enter Employee Salary");
          double salary = sc.nextDouble();
          System.out.println("Enter Password for user: ");
          String pass = sc.next();
          Employee e2 = new Employee(ename, type, age, salary, pass);
          Employee.employee.add(e2);
          break;

        case 2:
          System.out.println("Enter ID of employee: ");
          int id = sc.nextInt();
          boolean found = false;
          for(Employee e: Employee.employee)
          {
            if(e.getId() == id)
            {
              System.out.println(e.display());
              found = true;
              break;
            }
          }
          if(!found)
          {
            System.out.println("Employee not found");
          }
          break;

        case 3:
          for (Employee e: Employee.employee)
          {
            System.out.println(e.display());
          }
          break;

        case 4:
          System.out.println("Enter Your Employee ID");
          int id1 = sc.nextInt();
          for(Employee e : Employee.employee)
          {
            if(e.getId() == id1 )
            {
              if(e.designation != EmployeeType.MANAGER)
              {
                System.out.println("You are not a manager");
                break;
              }
              System.out.println("Enter Your Password");
              String pass1 = sc.next();
              if(pass1.equals(e.password))
              {
                System.out.println("Enter ID of the employee");
                id = sc.nextInt();
                System.out.println("Enter Raise Amount");
                double ra = sc.nextDouble();
                found = false;
                for(Employee emp : Employee.employee)
                {
                  if(emp.getId() == id)
                  {
                    emp.raiseSalary(ra);
                    found = true;
                    break;
                  }
                }
                if(!found)
                {
                  System.out.println("Employee not found");
                }
              }
              else
              {
                System.out.println("Invalid Password");
              }
              break;
            }
          }
          break;

        case 5:
          System.out.println("Enter ID of employee: ");
          id = sc.nextInt();
          found = false;
          for(Employee e: Employee.employee)
          {
            if(e.getId() == id)
            {
              Employee.employee.remove(e);
              found = true;
              break;
            }
          }
          if(!found)
          {
            System.out.println("Employee not found");
          }
          break;

        case 6:
          sc.close();
          throw new InterruptedException();

        default:
          System.out.println("Invalid choice");
          break;
        }
        sc.close();
    }
  }
}