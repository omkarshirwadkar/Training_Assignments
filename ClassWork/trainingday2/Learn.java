// package Training_Assignments.ClassWork.trainingday2;
// only 3 types(constants) were specified therefore enums
enum EmployeeType{
    // UPPERCASE ONLY
    CLERK,
    PROGRAMMER,
    MANAGER
}
class Employee{
    private int id;
    private String name;
    private int age;
    private float salary;
    private EmployeeType designation;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        if (id < 0){
            System.out.println("Invalid id");
        }
        else{
            this.id = id;
        }
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name.isEmpty()){
            System.out.println("Name cannot be empty");
        }
        else{
            this.name = name;
        }
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Age cannot be negative");
        }
        else{
            this.age = age;
        }
    }

    public float getSalary() {
        return salary;
    }
    public void setSalary(float salary) {
        if (salary < 0) {
            System.out.println("Salary cannot be negative");
        }
        else{
            this.salary = salary;
        }
    }

    public EmployeeType getDesignation() {
        return designation;
    }
    public void setDesignation(EmployeeType designation) {
        if (designation == null) {
            System.out.println("Designation cannot be null");
        }
        else{
            this.designation = designation;
        }   
    }

    public Employee(int id, String name, int age, float salary, EmployeeType designation) {
        if (id < 0) {
            System.out.println("Id cannot be negative");
        }
        else{
            this.id = id;
        }
        if (name == null) {
            System.out.println("Name cannot be null");
        }
        else{
            this.name = name;
        }
        if (age < 0) {
            System.out.println("Age cannot be negative");
        }
        else{
            this.age = age;
        }
        if (salary < 0) {
            System.out.println("Salary cannot be negative");
        }
        else{
            this.salary = salary;
        }
        if (designation == null) {
            System.out.println("Designation cannot be null");
        }
        else{
            this.designation = designation;
        }
    }
    public void display(){
        System.out.println("Id: "+id);
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Salary: "+salary);
        System.out.println("Designation: "+designation);
    }
}

public class Learn {    
    public static void main(String[] args) {
        Demo d1 = new Demo(10, 20);
        Demo d2 = new Demo(20, 90);

        // d2 also has the same values as d1 as it points to the same object as d1
        d2 = d1;
        
        // both d1 and d2 are now pointing to the same object
        // so both d1 and d2 will have the same values
        // changing the values of d1 will change the values of d2 as well
        d2.lent = 80;
        d1.width = 70;
        d1.display();
        d2.display();
    }
}
class Demo{
    int lent;
    int width;
    Demo(int lent, int width){
        this.lent = lent;
        this.width = width;
    }

    public void display(){
        System.out.println("Length: " + lent);
        System.out.println("Width: " + width);
        System.out.println("Area: " + lent * width);
    }
}