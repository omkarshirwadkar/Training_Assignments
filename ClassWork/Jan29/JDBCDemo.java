import java.io.*;
import java.sql.*;

public class JDBCDemo{
    public static void main(String[] args) {
        try{
            // // Load the JDBC driver
            // // Class.forName("org.postgresql.Driver");

            // // Create a connection
            // // protocol:database:port/database_name
            // Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demodb", "postgres", "tiger");

            // // Create a statement
            // Statement stmt = conn.createStatement();

            // // Execute a query
            // // stmt.executeUpdate("INSERT INTO employee VALUES('Dhirendra', 21)");
            // // stmt.executeUpdate("DELETE FROM employee WHERE name='Raju'");
            // ResultSet rs = stmt.executeQuery("SELECT * FROM employee");

            // // Process the results
            // while (rs.next()) {
            //     System.out.println(rs); // displays the object
            //     System.out.println(rs.getString(1) + " " + rs.getInt(2));
            // }

            // // Close the resources
            // rs.close();

            // // Close the statement
            // stmt.close();

            // // Close the connection
            // conn.close();

            // System.out.println("Data inserted successfully");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demodb", "postgres", "tiger");
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO employee VALUES (?, ?)");

            for(int i = 0; i < 5; i++) {
                System.out.println("Enter name: ");
                String name = br.readLine();

                System.out.println("Enter age: ");
                String age = br.readLine();
                pstmt.setString(1, name);
                pstmt.setInt(2, Integer.parseInt(age));
                pstmt.execute();
            }
            // System.out.println("Enter name:");
            // String name = br.readLine();

            // System.out.println("Enter age:");
            // int age = Integer.parseInt(br.readLine());

            // pstmt.setString(1, name);
            // pstmt.setInt(2, age);
            // executeUpdate(): if you want to know how many rows were affected
            // execute(): if you want to know the result set
            // pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}