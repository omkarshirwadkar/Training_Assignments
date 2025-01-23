import java.io.*;

public class IODemo {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter file name: ");
            String filename = br.readLine();
            File file = new File(filename);
            if(file.exists()){
                System.out.println("File exists");
                BufferedReader fr = new BufferedReader(new FileReader(file));
                // readLine() reads the entire line but if there are more than 1 line we will have to use a loop
                String line = "";
                while((line = fr.readLine()) != null){
                    System.out.println("Size of line: " + line.length());
                    System.out.println(line);

                }
                fr.close();
            }
            else{
                System.out.println("File does not exist");
            }
            br.close();
        }
        catch (Exception e){
            System.out.println("Error");
        }
    }    
}
