package Jan17;

class Biker extends Thread{
    private int speed;
    private float startTime;
    private float endTime;
    public Biker() {
        speed = 0;
    }
    public void run(){
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getSpeed() {
        return speed;
    }

    public void accelerate(int amount) {
        speed += amount;
    }

    public void brake( int amount) {
        if (speed - amount >= 0) {
            speed -= amount;
        }
        else{
            speed = 0;
        }
    }
}

class CountDown extends Thread{
    public void run() {
        for(int i = 10; i >= 0; i--) {
            System.out.println("--------------" + i + "--------------");
        }
        System.out.println("-----------GOOOOO----------------");
    }
}

public class BikeGame {
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("BikeGroup");
        Thread biker[] = new Thread[10];
        for (int i = 0; i < 10; i++) {
            biker[i] = new Thread(group, new Biker());
            biker[i].setName((i + 1) + " ator");
        }
        CountDown countdown = new CountDown();
        countdown.start();
        for (int i = 0; i < 10; i++) {
            biker[i].start();
        }
    }
}
