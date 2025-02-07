class Shared{
    static int sharedVar = 0;
}
class IncThread extends Thread {
    String name;
    public IncThread(String name) {
        this.name = name;
        new Thread(this).start();
    }
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + " is incrementing" + ++Shared.sharedVar);
        }
    }
}

public class ThreadRandom {
    public static void main(String[] args) {
        new IncThread("Ramesh");
        new IncThread("Suresh");
        new IncThread("Rajesh");
    }
}
