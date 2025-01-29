// package ClassWork.Jan29;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransactionDemo {
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demodb", "postgres", "tiger");
            // To perform rollback and commit setAutoCommit(false) should be used
            conn.setAutoCommit(false);
            
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO employee VALUES (?, ?)");

            for(int i = 0; i < 10; i++) {
                System.out.println("Enter name: ");
                String name = br.readLine();

                System.out.println("Enter age: ");
                String age = br.readLine();
                pstmt.setString(1, name);
                pstmt.setInt(2, Integer.parseInt(age));
                pstmt.execute();
                if (i == 4){
                    conn.rollback();
                }
                if (i == 9){
                    conn.commit();
                }
            }
        }
        catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
