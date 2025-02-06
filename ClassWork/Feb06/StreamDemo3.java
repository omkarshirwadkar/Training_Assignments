import java.util.*;
import java.util.stream.*;

class Emp{
    private String name;
    private int age;
    private int salary;
    private String designation;
    public Emp(String n, int a, int s, String d){
        name = n;
        age = a;
        salary = s;
        designation = d;
    }
    public String toString(){
        return " Name: " + name + "\nAge: " + age + "\nSalary: " + salary + "\nDesignation: " + designation ;
    }
    public int getAge(){
        return age;
    }
    public String getDesignation(){
        return designation;
    }
    public String getName(){
        return name;
    }
}
public class StreamDemo3 {
    public static void main(String[] args) {
        List<Emp> list = new ArrayList<Emp>();
        list.add(new Emp("Omkar", 21, 149000, "Programmer"));
        list.add(new Emp("Sahil", 31 ,39000, "Tester"));
        list.add(new Emp("Ravi", 30, 19000, "Tester"));
        list.add(new Emp("Sonal", 41, 149000, "Programmer"));
        list.add(new Emp("Aditi", 35, 29000, "Tester"));
        list.add(new Emp("Priya", 18, 42000, "Tester"));
        list.add(new Emp("Kamal", 19, 75000, "Programmer"));
        list.add(new Emp("Anish", 25, 144000, "Manager"));
        list.add(new Emp("Dhruv", 55, 55000, "Programmer"));
        list.add(new Emp("Chirag", 46, 49000, "Programmer"));
        list.add(new Emp("Sakshi", 35, 149000, "Manager"));
        list.add(new Emp("Sanika", 51, 159000, "Manager"));
        list.add(new Emp("Sujata", 44, 179000, "Manager"));

        Map<Boolean, List<Emp>> m1 = list.stream().collect(Collectors.partitioningBy(e -> e.getAge() < 30));
        System.out.println("---------Junior Employees----------------");
        System.out.println(m1.get(true));
        System.out.println("---------Senior Employees----------------");
        System.out.println(m1.get(false));
        System.out.println("------------------------------------------");

        Map<Boolean, Long> m2 = list.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 30, Collectors.counting()));
        System.out.println("Count of Junior Employee: " + m2.get(false));
        System.out.println("Count of Senior Employee: " + m2.get(true));

        Map<String, List<Emp>> m3 = list.stream().collect(Collectors.groupingBy(e -> e.getDesignation()));
        System.out.println(m3);

        Map<String, Long> m4 = list.stream().collect(Collectors.groupingBy(e -> e.getDesignation(), Collectors.counting()));
        System.out.println(m4);

        Map<String, List<String>> m5 = list.stream().collect(Collectors.groupingBy(e -> e.getDesignation(), Collectors.mapping(e -> e.getName(), Collectors.toList())));
        System.out.println(m5);
    }
}