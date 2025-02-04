import java.sql.*;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

class DBConnection {
	private static Connection con = null ; 
	private DBConnection()
	{
	}
	public static Connection getConnection()
	{
	  if(con==null)
	  {
	    try
	    {
	        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/empdb","postgres","tiger");
	    }
	    catch(Exception e)
	    {
	        System.out.println(e);
	    }
	  }
	  return con;
	}
	
	 public static void close()
	 {
	  try
	  {
	    con.close();
	  }
	  catch(Exception e)
	  {
	    System.out.println(e);
	  }
	 }
}

public class EmpAppManagement {
   public static void main(String[] args) {
	   
	  
	   String query = "SELECT emp_info FROM emp_json ";
	   String query2= "INSERT INTO emp_json(emp_info) values (?::json)";
	   try(
			   Connection con = DBConnection.getConnection();
				  PreparedStatement pstmt = con.prepareStatement(query);
			   PreparedStatement pstmt2 = con.prepareStatement(query2);
	    ) {
		  
		   ResultSet rs =pstmt.executeQuery();
		   JSONObject temp =null;
		   JSONParser parser = new JSONParser();
		   while(rs.next()) 
		   {
			   
			   String jsonString = rs.getString("emp_info");
	           JSONObject jsonObject = (JSONObject) parser.parse(jsonString);
	
	           // Extract values
	           String name = (String) jsonObject.get("name");
	           long age = (long) jsonObject.get("age");
	           String designation = (String) jsonObject.get("designation");
	           long salary = (long) jsonObject.get("salary");
	
	           // Print JSON data
	           System.out.println("-------------------------------------------------");
	           System.out.println("Name: " + name);
	           System.out.println("Age: " + age);
	           System.out.println("Designation: " + designation);
	           System.out.println("Salary: " + salary);
	           System.out.println("-------------------------------------------------");
		   }
		   JSONObject employee = new JSONObject();
	       employee.put("name", "Omkar Shirwadkar");
	       employee.put("age", 21);
	       employee.put("designation", "Software Engineer");
	       employee.put("salary", 45000);
		  
	       String jsonString = employee.toJSONString();
	       pstmt2.setString(1, jsonString);
		   pstmt2.executeUpdate();
	   }
	   catch(Exception e) {
		   System.out.println(e);
	   }
	   finally{
		  DBConnection.close(); 
	   }
   }
}
