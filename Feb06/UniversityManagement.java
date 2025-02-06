import java.io.*;
import java.util.*;
import java.util.stream.*;


class Fees{
    private int totalFees;
    private int feesPaid;
    private int feesPending;
    public Fees(int totalFees, int feesPaid, int feesPending){
        this.totalFees = totalFees;
        this.feesPaid = feesPaid;
        this.feesPending = feesPending;
    }
    public int getTotalFees(){
        return totalFees;
    }
    public int getFeesPaid(){
        return feesPaid;
    }
    public int getFeesPending(){
        return feesPending;
    }
}
class Student{
    private int rollNo;
    private String name;
    private int age;
    private int standard;
    private String school;
    private String gender;
    private double percentage;
    private Fees fees;
    public Student(int rollNo, String name, int age, int standard, String school, String gender, double percentage, int fees) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.standard = standard;
        this.school = school;
        this.gender = gender;
        this.percentage = percentage;
        this.fees = new Fees(standard * 1000, Math.min(fees, standard * 1000), Math.max(0, standard * 1000 - fees));
    }
    public String toString(){
        return "--------------------------------\nRoll No: " + rollNo + "\nName: " + name + "\nAge: " + age + "\nStandard: " + standard + "\nSchool: " + school + "\nGender: " + gender + "\nPercentage: " +  percentage + "\nTotal Fees: " + fees.getTotalFees() + "\nFees Paid: " + fees.getFeesPaid() + "\nFees Pending: " + fees.getFeesPending() + "\n--------------------------------";
    }
    public int getRollNo() {
        return rollNo;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getStandard() {
        return standard;
    }
    public String getSchool() {
        return school;
    }
    public String getGender() {
        return gender;
    }
    public double getPercentage() {
        return percentage;
    }
    public int getPaidFees() {
        return fees.getFeesPaid();
    }
    public int getPendingFees() {
        return fees.getFeesPending();
    }
    public int getTotalFees() {
        return fees.getTotalFees();
    }
}

class StudentList{
    public static List<Student> loadStudents(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(2021600021, "Rahul Punia", 10, 5, " St. Xavier's", "Male", 97.0, 3000));
        studentList.add(new Student(2021200015, "Sarvesh Birla", 18, 10, "St. Lawrence High School", "Male", 93, 8000));
        studentList.add(new Student(2021200016, "Priya Sharma", 17, 7, "St. Xavier's", "Female", 33, 7000));
        studentList.add(new Student(2021200017, "Rahul Verma", 16, 5, "DPS Delhi", "Male", 85, 6000));
        studentList.add(new Student(2021200018, "Ananya Sen", 15, 3, "Modern School", "Female", 29, 5000));
        studentList.add(new Student(2021200019, "Amit Gupta", 18, 12,"Springfield Academy",  "Male", 88, 12000));
        studentList.add(new Student(2021200020, "Neha Yadav", 17, 11,"St. Lawrence High School",  "Female", 92, 11000));
        studentList.add(new Student(2021200021, "Rohit Das", 16,11, "St. Xavier's",  "Male", 39, 9000));
        studentList.add(new Student(2021200022, "Kavita Nair", 15, 9,"DPS Delhi",  "Female", 90, 8000));
        studentList.add(new Student(2021200023, "Sameer Khan", 14, 8,"Modern School",  "Male", 87, 7000));
        studentList.add(new Student(2021200024, "Rina Bose", 18,12, "Springfield Academy",  "Female", 94, 12000));
        studentList.add(new Student(2021200025, "Arjun Mehta", 17, 11,"St. Lawrence High School",  "Male", 89, 11000));
        studentList.add(new Student(2021200026, "Sneha Iyer", 16,10, "St. Xavier's",  "Female", 85, 9000));
        studentList.add(new Student(2021200027, "Vikram Chauhan", 15, 9,"DPS Delhi",  "Male", 88, 8000));
        studentList.add(new Student(2021200028, "Ritika Singh", 14, 8,"Modern School",  "Female", 91, 7000));
        studentList.add(new Student(2021200029, "Aditya Roy", 18, 12,"Springfield Academy",  "Male", 93, 12000));
        studentList.add(new Student(2021200030, "Madhavi Joshi", 17,11, "St. Lawrence High School",  "Female", 90, 11000));
        studentList.add(new Student(2021200031, "Karan Malhotra", 16,10, "St. Xavier's",  "Male", 88, 9000));
        studentList.add(new Student(2021200032, "Rhea Kapoor", 15, 9,"DPS Delhi",  "Female", 87, 8000));
        studentList.add(new Student(2021200033, "Aayush Singh", 14, 8,"Modern School",  "Male", 85, 7000));
        studentList.add(new Student(2021200034, "Nisha Patil", 18, 12,"Springfield Academy",  "Female", 93, 12000));
        studentList.add(new Student(2021200035, "Varun Sharma", 17, 11,"St. Lawrence High School",  "Male", 89, 11000));
        studentList.add(new Student(2021200036, "Harsh Tiwari", 16, 10,"St. Xavier's",  "Male", 87, 8500));
        studentList.add(new Student(2021200037, "Pooja Mishra", 15,9, "DPS Delhi",  "Female", 92, 7500));
        studentList.add(new Student(2021200038, "Nitin Sharma", 14, 8,"Modern School",  "Male", 84, 6500));
        studentList.add(new Student(2021200039, "Megha Patel", 18, 12,"Springfield Academy",  "Female", 90, 9500));
        studentList.add(new Student(2021200040, "Ravi Kumar", 17, 11,"St. Lawrence High School",  "Male", 85, 10500));
        studentList.add(new Student(2021200041, "Divya Malhotra", 16, 10,"St. Xavier's",  "Female", 91, 9500));
        studentList.add(new Student(2021200042, "Siddharth Jain", 15, 9,"DPS Delhi",  "Male", 89, 7800));
        studentList.add(new Student(2021200043, "Tanya Rao", 14, 8,"Modern School",  "Female", 86, 7200));
        studentList.add(new Student(2021200044, "Aakash Bhatia", 18, 12,"Springfield Academy",  "Male", 94, 10000));
        studentList.add(new Student(2021200045, "Shreya Kapoor", 17, 11,"St. Lawrence High School",  "Female", 89, 11000));

