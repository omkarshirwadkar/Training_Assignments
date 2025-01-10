package emp.assignment;

public final class Programmer extends Emp{
    public Programmer(){
        // One method without calling super constructor 
        // salary = 30000;
        // designation = "Programmer";

        // another method
        super(30000, "Programmer");
    }
    public void raiseSalary(){
        salary += 5000;
    }
}
