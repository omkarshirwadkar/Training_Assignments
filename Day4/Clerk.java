package emp.assignment;


public final class Clerk extends Emp{
    public Clerk(){
        super(20000, "Clerk");
    }
    public void raiseSalary(){
        salary += 2000;
    }
}
