// package Jan29;

// import java.beans.Statement;
import java.sql.*;
import java.io.*;

class EmplooyeeDisplayer{
    public static void displayByType(PreparedStatement pstmt){
        try{
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                System.out.println("Employee ID: "+rs.getInt("emp_id"));
                System.out.println("Employee Name: "+rs.getString("emp_name"));
                System.out.println("Employee Age: "+rs.getInt("emp_age"));
                System.out.println("Employee Salary: "+rs.getDouble("emp_salary"));
                System.out.println("Employee Designation: "+rs.getString("emp_designation"));
                System.out.println("Employee Department: "+rs.getString("emp_department"));
                System.out.println();
            }
            rs.close();
        }
        catch (Exception e){
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
class InputTaker{
    public static void addEmployee(BufferedReader br, PreparedStatement pstmt, String designation){
        try{
            System.out.println("Enter Employee Name");
            String name = br.readLine();
            System.out.println("Enter Employee Age");
            int age = Integer.parseInt(br.readLine());
            System.out.println("Enter Employee Salary");
            double salary = Double.parseDouble(br.readLine());
            System.out.println("Enter Department");
            String department = br.readLine();
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setDouble(3,salary);
            pstmt.setString(4, designation);
            pstmt.setString(5, department);
            pstmt.executeUpdate();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void displayEmployees(PreparedStatement pstmt){
        try{
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                System.out.println("Employee ID: " + rs.getInt("emp_id"));
                System.out.println("Employee Name: " + rs.getString("emp_name"));
                System.out.println("Employee Age: " + rs.getInt("emp_age"));
                System.out.println("Employee Salary: " + rs.getDouble("emp_salary"));
                System.out.println("Employee Designation: " + rs.getString("emp_designation"));
                System.out.println("Employee Department: " + rs.getString("emp_department"));
                System.out.println();
            }
            rs.close();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
public class EmpManageApp {
    public static void main(String[] args) {
        try{
            // Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demodb", "postgres", "tiger");
            System.out.println("Connected to the database");

            Statement stmt = conn.createStatement();

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
                    PreparedStatement pstmt = conn.prepareStatement("INSERT INTO employee_database (emp_name, emp_age, emp_salary, emp_designation, emp_department) VALUES (?, ?, ?, ?, ?)");
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
                            case 1 -> InputTaker.addEmployee(br, pstmt, "Clerk");
                            case 2 -> InputTaker.addEmployee(br, pstmt, "Manager");
                            case 3 -> InputTaker.addEmployee(br, pstmt, "Programmer");
                            case 4 -> {
                                System.out.println("Enter designation");
                                String designation = br.readLine();
                                InputTaker.addEmployee(br, pstmt, designation);
                            }
                        }
                    }while(ch2 != 5);
                    pstmt.close();

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
                            case 1 -> {
                                PreparedStatement pstmt1 = conn.prepareStatement("SELECT * FROM employee_database order by emp_id");
                                EmplooyeeDisplayer.displayByType(pstmt1);
                                pstmt1.close();
                            }
                            case 2 -> {
                                PreparedStatement pstmt1 = conn.prepareStatement("SELECT * FROM employee_database order by emp_name");
                                EmplooyeeDisplayer.displayByType(pstmt1);
                                pstmt1.close();
                            }
                            case 3 -> {
                                PreparedStatement pstmt1 = conn.prepareStatement("SELECT * FROM employee_database order by emp_age");
                                EmplooyeeDisplayer.displayByType(pstmt1);
                                pstmt1.close();
                            }
                            case 4 -> {
                                PreparedStatement pstmt1 = conn.prepareStatement("SELECT * FROM employee_database order by emp_salary");
                                EmplooyeeDisplayer.displayByType(pstmt1);
                                pstmt1.close();
                            }
                            case 5 -> {
                                PreparedStatement pstmt1 = conn.prepareStatement("SELECT * FROM employee_database order by emp_designation");
                                EmplooyeeDisplayer.displayByType(pstmt1);
                                pstmt1.close();
                            }
                            case 6 -> {
                                PreparedStatement pstmt1 = conn.prepareStatement("SELECT * FROM employee_database order by emp_department");
                                EmplooyeeDisplayer.displayByType(pstmt1);
                                pstmt1.close();
                            }
                        }
                    } while (ch3 != 7);
                    break;

                    case 3:
                    System.out.println("Enter Employee ID");
                    int empid = Integer.parseInt(br.readLine());
                    System.out.println("Enter amount to be raised(positive) or to be deducted(negative)");
                    double amount = Double.parseDouble(br.readLine());
                    PreparedStatement pstmt2 = conn.prepareStatement("update employee_database set emp_salary = emp_salary + ? where emp_id = ?");
                    pstmt2.setDouble(1, amount);
                    pstmt2.setInt(2, empid);
                    pstmt2.executeUpdate();
                    pstmt2.close();
                    break;

                    case 4:
                    System.out.println("Enter Department to Search");
                    String dept = br.readLine();
                    System.out.println("Enter Name to Search");
                    String name = br.readLine();
                    PreparedStatement pstmt3 = conn.prepareStatement("SELECT * FROM employee_database WHERE emp_department = ? AND emp_name = ?");
                    pstmt3.setString(1, dept);
                    pstmt3.setString(2, name);
                    EmplooyeeDisplayer.displayByType(pstmt3);
                    pstmt3.close();
                    break;

                    case 5:
                    
                    System.out.println("Enter Employee ID");
                    int empid1 = Integer.parseInt(br.readLine());
                    PreparedStatement pstmt4 = conn.prepareStatement("SELECT * FROM employee_database where emp_id = ?");
                    pstmt4.setInt(1, empid1);
                    ResultSet rs = pstmt4.executeQuery();
                    if (rs.next()) {
                        System.out.println( "Employee Name: " + rs.getString("emp_name"));
                        System.out.println("Employee Age: " + rs.getInt("emp_age"));
                        System.out.println("Employee Salary: " + rs.getDouble("emp_salary"));
                        System.out.println( "Employee Department: " + rs.getString("emp_department"));
                        System.out.println( "Employee Designation: " + rs.getString("emp_designation"));
                        System.out.println();
                        System.out.println("Are you sure you want to delete this employee?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        int ch4 = Integer.parseInt(br.readLine());
                        if (ch4 == 1) {
                            PreparedStatement pstmt5 = conn.prepareStatement("DELETE FROM employee_database WHERE emp_id = ?");
                            pstmt5.setInt(1, empid1);
                            pstmt5.executeUpdate();
                            pstmt5.close();
                        }
                        else{
                            System.out.println("Employee not deleted");
                        }
                    }
                    else{
                        System.out.println("Employee not found");
                    }
                    rs.close();
                    pstmt4.close();
                }
            }while (ch1 != 6);

            // Closing resources
            br.close();
            stmt.close();
            conn.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}