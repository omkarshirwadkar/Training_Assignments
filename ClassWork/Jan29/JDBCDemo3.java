import java.sql.*;

public class JDBCDemo3 {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demodb", "postgres", "tiger");
            Statement stmt = conn.createStatement();
            stmt.addBatch("INSERT INTO employee values ('Kiran', 42)");
            stmt.addBatch("INSERT INTO employee values ('Rahul', 32)");
            stmt.addBatch("INSERT INTO employee values ('Sonali', 20)");
            stmt.addBatch( "INSERT INTO employee values ('Darshit', 19)");
            System.out.println("Wait for 20 seconds to see the batch execution....");
            Thread.sleep(20000);
            stmt.executeBatch();
            System.out.println("Batch execution completed");
            stmt.close();
            conn.close();
        }
        catch (Exception e) {
            System.out.println("Driver Not Loaded");
        }
    }
}
