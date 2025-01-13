package emp.assignment;

public final class Programmer extends Emp{
    public Programmer(){
        super(30000, "Programmer");
    }
    public void raiseSalary(){
        salary += 5000;
    }
}
