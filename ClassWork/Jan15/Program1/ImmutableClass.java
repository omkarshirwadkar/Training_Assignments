package ClassWork.Jan15.Program1;
import java.io.Serializable;

final class BigStudentClass implements Serializable{
    private final String name;
    private final int rollNo;
    private final int standard;
    public BigStudentClass(String name, int rollNo, int standard) {
        this.name = name;
        this.rollNo = rollNo;
        this.standard = standard;
    }

    public String getName() {
        return name;
    }
    public int getRollNo() {
        return rollNo;
    }
    public int getStandard() {
        return standard;
    }

    public String toString() {
        return "Student [name=" + name + ", rollNo=" + rollNo + ", standard =" + standard + "]";
    }
    public int hashCode() {
        return 31 + rollNo + name.hashCode() + standard;
    }
    public boolean equals(Object obj) {
        BigStudentClass s1 = (BigStudentClass) obj;
        return (s1.rollNo == this.rollNo) && (s1.name.equals(this.name)) && (s1.standard == this.standard);
        //another way to do the above
        //if (this == obj)
    }
}

// Instead of doing the above we can do the following
// record Student(String name, int rollNo, int standard) {}


// If we want some changes in the above record then we can do the following
record Student( String name, int rollNo, int standard) {
    static String schoolName = "ABC";
    Student(){
        this("Rinku", 13, 1);
    }
    Student (String name, int rollNo, int standard) {
        this.name = name;
        this.rollNo = rollNo;
        this.standard = standard;
    }
}

public class ImmutableClass{
    public static void main(String[] args) {
        Student s1 = new Student("Rinku", 13, 10);
        Student s2 = new Student("Ravi", 11, 8);
        Student s3 = s1;

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());

        System.out.println(s1.equals(s2));


    }
}