import java.io.*;

public class RAFDemo {
    public static void main(String[] args) {
        try {
            /*
            RandomAccessFile raf = new RandomAccessFile("toRead.txt", "rw");
            raf.seek(50);
            System.out.println(raf.readLine());
            System.out.println(raf.readLine());

            // To append anything at the end use seek method to jump to the last 
            // before writing make sure the mode is "rw" or "rws" or "rwd"
            // rws stands for read , write, and sync
            // sync means that the file will be written to the disk immediately
            // rwd stands for read, write, and disk sync
            raf.seek(raf.length());
            raf.writeBytes("Append this line at the end of the file");
            raf.close(); */

            // PrintWriter pw1 = new PrintWriter("toWrite.txt");
            // pw1.println("Hello, World!");
            // pw1.println("This is a test.");
            // pw1.close();

            // Append to toRead.txt
            // new FileOutputStream must be used  to write to any destination
            // set append to true to append to the file else everything will be overwritten
            // PrintWriter pw = new PrintWriter(new FileOutputStream("toRead.txt", true));

            // // Writing in Terminal
            PrintWriter pw2 = new PrintWriter(System.out);
            pw2.println("Hello, World!");
            pw2.println("This is a test.");
            pw2.close();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
