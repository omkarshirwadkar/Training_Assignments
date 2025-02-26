package ClassWork.Jan16.Program2;
// package ClassWork.trainingday8.Program2;

class Author{
    private static int authorCount = 0;
    private Author(){

    }
    public static Author getAuthor(){
        if (authorCount < 5){
            authorCount++;
            return new Author();
        }
        else {
            return null;
        }
    }
}

// Abstract Faactory Design
// Can create objects of subclasses at runtime
abstract class Vehicle{
    public static Vehicle getVehicle(String type){
        if (type.equals("car")){
            return new Car();
        }
        else if (type.equals("bike")){
            return new Bike();
        }
        else {
            return null;
        }

    }
}

class Car extends Vehicle{

}

class Bike extends Vehicle{

}

class Van extends Vehicle{

}

public class FactoryDesign {
    public static void main(String[] args) {
        Vehicle car = Vehicle.getVehicle("car");
        System.out.println(car);

    }
}
