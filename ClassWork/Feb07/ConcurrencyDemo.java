import java.util.concurrent.Semaphore;
class Shared{
    static int count = 0;
}
class IncThread extends Thread {
    String name;
    Semaphore sem;
    public IncThread(String name, Semaphore sem) {
        this.name = name;
        this.sem = sem;
        new Thread(this).start();
    }
    public void run() {
        // synchronized (Shared.class) {
        //     try{
        //         for (int i = 0; i < 5; i++) {
        //             System.out.println(name + " : " + ++Shared.count);
        //         }
        //     }
        //     catch (Exception e) {
        //         System.out.println(e);
        //     }
        // }

        try{
            System.out.println(name + " is waiting to get the permission....");
            sem.acquire();
            System.out.println(name + " got the permission to decrement the count");
            for (int i = 0; i < 5; i++) {
                System.out.println(name + " : " + ++Shared.count);
                Thread.sleep(700);
            }
            sem.release();
            System.out.println(name + " Permission released");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}


class DecThread extends Thread {
    String name;
    Semaphore sem;
    public DecThread(String name, Semaphore sem) {
        this.name = name;
        this.sem = sem;
        new Thread(this).start();
    }
    public void run() {

        try{
            System.out.println(name + " is waiting to get the permission....");
            sem.acquire();
            System.out.println(name + " got the permission to increment the count");
            for (int i = 0; i < 5; i++) {
                System.out.println(name + " : " + --Shared.count);
                Thread.sleep(700);
            }
            sem.release();
            System.out.println(name + " Permission released");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}

public class ConcurrencyDemo {
    public static void main(String[] args) {
        // new IncThread("Rajesh");
        // new IncThread("Suresh");
        // new IncThread("Ramesh");
        // new IncThread("Mahesh");


        Semaphore semaphore = new Semaphore(4);
        new DecThread("Rohil", semaphore);
        new IncThread("Rajesh", semaphore);
        new DecThread("Sahil", semaphore);
        new IncThread("Suresh", semaphore);
        new IncThread("Ramesh", semaphore);
        new DecThread("Mohil", semaphore);
        new IncThread("Mahesh", semaphore);
        new DecThread("Gohil", semaphore);
        new DecThread("Dohil", semaphore);
        new IncThread("Ganesh", semaphore);
    }
}
