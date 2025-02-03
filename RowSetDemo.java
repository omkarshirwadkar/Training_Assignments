// package Jan31;

import javax.sql.rowset.*;
import javax.sql.*;

public class RowSetDemo {
    public static void main(String[] args) {
        try{
            JdbcRowSet rs = RowSetProvider.newFactory().createJdbcRowSet();
            rs.setUrl("jdbc:postgresql://localhost:5432/demodb");
            rs.setUsername("postgres");
            rs.setPassword("tiger");

            // rs.setCommand("SELECT * FROM emp");
            // rs.execute();
            rs.addRowSetListener(new EmpListener());
            rs.addRowSetListener(new EmpListener2());
            rs.setCommand("SELECT * FROM emp");
            rs.execute();


            while (rs.next()){
                System.out.println("ID : " + rs.getInt("eid"));
                System.out.println("NAME : " + rs.getString("name"));
                System.out.println("SALARY : " + rs.getDouble("salary"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("DESIGNATION: " + rs.getString("designation"));
            }
            rs.close();

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class EmpListener implements RowSetListener {
    public void cursorMoved(RowSetEvent event) {
        System.out.println("-------------------Cursor Moved--------------------");
    }
    public void rowChanged(RowSetEvent event){
    }
    public void rowSetChanged(RowSetEvent event){
        System.out.println("----------------Row Set Changed-----------------");
    }
}

class EmpListener2 implements RowSetListener {
    public void cursorMoved(RowSetEvent event) {
        System.out.println("...........Cursor Moved.............");
    }
    public void rowChanged(RowSetEvent event){
    }
    public void rowSetChanged(RowSetEvent event){
        System.out.println("...........Row Set Changed..............");
    }
}