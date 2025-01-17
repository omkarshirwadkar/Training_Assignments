// package ClassWork.trainingday9;

class A extends Thread {
    public void run(){
        for (int i=0;i < 10;i++){
            System.out.println(Thread.currentThread().getName() + " : " + i);
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
        for (int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try{
                if (i % 3 == 0){
                    Thread.sleep(4000);
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
        for (int i=0;i<10;i++){
            System.out.println("Chickoo " + i);
            try{
                if (i % 2 == 0){
                    Thread.sleep(20000);
                }
            }
            catch (InterruptedException e) {
                System.out.println("Thread C is interrupted");
            }
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {

        // Grouping of threads
        ThreadGroup tg = new ThreadGroup("Demo");
        Thread a = new Thread(tg, new A());
        Thread b = new Thread(tg, new B());
        Thread c = new Thread(tg, new C());
        a.setName("Omkar");
        b.setName("Rohan");
        c.setName("Chickoo");

        

        // instead of object.run()
        // a.run();
        // b.run();
        // c.run();
        // do object.start(), beacause start() is used to start the thread and run() is used to execute the thread
        a.start();
        b.start();
        c.start();
        for (int i=0;i<10;i++){
            System.out.println("Main Thread " + i);
            // suspend and resume are deprecated in java 1.5 and removed in java 1.6
            // if (i == 2){
            //     b.suspend();
            // }
            // // if(i == 5){
            // //     b.resume();
            // // }
            // if (i == 5){
            //     c.stop();
            // }
            if (i == 2){
                tg.suspend();
            }
            if (i == 6){
                tg.resume();
            }
            if (i == 8){
                tg.stop();
            }
            if (i == 7){
                // Exception in thread "main" java.lang.IllegalThreadStateException
                // c.start();
            }
            if (i == 8){
                System.out.println("a is alive: " + a.isAlive());
                System.out.println("b is alive: " + b.isAlive());
                System.out.println("c is alive: " + c.isAlive());
            }
            try{
                Thread.sleep(500);
            }
            catch (InterruptedException e){
                System.out.println("Main Thread interrupted");
            }
        }

        // join () is used to wait for the thread to finish its execution
        // try {
        // a.join();
        // b.join();
        // c.join();
        // }
        // catch (InterruptedException e) {
        //     System.out.println("Main Thread is interrupted");
        // }
        System.out.println("--------Main Exit---------");
    }
}
