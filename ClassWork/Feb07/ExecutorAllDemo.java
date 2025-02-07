import java.util.concurrent.*;

class Greet implements Runnable{
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("From Greet: " + i);
        }
    }
}
class Sum implements Callable<Integer>{
    int val;
    Sum(int val){
        this.val = val;
    }
    public Integer call() {
        int res = 0;
        for (int i = 0; i <= val; i++) {
            res += i;
        }
        return res;
    }
}
public class ExecutorAllDemo {
    public static void main(String[] args) throws Exception{
        
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        executor.submit(new Greet());

        Future <Integer> f1 = executor.submit(new Sum(10));
        Future <Integer> f2 = executor.submit(new Sum(20));
        Future <Integer> f3 = executor.submit(new Sum(100));

        System.out.println(" Sum of 10: " + f1.get());
        System.out.println(" Sum of 20: " + f2.get());
        System.out.println(" Sum of 100: " + f3.get());

        // Cannot use try with resources here as there is no close method to call
        // try with resources is used for resources that implement AutoCloseable interface
        executor.shutdown();
    }   
}