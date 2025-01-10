package emp.assignment;
public final class Manager extends Emp{
    public Manager(){
        // One method without calling super constructor 
        // salary = 100000;
        // designation = "Manager";

        // another method
        super(100000, "Manager");
    }
    public void raiseSalary(){
        salary += 15000;
    }
}
