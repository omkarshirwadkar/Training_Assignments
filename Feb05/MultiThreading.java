import java.io.*;
class A
{
	public void print1to10()
	{
        try{
            for(int i=1; i<=10; i++)
            {   
                Thread.sleep(4000);
                System.out.println("From Class A print1to10(): "+i);
            }
        }
		catch (Exception e){
            System.out.println("Exception in print1to10(): "+e);
        }
	}
}
class B
{
	public void evenTill50()
	{
        try{
            for(int i=0; i<=50; i+=2)
            {
                Thread.sleep(1000);
                System.out.println("From class B evenTill50(): "+i);
            }
        }
		catch (Exception e){
            System.out.println("Exception in class B evenTill50(): "+e);
        }
	}
}
class C
{
	public void fib1to1000()
	{
        try{
            int first = 0, second = 1;
            while (first <= 1000) {
                Thread.sleep(2000);
                System.out.println("From Class C fib1to1000(): " + first);
                int next = first + second;
                first = second;
                second = next;
            }
        }
        catch (Exception e){
            System.out.println("Exception in Class C fib1to1000(): "+e);
        }
	}
}
public class MultiThreading
{
	public static void main(String args[])
	{
        // One way to create threads
        // Thread t1 = new Thread(() -> {
        //     new C().fib1to1000();
        // });
        // Thread t2 = new Thread(() -> {
        //     new B().evenTill50();
        // });
        // Thread t3 = new Thread(() -> {
        //     new A().print1to10();
        // });
        // t1.start();
        // t2.start();
        // t3.start();

        // Shortest way to create threads
        new Thread(new A() :: print1to10).start();
        new Thread(new B() :: evenTill50).start();
        new Thread(new C() :: fib1to1000).start();
	}
}
