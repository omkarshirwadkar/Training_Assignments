import java.util.Iterator;

class EmployeeList implements Iterator{
    public static int count = 0;
    public static Employee [] employees = new Employee[100];
    public void addEmployee(Employee e){
        employees[count++] = e;
    }
    public boolean hasNext(){
        if (employees[count] != null) {
            return true;
        }
        else{
            return false;
        }
    }
    public Employee next() {
        return employees[count++];
    }
    public Iterator iterator(){
        return this;
    }
}
class Employee{
    private String name;
    private int age;
    private double salary;
    private String designation;
}

abstract class EmployeeFactory{
    public static Employee getEmployee(String designation){
        Employee e = switch(designation){
            case "Manager" -> Manager.getObject();
            case "Programmer" -> Programmer.getObject();
            case "Clerk" -> Clerk.getObject();
            case "CEO" -> CEO.getObject();
        }
        return e;
    }
}
public class EmpManageAppDesign {
    
}
