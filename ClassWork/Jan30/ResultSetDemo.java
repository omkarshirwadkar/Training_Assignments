import java.sql.*;

public class ResultSetDemo {
    public static void main(String[] args) throws Exception{
        // ResultSet is by default forward only and read only
        // Can only read from ResultSet , cannot write to it
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demodb", "postgres", "tiger"); 

        // default is stated as follows
        // Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);


        // We have to specify the query to be executed
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        
        ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
        System.out.println("ResultSet is forward only:");

        while (rs.next()){
            System.out.println(rs.getString(1) + " " + rs.getString(2));
        }
        System.out.println("Printing reverse:");
        while (rs.previous()){
            System.out.println(rs.getString(1) + " " + rs.getString(2));
        }
        System.out.println("-----------------------------");
        // absolute is always from the beginning of the ResultSet
        System.out.println("Absolute position:");
        rs.absolute(3);
        System.out.println(rs.getString(1) + " " + rs.getString(2));

        // relative is always from the current position of the ResultSet
        System.out.println("Relative position:");
        rs.relative(2);
        System.out.println(rs.getString(1) + " " + rs.getString(2));

        // last is always from the end of the ResultSet
        System.out.println("Last position:");
        rs.last();
        System.out.println(rs.getString(1) + " " + rs.getString(2));

        // beforeFirst is always from the beginning of the ResultSet
        System.out.println("Before first position:");
        rs.beforeFirst();
        System.out.println(rs.getString(1) + " " + rs.getString(2));

        // afterLast is always from the end of the ResultSet
        System.out.println("After last position:");
        rs.afterLast();
        System.out.println("ResultSet is closed:");

        // for every above mentioned method we have is method to check if we are at that position
        rs.close();
    }
}
