interface I {
    void abc();
}

interface J {
    Object getObject();
}

class A {
    public A() {
        System.out.println("from constructor of A");
    }

    public static void classMethod() {
        System.out.println("from static method");
    }

    public void instanceMethod() {
        System.out.println("from instance method");
    }
}

class C {
    C() {
        System.out.println("From C constructor");
    }

    @Override
    public String toString() {
        System.out.println("This is an object of C class");
        return super.toString();
    }
}

class MethodRefereceDemo {
    public static void main(String[] args) {
        I i1 = () -> System.out.println("lambda function");
        i1.abc();

        I i2 = A::classMethod;
        i2.abc();

        I i3 = new A()::instanceMethod;
        i3.abc();

        I i4 = A::new;
        i4.abc();

        J j1 = C::new;

        Object obj = j1.getObject();
        System.out.println(obj);
    }
}