import java.io.*;
import java.util.concurrent.*;

class Countdown extends Thread {
   // Countdown(){
   //    new Thread(this).start();
   // }
   public void run(){
       for(int i=10;i>=1;i--){
           System.out.println("--------------------------------");
           System.out.println("Race will Begin in "+i+" Seconds");
           System.out.println("-------------------------------- ");
           try{
           Thread.sleep(1000);
           }
           catch(Exception e){
               System.out.println(e);
           }
       }
       System.out.println(" ------------ GO ------------- ");
   }
}
class Racer extends Thread {
    private String racerName ;
    private long startTime ;
    private long endTime ;
    private int speed = 0 ;
    private int distance = 0;
    private static Object lock = new Object();
    private CountDownLatch startlatch ;
    private CountDownLatch finishlatch;
    
    Racer(CountDownLatch startlatch,CountDownLatch finishlatch){
      this.startlatch=startlatch;
      this.finishlatch=finishlatch;

    }
    
    public String getRacerName(){
      return racerName;
    }
    public void setRacerName(String name){
       this.racerName = name ;
    }

    public long getStartTime(){
       return startTime;
    }
    public void setStartTime(long startTime){
     this.startTime=startTime;
    }

    public long getEndTime(){
        return endTime; 
    }
    public void setEndTIme(long endTime){
         this.endTime=endTime;
    }

    public int getSpeed(){
       return speed;
    }
    public void accelarate(){
      speed = speed + 1;
    }
    public void deaccelarate(){
        if(speed>5)speed--;
    } 
    
   public void display(int rank){
    System.out.println("  "+ rank+ "   |    "+this.getName()+"   |     "+this.startTime+"    |   "+this.endTime+"    |    "+(this.endTime-this.startTime) );
   }
    public void run(){

      System.out.println(this.getName() + " is ready. ");

         try{
            startlatch.await();
         }
         catch(Exception e){
            System.out.println(e);
         }
         
       
             this.startTime = System.currentTimeMillis();
       System.out.println(this.getName() + " started Running ");
       int mark=20;
       
       while(this.distance<BikeRace.distance){
        
       if(this.distance>mark){
        System.out.println(this.getName()+" completed " + mark + " metres mark .");
        mark=mark+20;
       }
        int randomnumber = (int)(Math.random()*3);
        switch(randomnumber){
          case 1:this.accelarate();
          break;
          case 2:this.deaccelarate();
          break;
        }
        this.distance=this.distance+speed;
        try{
          Thread.sleep(1000);
        }
        catch(Exception e){
           System.out.println(e);
        }
        
       }
       System.out.println(this.getName() + " finished Running ");
       this.endTime=System.currentTimeMillis();
       finishlatch.countDown();
    }

}
public class BikeRace{
   static int distance = 100 ;
   static int flag=0;
   public static void main(String[] args) {
      ExecutorService es = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
      CountDownLatch startlatch = new CountDownLatch(1);
      CountDownLatch finishlatch = new CountDownLatch(10);
      Racer racers[]=new Racer[10];
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      for(int i=0;i<10;i++){
         Racer racer = new Racer(startlatch,finishlatch);
         racers[i]=racer;
         System.out.println("Enter the name of the racer " + (i+1) + " :");
         try{
            String name = br.readLine();
            racer.setName(name);
            es.submit(new Thread(racer)) ;
         }
         catch(Exception e){
            System.out.println(e);
         }
      }
    while(true){
    System.out.print("Write Start to Begin :");
    try{
    String s = br.readLine();
    String temp = "Start";
    if(s.equalsIgnoreCase(temp))
    {

      Thread countdown = new Thread(new Countdown());
      countdown.start(); 
      try{
        countdown.join();
     }
     catch(Exception e){
        System.out.println(e);
     }
        startlatch.countDown();
        break;
    }
    }

    catch(Exception e){
       System.out.println(e);
    }
    }

   try{
      finishlatch.await();
   }
   catch(Exception e){
      System.out.println(e);
   }
   
   es.shutdown();
   
   SortRacer.sortRacersByTime(racers);
   System.out.println(" Rank |   Thread Name  |     Start Time      |       EndTime     |   Time Taken ");
   for(int i=0;i<10;i++){
      racers[i].display(i+1);
   }

   }
}
class SortRacer {
   public static void sortRacersByTime(Racer[] racers) {
       for (int i = 0; i < racers.length - 1; i++) {
           for (int j = 0; j < racers.length - i - 1; j++) {
               long time1 = racers[j].getEndTime() - racers[j].getStartTime();
               long time2 = racers[j + 1].getEndTime() - racers[j + 1].getStartTime();
               if (time1 > time2) {
                   Racer temp = racers[j];
                   racers[j] = racers[j + 1];
                   racers[j + 1] = temp;
               }
           }
       }
   }
}