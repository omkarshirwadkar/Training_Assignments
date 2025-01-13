
import java.util.Scanner;
import emp.assignment.Emp;
import emp.assignment.Clerk;
import emp.assignment.Programmer;
import emp.assignment.Manager;

public class EmpManageAppDay4 {
    public static void main(String[] args) {
        int ch1 = 0, ch2 = 0;
        Emp emp[] = new Emp[100];
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("-------------------------------------");
            System.out.println("1. Create Employee");
            System.out.println("2. Display");
            System.out.println("3. Raise Salary");
            System.out.println("4. Remove Employee");
            System.out.println("5. Exit");
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
                        Clerk c1 = new Clerk();
                        if (emp[Emp.trackId - 1] == null){
                            emp[Emp.trackId - 1] = c1;
                            Emp.countEmp += 1;
                        }
                        else{
                            System.out.println("No space available ID already taken");
                        }
                        break;
                        case 2:
                        Programmer p1 = new Programmer();
                        if (emp[Emp.trackId - 1] == null){
                            emp[Emp.trackId - 1] = p1;
                            Emp.countEmp += 1;
                        }
                        else{
                            System.out.println("No space available ID already taken");
                        }
                        break;
                        case 3:
                        Manager m1 = new Manager();
                        if (emp[Emp.trackId - 1] == null){
                            emp[Emp.trackId - 1] = m1;
                            Emp.countEmp += 1;
                        }
                        else{
                            System.out.println("No space available ID already taken");
                        }
                        break;
                    }
                }while(ch2 != 4);

                case 2:
                if (Emp.countEmp == 0){
                    System.out.println("No Employee Present to Display");
                }
                for (int i = 0; i < 100; i++){
                    if (emp[i] != null){
                        emp[i].display();
                    }
                }
                break;

                case 3:
                if (Emp.countEmp == 0){
                    System.out.println("No Employee Present to Raise Salary");
                }
                for (int i = 0; i < 100; i++){
                    if (emp[i] != null){
                        emp[i].raiseSalary();
                    }
                }
                break;
                case 4:
                System.out.println("Enter Employee ID to Remove");
                int did = sc.nextInt();
                if (emp[did] != null){
                    System.out.println("Employee Details: ");
                    emp[did].display();
                    System.out.println("Are you sure you want to remove this employee?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    int ch3 = sc.nextInt();
                    if (ch3 == 1){
                        emp[did] = null;
                        Emp.countEmp -= 1;
                    }
                    else{
                        System.out.println("Employee not removed");
                    }
                }
                else{
                    System.out.println("Employee ID not found");
                }

            }
        }while(ch1 != 5);
        System.out.println("Total Employees Present in the Company: " + Emp.countEmp);
    }
}
