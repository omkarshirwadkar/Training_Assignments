import java.util.*;
import java.io.*;

class AccessFiles{
    public static File openFile() {
        try{
            File file1 = new File("employees.ser");
            if (!file1.exists()) {
                file1.createNewFile();
            }
            return file1;
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
    public static void appendToFile(File file, Employee c2) {
        try {
            // RandomAccessFile raf = new RandomAccessFile(file, "rw");
            // raf.seek(raf.length());
            // String data = c2.getID() + "," + c2.getName() + "," + c2.getSalary() + "," + c2.getAge() + "," + c2.getDesignation();
            // raf.writeBytes(data + "\n");
            // raf.close();
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, true));
            oos.writeObject(c2);
            oos.close();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static HashMap<Integer, Employee> loadMapFromCSV(){
        HashMap<Integer, Employee> map = new HashMap<>();
        try {
            // File file = AccessFiles.openFile();
            // BufferedReader br = new BufferedReader(new FileReader(file));
            // String line;
            // while ((line = br.readLine()) != null) {
            //     String[] data = line.split(",");
            //     int id = Integer.parseInt(data[0]);
            //     String name = data[1];
            //     double salary = Double.parseDouble(data[2]);
            //     int age = Integer.parseInt(data[3]);
            //     String designation = data[4];
            //     if (designation.equals("Manager")) {
            //         map.put(id, new Manager(id, name, age, salary, designation));
            //     }
            //     else if (designation.equals("Programmer")) {
            //         map.put(id, new Programmer(id, name, age, salary, designation));
            //     }
            //     else if (designation.equals("Clerk")) {
            //         map.put(id, new Clerk(id, name, age, salary, designation));
            //     }
            //     else if (designation.equals("CEO")) {
            //         map.put(id, new CEO(id, name, age, salary, designation));
            //     }
            // }
            // br.close();
            // return map;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.ser"));
            Employee [] employees = (Employee[]) ois.readObject();
            for (Employee e : employees) {
                map.put(e.getID(), e);
            }
            ois.close();
            return map;
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
    public static HashSet <Integer> loadIDListFromCSV(){
        HashSet <Integer> list = new HashSet<>();
        try {
            // File file = AccessFiles.openFile();
            // BufferedReader br = new BufferedReader(new FileReader(file));
            // String line;
            // while ((line = br.readLine()) != null) {
            //     String[] data = line.split(",");
            //     int id = Integer.parseInt(data[0]);
            //     list.add(id);
            // }
            // br.close();
            // return list;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.ser"));
            Employee [] employees = (Employee[]) ois.readObject();
            for (Employee e : employees) {
                list.add(e.getID());
            }
            ois.close();
            return list;
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
class GetDetails{
    public static HashSet <Integer>  idList = AccessFiles.loadIDListFromCSV();
    public static int getID(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID: ");
        try{
            int id = scanner.nextInt();
            while (idList.contains(id)) {
                System.out.println("ID already exists. Enter a new ID: ");
                id = scanner.nextInt();
            }
            idList.add(id);
            return id;
        }
        catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid ID.");
            return 12;
        }

    }

    public static String getName(){
        Scanner sc1 = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc1.nextLine();
        // sc1.close();
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
abstract class Employee implements Serializable{
    private int id;
    private String name;
    private int age;
    private String designation;
    private double salary;
    private static boolean isFirstEmployeeCEO = false;
    public Employee(int id, String name, int age, double salary, String designation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.designation = designation;
    }
    protected Employee(int id, float salary, String designation) {
        // to ensure that the first employee is always the CEO
        if ((isFirstEmployeeCEO == false) && (designation.equals("CEO"))) {
            isFirstEmployeeCEO = true;
            this.id = id;
            this.salary = salary;
            this.designation = designation;
            this.name = GetDetails.getName();
            this.age = GetDetails.getAge();
        }
        else if (isFirstEmployeeCEO == false){
            System.out.println("-----------------First Employee must be CEO-------------------");
        }
        else{
            this.id = id;
            this.name = GetDetails.getName();
            this.age = GetDetails.getAge();
            this.salary = salary;
            this.designation = designation;
        }
    }
    public void display(){
        System.out.println("Employee ID: "+id);
        System.out.println("Employee Name: "+name);
        System.out.println("Employee Age: "+age);
        System.out.println("Employee Designation: "+designation);
        System.out.println("Employee Salary: "+salary);
    }
    public abstract void raiseSalary();

    public double getSalary(){
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public int getID() {
        return id;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getDesignation(){
        return designation;
    }
}


final class CEO extends Employee {
    private static CEO b1 = null;
    public CEO(int id, String name, int age, double salary, String designation) {
        super(id, name, age, salary, designation);
    }
    private CEO(int id) {
        super(id, 1000000, "CEO");
    }
    public static CEO getCEO() {
        if (b1 == null) {
            b1 = new CEO(GetDetails.getID());
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
class Manager extends Employee {
    private static int managerCount = 0;
    public Manager(int id, String name, int age, double salary, String designation) {
        super(id, name, age, salary, designation);
    }
    private Manager(int id){
        super(id, 50000, "Manager");
    }
    public static Manager getManager(){
        if (managerCount < 7){
            managerCount++;
            return new Manager(GetDetails.getID());
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
class Clerk extends Employee {
    public Clerk(int id, String name, int age, double salary, String designation) {
        super(id, name, age, salary, designation);
    }
    private Clerk(int id){
        super(id, 20000, "Clerk");
    }
    public static Clerk getClerk(){
        return new Clerk(GetDetails.getID());
    }
    public void raiseSalary(){
        double salary = getSalary();
        salary += 10000;
        setSalary(salary);
    }
}
class Programmer extends Employee {
    public Programmer(int id, String name, int age, double salary, String designation) {
        super(id, name, age, salary, designation);
    }
    private Programmer(int id){
        super(id, 40000, "Programmer");
    }
    public static Programmer getProgrammer(){
        return new Programmer(GetDetails.getID());
    }
    public void raiseSalary(){
        double salary = getSalary();
        salary += 5000;
        setSalary(salary);
    }
}

class EmployeeNameSorter implements Comparator <Employee> {
    public int compare(Employee e1, Employee e2) {
        return e1.getName().compareTo(e2.getName());
    }
}
class EmployeeIDSorter implements Comparator <Employee> {
    public int compare(Employee e1, Employee e2) {
        return e1.getID() - e2.getID();
    }
}

class EmployeeAgeSorter implements Comparator <Employee> {
    public int compare(Employee e1, Employee e2) {
        return e1.getAge() - e2.getAge();
    }
}

class EmployeeSalarySorter implements Comparator <Employee> {
    public int compare(Employee e1, Employee e2) {
        return (int) (e1.getSalary() - e2.getSalary());
    }
}

class EmployeeDesignationSorter implements Comparator <Employee> {
    public int compare(Employee e1, Employee e2) {
        return e1.getDesignation().compareTo(e2.getDesignation());
    }
}
public class EmployeeManagementApp {
    public static void main(String[] args) {
        int ch1 = 0, ch2 = 0, ch3 = 0;
        HashMap <Integer, Employee> empMap = AccessFiles.loadMapFromCSV();
        if (empMap == null) {
            List <Employee> empList = new ArrayList <Employee>();
        }
        else{
            List <Employee> empList = new ArrayList <Employee>(empMap.values());
        }
        // List <Employee> empList = new ArrayList <>(empMap.values());
        File file = AccessFiles.openFile();
        System.out.println("File is opened");
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("----------------Main Menu---------------------");
            System.out.println("1. Create Employee");
            System.out.println("2. Display All");
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
                                CEO c1 = CEO.getCEO();
                                empMap.put(c1.getID(), c1);
                                empList.add(c1);
                                // AccessFiles.appendToFile(file, c1);
                                GetDetails.idList.add(c1.getID());
                                break;

                                case 2:
                                Clerk c2 = Clerk.getClerk();
                                empMap.put(c2.getID(), c2);
                                empList.add(c2);
                                // AccessFiles.appendToFile(file, c2);
                                GetDetails.idList.add(c2.getID());
                                break;

                                case 3:
                                Programmer p1 = Programmer.getProgrammer();
                                empMap.put(p1.getID(), p1);
                                empList.add(p1);
                                // AccessFiles.appendToFile(file, p1);
                                GetDetails.idList.add(p1.getID());
                                break;

                                case 4:
                                Manager m1 = Manager.getManager();
                                empMap.put(m1.getID(), m1);
                                empList.add(m1);
                                // AccessFiles.appendToFile(file, m1);
                                GetDetails.idList.add(m1.getID());
                                break;

                                case 5:
                                break;

                                default:
                                System.out.println("Message: Enter Valid choice");
                                break;
                            }
                        }
                        catch (Exception e){
                            System.out.println("------------------------------------");
                            System.out.println("Invalid input. Please enter a number.");
                            System.out.println("Exception: " + e);
                            sc.next();
                        }
                    }while(ch2 != 5);
                    break;

                    case 2:
                    if (empMap.isEmpty()){
                        System.out.println("------------------------------------------------------");
                        System.out.println("No employees in the Company.");
                        System.out.println("------------------------------------------------------");
                    }
                    else{
                        System.out.println("------------------------------------------------------");
                        System.out.println("How do you want to display the details of the employees?");
                        System.out.println("------------------------------------------------------");
                        System.out.println("1. ID");
                        System.out.println("2. Name");
                        System.out.println("3. Age");
                        System.out.println("4. Salary");
                        System.out.println("5. Designation");
                        System.out.println("6. NA");
                        System.out.println("------------------------------------------------------");
                        ch3 = sc.nextInt();
                        switch(ch3){
                            case 1:
                            empList.sort(new EmployeeIDSorter());
                            for (Employee e : empList) {
                                e.display();
                            }
                            break;

                            case 2:
                            empList.sort(new EmployeeNameSorter());
                            for (Employee e : empList) {
                                e.display();
                            }
                            break;

                            case 3:
                            empList.sort(new EmployeeAgeSorter());
                            for (Employee e : empList) {
                                e.display();
                            }
                            break;

                            case 4:
                            empList.sort(new EmployeeSalarySorter());
                            for (Employee e : empList) {
                                e.display();
                            }
                            break;

                            case 5:
                            empList.sort(new EmployeeDesignationSorter());
                            for (Employee e : empList) {
                                e.display();
                            }
                            break;
                            
                            default:
                            System.out.println("Choose a valid option.");
                            break;

                        }
                    }
                    break;

                    case 3:
                    if (empMap.isEmpty()){
                        System.out.println("------------------------------------------------------");
                        System.out.println("No employees in the Company.");
                        System.out.println("------------------------------------------------------");
                    }
                    else{
                        for (Map.Entry<Integer, Employee> entry : empMap.entrySet()) {
                            entry.getValue().raiseSalary();
                        }
                    }
                    break;

                    case 4:
                    if (empMap.isEmpty()){
                        System.out.println("No employees in the Company");
                    }
                    else{
                        System.out.println("Enter Employee ID to remove");
                        int id = sc.nextInt();
                        if (empMap.containsKey(id)){
                            empMap.get(id).display();
                            System.out.println("Are you sure you want to remove this employee? (y/n)");
                            String choice = sc.next();
                            if (choice.equalsIgnoreCase("y")){
                                empMap.remove(id);
                                GetDetails.idList.remove(id);
                                System.out.println("Employee removed");
                            }
                            else{
                                System.out.println("Employee not removed");
                            }
                        }
                        else{
                            System.out.println("Employee not found");
                        }
                        
                    }
                    break;

                    case 5:
                    if (empMap.isEmpty()){
                        System.out.println("No employees in the Company");
                    }
                    else{
                        System.out.println("How do you want to search the employee");
                        System.out.println("1. By Name");
                        System.out.println("2. By ID");
                        System.out.println("3. By Designation");
                        ch3 = sc.nextInt();
                        switch (ch3) {
                            case 1:
                            System.out.println("Enter Employee Name to search");
                            String name = sc.next();
                            boolean found = false;
                            for (Map.Entry<Integer, Employee> entry : empMap.entrySet()) {
                                if (entry.getValue().getName().equals(name)) {
                                    entry.getValue().display();
                                    found = true;
                                }
                            }
                            if (!found) {
                                System.out.println("Employee not found");
                            }
                            break;

                            case 2:
                            System.out.println(" Enter Employee ID to search");
                            int id = sc.nextInt();
                            if (empMap.containsKey(id)){
                                empMap.get(id).display();
                            }
                            else{
                                System.out.println("Employee not found");
                            }
                            break;

                            case 3:
                            System.out.println(" Enter Employee Designation to search");
                            String designation = sc.next();
                            boolean found1 = false;
                            for (Map.Entry<Integer, Employee> entry : empMap.entrySet()) {
                                if (entry.getValue().getDesignation().equals(designation)) {
                                    entry.getValue().display();
                                    found1 = true;
                                }
                            }
                            if (!found1) {
                                System.out.println("Employee not found");
                            }
                            break;

                            default:
                            System.out.println("Invalid choice");
                        }

                        // System.out.println("Enter Employee ID to search");
                        // int id = sc.nextInt();
                        // if (empMap.containsKey(id)){
                        //     empMap.get(id).display();
                        // }
                        // else{
                        //     System.out.println("Employee not found");
                        // }
                        
                    }
                    break;
                    case 6:
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
            finally{
                for (Map.Entry<Integer, Employee> entry : empMap.entrySet()) {
                    AccessFiles.appendToFile(file,entry.getValue());
                }
            }
        }while(ch1 != 6);
    }
}