// <<<<<<< HEAD
import java.lang.Math;

class RandomNumber {
    static public int getRandomNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
class Rankings {
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
class Biker extends Thread {
    private String name;
    private long startTime, endTime, timeTaken;
    private int ranking;
    private int speed = 10;
    private int distance = 100;
    public static Biker getBiker(){
        return new Biker();
    }
    public void run(){
        startTime = System.currentTimeMillis();
        try {
            while (distance > 0) {
                int choice = RandomNumber.getRandomNumber(1, 3);
                // choice 1: speed up
                if (choice == 1) {
                    int speedUp = RandomNumber.getRandomNumber(1, 5);
                    this.accelerate(speedUp);
                    if (distance - speed <= 0){
                        distance = 0;
                    }
                    else{
                        distance -= speed;
                    }
                    System.out.println(this.getName() + " speed up by " + speedUp + ". Distance left: " + distance + " meters" + ".Current Speed: " + speed);
                }
                // choice 2: slow down
                else if (choice == 2) {
                    int slowDown = RandomNumber.getRandomNumber(1, 5);
                    this.decelerate(slowDown);
                    if (distance - speed <= 0){
                        distance = 0;
                    }
                    else{
                        distance -= speed;
                    }
                    System.out.println(this.getName() + " slow down by " + slowDown + ". Distance left: " + distance + " meters" + ".Current Speed: " + speed);
                }
                // choice 3: no change
                else {
                    if (distance - speed <= 0){
                        distance = 0;
                    }
                    else{
                        distance -= speed;
                    }
                    System.out.println(this.getName() + " Still Driving with the same speed" + ". Distance left: " + distance + " meters" + ".Current Speed: " + speed);
                }
            }
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            System.out.println(name + " is interrupted");
        }
        endTime = System.currentTimeMillis();
        timeTaken = endTime - startTime;
    }
    public long getStartTime() {
        return startTime;
    }
    public long getEndTime() {
        return endTime;
    }
    public long getTimeTaken() {
        return timeTaken;
    }
    public int getRanking() {
        return ranking;
    }
    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
    public void accelerate(int amount){
        if (speed + amount <= 50) {
            speed += amount;
        }
        else{
            speed = 50;
        }
    }
    public void decelerate(int amount) {
        if (speed - amount >= 1) {
            speed -= amount;
        }
        else{
            speed = 1;
        }
    }
}
class Countdown extends Thread {
    public void run() {
        System.out.println("Get Ready");
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("-----------------GO-----------------------");
    }
}
public class RoadRashGame {
    public static void main(String[] args) {
        Countdown countdown = new Countdown();
        Biker[] bikers = new Biker[10];
        countdown.start();
        try{
            countdown.join();
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
        for (int i = 0; i < 10; i++) {
            String name = "BIKER " + (char)(i + 65);
            bikers[i] = Biker.getBiker();
            bikers[i].setName(name);
            bikers[i].start();
        }
        try{
            for (int i = 0; i < 10; i++) {
                bikers[i].join();
            }
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
        Rankings.rankBikers(bikers);
        Rankings.printRankings(bikers);
    }
}
// =======
// import java.lang.Math;

// class RandomNumber {
//     static public int getRandomNumber(int min, int max) {
//         return (int) (Math.random() * (max - min + 1)) + min;
//     }
// }

// class Rankings {
//     public static void rankBikers(Biker [] bikers) {
//         for (int i = 0; i < bikers.length; i++) {
//             for (int j = i + 1; j < bikers.length; j++) {
//                 if (bikers[i].getTimeTaken() > bikers[j].getTimeTaken()){
//                     Biker temp = bikers[i];
//                     bikers[i] = bikers[j];
//                     bikers[j] = temp;
//                 }
//             }
//         }
//     }
//     public static void printRankings(Biker [] bikers) {
//         for (int i = 0; i < bikers.length; i++) {
//             bikers[i].setRanking((i + 1));
//             System.out.println("-----------------------------" + "\nRanking: " + bikers[i].getRanking() + "\nName: " + bikers[i].getName() + "\nStart Time: " + bikers[i].getStartTime() + "\nEnd Time: " + bikers[i].getEndTime() + "\nTime Taken: " + bikers[i].getTimeTaken() + "\n-----------------------------");
//         }
//     }
// }

// class Biker extends Thread {
//     private String name;
//     private long startTime, endTime, timeTaken;
//     private int ranking;
//     private int speed = 10;
//     private int distance = 100;
//     private Biker(){
//         super();
//     }
//     public static Biker getBiker(){
//         return new Biker();
//     }
//     public void run(){
//         startTime = System.currentTimeMillis();
//         try {
//             while (distance > 0) {
//                 int choice = RandomNumber.getRandomNumber(1, 3);

//                 // choice 1: speed up
//                 if (choice == 1) {
//                     int speedUp = RandomNumber.getRandomNumber(1, 5);
//                     this.accelerate(speedUp);
//                     if (distance - speed <= 0){
//                         distance = 0;
//                     }
//                     else{
//                         distance -= speed;
//                     }
//                     System.out.println(this.getName() + " speed up by " + speedUp + ". Distance left: " + distance + " meters" + ".Current Speed: " + speed);
//                 }

//                 // choice 2: slow down
//                 else if (choice == 2) {
//                     int slowDown = RandomNumber.getRandomNumber(1, 5);
//                     this.decelerate(slowDown);
//                     if (distance - speed <= 0){
//                         distance = 0;
//                     }
//                     else{
//                         distance -= speed;
//                     }
//                     System.out.println(this.getName() + " slow down by " + slowDown + ". Distance left: " + distance + " meters" + ".Current Speed: " + speed);
//                 }

//                 // choice 3: no change
//                 else {
//                     if (distance - speed <= 0){
//                         distance = 0;
//                     }
//                     else{
//                         distance -= speed;
//                     }
//                     System.out.println(this.getName() + " Still Driving with the same speed" + ". Distance left: " + distance + " meters" + ".Current Speed: " + speed);
//                 }
//             }
//             Thread.sleep(2000);
//         }
//         catch (InterruptedException e) {
//             System.out.println(name + " is interrupted");
//         }
//         endTime = System.currentTimeMillis();
//         timeTaken = endTime - startTime;
//     }
//     public long getStartTime() {
//         return startTime;
//     }
//     public long getEndTime() {
//         return endTime;
//     }
//     public long getTimeTaken() {
//         return timeTaken;
//     }
//     public int getRanking() {
//         return ranking;
//     }
//     public void setRanking(int ranking) {
//         this.ranking = ranking;
//     }
//     public void accelerate(int amount){
//         if (speed + amount <= 50) {
//             speed += amount;
//         }
//         else{
//             speed = 50;
//         }
//     }
//     public void decelerate(int amount) {
//         if (speed - amount >= 1) {
//             speed -= amount;
//         }
//         else{
//             speed = 1;
//         }
//     }
// }

// class Countdown extends Thread {
//     public void run() {
//         System.out.println("Get Ready");
//         for (int i = 10; i > 0; i--) {
//             System.out.println(i);
//             try {
//                 Thread.sleep(500);
//             }
//             catch (InterruptedException e) {
//                 System.out.println(e);
//             }
//         }
//         System.out.println("-----------------GO-----------------------");
//     }
// }

// public class RoadRashGame {
//     public static void main(String[] args) {
//         Countdown countdown = new Countdown();
//         Biker[] bikers = new Biker[10];
//         countdown.start();
//         try{
//             countdown.join();
//         }
//         catch (InterruptedException e) {
//             System.out.println(e);
//         }
//         for (int i = 0; i < 10; i++) {
//             String name = "BIKER " + (char)(i + 65);
//             bikers[i] = Biker.getBiker();
//             bikers[i].setName(name);
//             bikers[i].start();
//         }

//         try{
//             for (int i = 0; i < 10; i++) {
//                 bikers[i].join();
//             }
//         }
//         catch (InterruptedException e) {
//             System.out.println(e);
//         }
//         Rankings.rankBikers(bikers);
//         Rankings.printRankings(bikers);
//     }
// }
// >>>>>>> 23a7eb4eb63be3c80a16d5c54faf500f30394154
