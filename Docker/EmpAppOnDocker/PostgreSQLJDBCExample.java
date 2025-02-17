import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgreSQLJDBCExample {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Load the JDBC driver
            Class.forName("org.postgresql.Driver");

            // Establish the connection to the PostgreSQL container
            connection = DriverManager.getConnection(
                "jdbc:postgresql://my-postgres:5432/postgres", // Using container name as hostname
                "postgres", 
                "mysecretpassword");

            // Create a statement object
            statement = connection.createStatement();

            // Execute a query
            String query = "SELECT * FROM pg_catalog.pg_tables LIMIT 5";
            resultSet = statement.executeQuery(query);

            // Print the results
            while (resultSet.next()) {
                System.out.println("Table: " + resultSet.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
