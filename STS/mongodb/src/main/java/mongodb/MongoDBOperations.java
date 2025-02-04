package mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.Updates;
import com.mongodb.client.FindIterable;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.*;



public class MongoDBOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Printing");
		MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
		
		MongoDatabase database = mongoClient.getDatabase("demodb");
		
		MongoCollection<Document> collection = database.getCollection("Employee");
		
//		Document doc = new Document();
//		doc.append("name" , "Raman");
//		doc.append("age", 24);
//		doc.append("salary", 45000);
//		doc.append("designation", "Programmer");
//		collection.insertOne(doc);
		
//		collection.insertOne(new Document().append("name" , "Dhiraj").append("age", 42).append("salary", 55000).append("designation", "Admin"));
		
//		List<Document> empList = new ArrayList<Document>();
//		empList.add(new Document().append("name" , "Sujal").append("age", 23).append("salary", 50000).append("designation", "Clerk"));
//		empList.add(new Document().append("name" , "Rohit").append("age", 24).append("salary", 75000).append("designation", "Programmer"));
//		empList.add(new Document().append("name" , "Sonal").append("age", 32).append("salary", 80000).append("designation", "Manager"));
//		collection.insertMany(empList);
		
		
//		Bson projection1 = Projections.excludeId();
//		Bson projection2 = Projections.exclude("_id", "salary", "age");
//		
		Bson filter = Filters.eq("designation", "Program");
//		
//		Bson asort = Sorts.ascending("salary");
//		Bson dsort = Sorts.descending("age");
//		
		FindIterable<Document> i = collection.find(filter);//.projection(projection1).sort(dsort);
		for (Document d : i) {
			System.out.println(d.toJson());
		}
		
		
		
//		Bson filter = Filters.gt("age", 30);
//		Bson update = Updates.set("designation", "Manager");
//		collection.updateOne(filter, update);
//		System.out.println("Successfully did the operation on Mongo DB....");
		
		
		
//		Bson filter = Filters.eq("name", "Rohit");
//		collection.deleteOne(filter);
		
		
//		
//		FindIterable<Document> i = collection.find();
//		for (Document d : i) {
//			System.out.println(d.toJson());
//		}
		mongoClient.close();
		
	}

}
