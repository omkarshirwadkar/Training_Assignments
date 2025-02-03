import java.sql.*;
import java.io.*;
import javax.sql.rowset.*;
import javax.sql.*;

class EmplooyeeDisplayer{
    public static void displayByType(ResultSet rs){
        try{
            if (rs.next()){
                while(rs.next()){
                    System.out.println("Employee ID: "+rs.getInt("emp_id"));
                    System.out.println("Employee Name: "+rs.getString("emp_name"));
                    System.out.println("Employee Age: "+rs.getInt("emp_age"));
                    System.out.println("Employee Salary: "+rs.getDouble("emp_salary"));
                    System.out.println("Employee Designation: "+rs.getString("emp_designation"));
                    System.out.println("Employee Department: "+rs.getString("emp_department"));
                    System.out.println();
                }
            }
            else{
                System.out.println("No employee found");
            }
        }
        catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
class InputTaker{

    public static void addEmployee(BufferedReader br, JdbcRowSet rs ,String designation){
        try{
            System.out.println("Enter Employee Name");
            String name = br.readLine();
            System.out.println("Enter Employee Age");
            int age = Integer.parseInt(br.readLine());
            System.out.println("Enter Employee Salary");
            double salary = Double.parseDouble(br.readLine());
            System.out.println("Enter Department");
            String department = br.readLine();
            rs.setCommand("INSERT INTO employee_database (emp_name, emp_age, emp_salary, emp_designation, emp_department) VALUES (?,?,?,?,?)");
            rs.setString(1, name);
            rs.setInt(2, age);
            rs.setDouble(3, salary);
            rs.setString(4, designation);
            rs.setString(5, department);
            rs.execute();
            System.out.println("Employee Added");            
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
public class EmpManageApp {
    public static void main(String[] args) {
        try{
            // Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demodb"); 
            JdbcRowSet rs = RowSetProvider.newFactory().createJdbcRowSet();
            rs.setUrl("jdbc:postgresql://localhost:5432/demodb");
            rs.setUsername("postgres");
            rs.setPassword("tiger");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int ch1 = 0, ch2 = 0, ch3 = 0;
            do{
                System.out.println("----------------------------------------------------------");
                System.out.println("1. Create");
                System.out.println("2. Display");
                System.out.println("3. Appraisal");
                System.out.println("4. Search");
                System.out.println("5. Remove");
                System.out.println("6. Exit");
                System.out.println("----------------------------------------------------------");
                System.out.println("Enter your choice");
                ch1 = Integer.parseInt(br.readLine());
                switch(ch1){

                    case 1:
                    // PreparedStatement pstmt = conn.prepareStatement("INSERT INTO employee_database (emp_name, emp_age, emp_salary, emp_designation, emp_department) VALUES (?, ?, ?, ?, ?)");
                    do{
                        
                        System.out.println("------------------------------------------------------------");
                        System.out.println("1. Clerk");
                        System.out.println("2. Manager");
                        System.out.println("3. Programmer");
                        System.out.println("4. Other");
                        System.out.println("5. Exit");
                        System.out.println("------------------------------------------------------------");
                        System.out.println("Enter your choice");
                        ch2 = Integer.parseInt(br.readLine());
                        switch(ch2){
                            case 1 : InputTaker.addEmployee(br, rs,"Clerk"); break;
                            case 2 : InputTaker.addEmployee(br, rs,"Manager"); break;
                            case 3 : InputTaker.addEmployee(br, rs,"Programmer"); break;
                            case 4 : {
                                System.out.println("Enter designation");
                                String designation = br.readLine();
                                InputTaker.addEmployee(br, rs, designation);
                                break;
                            }

                        }
                    }while(ch2 != 5);
                    break;

                    case 2:
                    do{
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("How do you want to display the employees?");
                        System.out.println("1. By ID");
                        System.out.println("2. By Name");
                        System.out.println("3. By Age");
                        System.out.println("4. By Salary");
                        System.out.println("5. By Designation");
                        System.out.println("6. By Department");
                        System.out.println("7. Exit");
                        System.out.println("----------------------------------------------------------");
                        System.out.println("Enter your choice");
                        ch3 = Integer.parseInt(br.readLine());
                        switch(ch3){
                            case 1 : {
                                rs.setCommand("SELECT * FROM employee_database order by emp_id");
                                rs.execute();
                                EmplooyeeDisplayer.displayByType(rs);
                                break;
                            }
                            case 2 : {
                                rs.setCommand("SELECT * FROM employee_database order by emp_name");
                                rs.execute();
                                EmplooyeeDisplayer.displayByType(rs);
                                break;
                            }
                            case 3 : {
                                rs.setCommand("SELECT * FROM employee_database order by emp_age");
                                rs.execute();
                                EmplooyeeDisplayer.displayByType(rs);
                                break;
                            }
                            case 4 : {
                                rs.setCommand("SELECT * FROM employee_database order by emp_salary");
                                rs.execute();
                                EmplooyeeDisplayer.displayByType(rs);
                                break;
                            }
                            case 5 : {
                                rs.setCommand("SELECT * FROM employee_database order by emp_designation");
                                rs.execute();
                                EmplooyeeDisplayer.displayByType(rs);
                                break;
                            }
                            case 6 : {
                                rs.setCommand("SELECT * FROM employee_database order by emp_department");
                                rs.execute();
                                EmplooyeeDisplayer.displayByType(rs);
                                break;
                            }
                        }
                    } while (ch3 != 7);
                    break;

                    case 3:
                    System.out.println("Enter Employee ID");
                    int empid = Integer.parseInt(br.readLine());
                    System.out.println("Enter amount to be raised(positive) or to be deducted(negative)");
                    double amount = Double.parseDouble(br.readLine());
                    rs.setCommand("update employee_database set emp_salary = emp_salary + "+ amount +"  where emp_id = " + empid);
                    rs.execute();
                    // if (rs.getUpdateCount() == 1){
                    //     System.out.println("Salary updated");
                    // }
                    // else{
                    //     System.out.println("Employee ID not found");
                    // }
                    break;

                    case 4:
                    System.out.println("Enter Department to Search");
                    String dept = br.readLine();
                    System.out.println("Enter Name to Search");
                    String name = br.readLine();
                    rs.setCommand("SELECT * FROM employee_database WHERE emp_department = "+ dept +" AND emp_name = " + name);
                    break;

                    case 5:
                    
                    System.out.println("Enter Employee ID");
                    int empid1 = Integer.parseInt(br.readLine());
                    rs.setCommand("SELECT * FROM employee_database where emp_id = " + empid1);
                    if (rs.next()){
                        System.out.println("Are you sure you want to delete this employee?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        int ch4 = Integer.parseInt(br.readLine());
                        if (ch4 == 1) {
                            rs.setCommand("DELETE FROM employee_database WHERE emp_id = " + empid1);
                        }
                        else{
                            System.out.println("Employee not deleted");
                        }
                    }
                    // rs.close();
                }
            }while (ch1 != 6);

            br.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}