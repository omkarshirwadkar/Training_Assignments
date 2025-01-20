import java.util.*;
 
class Biker extends Thread
{
	String name;
	long startTime;
	long endTime;
	long timeTaken;
	Bike()
	{
		System.out.print("Enter biker name : ");
		this.name = new Scanner(System.in).next();
		new Thread(this).start();
	}
	public void run()
	{
		System.out.println(name+" is ready to race.....");
		synchronized(lock)
		{
			wait();
		}
		startTime = LocalTime.now();		
		System.out.print("Racing")
		for(int i=1; i<RacingDetails.distance; i++)
		{
			Thread.sleep((int)Math.random()*100);
			if(i%100)
				System.out.print(".");
		}
		endTime = LocalTime.now();
		timeTaken = endTime - startTime;
	}	
	public String toString()
	{
		System.out.println(name, startTime, endTime, timeTaken);
	}
}
class RacingDetails
{
	static int noOfBikers;
	static int distance;
	static String unit = "Meters";
}
 
public class BikeRacing
{
	public static void main(String args[])
	{
		Biker bikers[] = new Bikers[noOfBikers]; 
		RacingDetails.distance = 1000;
		for(int i=0; i<bikers.length; i++)		
		{
			bikers[i] = new Bikers();
		}
		Thread.sleep(2000);
		System.out.println("Count Down Started....");
		for(int i=10; i>0; i--)
		{
			System.out.println(i);
			Thread.sleep(1000);
		}
		System.out.println("GO");
		synchronized(lock)
		{
			notifyAll();
		}
		for(Biker b : bikers)
		{
			b.join();
		}
		sort(bikers)
		for(int i=0; i<b.length; i++)
		{
			System.out.print((i+1)+b);
		}
	}
	sort(Biker bikers[])
	{
		sorting logic for Bikers in the ascending order of timeTaken;
	}
}