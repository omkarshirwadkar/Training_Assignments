
import java.lang.reflect.*;
import java.util.Scanner;

class A{
    int x;
    A(int x){
        this.x = x;
    }
    public void finalize(){
        System.out.println("Object with value "+x+" is being garbage collected");
    }
}
public class LangDemo2 {
    public static void main(String[] args) throws Exception
    {
        // A a1 = new A(10);
        // A a2 = new A(20);
        // A a3 = new A(30);
        // // finalize() method may not be called immediately after object is no longer referenced.
        // // a2.finalize();

        // System.out.println(a1.x);
        // System.out.println(a2.x);
        // System.out.println(a3.x);
        // a1 = null;
        // a2 = null;

        // // System.gc();
        // Thread.sleep(1000);

        // System.out.println(a3.getClass());


        // Class c1 = a3.getClass();
        // This kind of programming is called reflection programming.
        // This is the program used by the javap command
        // This is also used by Java IDEs to display the class information
        
        System.out.println("Enter class name: ");
        Class c2 = Class.forName(new Scanner(System.in).next());
        Object o = c2.newInstance();
        System.out.println(o);
        Method m[] = c2.getMethods();
        Field f[] = c2.getFields();
        Constructor con[] = c2.getConstructors();
        for (int i=0;i<m.length;i++){
            System.out.println(m[i].getName());
        }

        // Without calling a constructor create an object
        // Object o = c2.newInstance();
    }
    
}
