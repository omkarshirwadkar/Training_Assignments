// package Jan21;

import java.util.Scanner;
import java.lang.reflect.*;

class Calculator {
    public int add(int x, int y){
        return x + y;
    }
    public int sub(int x, int y){
        return x - y;
    }
    public int mul(int x, int y){
        return x * y;
    }
    public int div(int x, int y){
        if(y == 0) {
            return 0;
        }
        return x / y;
    }
}

public class Calculation{
    public static void main(String[] args){
        try{
            Class calculatorClass = Class.forName("Calculator");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the method name (add, sub, mul, div):");
            String methodName = sc.nextLine();

            // get the method object
            Method method = calculatorClass.getMethod(methodName, int.class, int.class);

            // get the calculator object
            Calculator calculator = (Calculator) calculatorClass.newInstance();

            System.out.println("Enter parameter 1: ");
            int num1 = sc.nextInt();
            System.out.println("Enter parameter 2: ");
            int num2 = sc.nextInt();
            Object result = method.invoke(calculator, num1, num2);
            System.out.println("Result: " + result);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
