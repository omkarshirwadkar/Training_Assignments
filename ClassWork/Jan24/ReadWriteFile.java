import java.io.*;
import java.util.StringTokenizer;

class Employee{
    private String name;
    private int age;
    private int salary;
    private String designation;
    public Employee(){
        readDetails();
    }
    public void readDetails(){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter your name:");
            name = br.readLine();
            System.out.println("Enter your age:");
            age = Integer.parseInt(br.readLine());
            System.out.println("Enter your salary:");
            salary = Integer.parseInt(br.readLine());
            System.out.println("Enter your designation:");
            designation = br.readLine();
            br.close();
        }
        catch (IOException e) {
            System.out.println("Error reading input");
        }
    }
    public void writeToFile(){
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("employees.csv", true));
            pw.println(name + "," + age + "," + salary + "," + designation);
            pw.close();
        }
        catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }
    public static void display(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
                System.out.println("Name: " + st.nextToken());
                System.out.println("Age: " + st.nextToken());
                System.out.println("Salary: " + st.nextToken());
                System.out.println("Designation: " + st.nextToken());
                System.out.println();
            }
            br.close();
        }
        catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
public class ReadWriteFile {
    public static void main(String[] args) {
        int ch = 0;
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            do{
                System.out.println("----------------------------------");
                System.out.println("1. Create Employee");
                System.out.println("2. Display Employee");
                System.out.println("3. Exit");
                System.out.println("----------------------------------");
                System.out.println("Enter your choice:");
                ch = Integer.parseInt(br.readLine());
                switch(ch){
                    case 1 -> new Employee().writeToFile();
                    case 2 -> new Employee();
                    case 3 -> System.out.println("Exiting...");
                }
            }while (ch != 3);
        }
        catch (Exception e) {
            System.out.println("Invalid choice");
        }
    }
}