        return studentList;
    }
}
class StudentCalculations{

}
/*How many students in each standard
How many students are male and female
How many students have failed and passed(40%)
    --> Whole University
    --> School Wise
Top 3 students
Top Scorer School wise
average age of mail and female students
Total fees collected school wise
Total fees pending school wise
Total no of students in the University */
public class UniversityManagement {
    public static void main(String[] args) {
        try{
            List<Student> students = StudentList.loadStudents();
            System.out.println("University Management System");
            int choice = 0;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            do{
                System.out.println("1. How many students in each standard?");
                System.out.println("2. How many students are male and female?");
                System.out.println("3. How many students have failed and passed?(Passing Criteria: 40%)");
                System.out.println("4. Top 3 students");
                System.out.println("5. Top Scorer school wise");
                System.out.println("6. Average age of male and female students");
                System.out.println("7. Total fees collected school wise");
                System.out.println("8. Total fees pending school wise");
                System.out.println("9. Total no of students in the University");
                System.out.println("10. Exit");
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(br.readLine());
                switch(choice){
                    case 1 -> {
                        Map<Integer, Long> m1= students.stream().collect(Collectors.groupingBy(s -> s.getStandard(), Collectors.counting()));
                        System.out.println(m1);
                    }

                    case 2 -> {
                        Map<String, Long> m1 = students.stream().collect(Collectors.groupingBy(s -> s.getGender(), Collectors.counting()));
                        System.out.println(m1);
                    }
                    case 3 -> {
                        System.out.println("1. On University Level");
                        System.out.println("2. On School Level");
                        int choice2 = Integer.parseInt(br.readLine());
                        
                        switch (choice2) {
                            case 1 -> {
                                // Students passed on University level
                                Map<Boolean, Long> m1 = students.stream().collect(Collectors.partitioningBy(e -> e.getPercentage() >= 40,Collectors.counting()));
                                System.out.println(m1);
                            }
                            case 2 -> {
                                // Students passed on School level
                                Map<String, Map<Boolean, Long>> m1 = students.stream().collect(Collectors.groupingBy(s -> s.getSchool(), Collectors.groupingBy(s -> s.getPercentage() >= 40, Collectors.counting())));
                                System.out.println(m1);
                            }
                        }
                        
                    }
                    case 4 -> {
                        students.stream().sorted(Comparator.comparing(Student::getPercentage).reversed()).limit(3).forEach(System.out::println);
                    }
                    case 5 -> 
                    {
                        Map<Object, Optional<Student>> m1 = students.stream().collect(Collectors.groupingBy(s -> s.getSchool(), Collectors.maxBy(Comparator.comparing(Student::getPercentage))));
                        System.out.println(m1);
                    }
                    case 6 -> {
                        Map<String, Double> m1 = students.stream().collect(Collectors.groupingBy(s -> s.getGender(), Collectors.averagingDouble(Student::getAge)));
                        System.out.println(m1);
                    }
                    case 7 -> {
                        Map<Object, Double> m1 = students.stream().collect(Collectors.groupingBy(s -> s.getSchool(), Collectors.summingDouble(Student::getPaidFees)));
                        System.out.println(m1);
                    }
                    case 8 -> {
                        Map<Object, Double> m1 = students.stream().collect(Collectors.groupingBy(s -> s.getSchool(), Collectors.summingDouble(Student::getPendingFees)));
                        System.out.println(m1);
                    }
                    case 9 -> {
                        System.out.println(students.size());
                    }
                }
            }while(choice != 10);
        }
        catch( Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
