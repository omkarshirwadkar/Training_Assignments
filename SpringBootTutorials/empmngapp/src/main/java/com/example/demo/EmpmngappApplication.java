package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EmpmngappApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(EmpmngappApplication.class, args);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Employee> empList = new ArrayList<Employee>();
        int ch1 = 0, ch2 = 0, ch3 = 0;
        try {
        	do{
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
                switch(ch1){
                    case 1:
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
                        Employee emp = null;
                        switch(ch2){
                            case 1 : {
                                emp = (Employee) ctx.getBean("newemp", "Clerk"); 
                                empList.add(emp);
                                break;
                            }

                            case 2 : {
                                emp = (Employee) ctx.getBean("newemp", "Manager"); 
                                empList.add(emp);
                                break;
                            }
                            
                            case 3 : {
                                emp = (Employee) ctx.getBean("newemp", "Programmer"); 
                                empList.add(emp);
                                break;
                            }
                            
                            case 4 : {
                                System.out.println("Enter designation");
                                String designation = br.readLine();
                                emp = (Employee) ctx.getBean("newemp", designation); 
                                empList.add(emp);
                                break;
                            }
                        }
                    }while(ch2 != 5);
                    break;

                    case 2:
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Employee List");
                    System.out.println("------------------------------------------------------------");
                    for(int i=0;i<empList.size();i++){
                        System.out.println((i+1)+". Name : "+empList.get(i).getName());
                        System.out.println("Age : "+empList.get(i).getAge());
                        System.out.println("Salary : "+empList.get(i).getSalary());
                        System.out.println("Designation : "+empList.get(i).getDesignation());
                    }
                    break;

                    case 3:
                    System.out.println("Enter Employee name");
                    String name = br.readLine();
                    System.out.println("Enter amount to be raised(positive) or to be deducted(negative)");
                    int amount = Integer.parseInt(br.readLine());
                    boolean found = false;
                    for(int i=0;i<empList.size();i++){
                        if(empList.get(i).getName().equals(name)){
                            empList.get(i).setSalary(empList.get(i).getSalary()+amount);
                            System.out.println("Salary of "+name+" has been updated");
                            found = true;
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Employee not found");
                    }
                    break;

                    case 4:
                    System.out.println("Enter Name to Search");
                    String name1 = br.readLine();
                    boolean found1 = false;
                    for(int i=0;i<empList.size();i++){
                        if(empList.get(i).getName().equals(name1)){
                            System.out.println("Name : "+empList.get(i).getName());
                            System.out.println("Age : "+empList.get(i).getAge());
                            System.out.println("Salary : "+empList.get(i).getSalary());
                            System.out.println("Designation : "+empList.get(i).getDesignation());
                            found1 = true;
                            break;
                        }
                    }
                    if(!found1){
                        System.out.println("Employee not found");
                    }
                    break;
                    
                    case 5:
                    System.out.println("Enter Name to Delete");
                    String name2 = br.readLine();
                    boolean found2 = false;
                    for(int i=0;i<empList.size();i++){
                        if(empList.get(i).getName().equals(name2)){
                            empList.remove(i);
                            System.out.println("Employee "+name2+" has been deleted");
                            found2 = true;
                            break;
                        }
                    }
                    if(!found2){
                        System.out.println("Employee not found");
                    }
                    break;
                }
            }while (ch1 != 6);
            br.close();
        }
        catch(Exception e) {
        	System.out.println(e.getMessage());
        }
	}
}
