import java.util.concurrent.*;

public class ConcurrencyDemo3 {
    public static void main(String[] args) throws Exception{
        CompletableFuture <String> future = CompletableFuture.supplyAsync(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("using Supply Async for String type");
                try{
                    Thread.sleep(1000);
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            return "Completed the execution";
        }).orTimeout(5, TimeUnit.SECONDS).exceptionally(s -> "You have timed out");
        CompletableFuture <Double> future2 = CompletableFuture.supplyAsync(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("using Supply Async for Double type");
            }
            return 10.0;
        });
        CompletableFuture.runAsync( ()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("using Run Async");
            }
        });

        CompletableFuture<Void> future3 = CompletableFuture.allOf( future, future2 );
        future3.join();
        // future.thenAccept((result) -> {
        //     System.out.println("result is " + result);
        // });
        System.out.println("Result from future: "+ future.get());
        System.out.println("Result from future: "+ future.getNow("Default for display"));
        // System.out.println("Second guy " + );
        future.thenApply( (result) -> {
            System.out.println("result is " + result);
            return result;
        });

        future2.thenApplyAsync((x) -> {
            System.out.println("Summing till 100 " + x);
            return x;
        });
        System.out.println("Main thread finished");
        Thread.sleep(10000);
    }   
}