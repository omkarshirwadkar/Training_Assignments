package assignment;

public class CalculatorMain{
    public static void main(String [] args){
        Calculator calc = new Calculator();
        System.out.println(calc.add(10, 20));
        System.out.println(calc.sub(10, 20));
        // calc.sub(20, 10);
    }
}