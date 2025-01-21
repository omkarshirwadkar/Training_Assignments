// package ClassWork.Jan21;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.Stack;
import java.util.BitSet;

public class UtilDemo {
    public static void main(String[] args) {
        // Date d1 = new Date();
        // System.out.println(d1);
        // // Standard datetime is 01/01/1970 00:00:00.000
        // // use negative numbers to set time before 01/01/1970 00:00:00.000
        // d1.setTime(-8888888888888L);
        // System.out.println(d1);

        // Date d2 = new Date();
        // // setMonth number starts with 0
        // // if more than 12 then it will take the remainder of the number divided by 12
        // d2.setMonth(48);
        // System.out.println(d2);


        // // getYear() returns the year minus 1900
        // System.out.println(1900 + d2.getYear()); // --> 129
        // System.out.println("-------------------------------");


        // Stack s1 = new Stack();
        // s1.push("111");
        // s1.push("222");
        // s1.push("333");
        // s1.push("444");
        // s1.push("555");

        // // System.out.println(s1.pop());
        // // System.out.println(s1.pop());
        // // System.out.println(s1.pop());

        // System.out.println(s1.peek());
        // // search() method returns the position of the first occurrence of the specified element in this stack from the top of the stack starting from 1
        // System.out.println(s1.search("111")); // --> returns 5 beacause it is the 5th element from the top of the stack

        // System.out.println(s1.search("3213")); // if the element is not present in the stack then it returns -1

        // Calendar c1 = Calendar.getInstance();
        // System.out.println(c1.getTime());

        BitSet bs1 = new BitSet(16);
        BitSet bs2 = new BitSet(16);
        BitSet bs3 = new BitSet(16);

        for (int i = 0; i < 16; i++) {
            if (i % 2 == 0) {
                bs1.set(i);
            }
            if (i % 3 == 0) {
                bs2.set(i);
            }
            if (i % 4 == 0) {
                bs3.set(i);
            }
        }
        System.out.println(bs1);
        System.out.println(bs2);
        bs3.and(bs2);
        System.out.println(bs3);
        bs1.or(bs2);
        System.out.println(bs1);
        bs1.xor(bs3);
    }
}
