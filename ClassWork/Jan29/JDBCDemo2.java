// package ClassWork.Jan29;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCDemo2 {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demodb", "postgres", "tiger");
            CallableStatement cs = conn.prepareCall("CALL dummy_record()");
            cs.execute();
            cs.close();
            conn.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
