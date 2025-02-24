public class OperatorWorking{
    public static void main(String[] args) {
        int a = -10;
        // Binary Representation of 10 is 1010
        int b = a << 1; // Left Shift Operator
        System.out.println("Value of b after left shift operation is: " + b);
        int c = a >> 1; // Right Shift Operator
        System.out.println("Value of c after right shift operation is: " + c);
        int d = a >>> 1; // Unsigned Right Shift Operator
        System.out.println("Value of d after unsigned right shift operation is: " + d);
    }
}