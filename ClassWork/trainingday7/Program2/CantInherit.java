package ClassWork.trainingday7.Program2;


sealed class Manager permits SalesManager, MarketingManager{
    int x = 10;
    public void display() {
        System.out.println("Value of x is: " + x);
    }
}
final class Peon
{

}
non-sealed class SalesManager extends Manager {

}
sealed class MarketingManager extends Manager permits DistributionManager{

}

class GlobalManager extends SalesManager{

}

final class DistributionManager extends MarketingManager {}
public class CantInherit {
    public static void main(String[] args) {
    }
}
