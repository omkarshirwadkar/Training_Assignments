import java.util.*;
public class SplitString {
    public static void main(String[] args) {
        // String str = "Omkar|Dinanath|Shirwadkar|21|,,,Male|Programmer|omkar@gmail.com|Mumbai|Maharashtra";
        String str = "12333,Omkar,,32,CEO";
        StringTokenizer st = new StringTokenizer(str, "|;:,");

        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }   
}
