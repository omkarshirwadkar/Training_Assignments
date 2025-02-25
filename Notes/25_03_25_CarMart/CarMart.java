import java.sql.*;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.*;
import java.io.*;


class CarDBOperations{
    public static void addCar(BufferedReader br, JdbcRowSet rs){
        try{
            System.out.println("Enter car company");
            String company = br.readLine();
            System.out.println("Enter car model year");
            int year = Integer.parseInt(br.readLine());
            System.out.println("Enter number of seats in the car");
            int seats = Integer.parseInt(br.readLine());
            System.out.println("Enter Fuel type");
            String fuel = br.readLine();
            System.out.println("Enter Car Type");
            String type = br.readLine();
            System.out.println("Enter Car Price");
            int price = Integer.parseInt(br.readLine());
            System.out.println("Enter Car Status:");
            System.out.println("0. Not Sold");
            System.out.println("1. Sold");
            boolean sold = false;
            if (Integer.parseInt(br.readLine()) == 1){
                sold = true;
            }
            rs.setCommand("INSERT INTO car (company, model, seater, fuel_type, car_type, price, sold) VALUES (?, ?, ?, ?, ?, ?, ?)");
            rs.setString(1, company);
            rs.setInt(2, year);
            rs.setInt(3, seats);
            rs.setString(4, fuel);
            rs.setString(5, type);
            rs.setInt(6, price);
            rs.setBoolean(7, sold);
            rs.execute();
            System.out.println("Car added successfully");
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static boolean searchAllUnsoldCars(JdbcRowSet rs){
        try{
            rs.setCommand("SELECT * FROM car WHERE sold = false");
            rs.execute();
            int count = 0;
            while(rs.next()){
                System.out.println("Car ID: " + rs.getInt("car_id"));
                System.out.println("Car Company: " + rs.getString("company"));
                System.out.println("Car Model Year: " + rs.getInt("model"));
                System.out.println("Number of seats in the car: " + rs.getInt("seater"));
                System.out.println("Fuel type: " + rs.getString("fuel_type"));
                System.out.println("Car Type: " + rs.getString("car_type"));
                System.out.println("Car Price: " + rs.getInt("price"));
                System.out.println("Car Status: Not Sold");
                count++;
            }
            if (count == 0){
                System.out.println("No cars found");
                return false;
            }
            return true;
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
    public static boolean searchCompanyCars(JdbcRowSet rs, BufferedReader br){
        try{
            rs.setCommand("SELECT * FROM car WHERE company = ?");
            System.out.print("Enter Company Name: ");
            String company = br.readLine();
            rs.setString( 1, company);
            rs.execute();
            int count = 0;
            while(rs.next()){
                System.out.println("Car ID: " + rs.getInt("car_id"));
                System.out.println("Car Company: " + rs.getString("company"));
                System.out.println("Car Model Year: " + rs.getInt("model"));
                System.out.println("Number of seats in the car: " + rs.getInt("seater"));
                System.out.println("Fuel type: " + rs.getString("fuel_type"));
                System.out.println("Car Type: " + rs.getString("car_type"));
                System.out.println("Car Price: " + rs.getInt("price"));
                System.out.println("Car Status: Not Sold");
                count++;
            }
            if (count == 0){
                System.out.println("No cars found");
                return false;
            }
            return true;
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
    public static boolean searchTypeCars(JdbcRowSet rs, BufferedReader br){
        try{
            rs.setCommand( "SELECT * FROM car WHERE car_type = ?");
            System.out.print("Enter Car Type: ");
            String carType = br.readLine();
            rs.setString( 1, carType);
            rs.execute();
            int count = 0;
            while(rs.next()){
                System.out.println("Car ID: " + rs.getInt("car_id"));
                System.out.println("Car Company: " + rs.getString("company"));
                System.out.println("Car Model Year: " + rs.getInt("model"));
                System.out.println("Number of seats in the car: " + rs.getInt("seater"));
                System.out.println("Fuel type: " + rs.getString("fuel_type"));
                System.out.println("Car Type: " + rs.getString("car_type"));
                System.out.println("Car Price: " + rs.getInt("price"));
                System.out.println("Car Status: Not Sold");
                count++;
            }
            if (count == 0){
                System.out.println("No cars found");
                return false;
            }
            return true;
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
    public static boolean searchCars(JdbcRowSet rs){
        try{
            rs.execute();
            int count = 0;
            while(rs.next()){
                System.out.println("Car ID: " + rs.getInt("car_id"));
                System.out.println("Car Company: " + rs.getString("company"));
                System.out.println("Car Model Year: " + rs.getInt("model"));
                System.out.println("Number of seats in the car: " + rs.getInt("seater"));
                System.out.println("Fuel type: " + rs.getString("fuel_type"));
                System.out.println("Car Type: " + rs.getString("car_type"));
                System.out.println("Car Price: " + rs.getInt("price"));
                System.out.println("Car Status: Not Sold");
                count++;
            }
            if (count == 0){
                System.out.println("No cars found");
                return false;
            }
            return true;
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
    public static boolean searchPriceRangeCars(JdbcRowSet rs, BufferedReader br){
        try{
            rs.setCommand( "SELECT * FROM car WHERE price BETWEEN ? AND ?");
            System.out.print("Enter Min Price: ");
            int minPrice = Integer.parseInt(br.readLine());
            System.out.print("Enter Max Price: ");
            int maxPrice = Integer.parseInt(br.readLine());
            rs.setInt( 1, minPrice);
            rs.setInt( 2, maxPrice);
            rs.execute();
            int count = 0;
            while(rs.next()){
                System.out.println("Car ID: " + rs.getInt("car_id"));
                System.out.println("Car Company: " + rs.getString("company"));
                System.out.println("Car Model Year: " + rs.getInt("model"));
                System.out.println("Number of seats in the car: " + rs.getInt("seater"));
                System.out.println("Fuel type: " + rs.getString("fuel_type"));
                System.out.println("Car Type: " + rs.getString("car_type"));
                System.out.println("Car Price: " + rs.getInt("price"));
                System.out.println("Car Status: Not Sold");
                count++;
            }
            if (count == 0){
                System.out.println("No cars found");
                return false;
            }
            return true;
        }
        catch(Exception e){
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}
public class CarMart{
    public static void main(String[] args) {
        try{
            JdbcRowSet rs = RowSetProvider.newFactory().createJdbcRowSet();
            rs.setUrl("jdbc:postgresql://localhost:5432/cardb");
            rs.setUsername("postgres");
            rs.setPassword("tiger");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int ch1 = 0;
            do{
                // Main menu
                System.out.println("Welcome to CarMart!");
                System.out.println("1. Add");
                System.out.println("2. Search");
                System.out.println("3. Update");
                System.out.println("4. Sold");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                ch1 = Integer.parseInt(br.readLine());
                switch (ch1) {
                    case 1:
                    CarDBOperations.addCar(br, rs);
                    break;

                    case 2:
                    int ch2 = 0;
                    do{
                        System.out.println("Search Sub Menu");
                        System.out.println("1. All Unsold Cars");
                        System.out.println("2. Company");
                        System.out.println("3. Type");
                        System.out.println("4. Price Range");
                        System.out.println("5. Exit");
                        System.out.println("Enter your choice: ");
                        ch2 = Integer.parseInt(br.readLine());
                        switch (ch2) {
                            case 1:
                            
                            CarDBOperations.searchAllUnsoldCars(rs);
                            break;

                            case 2:
                            CarDBOperations.searchCompanyCars(rs, br);
                            break;

                            case 3:
                            CarDBOperations.searchTypeCars(rs, br);
                            break;

                            case 4:
                            
                            CarDBOperations.searchPriceRangeCars(rs, br);
                            break;

                        }

                    }while(ch2 != 5);
                    break;

                    case 3:
                    boolean carFound = false;
                    int carID = -1;
                    do{
                        System.out.println("Enter Car ID: ");
                        carID = Integer.parseInt(br.readLine());
                        rs.setCommand("SELECT * FROM car WHERE car_id = " + carID);
                        carFound = CarDBOperations.searchCars(rs);
                    }while(carFound == false);
                    System.out.println("Enter new Price : ");
                    int newPrice = Integer.parseInt(br.readLine());
                    rs.setCommand(" UPDATE car SET price = ? WHERE car_id = ?");
                    rs.setInt(1, newPrice);
                    rs.setInt(2, carID);
                    rs.execute();
                    System.out.println("Car Price Updated Successfully");
                    break;

                    case 4:
                    int ch3 = 0;
                    do{
                        System.out.println("1. All");
                        System.out.println("2. Update");
                        System.out.println("3. Exit");
                        System.out.print("Enter Choice: ");
                        ch3 = Integer.parseInt(br.readLine());
                        switch(ch3){
                            case 1:
                            rs.setCommand("SELECT * FROM car WHERE sold = true");
                            CarDBOperations.searchCars(rs);
                            break;

                            case 2:
                            System.out.print("Enter Car ID: ");
                            int carID2 = Integer.parseInt(br.readLine());
                            rs.setCommand("UPDATE car SET sold = ? WHERE car_id = ?");
                            rs.setBoolean(1, true);
                            rs.setInt(2, carID2);
                            rs.execute();
                            break;
                        }
                    }while(ch3 != 3);
                }
            }while(ch1 != 5);
            br.close();
            rs.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}