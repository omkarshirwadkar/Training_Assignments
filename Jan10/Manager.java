package Jan10;
public final class Manager extends Emp{
    public Manager(){
        super(100000, "Manager");
    }
    public void raiseSalary(){
        salary += 15000;
    }
}
