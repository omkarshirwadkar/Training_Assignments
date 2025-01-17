package ClassWork.Jan17.Program3;
// package ClassWork.trainingday9.Program3;


class A implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is waiting  for permission.");
        synchronized(this){
            System.out.println(Thread.currentThread().getName() + " is running");
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " " + (i + 1));
                try{
                    Thread.sleep(500);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
}
public class SyncDemo {
    public static void main(String[] args) {
        A a1 = new A();
        Thread t1 = new Thread(a1);
        Thread t2 = new Thread(a1);
        Thread t3 = new Thread(a1);
        t1.setName("Rohan");
        t2.setName("Sohan");
        t3.setName("Mohan");
        t2.setDaemon(true);

        t1.start();
        t2.start();
        t3.start();
        // cannot change a running thread to daemon
        // cannot change a daemon thread to non-daemon thread once the thread starts running
        // t2.setDaemon(false);
    }
}
