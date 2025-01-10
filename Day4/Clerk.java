package emp.assignment;

// No one should be able to inherit Clerk, Manager and Programmer therefore making them final
public final class Clerk extends Emp{
    public Clerk(){
        // One method without calling super constructor 
        // salary = 20000;
        // designation = "Clerk";

        // another method
        super(20000, "Clerk");
    }
    public void raiseSalary(){
        salary += 2000;
    }
}
