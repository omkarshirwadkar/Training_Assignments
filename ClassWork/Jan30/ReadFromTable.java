import java.io.*;
import java.sql.*;

public class ReadFromTable {
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the table name:");
            String tableName = br.readLine();
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demodb", "postgres", "tiger"); 
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.println(metaData.getColumnName(i).toUpperCase() + " : " + rs.getString(i));
                }

                // Tedious task and cant be the same for all tables
                // System.out.println("EID " + rs.getInt(1));
                // System.out.println("Name " + rs.getString(2));
                // System.out.println("Age " + rs.getInt(3));
                // System.out.println("Salary " + rs.getDouble(4));
                // System.out.println("Designation " + rs.getString(5));
            }
            // metaData.close();
            rs.close();
            stmt.close();
            conn.close();
            br.close();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
