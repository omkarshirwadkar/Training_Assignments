import java.util.*;

class Student {//implements Comparable{ // Implemented Comparable interface as Student class is used in TreeSet and TreeSet requires elements to be comparable, thus override the compareTo() method.
    public int rollNo;
    public String name;
    public int standard;

    public Student(int rollNo, String name, int standard){
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
        // return new Integer(rollNo).compareTo(student.rollNo);
        // if you want to reverse the order then
        // return student.rollNo - this.rollNo;
    }

}

class NameSorter implements Comparator<Student>{
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name);
    }
}

class RollNoSorter implements Comparator<Student>{
    public int compare(Student s1, Student s2) {
        return s1.rollNo - s2.rollNo;
        // return new Integer(s1.rollNo).compareTo(s2.rollNo);
    }
}

class StandardSorter implements Comparator<Student>{
    public int compare(Student s1, Student s2) {
        return s1.standard - s2.standard;
        // return new Integer(s1.standard).compareTo(s2.standard);
    }
}
public class StudentList {
    public static void main(String[] args) {
        // HashSet <Student> studentList = new HashSet<>();
        // If we are implementing the Comparable interface then override the compareTo() method
        // TreeSet <Student> studentList = new TreeSet<>();

        // If we are implementing the Comparator interface then override the compare() method and pass a new object of the Class in the TreeSet.
        TreeSet <Student> studentList = new TreeSet<>(new RollNoSorter());

        
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
