package ClassWork.Jan08;
// package Training_Assignments.ClassWork.trainingday2;

class Person{
    String name;
}

public class ArrayDemo {
    // creating an array object which can hold 5 Person objects
    // Person object is the type of the array
    // Person object is not created here
    public static void main(String[] args) 
    {
        Person persons[] = new Person[5];
        System.out.println(persons.length);
        String users[] = {"AAA", "BBB", "CCC", "DDD", "EEE"};
        for (int i=0;i<5;i++)
        {
            persons[i]=new Person();
            persons[i].name = users[i];
        }
        for(Person p: persons)
        {
            System.out.println("Name: "+p.name);
        }
        // This works because of autoboxing
        // We don't have to specify the columns
        // Each row can have different number of columns --> Jagged array
        int arr[][] = new int[3][];
        arr[0] = new int[2];
        arr[1] = new int[5];
        arr[2] = new int[3];
        int cnt = 1;
        for (int i=0; i<3 ;i++)
        {
            for (int j=0; j<arr[i].length ;j++)
            {
                arr[i][j] = cnt;
                cnt += cnt;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
}
