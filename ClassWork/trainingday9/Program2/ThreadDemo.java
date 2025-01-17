// package ClassWork.trainingday9;

class A extends Thread {
    public void run(){
        for (int i=0;i < 20;i++){
            System.out.println("Apple " + i);
            try{
                if (i % 5 == 0){
                    Thread.sleep(8000);
                }
            }
            catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

class B extends Thread {
    public void run(){
        for (int i=0;i<20;i++){
            System.out.println("Banana " + i);
            try{
                if (i % 3 == 0){
                    Thread.sleep(3000);
                }
            }
            catch (InterruptedException e) {
                System.out.println("Thread B is interrupted");
            }
        }
    }
}

class C extends Thread {
    public void run(){
        for (int i=0;i<20;i++){
            System.out.println("Chickoo " + i);
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();

        // instead of object.run()
        // a.run();
        // b.run();
        // c.run();

        // do object.start(), beacause start() is used to start the thread and run() is used to execute the thread
        a.start();
        b.start();
        c.start();
        for (int i=0;i<20;i++){
            System.out.println("Main Thread " + i);
        }
        System.out.println("--------Main Exit---------");
    }
}
