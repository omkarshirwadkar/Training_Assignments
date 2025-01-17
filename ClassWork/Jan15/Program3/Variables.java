package ClassWork.Jan15.Program3;
public class Variables{
    // variable will be initialized to 0 
    static int b;

    // var is not allowed here
    // var is only allowed as a local variable, not as a static variable or a field of a class
    // var i;

    public static void main(String[] args) {

        // variable a might not have been initialized
        // int a;
        // System.out.println(a);

        // System.out.println(b);

        // var should always be initialized 
        // cannot infer type for local variable a
        var a = 22;
        a = 20;
        System.out.println(a);

        // var can be used as a variable name but not as a class name
        float var = 20.0f;

        // var array doesn't need to specify []
        // Usually: int[] array = new int[10];
        var arr = new int[8];

        // enum can be a part of switch case 
        enum Month{
            JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;
        }

        // switch (Month.FEBRUARY){
            // either we can do this 
            // case JANUARY:
            // System.out.println("Spring");
            // break;
            // case FEBRUARY:
            // System.out.println("Spring");
            // break;
            // case MARCH:
            // System.out.println("Spring");
            // break;
            // case APRIL:
            // System.out.println("Summer");
            // break;
            // case MAY:
            // System.out.println("Summer");
            // break;
            // case JUNE:
            // System.out.println("Summer");
            // break;
            // case JULY:
            // System.out.println("Rainy");
            // break;
            // case AUGUST:
            // System.out.println("Rainy");
            // break;
            // case SEPTEMBER:
            // System.out.println("Rainy");
            // break;
            // case OCTOBER:
            // System.out.println("Autumn");
            // break;
            // case NOVEMBER:
            // System.out.println("Autumn");
            // break;
            // case DECEMBER:
            // System.out.println("Autumn");
            // break;

            // or we can do this
            // case JANUARY, FEBRUARY, MARCH -> System.out.println("Spring");
            // case APRIL, MAY, JUNE -> System.out.println("Summer");
            // case JULY, AUGUST, SEPTEMBER -> System.out.println("Rainy");
            // case OCTOBER, NOVEMBER, DECEMBER -> System.out.println("Autumn");
            // }

            
            // If we are expecting something from the switch block
            String choice = switch(Month.APRIL)
            {
                case JANUARY, FEBRUARY, MARCH -> "Spring";
                case APRIL, MAY, JUNE -> "Summer";
                case JULY, AUGUST, SEPTEMBER -> "Rainy";
                case OCTOBER, NOVEMBER, DECEMBER -> "Autumn";
            };
    }
}