import java.util.*;

class Student implements Comparable{ // Implemented Comparable interface as Student class is used in TreeSet and TreeSet requires elements to be comparable, thus override the compareTo() method.
    private int rollNo;
    private String name;
    private int standard;

    public Student(int rollNo, String name, int standard) {
        this.rollNo = rollNo;
        this.name = name;
        this.standard = standard;
    }
    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name + ", Standard: " + standard;
    }

    // To avoid duplicate objects override both equals() and hashCode() methods 
    // public boolean equals(Object obj) {
    //     Student student = (Student) obj;
    //     return this.rollNo == student.rollNo && this.standard == student.standard;
    // }
    // public int hashCode() {
    //     // this is for the searching purpose 
    //     // creates buckets based on the hash code
    //     // Use appropriate feature and not the primary key
    //     return standard;
    // }
    public int compareTo(Object obj) {
        Student student = (Student) obj;
        return this.rollNo - student.rollNo;
    }

}

public class StudentList {
    public static void main(String[] args) {
        // HashSet <Student> studentList = new HashSet<>();
        TreeSet <Student> studentList = new TreeSet<>();
        studentList.add(new Student(1, "John", 10));
        studentList.add(new Student(5, "Jane", 5));
        studentList.add (new Student(3, "Ron", 7));
        studentList.add(new Student(4, "Omkar", 6));

        // Adding a duplicate
        studentList.add(new Student(1, "John", 10));
        // It adds the  duplicate object as the object has different memory location 

        Iterator <Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
