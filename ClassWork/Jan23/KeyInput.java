import java.io.BufferedReader;
import java.io.InputStreamReader;
public class KeyInput {
    public static void main(String[] args) {
        try{
            // System.in is used to take Byte Input from keyboard
            // InputStreamReader is used to convert the byte stream into character stream
            // BufferedReader is used to read the character stream
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Your Name: ");
            // readLine() is used to read a line of text from the user
            String name = br.readLine();
            System.out.println("Hello " + name);

            System.out.println("Enter Your Age: ");
            // read() is used to read a single character from the user
            // int age = br.read();
            // To get Integer we have to use Integer.parseInt() method
            int age = Integer.parseInt(br.readLine());
            System.out.println("Your Age after 10 years will be: " + (age + 10));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}