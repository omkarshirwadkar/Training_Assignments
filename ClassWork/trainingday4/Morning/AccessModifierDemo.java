package ClassWork.trainingday4.Morning;

class A{
    public int a; // A, B, C, D, E, F
    private int b; // A
    protected int c; // A, B, C, E, F
    int d; // A, B, C
}

public class AccessModifierDemo {
    public static void main(String[] args) {
        A a[] = new A[10];
        a[3] = new A();
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
