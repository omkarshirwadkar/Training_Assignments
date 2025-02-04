import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;

import org.bson.Document;
import org.bson.conversions.Bson;

import java.io.*;
import java.util.*;

//interface UserDAO{
//    void createUser(MongoCollection<Document> collection, String designation, BufferedReader br);
////    void updateUser();
////    void deleteUser(int id);
//}

class DBOperations{
	public static void createUser(MongoCollection<Document> collection, String designation, BufferedReader br){
		try {
			System.out.println("Enter Employee ID");
			int eid = Integer.parseInt(br.readLine());
			if(collection.find(Filters.eq("eid", eid)).first() == null) {
				System.out.println("Enter Employee Name");
	            String name = br.readLine();
	            System.out.println("Enter Employee Age");
	            int age = Integer.parseInt(br.readLine());
	            System.out.println("Enter Employee Salary");
	            double salary = Double.parseDouble(br.readLine());
	            System.out.println("Enter Department");
	            String department = br.readLine();
	            collection.insertOne(new Document().append("eid", eid).append("name", name).append("age", age).append("salary", salary).append("designation", designation).append("department", department));
			}
			else {
				System.out.println("ID already exist");
			}
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void displayAllUser(MongoCollection<Document> collection,String type) {
		Bson sortBy = Sorts.ascending(type);
		FindIterable<Document> i = collection.find().sort(sortBy);
		for (Document d : i) {
			System.out.println(d.toJson());
		}
	}
	public static void searchUser(MongoCollection<Document> collection, BufferedReader br) {
		try {
			System.out.println("Enter Employee ID:");
			int eid = Integer.parseInt(br.readLine());
			if(collection.find(Filters.eq("eid", eid)).first() == null) {
				System.out.println("No Employee present for this ID:");
			}
			else {
				System.out.println(collection.find(Filters.eq("eid", eid)).first().toJson());
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void raiseSalary(MongoCollection<Document> collection, BufferedReader br) {
		try {
			System.out.println("Enter Employee ID:");
			int eid = Integer.parseInt(br.readLine());
			if(collection.find(Filters.eq("eid", eid)).first() == null) {
				System.out.println("No Employee present for this ID:");
			}
			else {
				System.out.println("Enter Amount:");
				int amount = Integer.parseInt(br.readLine());
				Bson filter = Filters.eq("eid", eid);
				Bson update = Updates.set("salary", collection.find(filter).first().getDouble("salary") + amount);
				collection.updateOne(filter,update);	
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void deleteUser(MongoCollection<Document> collection, BufferedReader br) {
		try {
			System.out.println("Enter Employee ID:");
			int eid = Integer.parseInt(br.readLine());
			if(collection.find(Filters.eq("eid", eid)).first() == null) {
				System.out.println("No Employee present for this ID:");
			}
			else {
				System.out.println(collection.find(Filters.eq("eid", eid)).first().toJson());
				System.out.println("Are you sure you want to delete this empployee");
				System.out.println("1. Yes");
				System.out.println("2. No");
				int ch = Integer.parseInt(br.readLine());
				if (ch == 1) {
					collection.deleteOne(Filters.eq("eid", eid));
				}
				else {
					System.out.println("User Not Deleted");
				}
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
public class EmpManageApp {

	public static void main(String[] args) {
		
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		
		MongoDatabase database = mongoClient.getDatabase("demodb");
		
		MongoCollection<Document> collection = database.getCollection("Emp");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int ch1 = 0;
	        do {
	        	System.out.println("----------------------------------------------------------");
	            System.out.println("1. Create");
	            System.out.println("2. Display");
	            System.out.println("3. Appraisal");
	            System.out.println("4. Search");
	            System.out.println("5. Remove");
	            System.out.println("6. Exit");
	            System.out.println("----------------------------------------------------------");
	            System.out.println("Enter your choice");
	            ch1 = Integer.parseInt(br.readLine());
	            switch(ch1) {
	            case 1:
	            	int ch2 = 0;
	            	do{
	            		System.out.println("------------------------------------------------------------");
                        System.out.println("1. Clerk");
                        System.out.println("2. Manager");
                        System.out.println("3. Programmer");
                        System.out.println("4. Other");
                        System.out.println("5. Exit");
                        System.out.println("------------------------------------------------------------");
                        System.out.println("Enter your choice");
                        ch2 = Integer.parseInt(br.readLine());
                        switch(ch2) {
                        case 1:
                        	DBOperations.createUser(collection, "Clerk", br);
                        	break;
                        case 2:
                        	DBOperations.createUser(collection, "Manager", br);
                        	break;
                        case 3:
                        	DBOperations.createUser(collection, "Programmer", br);
                        	break;
                        case 4:
                        	System.out.println("Enter Designation: ");
                        	String designation = br.readLine();
                        	DBOperations.createUser(collection, designation, br);
                        	break;
                        }
	            	}while(ch2 != 5);
	            	break;
	            case 2:
	            	System.out.println("-----------------------------------------------------------");
                    System.out.println("How do you want to display the employees?");
                    System.out.println("1. By ID");
                    System.out.println("2. By Name");
                    System.out.println("3. By Age");
                    System.out.println("4. By Salary");
                    System.out.println("5. By Designation");
                    System.out.println("6. By Department");
                    System.out.println("7. Exit");
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Enter your choice");
                    int ch3 = Integer.parseInt(br.readLine());
                    switch(ch3) {
                    case 1:
                    	DBOperations.displayAllUser(collection, "eid");
                    	break;
                    case 2:
                    	DBOperations.displayAllUser(collection, "name");
                    	break;
                    case 3:
                    	DBOperations.displayAllUser(collection, "age");
                    	break;
                    case 4:
                    	DBOperations.displayAllUser(collection, "salary");
                    	break;
                    case 5:
                    	DBOperations.displayAllUser(collection, "designation");
                    	break;
                    case 6:
                    	DBOperations.displayAllUser(collection, "department");
                    	break;
                    case 7:
                    	System.out.println("Not Displayed");
                    	break;
                    }
                    break;
	            case 3:
	            	// Appraisal
	            	DBOperations.raiseSalary(collection, br);
	            	break;
	            case 4:
	            	// Search
	            	DBOperations.searchUser(collection, br);
	            	break;
	            case 5:
	            	// Delete
	            	DBOperations.deleteUser(collection, br);
	            	break;
	            }
	        }while(ch1 != 6);
	        br.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		mongoClient.close();
	}

}
