package ClassWork.Jan09.Afternoon;
// package Afternoon;

class Room{
    int length;
    int width;

    // Methods can have class name
    // void Room(){
    //     length = 10;
    //     width = 20;
    // }
    
    void displayArea(){
        int area = length * width;
        System.out.println("Area of room is " + area);
    }
}

public class RoomMain {
    public static void main(String[] args) {
        Room room = new Room();
        room.displayArea(); // --> Area of room is 0
    }
}
