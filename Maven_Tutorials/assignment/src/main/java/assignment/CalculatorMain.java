package assignment;

public class CalculatorMain{
    public static void main(String [] args){
        Calculator calc = new Calculator();
        System.out.println( " Addition: " + calc.add(10, 20));
        System.out.println( " Subtraction: " + calc.sub(10, 20));
        // System.out.println( " Multiplication: " + calc.mul(10, 20));
    }
}