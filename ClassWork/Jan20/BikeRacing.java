import java.time.LocalTime;
import java.util.Scanner;

class Biker extends Thread{
    String name;
    long startTime;
    long endTime;
    long timeTaken;
    int ranking;
    private static final Object lock = new Object();
    static boolean raceStarted = false;
    Biker() {
        System.out.print("Enter the name of the biker: ");
        setName(new Scanner(System.in).next());
        new Thread(this).start();
    }

    public void run() {
        System.out.println(this.getName() + " is ready to start the race.");
        synchronized(lock){
            try{
                while( !raceStarted ){
                    lock.wait();
                }
            }
            catch(InterruptedException e){
                System.out.println("Thread interrupted.");
            }
        }
        startTime = System.currentTimeMillis();
        System.out.println(this.getName() + " has started the race.");
        for(int i=1; i<RacingDetails.distance; i++)
		{
			try{
                Thread.sleep((int)Math.random()*1000);
            }
            catch(InterruptedException e){
                System.out.println("Thread interrupted.");
            }
			if(i%100 == 0)
				System.out.print(".");
		}
        endTime = System.currentTimeMillis();
        timeTaken = endTime - startTime;
        System.out.println(this.getName() + " has finished the race. " + endTime);
    }
    public String toString(){
        return this.getName() + " started at " + LocalTime.ofSecondOfDay(startTime/1000) + " and finished at " + LocalTime.ofSecondOfDay(endTime/1000) + " and took " + timeTaken + " milliseconds.";
    }
    public static void startRace(){
        synchronized(lock){
            raceStarted = true;
            lock.notifyAll();
        }
    }
    public int getRanking(){
        return ranking;
    }
    public void setRanking(int ranking){
        this.ranking = ranking;
    }
    public long getTimeTaken(){
        return timeTaken;
    }
    public long getStartTime(){
        return startTime;
    }
    public long getEndTime(){
        return endTime;
    }
}

class RacingDetails
{
	static int noOfBikers = 10;
	static int distance = 10000;
	static String unit = "Meters";
}

class Rankings{
    public static void rankBikers(Biker [] bikers) {
        for (int i = 0; i < bikers.length; i++) {
            for (int j = i + 1; j < bikers.length; j++) {
                if (bikers[i].getTimeTaken() > bikers[j].getTimeTaken()){
                    Biker temp = bikers[i];
                    bikers[i] = bikers[j];
                    bikers[j] = temp;
                }
            }
        }
    }
    public static void printRankings(Biker [] bikers) {
        for (int i = 0; i < bikers.length; i++) {
            bikers[i].setRanking((i + 1));
            System.out.println("-----------------------------" + "\nRanking: " + bikers[i].getRanking() + "\nName: " + bikers[i].getName() + "\nStart Time: " + bikers[i].getStartTime() + "\nEnd Time: " + bikers[i].getEndTime() + "\nTime Taken: " + bikers[i].getTimeTaken() + "\n-----------------------------");
        }
    }
}
public class BikeRacing {
    public static void main(String[] args) {
        Biker bikers[] = new Biker[RacingDetails.noOfBikers];
        for (int i = 0; i < 10; i++) {
            bikers[i] = new Biker();
        }
        try{
            Thread.sleep(2000);
        }
        catch (InterruptedException e){
            System.out.println("Thread interrupted.");
        }
        System.out.println("Countdown Started");
        for (int i = 10; i >= 1; i--) {
            System.out.println(i);
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                System.out.println("Thread interrupted.");
            }
        }
        System.out.println("Gooooooooooooooooooooooooooo");

        Biker.startRace();
        for (Biker biker : bikers) {
            try {
                biker.join();
            }
            catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }
        Rankings.rankBikers(bikers);
        Rankings.printRankings(bikers);
    }    
}
